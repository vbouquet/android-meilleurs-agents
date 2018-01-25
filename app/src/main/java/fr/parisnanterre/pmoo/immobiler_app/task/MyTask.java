package fr.parisnanterre.pmoo.immobiler_app.task;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.AsyncTask;
import android.util.Log;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.lang.ref.WeakReference;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;
import java.util.Locale;

import fr.parisnanterre.pmoo.immobiler_app.activity.MainActivity;
import fr.parisnanterre.pmoo.immobiler_app.model.MeilleursAgentsLocID;
import fr.parisnanterre.pmoo.immobiler_app.model.market.MeilleursAgentsMarketPrice;
import fr.parisnanterre.pmoo.immobiler_app.util.ToolsPpmInJava;

public class MyTask extends AsyncTask<Location, Void, Void> {
    private WeakReference<MainActivity> mainActivity;
    private Geocoder geocoder;
    private Bitmap bitmap;
    private Address address;
    private int price;

    public MyTask(MainActivity activity) {
        this.mainActivity = new WeakReference<>(activity);
        geocoder = new Geocoder(activity);
    }

    @Override
    protected Void doInBackground(Location... locations) {
        // Position par défaut
        double latitude = 48.913361;
        double longitude = 2.266903;
        if (locations.length > 0 && locations[0] != null) {
            latitude = locations[0].getLatitude();
            longitude = locations[0].getLongitude();
        }
        Log.d("GeoCoder", String.format("location %f, %f", latitude, longitude));
        try {
            // Récupération de l'adresse avec geocoder
            List<Address> addresses = geocoder.getFromLocation(latitude, longitude, 1);
            if (addresses != null && addresses.size() > 0) {
                Address address = addresses.get(0);
                this.address = address;
                Log.d("address", address.toString());

                // Récupération de l'image avec l'API google map
                URL googleMapURL = new URL(
                        String.format("https://maps.googleapis.com/" +
                                "maps/api/staticmap?center=%s,%s&zoom=14&size=1000x1000",
                                latitude, longitude
                        )
                );
                this.bitmap = BitmapFactory.decodeStream(
                        googleMapURL.openConnection().getInputStream()
                );

                // Récupération des identifiants (placeType et placeId) meilleursAgents
                // pour la location
                String meilleursAgentsParams = URLEncoder.encode(
                        String.format("%s,%s",
                                address.getAddressLine(0),
                                address.getAddressLine(1)
                        ), "UTF-8"
                );
                String meilleursAgentsURL = String.format(
                        "https://api.meilleursagents.com/geo/v1/?types=addresses&q=%s",
                        meilleursAgentsParams
                );
                Log.d("meilleursAgentsURL", meilleursAgentsURL);
                String meilleursAgentsLookup = ToolsPpmInJava.getJson(meilleursAgentsURL);
                try {
                    // Association des éléments json avec les classes et récupération des ID
                    ObjectMapper objectMapper = new ObjectMapper();
                    Reader reader = new StringReader(meilleursAgentsLookup);
                    MeilleursAgentsLocID meilleursAgentsLocID = objectMapper.readValue(
                            reader, MeilleursAgentsLocID.class);


                    int placeType = meilleursAgentsLocID.getResponse().getPlaces().get(0).getType();
                    int placeId = meilleursAgentsLocID.getResponse().getPlaces().get(0).getId();

                    // Récupération de l'URL pour le prix de l'immobilier sur la position
                    // (à cause du problème de redirection)
                    String meilleursAgentsPricesParams = String.format(Locale.FRANCE,
                            "place_type=%d&place_id=%d&base_url=/prix-immobilier/",
                            placeType, placeId
                    );
                    String meilleursAgentsPricesURL = String.format(
                            "https://www.meilleursagents.com/api/geo2/search?%s",
                            meilleursAgentsPricesParams
                    );
                    Log.d("meilleursAgentsPrices", meilleursAgentsPricesURL);
                    String meilleursAgentsPricesFinalURL = ToolsPpmInJava.getFinalURL(meilleursAgentsPricesURL);
                    Log.d("finalURL", meilleursAgentsPricesFinalURL);

                    // Récupération du prix grâce à l'URL récupéré en fonction de la position
                    String meilleursAgentsPrices = ToolsPpmInJava.getJson(
                            meilleursAgentsPricesFinalURL + "?partial=1");
                    Log.d("raw", meilleursAgentsPrices);

                    // Association des éléments json avec les classes et récupération du prix
                    objectMapper = new ObjectMapper();
                    reader = new StringReader(meilleursAgentsPrices);
                    MeilleursAgentsMarketPrice meilleursAgentsMarketPrice = objectMapper.readValue(reader, MeilleursAgentsMarketPrice.class);

                    price = meilleursAgentsMarketPrice.getMarket().getPrices().getSell().getApartment().getValue();
                    Log.i("final price", "PRICE = " + price);

                } catch (MalformedURLException e) {
                    e.getStackTrace();
                }
            } else {
                Log.d("Geocoder", "Addresses null or empty");
            }
        } catch (IOException e) {
            Log.d("GeoCoder", String.format("Error getFromLocation %f, %f", latitude, longitude));
            e.printStackTrace();
        }

        // TODO Chercher le prix au m2 des appartements à l'endroit recherché sur meilleursagent.com
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        MainActivity activity = mainActivity.get();
        if (activity != null && bitmap != null) {
            activity.updateMapImage(bitmap);
            activity.updateAddress(address);
            activity.updatePrice(price);
        }
    }
}

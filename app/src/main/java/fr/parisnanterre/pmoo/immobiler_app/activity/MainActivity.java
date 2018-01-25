package fr.parisnanterre.pmoo.immobiler_app.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.location.Address;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

import fr.parisnanterre.pmoo.immobiler_app.R;
import fr.parisnanterre.pmoo.immobiler_app.listener.MyLocationListener;
import fr.parisnanterre.pmoo.immobiler_app.task.MyTask;

public class MainActivity extends Activity {
    private static String toast_start_gps = "GPS start";
    private static String toast_stop_gps = "GPS stop";
    private static String toast_get_info = "Get infomartions about position";
    private TextView latitudeTextView;
    private TextView longitudeTextView;
    private TextView addressTextView;
    private TextView priceTextView;
    private ImageView mapImageView;
    private LocationManager locationManager;
    private LocationListener locationListener = new MyLocationListener(this);
    private Location location;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Récupération des éléments de l'UI
        Button startButton = findViewById(R.id.activity_main_button_start);
        Button stopButton = findViewById(R.id.activity_main_button_stop);
        Button getInfoButton = findViewById(R.id.activity_main_button_get_info);
        latitudeTextView = findViewById(R.id.activity_main_text_view_latitude);
        longitudeTextView = findViewById(R.id.activity_main_text_view_longitude);
        addressTextView = findViewById(R.id.activity_main_text_view_address_info);
        priceTextView = findViewById(R.id.activity_main_text_view_price_info);
        mapImageView = findViewById(R.id.activity_main_image_view_map);

        // Mise à jour de la position par défaut
        updatePositionView(null);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, toast_start_gps, Toast.LENGTH_LONG).show();
                startGps();
            }
        });

        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), toast_stop_gps, Toast.LENGTH_LONG).show();
                stopGps();
            }
        });

        getInfoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), toast_get_info, Toast.LENGTH_LONG).show();
                MyTask task = new MyTask(MainActivity.this);
                task.execute(location);
            }
        });
    }

    @SuppressLint("MissingPermission")
    void startGps() {
        locationManager = (LocationManager) getApplicationContext()
                .getSystemService(Context.LOCATION_SERVICE);
        if (locationManager != null) {
            locationManager.requestLocationUpdates(
                    LocationManager.GPS_PROVIDER, 2000, 1, locationListener);
            Log.i("LocationManager", "Started");
        } else {
            Log.i("LocationManager", "Error starting location manager");
        }
    }

    void stopGps() {
        locationManager.removeUpdates(locationListener);
    }

    /**
    Mise à jour de la position, si location est null alors valeur par défaut:
     61bis Rue Paul Déroulède 92270 Bois-Colombes France
     */
    public void updatePositionView(Location location) {
        Log.d("updatePositionView", "location");
        if (location != null) {
            this.location = location;
            latitudeTextView.setText(
                    String.format(Locale.FRANCE, "Latitude: %f", location.getLatitude()));
            longitudeTextView.setText(
                    String.format(Locale.FRANCE, "Longitude: %f", location.getLongitude()));
        } else {
            latitudeTextView.setText(
                    String.format(Locale.FRANCE, "Latitude: %f", 48.913361));
            longitudeTextView.setText(
                    String.format(Locale.FRANCE, "Longitude: %f", 2.266903));
        }
    }

    public void updateMapImage(Bitmap bitmap) {
        if (bitmap != null) {
            mapImageView.setImageBitmap(bitmap);
        }
    }

    public void updateAddress(Address address) {
        if (address != null) {
            addressTextView.setText(String.format("%s %s %s", address.getAddressLine(0),
                    address.getAddressLine(1), address.getAddressLine(2)));
        }
    }

    public void updatePrice(int price) {
        priceTextView.setText(String.format(Locale.FRANCE, "%d \u20ac", price));
    }
}

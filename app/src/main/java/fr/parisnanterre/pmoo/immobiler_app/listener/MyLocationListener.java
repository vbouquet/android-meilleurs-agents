package fr.parisnanterre.pmoo.immobiler_app.listener;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.util.Log;

import fr.parisnanterre.pmoo.immobiler_app.activity.MainActivity;

public class MyLocationListener implements LocationListener {
    private MainActivity mainActivity;

    public MyLocationListener(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    @Override
    public void onLocationChanged(Location location) {
        if (location != null) {
            Log.i("MyLocationListener", String.format("%s", location.toString()));
            mainActivity.updatePositionView(location);
        } else {
            Log.i("MyLocationListener", "Location is null");
        }
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }
}

package fr.parisnanterre.pmoo.immobiler_app.security;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PermissionInfo;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import fr.parisnanterre.pmoo.immobiler_app.activity.MainActivity;

public class SecurityPMOB {

    public static void requestPermissions(MainActivity activity) {
        List<PermissionInfo> permissionInfoList = getAppPermissions(activity.getApplicationContext());
        ArrayList<String> permissionArrayList = new ArrayList<String>();
        for (PermissionInfo permissionInfo : permissionInfoList) {
            Log.d("Permission", permissionInfo.name);
//            if (!isPermissionGranted(activity.getApplicationContext(), permissionInfo.name))
            permissionArrayList.add(permissionInfo.name);
        }
        String[] permStringsArray = permissionArrayList.toArray(new String[1]);
        if (permStringsArray != null && permStringsArray.length > 0) {
            activity.requestPermissions(permStringsArray, 1);
        }
    }

    public static boolean isPermissionGranted(Context context, String permission) {
        //int permissionState = ContextCompat.checkSelfPermission(context, permission);
        int permissionState = context.checkSelfPermission(permission);
        if (permissionState == PackageManager.PERMISSION_GRANTED) {
            return true;
        }
        else return false;
    }

    public static List<PermissionInfo> getAppPermissions (Context context) {
        ArrayList<PermissionInfo> permissionInfoList = new ArrayList<PermissionInfo>();
        try {
            PackageManager packageManager = context.getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo
                    (context.getPackageName(), PackageManager.GET_PERMISSIONS);
            String[] permissionsArray = packageInfo.requestedPermissions;
            for (String permissionString : permissionsArray) {
                PermissionInfo permissionInfo = packageManager.getPermissionInfo(permissionString,
                        PackageManager.GET_META_DATA);
                permissionInfoList.add(permissionInfo);
            }
        } catch (PackageManager.NameNotFoundException e) {
            Log.d("FQDN", "Exception :" + e, e);
        }
        return permissionInfoList;
    }
}

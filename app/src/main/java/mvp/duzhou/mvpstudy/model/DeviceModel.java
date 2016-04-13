package mvp.duzhou.mvpstudy.model;

import android.content.Context;
import android.os.Build;
import android.telephony.TelephonyManager;

import java.text.SimpleDateFormat;
import java.util.Date;

import mvp.duzhou.mvpstudy.MVPApplication;

/**
 * Created by zhou on 16/4/13.
 */
public class DeviceModel {
    public String getImei(){
        TelephonyManager telephonyManager = (TelephonyManager) MVPApplication.getContext().getSystemService(Context.TELEPHONY_SERVICE);
        if (telephonyManager != null)
            return telephonyManager.getDeviceId();
        return null;
    }

    public String getDeviceName(){
        return Build.MODEL;
    }

    public String getDateTime(){
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(new Date());
    }
}

package mvp.duzhou.mvpstudy.presenter;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

import java.text.SimpleDateFormat;
import java.util.Date;

import mvp.duzhou.mvpstudy.MVPApplication;
import mvp.duzhou.mvpstudy.model.DeviceModel;
import mvp.duzhou.mvpstudy.view.IDeviceView;

/**
 * Created by zhou on 16/4/13.
 */
public class DevicePresenter {
    private IDeviceView deviceView;
    private DeviceModel deviceModel;
    private PowerReceiver powerReceiver;

    public DevicePresenter(IDeviceView deviceView){
        this.deviceView = deviceView;
        deviceModel = new DeviceModel();
    }

    public void setDeviceImei(){
        deviceView.setImei(deviceModel.getImei());
    }

    public void setDeviceName(){
        deviceView.setDevice(deviceModel.getDeviceName());
    }

    public void setTime(){
        deviceView.setTime(deviceModel.getDateTime());
    }

    public void setPower(){
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(Intent.ACTION_BATTERY_CHANGED);
        powerReceiver = new PowerReceiver();
        MVPApplication.getContext().registerReceiver(powerReceiver , intentFilter);
    }


    class PowerReceiver extends BroadcastReceiver{
        @Override
        public void onReceive(Context context, Intent intent) {
            if (Intent.ACTION_BATTERY_CHANGED.equals(intent.getAction())){
                //获取当前电量
                int level = intent.getIntExtra("level", 0);
                //电量的总刻度
                int scale = intent.getIntExtra("scale", 100);
                deviceView.setPower("当前电量："+level + "--" + scale);
                if (powerReceiver != null)
                    MVPApplication.getContext().unregisterReceiver(powerReceiver);

            }
        }
    }

}

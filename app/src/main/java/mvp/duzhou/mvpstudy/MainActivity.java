package mvp.duzhou.mvpstudy;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import mvp.duzhou.mvpstudy.presenter.DevicePresenter;
import mvp.duzhou.mvpstudy.view.IDeviceView;

/**
 * Created by zhou on 16/4/13.
 */
public class MainActivity extends Activity implements IDeviceView{
    TextView deviceTextView , imeiTextView , powerTextView , timeTextView;
    private DevicePresenter devicePresenter = new DevicePresenter(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device);
        deviceTextView = (TextView) findViewById(R.id.tv_device_name);
        imeiTextView = (TextView) findViewById(R.id.tv_imei);
        powerTextView = (TextView) findViewById(R.id.tv_power);
        timeTextView = (TextView) findViewById(R.id.tv_time);
        devicePresenter.setDeviceImei();
        devicePresenter.setDeviceName();
        devicePresenter.setPower();
        devicePresenter.setTime();
    }

    @Override
    public void setDevice(String deviceName) {
        deviceTextView.setText(deviceName);
    }

    @Override
    public void setImei(String imei) {
        imeiTextView.setText(imei);
    }

    @Override
    public void setPower(String power) {
        powerTextView.setText(power);
    }

    @Override
    public void setTime(String time) {
        timeTextView.setText(time);
    }
}

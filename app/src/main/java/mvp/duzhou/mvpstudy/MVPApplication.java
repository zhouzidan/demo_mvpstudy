package mvp.duzhou.mvpstudy;

import android.app.Application;
import android.content.Context;

/**
 * Created by zhou on 16/4/13.
 */
public class MVPApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }
    private static Context context;

    public static Context getContext(){
        return context;
    }

}

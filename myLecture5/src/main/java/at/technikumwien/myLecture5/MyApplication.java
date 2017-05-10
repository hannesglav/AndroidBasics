package at.technikumwien.myLecture5;

import android.app.AlarmManager;
import android.app.Application;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import at.technikumwien.myLecture5.ui.AlarmReceiver;

/**
 * Created by FH on 24.04.2017.
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        AlarmManager am = (AlarmManager) this.getSystemService(Context.ALARM_SERVICE);

        final long TWO_SECONDS = 2000L;

        Intent intent = new Intent(AlarmReceiver.ACTION_ALARM);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this,234,intent,0);

        Log.i("MyApplication","started");

        am.setExact(
                AlarmManager.RTC,
                System.currentTimeMillis() + TWO_SECONDS,
      //          TWO_SECONDS,
                pendingIntent
        );

         am.setRepeating(
                AlarmManager.RTC,
                System.currentTimeMillis(),
                TWO_SECONDS,
                pendingIntent
         );



    }
}

package at.technikumwien.myLecture5.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by FH on 24.04.2017.
 */

public class AlarmReceiver extends BroadcastReceiver {

    public static String ACTION_ALARM = "at.technikumwien.myLecture5.ALARM";

    @Override
    public void onReceive(Context context, Intent intent) {
       Log.i("AlarmReceiver", "Receiving alarm with action "+intent.getAction());
    }
}

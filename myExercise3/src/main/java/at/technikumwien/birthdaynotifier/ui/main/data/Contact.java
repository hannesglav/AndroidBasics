package at.technikumwien.birthdaynotifier.ui.main.data;

import android.util.Log;

import com.google.auto.value.AutoValue;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


@AutoValue
public abstract class Contact {
    public abstract long id();
    public abstract String name();
    public abstract Date birthday();

    public static Contact create(long id, String name, Date birthday) {
        return new AutoValue_Contact(id,name,birthday);
    }

    // formatted output
    public String getFormattedBirthday(){
        SimpleDateFormat sdf=new SimpleDateFormat();
        sdf.applyPattern("dd. MMM\nyyyy");
        // Log.i("myLog","getFormattedBirthday\n"+sdf.format(birthday()));
        return sdf.format(birthday());
    }

    // returns true, if today is a birthday
    public boolean hasBirthday() {
        // by default is current date selected
        Calendar rightNow= Calendar.getInstance();
        // rightNow.set(117,3,24);
        // Log.i("myLog","hasBirthday.rightNow.MONTH\n"+rightNow.get(Calendar.MONTH));
        // Log.i("myLog","hasBirthday.rightNow.DAY_OF_MONTH\n"+rightNow.get(Calendar.DAY_OF_MONTH));

        // birthday
        // Date.Set(Year - 1900, Month = 0..11, Date= 1..31)
        // convert to Calendar
        Calendar bd = Calendar.getInstance();
        bd.set(birthday().getYear(),birthday().getMonth(),birthday().getDate());
        // Log.i("myLog","hasBirthday.bd.MONTH\n"+bd.get(Calendar.MONTH));
        // Log.i("myLog","hasBirthday.bd.DAY_OF_MONTH\n"+bd.get(Calendar.DAY_OF_MONTH));

        // compare for equal Month, Day_of_month
        if (bd.get(Calendar.MONTH) != rightNow.get(Calendar.MONTH))
            return false;

        if (bd.get(Calendar.DAY_OF_MONTH) != rightNow.get(Calendar.DAY_OF_MONTH))
            return false;

        // Log.i("myLog","hasBirthday.Matching");
        return  true;
    }

}

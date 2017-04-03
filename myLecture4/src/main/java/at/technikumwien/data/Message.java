package at.technikumwien.data;

import com.google.auto.value.AutoValue;

/**
 * Created by FH on 03.04.2017.
 */

@AutoValue
public abstract class Message {
    public abstract String title();
    public abstract String message();

    public static Message create(String title, String message) {
        return new AutoValue_Message(title,message);
    }
}

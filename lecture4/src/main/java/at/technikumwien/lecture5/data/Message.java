<<<<<<< HEAD:lecture4/src/main/java/at/technikumwien/lecture4/data/Message.java
package at.technikumwien.myLecture5.data;
=======
package at.technikumwien.lecture5.data;
>>>>>>> AndroidBasics_solution/summerterm2017:lecture4/src/main/java/at/technikumwien/lecture5/data/Message.java

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class Message {
    public abstract String title();
    public abstract String message();

    public static Message create(String title, String message) {
        return new AutoValue_Message(title, message);
    }
}

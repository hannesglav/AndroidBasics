<<<<<<< HEAD:lecture4/src/main/java/at/technikumwien/lecture4/ui/recyclerview/MessageViewHolder.java
package at.technikumwien.myLecture5.ui.recyclerview;
=======
package at.technikumwien.lecture5.ui.recyclerview;
>>>>>>> AndroidBasics_solution/summerterm2017:lecture4/src/main/java/at/technikumwien/lecture5/ui/recyclerview/MessageViewHolder.java


import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

<<<<<<< HEAD:lecture4/src/main/java/at/technikumwien/lecture4/ui/recyclerview/MessageViewHolder.java
import at.technikumwien.myLecture5.R;
import at.technikumwien.myLecture5.data.Message;
=======
import at.technikumwien.lecture5.R;
import at.technikumwien.lecture5.data.Message;
>>>>>>> AndroidBasics_solution/summerterm2017:lecture4/src/main/java/at/technikumwien/lecture5/ui/recyclerview/MessageViewHolder.java

public class MessageViewHolder extends RecyclerView.ViewHolder {

    private TextView titleTextView;
    private TextView messageTextView;

    public MessageViewHolder(View itemView) {
        super(itemView);

        titleTextView = (TextView) itemView.findViewById(R.id.title);
        messageTextView = (TextView) itemView.findViewById(R.id.message);
    }

    public void update(Message message) {
        titleTextView.setText(message.title());
        messageTextView.setText(message.message());
    }
}

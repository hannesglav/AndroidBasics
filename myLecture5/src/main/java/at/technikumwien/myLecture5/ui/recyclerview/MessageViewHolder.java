package at.technikumwien.myLecture5.ui.recyclerview;


import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import at.technikumwien.myLecture5.R;
import at.technikumwien.myLecture5.data.Message;

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

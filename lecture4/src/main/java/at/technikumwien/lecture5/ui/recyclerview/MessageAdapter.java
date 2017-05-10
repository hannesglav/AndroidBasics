<<<<<<< HEAD:lecture4/src/main/java/at/technikumwien/lecture4/ui/recyclerview/MessageAdapter.java
package at.technikumwien.myLecture5.ui.recyclerview;
=======
package at.technikumwien.lecture5.ui.recyclerview;
>>>>>>> AndroidBasics_solution/summerterm2017:lecture4/src/main/java/at/technikumwien/lecture5/ui/recyclerview/MessageAdapter.java


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Collections;
import java.util.List;

<<<<<<< HEAD:lecture4/src/main/java/at/technikumwien/lecture4/ui/recyclerview/MessageAdapter.java
import at.technikumwien.myLecture5.R;
import at.technikumwien.myLecture5.data.Message;
=======
import at.technikumwien.lecture5.R;
import at.technikumwien.lecture5.data.Message;
>>>>>>> AndroidBasics_solution/summerterm2017:lecture4/src/main/java/at/technikumwien/lecture5/ui/recyclerview/MessageAdapter.java

public class MessageAdapter extends RecyclerView.Adapter<MessageViewHolder> {

    private List<Message> messageList = Collections.emptyList();

    public void setList(List<Message> messageList) {
        this.messageList = messageList;
        notifyDataSetChanged();
    }

    @Override
    public MessageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_message, parent, false);

        return new MessageViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MessageViewHolder holder, int position) {
        holder.update(messageList.get(position));
    }

    @Override
    public int getItemCount() {
        return messageList.size();
    }
}

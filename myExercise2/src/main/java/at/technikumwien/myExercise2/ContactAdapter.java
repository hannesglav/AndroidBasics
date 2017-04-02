package at.technikumwien.myExercise2;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Collections;
import java.util.List;


public class ContactAdapter extends RecyclerView.Adapter<ContactViewHolder> {

    private List<String> kontakteListe = Collections.emptyList();

    public void setContactList(List<String> contactList) {
        this.kontakteListe = contactList;
        notifyDataSetChanged();
    }

    @Override
    public ContactViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_contact, parent, false);

        return new ContactViewHolder(view);
    }

    // Here we update our view holder with new data for a specific position
    // in our list
    @Override
    public void onBindViewHolder(ContactViewHolder holder, int position) {
        holder.update(kontakteListe.get(position));
    }

    @Override
    public int getItemCount() {
        return kontakteListe.size();
    }

}

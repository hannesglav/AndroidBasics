package at.technikumwien.birthdaynotifier.ui.main.recyclerview;

import android.media.Image;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import at.technikumwien.birthdaynotifier.R;
import at.technikumwien.birthdaynotifier.ui.main.data.Contact;

/**
 * Please read the {@link RecyclerView.ViewHolder} java docs.
 */
class ContactViewHolder extends RecyclerView.ViewHolder {

    private CardView cardView;
    private ImageView img;
    private TextView name;
    private TextView bday;

    ContactViewHolder(View itemView) {
        super(itemView);

        // Find our views
        cardView = (CardView) itemView.findViewById(R.id.card_view);
        img = (ImageView) itemView.findViewById(R.id.image);
        name = (TextView) itemView.findViewById(R.id.name);
        bday = (TextView) itemView.findViewById(R.id.birthday);

        // Show a Snackbar when the card view is clicked
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(cardView, name.getText() + " clicked", Snackbar.LENGTH_LONG).show();
            }
        });
    }

    // Here we set the new item model on our view holder and
    // update our views accordingly
    void update(Contact currentContact) {
        img.setImageResource(currentContact.hasBirthday() ? R.drawable.ic_cake_black : R.drawable.ic_person_black);
        name.setText(currentContact.name());
        bday.setText(currentContact.getFormattedBirthday());
    }
}

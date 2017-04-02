package at.technikumwien.myExercise2;

import android.support.design.widget.Snackbar;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;


public class ContactViewHolder extends RecyclerView.ViewHolder {

    private CardView cardView;
    private TextView textView;

    ContactViewHolder(View itemView)
    {
        super(itemView);

        cardView = (CardView) itemView.findViewById(R.id.card_view);
        textView = (TextView) itemView.findViewById(R.id.name);

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(cardView,textView.getText()+" clicked.",Snackbar.LENGTH_LONG).show();
            }
        });
    }

    void update(String contactName)
    {
        textView.setText(contactName);
    }

}

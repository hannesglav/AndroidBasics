package at.technikumwien.myExercise2;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private FloatingActionButton fab;
    private TextView emptyTextView;

    private ContactAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView =(RecyclerView) findViewById(R.id.recycler_view);
        fab = (FloatingActionButton) findViewById(R.id.fab);
        emptyTextView = (TextView) findViewById(R.id.empty_TextView);

        adapter = new ContactAdapter();

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Load(Arrays.asList(
                        "Anton Maier",
                        "Berta Munk",
                        "Gabriel Donner",
                        "Konrad Kästner",
                        "Ludwig Gruber",
                        "Michael Sonntag",
                        "Monika Zander",
                        "Stefanie Winkler",
                        "Paul Binder",
                        "Otto Habsburg"

                ));
            }
        });


    }

    private static final String TAG = "MyActivity";
    private void Load(List<String> contactList) {
        Snackbar.make(fab, "Kontakte geladen", Snackbar.LENGTH_LONG).show();
        emptyTextView.setVisibility(contactList.isEmpty() ? View.VISIBLE : View.GONE);
        adapter.setContactList(contactList);
    }
}

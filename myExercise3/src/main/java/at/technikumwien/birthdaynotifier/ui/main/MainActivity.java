package at.technikumwien.birthdaynotifier.ui.main;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import at.technikumwien.birthdaynotifier.R;
import at.technikumwien.birthdaynotifier.ui.main.data.Contact;
import at.technikumwien.birthdaynotifier.ui.main.recyclerview.ContactAdapter;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CONTACT_PERMISSION = 346;

    private RecyclerView recyclerView;
    private FloatingActionButton fab;
    private TextView emptyText;

    private ContactAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the content view and find our views
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        fab = (FloatingActionButton) findViewById(R.id.fab);
        emptyText = (TextView) findViewById(R.id.no_contacts);

        // Create an adapter for the RecyclerView
        adapter = new ContactAdapter();

        // If the recycler view does not change in size, this
        // enables some optimizations
        recyclerView.setHasFixedSize(true);
        // Set a LinearLayoutManager, which lays the items out one after another
        // (like a LinearLayout)
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        // Set our contacts adapter on the RecyclerView
        recyclerView.setAdapter(adapter);

        // Show a snackbar when the floating action button is clicked
        // and add some data to show
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkContactsPermission();
            }
        });
    }

    // Is called, when contacts are loaded. Here we set the visibility
    // of the empty list info text and update the data in our adapter
    private void onContactsLoaded(List<Contact> contactList) {
        emptyText.setVisibility(contactList.isEmpty() ? View.VISIBLE : View.GONE);
        // Button blockiert das Datum
        fab.setVisibility(contactList.isEmpty() ? View.VISIBLE : View.GONE);
        adapter.setContactList(contactList);
    }

    // checks the permission
    private void checkContactsPermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CALENDAR)== PackageManager.PERMISSION_GRANTED) {
            onContactsPermissionGranted();
        } else {
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.READ_CALENDAR},REQUEST_CONTACT_PERMISSION);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == REQUEST_CONTACT_PERMISSION) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED)
                onContactsPermissionGranted();
            else
                onContactsPermissionDenied();
        }
    }

    private void onContactsPermissionGranted() {
        Snackbar.make(fab, "Permission granted", Snackbar.LENGTH_LONG).show();
        onContactsLoaded(Arrays.asList(
                Contact.create(1,"Anton Maier",new Date(61,0,31)),
                Contact.create(2,"Berta Munk",new Date(62,1,29)),
                Contact.create(3,"Gabriel Donner",new Date(63,3,23)),
                Contact.create(4,"Konrad Kästner",new Date(90,3,24)),
                Contact.create(5,"Ludwig Gruber",new Date(65,3,25)),
                Contact.create(6,"Michael Sonntag",new Date(66,8,2)),
                Contact.create(7,"Monika Zander",new Date(67,10,20)),
                Contact.create(8,"Stefanie Winkler",new Date(68,4,1)),
                Contact.create(9,"Paul Binder",new Date(69,3,23)),
                Contact.create(10,"Otto Habsburg",new Date(101,3,24)),
                Contact.create(11,"Maria Habsburg",new Date(102,11,24))
        ));
    }

    private void onContactsPermissionDenied() {
        Snackbar.make(fab, "Permission needed to show birthdays", Snackbar.LENGTH_LONG)
                .setAction("Try again?", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        checkContactsPermission();
                    }
                }).show();
    }


}

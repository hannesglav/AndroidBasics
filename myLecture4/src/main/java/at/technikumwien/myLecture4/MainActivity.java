package at.technikumwien.myLecture4;

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

import java.util.Arrays;
import java.util.List;

import at.technikumwien.data.Message;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CODE_PERMISSION = 345;

    private RecyclerView recyclerView;
    private FloatingActionButton button;

    private MessageAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        button = (FloatingActionButton) findViewById(R.id.load_data);

        adapter = new MessageAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    checkPermission();
            }
        });
    }

    private void onDataLoaded(List<Message> messageList) {
        adapter.setLists(messageList);
    }

    public void checkPermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CALENDAR)== PackageManager.PERMISSION_GRANTED) {
            onPermissionGranted();
        } else {
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.READ_CALENDAR},REQUEST_CODE_PERMISSION);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == REQUEST_CODE_PERMISSION) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                onPermissionGranted();
            } else {
                onPermissionDenied();
            }
        }
    }

    public void onPermissionGranted() {
        Snackbar.make(recyclerView,"Berechtigung erlaubt",Snackbar.LENGTH_LONG).show();

        onDataLoaded(Arrays.asList(
                Message.create("Titel 1", "Nach"),
                Message.create("Titel 2.", "Dies ist noch eine Nachricht")));
    }


    public void onPermissionDenied() {
        Snackbar.make(recyclerView,"Benötige Berechtigung um Kalendereinträge anzuzeigen",Snackbar.LENGTH_LONG)
                .setAction("Erneut fragen", new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        checkPermission();
                    }
                }).show();

    }
}

package at.technikumwien.birthdaynotifier.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import at.technikumwien.birthdaynotifier.R;
import at.technikumwien.birthdaynotifier.ui.fragment.MainFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().add(
                    R.id.container,new MainFragment()).commit();

        }
    }
}

package at.technikumwien.birthdaynotifier.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

import at.technikumwien.birthdaynotifier.R;

public class MessageActivity extends AppCompatActivity {

    private static final String EXTRA_MESSAGE = "message";

    public static Intent getIntent(Context ctx, String message) {
        Intent intent = new Intent(ctx, MessageActivity.class);
        intent.putExtra(EXTRA_MESSAGE, message);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.message);

        String message = getIntent().getStringExtra(EXTRA_MESSAGE);
        TextView textView = (TextView) findViewById(R.id.message);
        textView.setText(message);
    }
}

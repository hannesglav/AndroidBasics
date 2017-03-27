package at.technikumwien.birthdaynotifier.ui.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import at.technikumwien.birthdaynotifier.R;
import at.technikumwien.birthdaynotifier.ui.activity.MessageActivity;


public class MainFragment extends Fragment {
    private static final String KEY_MESSAGE = "message";

    private EditText message;
    private Button sendActivity, sendFragment;

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putString(KEY_MESSAGE,getMessage());
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    public void onViewCreated(View view,Bundle savedInstanceState) {
        super.onViewCreated(view,savedInstanceState);

        message = (EditText) getView().findViewById(R.id.message);
        sendActivity= (Button) getView().findViewById(R.id.send_activity);
        sendFragment= (Button) getView().findViewById(R.id.send_fragment);

        if(savedInstanceState != null) {
            message.setText(savedInstanceState.getString(KEY_MESSAGE));
        }

        sendActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(MessageActivity.getIntent(getContext(),getMessage()));
            }
        });


        sendFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    getFragmentManager().beginTransaction()
                        .replace(R.id.container,MessageFragment.getFragment(getMessage()))
                        .addToBackStack(null)
                        .commit();
            }
        });

    }

    private String getMessage() {
        return message.getText().toString();
    }


}
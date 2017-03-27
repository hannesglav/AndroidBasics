package at.technikumwien.birthdaynotifier.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import at.technikumwien.birthdaynotifier.R;


public class MessageFragment extends Fragment {

    private static final String EXTRA_MESSAGE = "message";

    public static Fragment getFragment(String message) {
        MessageFragment messageFragment = new MessageFragment();
        Bundle args = new Bundle();
        args.putString(EXTRA_MESSAGE,message);
        messageFragment.setArguments(args);
        return messageFragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.message, container, false);
    }

    public void onViewCreated(View view,Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        String message = getArguments().getString(EXTRA_MESSAGE);
        TextView textView = (TextView) getView().findViewById(R.id.message);
        textView.setText(message);
    }
}

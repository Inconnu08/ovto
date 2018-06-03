package application.taufiqrahman.com.ovto.bottomTabBar;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import application.taufiqrahman.com.ovto.MainActivity;
import application.taufiqrahman.com.ovto.R;

public class Notifications extends Fragment {

    View rootView;

    public Notifications() {
        // Required empty public constructor
    }

    @Override
    public void onStart() {
        super.onStart();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_notifications, container, false);

        MainActivity.mToolbarText.setText(R.string.notifications_title);
        return rootView;
    }
}

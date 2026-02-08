package com.example.formapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class SecondFragment extends Fragment {

    TextView tEmail, tName, tSurname;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_second, container, false);

        tEmail = view.findViewById(R.id.tEmail);
        tName = view.findViewById(R.id.tName);
        tSurname = view.findViewById(R.id.tSurname);

        Bundle bundle = getArguments();

        if (bundle != null) {
            tEmail.setText("Email: " + bundle.getString("email"));
            tName.setText("Imię: " + bundle.getString("name"));
            tSurname.setText("Nazwisko: " + bundle.getString("surname"));
        }

        return view;
    }
}

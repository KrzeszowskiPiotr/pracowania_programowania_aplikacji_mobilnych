package com.example.formapp;

import android.os.Bundle;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

public class FirstFragment extends Fragment {

    EditText email, name, surname;
    Button button;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_first, container, false);

        email = view.findViewById(R.id.email);
        name = view.findViewById(R.id.name);
        surname = view.findViewById(R.id.surname);
        button = view.findViewById(R.id.button);

        button.setOnClickListener(v -> {

            String e = email.getText().toString();
            String n = name.getText().toString();
            String s = surname.getText().toString();

            if (e.isEmpty() || n.isEmpty() || s.isEmpty()) {
                Toast.makeText(getActivity(), "Uzupełnij wszystkie pola", Toast.LENGTH_SHORT).show();
                return;
            }

            if (!Patterns.EMAIL_ADDRESS.matcher(e).matches()) {
                Toast.makeText(getActivity(), "Niepoprawny email", Toast.LENGTH_SHORT).show();
                return;
            }

            Bundle bundle = new Bundle();
            bundle.putString("email", e);
            bundle.putString("name", n);
            bundle.putString("surname", s);

            SecondFragment fragment = new SecondFragment();
            fragment.setArguments(bundle);

            getParentFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragmentContainerView, fragment)
                    .addToBackStack(null)
                    .commit();
        });

        return view;
    }
}

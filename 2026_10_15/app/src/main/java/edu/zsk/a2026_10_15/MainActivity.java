package edu.zsk.a2026_10_15;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private int licznikPolubien = 0;
    private TextView tvLicznik;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnPolub = findViewById(R.id.btnPolub);
        Button btnUsun = findViewById(R.id.btnUsun);
        tvLicznik = findViewById(R.id.tvLicznik);

        aktualizujLicznik();

        btnPolub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                licznikPolubien++;
                aktualizujLicznik();
            }
        });

        btnUsun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (licznikPolubien > 0) {
                    licznikPolubien--;
                    aktualizujLicznik();
                }
            }
        });
    }

    private void aktualizujLicznik() {
        tvLicznik.setText(getString(R.string.licznik_format, licznikPolubien));
    }
}
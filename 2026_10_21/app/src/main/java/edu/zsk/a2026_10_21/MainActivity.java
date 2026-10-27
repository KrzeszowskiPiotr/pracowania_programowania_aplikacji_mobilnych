package edu.zsk.a2026_10_21;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText etImie, etCel, etCzas;
    private TextView tvPies, tvKot, tvSwinka, tvWiek, tvWynik;
    private SeekBar seekBarWiek;
    private String wybraneGatunek = "";
    private int wiekZwierzecia = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etImie = findViewById(R.id.etImie);
        etCel = findViewById(R.id.etCel);
        etCzas = findViewById(R.id.etCzas);
        tvPies = findViewById(R.id.tvPies);
        tvKot = findViewById(R.id.tvKot);
        tvSwinka = findViewById(R.id.tvSwinka);
        tvWiek = findViewById(R.id.tvWiek);
        seekBarWiek = findViewById(R.id.seekBarWiek);
        tvWynik = findViewById(R.id.tvWynik);

        tvPies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wybraneGatunek = "Pies";
                seekBarWiek.setMax(18);
                zaznaczGatunek(tvPies);
            }
        });

        tvKot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wybraneGatunek = "Kot";
                seekBarWiek.setMax(20);
                zaznaczGatunek(tvKot);
            }
        });

        tvSwinka.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wybraneGatunek = "Świnka morska";
                seekBarWiek.setMax(9);
                zaznaczGatunek(tvSwinka);
            }
        });

        seekBarWiek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                wiekZwierzecia = progress;
                tvWiek.setText(getString(R.string.wiek_format, wiekZwierzecia));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        Button btnOk = findViewById(R.id.btnOk);
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String imie = etImie.getText().toString();
                String cel = etCel.getText().toString();
                String czas = etCzas.getText().toString();
                String wynik = imie + ", " + wybraneGatunek + ", " + wiekZwierzecia + ", " + cel + ", " + czas;
                tvWynik.setText(wynik);
            }
        });
    }

    private void zaznaczGatunek(TextView wybrane) {
        tvPies.setBackgroundColor(getResources().getColor(android.R.color.transparent));
        tvKot.setBackgroundColor(getResources().getColor(android.R.color.transparent));
        tvSwinka.setBackgroundColor(getResources().getColor(android.R.color.transparent));
        wybrane.setBackgroundColor(getResources().getColor(R.color.orange));
    }
}
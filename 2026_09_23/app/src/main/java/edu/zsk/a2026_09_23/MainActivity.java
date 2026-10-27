package edu.zsk.a2026_09_23;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tvRozmiar, tvCytat;
    private SeekBar seekBarRozmiar;
    private final String[] tablicaCytatów = {"Dzień dobry", "Good morning", "Buenos dias"};
    private int indeksCytatu = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvRozmiar = findViewById(R.id.tvRozmiar);
        tvCytat = findViewById(R.id.tvCytat);
        seekBarRozmiar = findViewById(R.id.seekBarRozmiar);
        Button btnDalej = findViewById(R.id.btnDalej);

        seekBarRozmiar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tvRozmiar.setText(getString(R.string.rozmiar_format, progress));
                if (progress > 0) {
                    tvCytat.setTextSize(TypedValue.COMPLEX_UNIT_SP, progress);
                } else {
                    tvCytat.setTextSize(TypedValue.COMPLEX_UNIT_SP, 1);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        btnDalej.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                indeksCytatu = (indeksCytatu + 1) % tablicaCytatów.length;
                tvCytat.setText(tablicaCytatów[indeksCytatu]);
            }
        });
    }
}
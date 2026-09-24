package edu.zsk.zadanie_09_23;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView sizeLabel;
    private SeekBar fontSeekBar;
    private TextView quoteText;
    private Button changeBtn;

    private final String[] quotes = {"Dzień dobry", "Good morning", "Buenos dias"};
    private int currentQuoteIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sizeLabel = findViewById(R.id.sizeLabel);
        fontSeekBar = findViewById(R.id.fontSeekBar);
        quoteText = findViewById(R.id.quoteText);
        changeBtn = findViewById(R.id.changeBtn);

        quoteText.setText(quotes[currentQuoteIndex]);

        fontSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                sizeLabel.setText(getString(R.string.label_size) + progress);
                quoteText.setTextSize(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        changeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentQuoteIndex = (currentQuoteIndex + 1) % quotes.length;
                quoteText.setText(quotes[currentQuoteIndex]);
            }
        });
    }
}
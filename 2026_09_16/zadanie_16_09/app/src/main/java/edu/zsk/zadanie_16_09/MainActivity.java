package edu.zsk.zadanie_16_09;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText pralkaEntry;
    private Button zatwierdzBtn;
    private TextView pralkaStatusLabel;

    private Button odkurzaczBtn;
    private TextView odkurzaczStatusLabel;

    private boolean isOdkurzaczWlaczony = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pralkaEntry = findViewById(R.id.pralkaEntry);
        zatwierdzBtn = findViewById(R.id.zatwierdzBtn);
        pralkaStatusLabel = findViewById(R.id.pralkaStatusLabel);

        odkurzaczBtn = findViewById(R.id.odkurzaczBtn);
        odkurzaczStatusLabel = findViewById(R.id.odkurzaczStatusLabel);

        zatwierdzBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = pralkaEntry.getText().toString();
                if (!input.isEmpty()) {
                    try {
                        int nrPrania = Integer.parseInt(input);
                        if (nrPrania >= 1 && nrPrania <= 12) {
                            pralkaStatusLabel.setText(getString(R.string.washing_machine_status_prefix) + nrPrania);
                        }
                    } catch (NumberFormatException ignored) {
                    }
                }
            }
        });

        odkurzaczBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isOdkurzaczWlaczony = !isOdkurzaczWlaczony;

                if (isOdkurzaczWlaczony) {
                    odkurzaczBtn.setText(R.string.btn_turn_off);
                    odkurzaczStatusLabel.setText(R.string.vacuum_status_on);
                } else {
                    odkurzaczBtn.setText(R.string.btn_turn_on);
                    odkurzaczStatusLabel.setText(R.string.vacuum_status_off);
                }
            }
        });
    }
}
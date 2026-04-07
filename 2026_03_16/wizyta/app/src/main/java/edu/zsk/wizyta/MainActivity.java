package edu.zsk.wizyta;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private String speciesSelected = "";
    private int ageValue = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText etOwner = findViewById(R.id.etOwner);
        ListView lvSpecies = findViewById(R.id.lvSpecies);
        SeekBar sbAge = findViewById(R.id.sbAge);
        TextView tvAgeDisplay = findViewById(R.id.tvAgeDisplay);
        EditText etPurpose = findViewById(R.id.etPurpose);
        EditText etTime = findViewById(R.id.etTime);
        Button btnOk = findViewById(R.id.btnOk);
        TextView tvSummary = findViewById(R.id.tvSummary);

        String[] speciesArr = {"Pies", "Kot", "Świnka morska"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, speciesArr);
        lvSpecies.setAdapter(adapter);

        lvSpecies.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                speciesSelected = speciesArr[position];
                if (speciesSelected.equals("Pies")) {
                    sbAge.setMax(18);
                } else if (speciesSelected.equals("Kot")) {
                    sbAge.setMax(20);
                } else if (speciesSelected.equals("Świnka morska")) {
                    sbAge.setMax(9);
                }
            }
        });

        sbAge.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                ageValue = progress;
                tvAgeDisplay.setText("Ile ma lat? " + progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String owner = etOwner.getText().toString();
                String purpose = etPurpose.getText().toString();
                String time = etTime.getText().toString();

                String output = owner + ", " + speciesSelected + ", " + ageValue + ", " + purpose + ", " + time;
                tvSummary.setText(output);
            }
        });
    }
}
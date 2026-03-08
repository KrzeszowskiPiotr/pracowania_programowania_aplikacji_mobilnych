package edu.zsk.sprawdzianpiotrkrzeszowski4c;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private EditText nameInput, surnameInput, classInput;
    private Button saveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        nameInput = findViewById(R.id.name_input);
        surnameInput = findViewById(R.id.surname_input);
        classInput = findViewById(R.id.class_input);
        saveButton = findViewById(R.id.save_note_button);

        saveButton.setOnClickListener(v -> {
            String name = nameInput.getText().toString().trim();
            String surname = surnameInput.getText().toString().trim();
            String className = classInput.getText().toString().trim();

            if (name.isEmpty() || surname.isEmpty() || className.isEmpty()) {
                Toast.makeText(this, "Wypełnij wszystkie pola!", Toast.LENGTH_SHORT).show();
            } else {
                ProgressDialog progressDialog = new ProgressDialog(this);
                progressDialog.setTitle("Dodaję uwagę...");
                progressDialog.setMessage("Proszę czekać.");
                progressDialog.show();

                nameInput.setText("");
                surnameInput.setText("");
                classInput.setText("");

                new Handler().postDelayed(() -> {
                    progressDialog.dismiss();

                    Intent intent = new Intent(MainActivity.this, ReportedActivity.class);
                    intent.putExtra("NAME_EXTRA", name);
                    intent.putExtra("SURNAME_EXTRA", surname);
                    intent.putExtra("CLASS_EXTRA", className);

                    startActivity(intent);
                }, 2000);
            }
        });
    }
}
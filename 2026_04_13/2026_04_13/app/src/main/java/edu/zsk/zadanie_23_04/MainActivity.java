package edu.zsk.zadanie_23_04;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private int clickCount = 0;
    private String welcomeMessage = "";

    private EditText etName, etEmail;
    private TextView txt1, txt2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.etName);
        etEmail = findViewById(R.id.etEmail);
        Button btnCounter = findViewById(R.id.btnCounter);
        txt1 = findViewById(R.id.txt1);
        txt2 = findViewById(R.id.txt2);

        if(savedInstanceState != null)
        {
            clickCount = savedInstanceState.getInt("COUNT_KEY");
            welcomeMessage = savedInstanceState.getString("WELCOME_KEY","");

            txt1.setText(welcomeMessage);
            txt2.setText("Kliknales przycisk " + clickCount + " razy");
        }

        btnCounter.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String name = etName.getText().toString().trim();
                String email = etEmail.getText().toString().trim();

                if(name.isEmpty() || email.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Najpierw uzupelnij swoje dane", Toast.LENGTH_SHORT).show();
                }else {
                    clickCount++;
                    welcomeMessage = "Witaj, " + name + "!Twoj adres e-mail to: " + email;

                    txt1.setText(welcomeMessage);
                    txt2.setText("Kliknales przycisk " + clickCount + " razy");
                }
            }
        });
    }
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("COUNT_KEY", clickCount);
        outState.putString("WELCOME_KEY", welcomeMessage);
    }
}
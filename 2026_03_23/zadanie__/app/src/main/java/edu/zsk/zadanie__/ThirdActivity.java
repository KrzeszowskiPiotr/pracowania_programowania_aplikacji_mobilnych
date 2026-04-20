package edu.zsk.zadanie__;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class ThirdActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        Button btn4 = findViewById(R.id.btn4);
        btn4.setOnClickListener(v -> startActivity(new Intent(this, MainActivity.class)));
    }
}
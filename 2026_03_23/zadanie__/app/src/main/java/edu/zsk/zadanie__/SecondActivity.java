package edu.zsk.zadanie__;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Button btn3 = findViewById(R.id.btn3);
        btn3.setOnClickListener(v -> startActivity(new Intent(this, MainActivity.class)));
    }
}
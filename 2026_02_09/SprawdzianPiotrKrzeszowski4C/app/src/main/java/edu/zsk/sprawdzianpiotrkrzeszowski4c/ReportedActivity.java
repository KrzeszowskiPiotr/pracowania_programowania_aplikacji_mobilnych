package edu.zsk.sprawdzianpiotrkrzeszowski4c;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ReportedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_reported);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        setContentView(R.layout.activity_reported);


        String name = getIntent().getStringExtra("NAME_EXTRA");
        String surname = getIntent().getStringExtra("SURNAME_EXTRA");
        String className = getIntent().getStringExtra("CLASS_EXTRA");


        TextView reportedName = findViewById(R.id.reported_name);
        TextView reportedSurname = findViewById(R.id.reported_surname);
        TextView reportedClass = findViewById(R.id.reported_class);

        reportedName.setText(name);
        reportedSurname.setText(surname);
        reportedClass.setText(className);


        Button backButton = findViewById(R.id.save_note_button);
        backButton.setOnClickListener(v -> {
            finish();
        });
    }
}
package com.example.mobileas1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.CheckBox;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private CheckBox readyCheckBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        readyCheckBox = findViewById(R.id.readyCheckBox);

        // Set OnClickListener on CheckBox
        readyCheckBox.setOnClickListener(v -> {
            if (readyCheckBox.isChecked()) {
                Intent intent = new Intent(MainActivity.this, WorkoutSelectionActivity.class);
                startActivity(intent);
            }
        });
    }
}


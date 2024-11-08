package com.example.mobileas1;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import androidx.appcompat.app.AppCompatActivity;

public class WorkoutSelectionActivity extends AppCompatActivity {

    private Spinner workoutSpinner;
    private String selectedWorkout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_selection);

        workoutSpinner = findViewById(R.id.workoutSpinner);
        Button btnSelectWorkout = findViewById(R.id.btnSelectWorkout);

        String[] workouts = {"Legs", "Shoulders", "Chest", "Back"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, workouts);
        workoutSpinner.setAdapter(adapter);

        workoutSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedWorkout = workouts[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });

        btnSelectWorkout.setOnClickListener(v -> {
            Intent intent = new Intent(WorkoutSelectionActivity.this, ExerciseListActivity.class);
            intent.putExtra("WORKOUT_TYPE", selectedWorkout);
            startActivity(intent);
        });
    }
}

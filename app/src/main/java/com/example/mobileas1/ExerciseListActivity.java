package com.example.mobileas1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.HashMap;
import java.util.List;

public class ExerciseListActivity extends AppCompatActivity {

    private ListView exerciseListView;
    private List<String> exercises;
    private HashMap<String, Integer> exerciseImages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_list);

        exerciseListView = findViewById(R.id.exerciseListView);

        // Get the workout type from the intent
        String workoutType = getIntent().getStringExtra("WORKOUT_TYPE");

        // Fetch the exercises based on the workout type
        exercises = ExerciseData.getExercises(workoutType);

        // Initialize the exercise images map
        initializeExerciseImages();

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, exercises);
        exerciseListView.setAdapter(adapter);

        // Set click listener to handle item selection
        exerciseListView.setOnItemClickListener((parent, view, position, id) -> {
            String selectedExercise = exercises.get(position);
            Integer imageResId = exerciseImages.get(selectedExercise);

            if (imageResId != null) { // Only pass if the exercise has an associated image
                Intent intent = new Intent(ExerciseListActivity.this, ExerciseDetailActivity.class);
                intent.putExtra("EXERCISE_NAME", selectedExercise);
                intent.putExtra("EXERCISE_IMAGE", imageResId);
                startActivity(intent);
            }
        });
    }

    private void initializeExerciseImages() {
        exerciseImages = new HashMap<>();
        exerciseImages.put("Squats", R.drawable.squats);
        exerciseImages.put("Lunges", R.drawable.lunges);
        exerciseImages.put("Calf Raises", R.drawable.calf_raises);
        exerciseImages.put("Leg Extensions", R.drawable.leg_extensions);
        exerciseImages.put("Pike Push-Ups", R.drawable.pike_push_ups);
        exerciseImages.put("Arm Circles", R.drawable.arm_circles );
        exerciseImages.put("Front Arm Raises ", R.drawable.front_arm_raises );
        exerciseImages.put("Side Arm Raises", R.drawable.side_arm_raises);
        exerciseImages.put("Wide Push-Ups", R.drawable.wide_push_ups);
        exerciseImages.put("Incline Push-Ups", R.drawable.incline_push_ups);
        exerciseImages.put("Regular Push-Ups", R.drawable.regular_push_ups);
        exerciseImages.put("Decline Push-Ups", R.drawable.decline_push_ups);
        exerciseImages.put("Superman Exercise", R.drawable.superman);
        exerciseImages.put("Bird Dog", R.drawable.bird_dog );
        exerciseImages.put("Reverse Snow Angels", R.drawable.reverse_snow_angels);


    }
}

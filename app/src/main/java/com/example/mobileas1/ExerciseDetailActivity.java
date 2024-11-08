package com.example.mobileas1;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ExerciseDetailActivity extends AppCompatActivity {

    private int seconds = 0;
    private boolean running = false;
    private TextView timerText;
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_detail);

        timerText = findViewById(R.id.timerText);
        Button btnStart = findViewById(R.id.btnStart);
        Button btnStop = findViewById(R.id.btnStop);
        Button btnReset = findViewById(R.id.btnReset);
        ImageView exerciseImage = findViewById(R.id.exerciseImage);

        // Get the exercise image resource ID from the intent
        int imageResId = getIntent().getIntExtra("EXERCISE_IMAGE", -1);

        if (imageResId != -1) {
            exerciseImage.setImageResource(imageResId);
        } else {
            exerciseImage.setVisibility(View.GONE); // Hide the ImageView if no image is available
        }

        btnStart.setOnClickListener(v -> running = true);
        btnStop.setOnClickListener(v -> running = false);
        btnReset.setOnClickListener(v -> {
            running = false;
            seconds = 0;
            updateTimer();
        });

        runTimer();
    }

    private void runTimer() {
        handler.post(new Runnable() {
            @Override
            public void run() {
                int hours = seconds / 3600;
                int minutes = (seconds % 3600) / 60;
                int secs = seconds % 60;

                String time = String.format("%02d:%02d:%02d", hours, minutes, secs);
                timerText.setText(time);

                if (running) {
                    seconds++;
                }
                handler.postDelayed(this, 1000);
            }
        });
    }

    private void updateTimer() {
        int hours = seconds / 3600;
        int minutes = (seconds % 3600) / 60;
        int secs = seconds % 60;
        String time = String.format("%02d:%02d:%02d", hours, minutes, secs);
        timerText.setText(time);
    }
}

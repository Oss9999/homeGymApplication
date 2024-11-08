package com.example.mobileas1;

import java.util.ArrayList;
import java.util.List;

public class ExerciseData {

    public static List<String> getExercises(String workoutType) {
        List<String> exercises = new ArrayList<>();

        switch (workoutType) {
            case "Legs":
                exercises.add("Squats");
                exercises.add("Lunges");
                exercises.add("Leg Extensions");
                exercises.add("Calf Raises");
                break;

            case "Shoulders":
                exercises.add("Pike Push-Ups");
                exercises.add("Arm Circles");
                exercises.add("Front Arm Raises");
                exercises.add("Side Arm Raises");
                break;

            case "Chest":
                exercises.add("Regular Push-Ups");
                exercises.add("Incline Push-Ups");
                exercises.add("Wide Push-Ups");
                exercises.add("Decline Push-Ups");
                break;

            case "Back":
                exercises.add("Superman Exercise");
                exercises.add("Bird Dog");
                exercises.add("Reverse Snow Angels");
                break;


            default:
                exercises.add("No exercises available");
                break;
        }

        return exercises;
    }
}

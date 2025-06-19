package ExamPrep.workout;

import java.util.ArrayList;
import java.util.List;

public class Workout {
    private List<Exercise> exercises;
    private String type;
    private int exerciseCount;

    public Workout(String type, int exerciseCount) {
        this.exercises = new ArrayList<>();
        this.type = type;
        this.exerciseCount = exerciseCount;
    }

    public List<Exercise> getExercises() {
        return this.exercises;
    }

    public String getType() {
        return this.type;
    }

    public void addExercise(Exercise exercise){
        if (this.exerciseCount> this.exercises.size()){
            this.exercises.add(exercise);
        }
    }

    public boolean removeExercise(String name, String muscle){
        for (Exercise exercise : this.exercises) {
            if (exercise.getName().equals(name) && exercise.getMuscle().equals(muscle)) {
                this.exercises.remove(exercise);
                return true;
            }
        }
        return false;
    }

    public Exercise getExercise(String name, String muscle){
        for (Exercise exercise : this.exercises) {
            if (exercise.getName().equals(name) && exercise.getMuscle().equals(muscle)) {
               return  exercise;
            }
        }
        return null;
    }

    public Exercise getMostBurnedCaloriesExercise(){
        if (this.exercises.size() <=0){
            return null;
        }
        int maxBurnedCalories =0;
        Exercise maxExercise = null;
        for (Exercise exercise : this.exercises) {
            if (exercise.getBurnedCalories()> maxBurnedCalories) {
                maxBurnedCalories = exercise.getBurnedCalories();
                maxExercise = exercise;
            }
        }
        return  maxExercise;
    }

    public int getExerciseCount() {
        return  this.exercises.size();
    }

    public String getStatistics(){
        StringBuilder sb = new StringBuilder();
        sb.append("Workout type: ").append(this.type).append(System.lineSeparator());

        for (Exercise exercise : this.exercises) {
            sb.append(exercise.toString()).append(System.lineSeparator());
        }

        return sb.toString().trim();

    }
}

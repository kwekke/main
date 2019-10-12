package seedu.exercise.model;

import javafx.collections.ObservableList;
import seedu.exercise.model.exercise.Exercise;

public interface ReadOnlyExerciseDatabase {

    ObservableList<Exercise> getAllExerciseList();
    ObservableList<Exercise> getSampleExerciseList();
}

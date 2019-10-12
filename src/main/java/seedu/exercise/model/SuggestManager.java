package seedu.exercise.model;

import static java.util.Objects.requireNonNull;

import java.util.List;

import javafx.collections.ObservableList;
import seedu.exercise.model.exercise.Exercise;
import seedu.exercise.model.exercise.UniqueExerciseList;

public class SuggestManager {

    private final UniqueExerciseList allExercises = new UniqueExerciseList();

    public SuggestManager() {};

    public SuggestManager(ReadOnlyExerciseBook allExercises) {
        this();
        resetData(allExercises);
    }

    //// list overwrite operations

    /**
     * Replaces the contents of the exercise list with {@code exercises}.
     * {@code exercises} must not contain duplicate exercises.
     */
    public void setExercises(List<Exercise> exercises) {
        this.allExercises.setExercises(exercises);
    }

    /**
     * Resets the existing data of this {@code ExerciseBook} with {@code newData}.
     */
    public void resetData(ReadOnlyExerciseBook newData) {
        requireNonNull(newData);

        setExercises(newData.getExerciseList());
    }

    //// exercise-level operations

    /**
     * Returns true if a exercise with the same identity as {@code exercise} exists in the exercise book.
     */
    public boolean hasExercise(Exercise exercise) {
        requireNonNull(exercise);
        return allExercises.contains(exercise);
    }

    //// util methods

    public String toString() {
        return allExercises.asUnmodifiableObservableList().size() + " exercises";
        // TODO: refine later
    }

    public ObservableList<Exercise> getExerciseList() {
        return allExercises.asUnmodifiableObservableList();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(obj instanceof ModelManager)) {
            return false;
        }

        // state check
        SuggestManager other = (SuggestManager) obj;
        return allExercises.equals(other.allExercises);
    }
}

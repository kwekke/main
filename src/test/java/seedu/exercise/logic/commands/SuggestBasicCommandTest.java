package seedu.exercise.logic.commands;

import static seedu.exercise.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.exercise.testutil.TypicalExercises.getTypicalExerciseBook;

import org.junit.jupiter.api.Test;

import seedu.exercise.model.ExerciseBook;
import seedu.exercise.model.Model;
import seedu.exercise.model.ModelManager;
import seedu.exercise.model.RegimeBook;
import seedu.exercise.model.UserPrefs;

public class SuggestBasicCommandTest {

    private Model model;
    private Model expectedModel;

    public void setUp() {
        model = new ModelManager(new ExerciseBook(), new RegimeBook(),
                getTypicalExerciseBook(), new UserPrefs());
        expectedModel = new ModelManager(new ExerciseBook(), new RegimeBook(),
                model.getAllExerciseBookData(), new UserPrefs());
    }

    @Test
    public void execute_listIsNotFiltered_showsSameList() {
        assertCommandSuccess(new SuggestBasicCommand(), model, SuggestCommand.MESSAGE_SUCCESS, expectedModel);
    }

}

package seedu.exercise.logic.commands;

import static java.util.Objects.requireNonNull;

import java.util.function.Predicate;

import seedu.exercise.logic.commands.exceptions.CommandException;
import seedu.exercise.model.Model;
import seedu.exercise.model.exercise.Exercise;

public class SuggestBasicCommand extends Command {

    public static final String COMMAND_WORD = "suggest-basic";

    public static final String MESSAGE_SUCCESS = "Listed all suggested exercises";

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        model.updateFilteredExerciseList(new Predicate<Exercise>() {
            @Override
            public boolean test(Exercise exercise) {
                return true;
            }
        });
        return new CommandResult(MESSAGE_SUCCESS);
    }
}

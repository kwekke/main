package seedu.exercise.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.exercise.logic.parser.CliSyntax.PREFIX_MUSCLE;
import static seedu.exercise.logic.parser.CliSyntax.PREFIX_SUGGEST;

import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;

import seedu.exercise.logic.commands.exceptions.CommandException;
import seedu.exercise.model.Model;
import seedu.exercise.model.property.CustomProperty;
import seedu.exercise.model.property.Muscle;
import seedu.exercise.model.resource.Exercise;

public class SuggestPossibleCommand extends SuggestCommand {

    public static final String MESSAGE_SUCCESS = "Listed suggested exercises.";

    public static final String MESSAGE_USAGE_SUGGEST_POSSIBLE = "Parameters: "
            + PREFIX_SUGGEST + "POSSIBLE"
            + PREFIX_MUSCLE + "MUSCLE]...\n"
            + "\t\tExample: " + COMMAND_WORD + " "
            + PREFIX_SUGGEST + "possible "
            + PREFIX_MUSCLE + "Leg";

    private Set<Muscle> muscles;

    public SuggestPossibleCommand(Set<Muscle> muscles) {
        this.muscles = muscles;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        Predicate<Exercise> predicate = new Predicate<Exercise>() {
            @Override
            public boolean test(Exercise exercise) {
                Set<Muscle> m = exercise.getMuscles();
                for(Muscle muscle: muscles) {
                    if (!(m.contains(muscle))) {
                        return false;
                    }
                }
                return true;
            }
        };
        model.updateSuggestedExerciseList(predicate);
        return new CommandResult(MESSAGE_SUCCESS);
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof SuggestPossibleCommand); // instanceof handles nulls
    }
}

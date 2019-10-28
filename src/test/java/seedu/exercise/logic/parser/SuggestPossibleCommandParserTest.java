package seedu.exercise.logic.parser;

import static seedu.exercise.logic.commands.CommandTestUtil.VALID_FULL_NAME_RATING;
import static seedu.exercise.logic.commands.CommandTestUtil.VALID_FULL_NAME_REMARK;
import static seedu.exercise.logic.commands.CommandTestUtil.VALID_MUSCLE_AEROBICS;
import static seedu.exercise.logic.commands.CommandTestUtil.VALID_MUSCLE_BASKETBALL;
import static seedu.exercise.logic.commands.CommandTestUtil.VALID_PARAMETER_TYPE_RATING;
import static seedu.exercise.logic.commands.CommandTestUtil.VALID_PARAMETER_TYPE_REMARK;
import static seedu.exercise.logic.commands.CommandTestUtil.VALID_PREFIX_NAME_RATING;
import static seedu.exercise.logic.commands.CommandTestUtil.VALID_PREFIX_NAME_REMARK;
import static seedu.exercise.logic.commands.CommandTestUtil.VALID_RATING_VALUE;
import static seedu.exercise.logic.commands.CommandTestUtil.VALID_REMARK_VALUE;
import static seedu.exercise.logic.parser.CommandParserTestUtil.assertParseSuccess;
import static seedu.exercise.logic.parser.predicate.PredicateUtil.predicateShowExerciseWithCustomProperty;
import static seedu.exercise.logic.parser.predicate.PredicateUtil.predicateShowExercisesWithMuscle;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;

import org.junit.jupiter.api.Test;

import seedu.exercise.logic.commands.SuggestPossibleCommand;
import seedu.exercise.logic.parser.predicate.BasePropertyPredicate;
import seedu.exercise.logic.parser.predicate.ExercisePredicate;
import seedu.exercise.model.property.CustomProperty;
import seedu.exercise.model.property.Muscle;
import seedu.exercise.model.resource.Exercise;
import seedu.exercise.testutil.CustomPropertyBuilder;

public class SuggestPossibleCommandParserTest {
    private SuggestCommandParser parser = new SuggestCommandParser();

    @Test
    public void parse_optionalFieldsMissing_success() {
        Set<Muscle> targetMuscles = new HashSet<>();
        targetMuscles.add(new Muscle(VALID_MUSCLE_AEROBICS));
        targetMuscles.add(new Muscle(VALID_MUSCLE_BASKETBALL));
        BasePropertyPredicate predicateMuscleAnd = predicateShowExercisesWithMuscle(targetMuscles, true);
        BasePropertyPredicate predicateMuscleOr = predicateShowExercisesWithMuscle(targetMuscles, false);

        Map<String, String> targetCustomProperties = new HashMap<>();
        CustomProperty rating = new CustomPropertyBuilder().withPrefix(VALID_PREFIX_NAME_RATING)
                .withFullName(VALID_FULL_NAME_RATING).withParameterType(VALID_PARAMETER_TYPE_RATING).build();
        CustomProperty remark = new CustomPropertyBuilder().withPrefix(VALID_PREFIX_NAME_REMARK)
                .withFullName(VALID_FULL_NAME_REMARK).withParameterType(VALID_PARAMETER_TYPE_REMARK).build();
        targetCustomProperties.put(VALID_FULL_NAME_RATING, VALID_RATING_VALUE);
        targetCustomProperties.put(VALID_FULL_NAME_REMARK, VALID_REMARK_VALUE);
        Predicate<Exercise> predicateCustomPropertyAnd =
                predicateShowExerciseWithCustomProperty(targetCustomProperties, true);
        Predicate<Exercise> predicateCustomPropertyOr =
                predicateShowExerciseWithCustomProperty(targetCustomProperties, false);

        //no custom properties
        Predicate<Exercise> exercisePredicateMuscleAdd = new ExercisePredicate(true, predicateMuscleAnd);
        assertParseSuccess(parser, " s/possible o/and m/Back m/Arms",
                new SuggestPossibleCommand(exercisePredicateMuscleAdd));
    }

}

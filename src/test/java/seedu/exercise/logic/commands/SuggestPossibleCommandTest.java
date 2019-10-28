package seedu.exercise.logic.commands;

import static seedu.exercise.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.exercise.logic.parser.predicate.PredicateUtil.predicateShowExerciseWithCustomProperty;
import static seedu.exercise.logic.parser.predicate.PredicateUtil.predicateShowExercisesWithMuscle;
import static seedu.exercise.model.util.DefaultPropertyBookUtil.getDefaultPropertyBook;
import static seedu.exercise.testutil.CommonTestData.VALID_FULL_NAME_RATING;
import static seedu.exercise.testutil.CommonTestData.VALID_FULL_NAME_REMARK;
import static seedu.exercise.testutil.CommonTestData.VALID_MUSCLE_AEROBICS;
import static seedu.exercise.testutil.CommonTestData.VALID_MUSCLE_BASKETBALL;
import static seedu.exercise.testutil.CommonTestData.VALID_PARAMETER_TYPE_RATING;
import static seedu.exercise.testutil.CommonTestData.VALID_PARAMETER_TYPE_REMARK;
import static seedu.exercise.testutil.CommonTestData.VALID_PREFIX_NAME_RATING;
import static seedu.exercise.testutil.CommonTestData.VALID_PREFIX_NAME_REMARK;
import static seedu.exercise.testutil.CommonTestData.VALID_VALUE_RATING;
import static seedu.exercise.testutil.CommonTestData.VALID_VALUE_REMARK;
import static seedu.exercise.testutil.typicalutil.TypicalExercises.getTypicalExerciseBook;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import seedu.exercise.model.Model;
import seedu.exercise.model.ModelManager;
import seedu.exercise.model.ReadOnlyResourceBook;
import seedu.exercise.model.UserPrefs;
import seedu.exercise.model.property.CustomProperty;
import seedu.exercise.model.property.Muscle;
import seedu.exercise.model.resource.Exercise;
import seedu.exercise.testutil.builder.CustomPropertyBuilder;

public class SuggestPossibleCommandTest {

    private Model model;
    private Model expectedModel;
    private Set<Muscle> targetMuscles;
    private Map<String, String> targetCustomProperties;

    @BeforeEach
    public void setUp() {
        model = new ModelManager(getTypicalExerciseBook(), new ReadOnlyResourceBook<>(),
                getTypicalExerciseBook(), new ReadOnlyResourceBook<>(),
                new UserPrefs(), getDefaultPropertyBook());
        expectedModel = new ModelManager(model.getExerciseBookData(), new ReadOnlyResourceBook<>(),
                getTypicalExerciseBook(), new ReadOnlyResourceBook<>(),
                new UserPrefs(), getDefaultPropertyBook());

        targetMuscles = new HashSet<Muscle>();
        targetMuscles.add(new Muscle(VALID_MUSCLE_AEROBICS));
        targetMuscles.add(new Muscle(VALID_MUSCLE_BASKETBALL));

        targetCustomProperties = new HashMap<String, String>();
        targetCustomProperties.put(VALID_FULL_NAME_RATING, VALID_VALUE_RATING);
        targetCustomProperties.put(VALID_FULL_NAME_REMARK, VALID_VALUE_REMARK);
        CustomProperty rating = new CustomPropertyBuilder().withPrefix(VALID_PREFIX_NAME_RATING)
                .withFullName(VALID_FULL_NAME_RATING).withParameterType(VALID_PARAMETER_TYPE_RATING).build();
        CustomProperty remark = new CustomPropertyBuilder().withPrefix(VALID_PREFIX_NAME_REMARK)
                .withFullName(VALID_FULL_NAME_REMARK).withParameterType(VALID_PARAMETER_TYPE_REMARK).build();
        model.getPropertyBook().addCustomProperty(rating);
        model.getPropertyBook().addCustomProperty(remark);
        expectedModel.getPropertyBook().addCustomProperty(rating);
        expectedModel.getPropertyBook().addCustomProperty(remark);

    }

    @Test
    public void execute_suggestPossibleMuscle_success() {
        boolean isStrict = true;
        Predicate<Exercise> predicateMuscleAnd = predicateShowExercisesWithMuscle(targetMuscles, isStrict);

        expectedModel.updateSuggestedExerciseList(predicateMuscleAnd);
        assertCommandSuccess(new SuggestPossibleCommand(predicateMuscleAnd),
                model, SuggestPossibleCommand.MESSAGE_SUCCESS, expectedModel);
    }

    @Test
    public void execute_suggestPossibleCustomProperty_success() {
        boolean isStrict = true;
        Predicate<Exercise> predicateCustomPropertyAnd =
                predicateShowExerciseWithCustomProperty(targetCustomProperties, isStrict);

        expectedModel.updateSuggestedExerciseList(predicateCustomPropertyAnd);
        assertCommandSuccess(new SuggestPossibleCommand(predicateCustomPropertyAnd),
                model, SuggestPossibleCommand.MESSAGE_SUCCESS, expectedModel);
    }

}

package seedu.exercise.testutil;

import seedu.exercise.logic.parser.Prefix;
import seedu.exercise.model.exercise.CustomProperty;
import seedu.exercise.model.exercise.ParameterType;

/**
 * A utility class to help with building CustomProperty objects.
 */
public class CustomPropertyBuilder {

    private static final String DEFAULT_PREFIX = "r";
    private static final String DEFAULT_FULL_NAME = "Rating";
    private static final String DEFAULT_PARAMETER_TYPE = "Number";

    private Prefix prefix;
    private String fullName;
    private ParameterType parameterType;

    public CustomPropertyBuilder() {
        prefix = new Prefix(DEFAULT_PREFIX);
        fullName = DEFAULT_FULL_NAME;
        parameterType = ParameterType.NUMBER;
    }

    public CustomPropertyBuilder(CustomProperty customPropertyToCopy) {
        prefix = customPropertyToCopy.getPrefix();
        fullName = customPropertyToCopy.getFullName();
        parameterType = customPropertyToCopy.getParameterType();
    }

    /**
     * Sets the {@code Prefix} of the {@code CustomProperty} that we are building.
     */
    public CustomPropertyBuilder withPrefix(String prefix) {
        this.prefix = new Prefix(prefix + "/");
        return this;
    }

    /**
     * Sets the full name of the {@code CustomProperty} that we are building.
     */
    public CustomPropertyBuilder withFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    /**
     * Sets the {@code ParameterType} of the {@code CustomProperty} that we are building.
     */
    public CustomPropertyBuilder withParameterType(String parameterType) {
        this.parameterType = parameterType.equals("Number")
                ? ParameterType.NUMBER
                : parameterType.equals("Text")
                    ? ParameterType.TEXT
                    : ParameterType.DATE;
        return this;
    }

    public CustomProperty build() {
        return new CustomProperty(prefix, fullName, parameterType);
    }

}

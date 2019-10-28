package seedu.exercise.ui;

import static java.util.Objects.requireNonNull;

/**
 * Encapsulates the different list of resource types to be displayed in GUI.
 */
public enum ListResourceType {
    NULL("null"),
    EXERCISE("exercise"),
    REGIME("regime"),
    SCHEDULE("schedule"),
    SUGGESTION("suggestion");

    public static final String LIST_RESOURCE_TYPE_CONSTRAINTS =
            "List resource type should be one of the following: exercise, regime, schedule or suggestion";

    private String resourceType;

    ListResourceType(String resourceType) {
        this.resourceType = resourceType;
    }

}

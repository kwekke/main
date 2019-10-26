package seedu.exercise.logic.commands;

import static java.util.Objects.requireNonNull;

import java.util.Objects;

/**
 * Represents the result of a command execution.
 */
public class CommandResult {

    private final String feedbackToUser;

    /**
     * Help information should be shown to the user.
     */
    private final boolean showHelp;

    /**
     * The application should exit.
     */
    private final boolean exit;

    private boolean showExerciseList = false;

    private boolean showRegimeList = false;

    private boolean showScheduleList = false;

    private boolean showSuggestionlist = false;

    /**
     * Show the resolve window to user due to scheduling conflict
     */
    private final boolean showResolve;

    /**
     * Constructs a {@code CommandResult} with the specified fields.
     */
    public CommandResult(String feedbackToUser, boolean showHelp, boolean exit, boolean showResolve) {
        this.feedbackToUser = requireNonNull(feedbackToUser);
        this.showHelp = showHelp;
        this.exit = exit;
        this.showResolve = showResolve;
    }

    public CommandResult showExercises() {
        assert !(showExerciseList || showRegimeList || showScheduleList || showSuggestionlist);
        showExerciseList = true;
        return this;
    }

    public CommandResult showRegimes() {
        assert !(showExerciseList || showRegimeList || showScheduleList || showSuggestionlist);
        this.showRegimeList = true;
        return this;
    }

    public CommandResult showSchedules() {
        assert !(showExerciseList || showRegimeList || showScheduleList || showSuggestionlist);
        this.showScheduleList = true;
        return this;
    }

    public CommandResult showSuggestions() {
        assert !(showExerciseList || showRegimeList || showScheduleList || showSuggestionlist);
        this.showSuggestionlist = true;
        return this;
    }

    /**
     * Constructs a {@code CommandResult} with the specified {@code feedbackToUser},
     * and other fields set to their default value.
     */
    public CommandResult(String feedbackToUser) {
        this(feedbackToUser, false, false, false);
    }

    public String getFeedbackToUser() {
        return feedbackToUser;
    }

    public boolean isShowHelp() {
        return showHelp;
    }

    public boolean isExit() {
        return exit;
    }

    public boolean isShowExerciseList() {
        return showExerciseList;
    }

    public boolean isShowRegimeList() {
        return showRegimeList;
    }

    public boolean isShowScheduleList() {
        return showScheduleList;
    }

    public boolean isShowSuggestionList() {
        return showSuggestionlist;
    }

    public boolean isShowResolve() {
        return showResolve;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof CommandResult)) {
            return false;
        }

        CommandResult otherCommandResult = (CommandResult) other;
        return feedbackToUser.equals(otherCommandResult.feedbackToUser)
            && showHelp == otherCommandResult.showHelp
            && exit == otherCommandResult.exit;
    }

    @Override
    public int hashCode() {
        return Objects.hash(feedbackToUser, showHelp, exit);
    }

}

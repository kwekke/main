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

    private boolean showResultsList;
    private boolean showRegimeList;
    private boolean showScheduleList;
    private boolean showSuggestionlist;


    /**
     * Constructs a {@code CommandResult} with the specified fields.
     */

    public CommandResult(String feedbackToUser, boolean showHelp, boolean exit) {
        this.feedbackToUser = requireNonNull(feedbackToUser);
        this.showHelp = showHelp;
        this.exit = exit;
    }

    public CommandResult showResults() {
        this.showResultsList = true;
        return this;
    }

    public CommandResult showRegimes() {
        this.showRegimeList = true;
        return this;
    }

    public CommandResult showSchedules() {
        this.showScheduleList = true;
        return this;
    }

    public CommandResult showSuggestions() {
        this.showSuggestionlist = true;
        return this;
    }

    /**
     * Constructs a {@code CommandResult} with the specified {@code feedbackToUser},
     * and other fields set to their default value.
     */
    public CommandResult(String feedbackToUser) {
        this(feedbackToUser, false, false);
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

    public boolean isShowResultsList() {
        return showResultsList;
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

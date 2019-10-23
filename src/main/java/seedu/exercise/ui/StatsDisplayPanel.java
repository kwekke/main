package seedu.exercise.ui;

import java.util.logging.Logger;

import javafx.scene.layout.Region;
import seedu.exercise.commons.core.LogsCenter;

public class StatsDisplayPanel extends UiPart<Region> {
    private static final String FXML = "StatsDisplayPanel.fxml";
    private final Logger logger = LogsCenter.getLogger(StatsDisplayPanel.class);

    public StatsDisplayPanel() {
        super(FXML);
    }
}

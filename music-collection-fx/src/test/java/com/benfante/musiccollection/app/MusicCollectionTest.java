package com.benfante.musiccollection.app;

import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxAssert;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;
import org.testfx.matcher.base.WindowMatchers;
import org.testfx.matcher.control.LabeledMatchers;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.CoreMatchers.*;

/**
 * Basic tests on the MusicCollection app.
 *
 * @author lucio
 */
@ExtendWith(ApplicationExtension.class)
public class MusicCollectionTest {
    private Stage stage;

    @Start
    private void start(Stage stage) throws Exception {
        this.stage = stage;
        MusicCollection app = new MusicCollection();
        app.start(stage);
    }

    @Test
    void testAppTitle(FxRobot robot) {
        assertThat(stage.getTitle(), is("Music Collection"));
    }
    
    @Test
    void testAppIsShowed(FxRobot robot) {
        FxAssert.verifyThat(stage, WindowMatchers.isShowing());
    }
    
    // Probably you'll want to remove this test when you'll enhance the app
    @Test
    void testAppLabel(FxRobot robot) {
        FxAssert.verifyThat("#helloLabel", LabeledMatchers.hasText("Hello, Music Collection"));
    }
}

package com.benfante.musiccollection.app;

import java.util.concurrent.TimeoutException;
import javafx.application.Application;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.testfx.api.FxAssert;
import org.testfx.matcher.base.WindowMatchers;
import org.testfx.matcher.control.LabeledMatchers;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.springframework.boot.test.context.SpringBootTest;
import org.testfx.api.FxToolkit;

/**
 * Basic tests on the MusicCollection app.
 *
 * @author lucio
 */
@SpringBootTest
public class MusicCollectionTest {
    private static Application application;
    private static Stage stage;
    
    @BeforeAll
    private static void setup() throws TimeoutException {
        FxToolkit.registerPrimaryStage();
        application = new MusicCollection();
        FxToolkit.setupApplication(() -> application);        
        stage = FxToolkit.toolkitContext().getRegisteredStage();
    }

    @AfterAll
    private static void shutdown() throws TimeoutException {
        FxToolkit.cleanupStages();
    }
    
    @Test
    void testAppTitle() {
        assertThat(stage.getTitle(), is("Music Collection"));
    }
    
    @Test
    void testAppIsShowed() {
        FxAssert.verifyThat(stage, WindowMatchers.isShowing());
    }
    
    // Probably you'll want to remove this test when you'll enhance the app
    @Test
    void testAppLabel() {
        FxAssert.verifyThat("#helloLabel", LabeledMatchers.hasText("Hello, Music Collection"));
    }
}

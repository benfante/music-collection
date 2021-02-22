package com.benfante.musiccollection.app.spring;

import com.benfante.musiccollection.app.MusicCollection;
import com.benfante.musiccollection.app.controller.MainController;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import net.rgielen.fxweaver.core.FxWeaver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 *
 * @author lucio
 */
@Component
public class StageInitializer implements ApplicationListener<MusicCollection.StageReadyEvent> {

    private final String applicationTitle;
    private final FxWeaver fxWeaver;

    public StageInitializer(@Value("${spring.application.ui.title}") String applicationTitle,
            FxWeaver fxWeaver) {
        this.applicationTitle = applicationTitle;
        this.fxWeaver = fxWeaver;
    }

    @Override
    public void onApplicationEvent(MusicCollection.StageReadyEvent e) {
        Stage stage = e.getStage();
        Parent root = fxWeaver.loadView(MainController.class);
        stage.setTitle("Music Collection");
        stage.setScene(new Scene(root));
        stage.show();
    }

}

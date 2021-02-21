package com.benfante.musiccollection.app;

import javafx.application.Application;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *
 * @author lucio
 */
@SpringBootApplication
public class MusicCollectionApplication {
    public static void main(String[] args) {
        Application.launch(MusicCollection.class, args);
    }
}

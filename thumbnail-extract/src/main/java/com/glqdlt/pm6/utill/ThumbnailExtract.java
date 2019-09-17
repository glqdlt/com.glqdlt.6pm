package com.glqdlt.pm6.utill;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Date 2019-09-14
 *
 * @author glqdlt
 */
public class ThumbnailExtract extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(ClassLoader.getSystemResource("sample.fxml"));
        stage.setTitle("썸네일 추출기");
        stage.setScene(new Scene(root, 1600, 900));
        stage.show();
    }
}

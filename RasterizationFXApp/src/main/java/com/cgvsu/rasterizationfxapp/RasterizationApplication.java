package com.cgvsu.rasterizationfxapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ru.edu.vsu.cs.kumitskiy_k_s.math.Vector3d;
import ru.edu.vsu.cs.kumitskiy_k_s.models.Model;

import java.io.IOException;

public class RasterizationApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(RasterizationApplication.class.getResource("mainwindow.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setTitle("Rasterization App");
        stage.setScene(scene);
        stage.show();

        Model model = new Model();
        model.getVertices().add(new Vector3d(1.0,1.0,1.0));
        System.out.println(model.getVertices().get(0));
    }

    public static void main(String[] args) {
        launch();
    }
}
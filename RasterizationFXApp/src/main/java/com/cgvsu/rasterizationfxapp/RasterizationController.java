package com.cgvsu.rasterizationfxapp;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.AnchorPane;

import javafx.scene.paint.Color;
import ru.edu.vsu.cs.kumitskiy_k_s.math.Vector3d;
import ru.edu.vsu.cs.kumitskiy_k_s.models.Model;
import ru.edu.vsu.cs.kumitskiy_k_s.models.Polygon;
import ru.edu.vsu.cs.kumitskiy_k_s.rastarization.Rasterization;
import ru.edu.vsu.cs.kumitskiy_k_s.rastarization.TriangleRasterizationV1;
import ru.edu.vsu.cs.kumitskiy_k_s.rastarization.tools.Vertex;
import ru.edu.vsu.cs.kumitskiy_k_s.triangulation.MyTriangulation;
import ru.edu.vsu.cs.kumitskiy_k_s.triangulation.TriangulatedModel;
import ru.edu.vsu.cs.kumitskiy_k_s.triangulation.Triangulation;

import java.util.List;
import java.util.Random;

public class RasterizationController {

    @FXML
    AnchorPane anchorPane;
    @FXML
    private Canvas canvas;

    @FXML
    private void initialize() {
        Rasterization rasterization = new TriangleRasterizationV1();
        Triangulation triangulation = new MyTriangulation();
        Random random = new Random();
        anchorPane.prefWidthProperty().addListener((ov, oldValue, newValue) -> canvas.setWidth(newValue.doubleValue()));
        anchorPane.prefHeightProperty().addListener((ov, oldValue, newValue) -> canvas.setHeight(newValue.doubleValue()));

        Model model = new Model();
        model.setVertices(List.of(new Vector3d(10.0, 300.0, 0.0),
                new Vector3d(250.0, 150.0, 0.0),
                new Vector3d(400.0, 200.0, 0.0),
                new Vector3d(400.0, 400.0, 0.0),
                new Vector3d(250.0, 450.0, 0.0)));
        model.setPolygons(List.of(new Polygon(List.of(0, 1, 2, 3, 4))));
        TriangulatedModel triangulatedModel = triangulation.triangulate(model);
        for (Polygon trig : triangulatedModel.getPolygons()) {

            Color color = new Color(random.nextDouble(0,0.9), random.nextDouble(0,0.9), random.nextDouble(0,0.9), 1);
            Vertex[] vertices = new Vertex[3];
            for (int i = 0; i < 3; i++) {
                int vertexIndex = trig.getVerticesIndexes().get(i);
                Vector3d vertexCoords = triangulatedModel.getVertices().get(vertexIndex);
                Vertex vertex = new Vertex((int)vertexCoords.getX(), (int)vertexCoords.getY(), color);
                vertices[i] = vertex;
            }
            rasterization.draw(canvas.getGraphicsContext2D(), vertices);
        }
    }

}
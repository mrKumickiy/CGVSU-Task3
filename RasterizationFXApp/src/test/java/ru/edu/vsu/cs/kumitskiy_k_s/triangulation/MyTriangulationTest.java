package ru.edu.vsu.cs.kumitskiy_k_s.triangulation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.edu.vsu.cs.kumitskiy_k_s.math.Vector3d;
import ru.edu.vsu.cs.kumitskiy_k_s.models.Model;
import ru.edu.vsu.cs.kumitskiy_k_s.models.Polygon;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
class MyTriangulationTest {
    Triangulation triangulation = new MyTriangulation();
    @Test
    void triangulateNull() {
        Assertions.assertNull(triangulation.triangulate(null));
    }

    @Test
    void triangulateOnePolygon() {
        List<Vector3d> actualVertices = new ArrayList<>(List.of(new Vector3d(10.0, 300.0, 0.0),
                new Vector3d(250.0, 150.0, 0.0),
                new Vector3d(400.0, 200.0, 0.0),
                new Vector3d(400.0, 400.0, 0.0),
                new Vector3d(250.0, 450.0, 0.0)));
        List<Integer> verticesIndexes = new ArrayList<>(List.of(0, 1, 2, 3, 4));

        Model model = new Model(actualVertices, new ArrayList<>(List.of(new Polygon(verticesIndexes))));
        TriangulatedModel triangulatedModel = triangulation.triangulate(model);
        List<Polygon> expectedList = new ArrayList<>(List.of(new Polygon(List.of(0, 1, 2)),
                new Polygon(List.of(0, 2, 3)),
                new Polygon(List.of(0, 3, 4))));

        for (int i = 0; i < expectedList.size(); i++) {
            System.out.println("Check polygon " + expectedList.get(i).getVerticesIndexes());
            Assertions.assertArrayEquals(expectedList.get(i).getVerticesIndexes().toArray(),
                    triangulatedModel.getPolygons().get(i).getVerticesIndexes().toArray());
        }
    }

    @Test
    void triangulateTwoPolygons() {
        List<Vector3d> actualVertices = new ArrayList<>(List.of(new Vector3d(10.0, 300.0, 0.0),
                new Vector3d(250.0, 150.0, 0.0),
                new Vector3d(400.0, 200.0, 0.0),
                new Vector3d(400.0, 400.0, 0.0),
                new Vector3d(250.0, 450.0, 0.0),
                new Vector3d(500.0, 200.0, 0.0),
                new Vector3d(600.0, 200.0, 0.0),
                new Vector3d(500.0, 300.0, 0.0),
                new Vector3d(600.0, 300.0, 0.0)));
        List<Integer> polygonVerticesOne = new ArrayList<>(List.of(0, 1, 2, 3, 4));
        List<Integer> polygonVerticesTwo = new ArrayList<>(List.of(5, 6, 8, 7));

        Model model = new Model(actualVertices, new ArrayList<>(List.of(new Polygon(polygonVerticesOne), new Polygon(polygonVerticesTwo))));
        TriangulatedModel triangulatedModel = triangulation.triangulate(model);
        List<Polygon> expectedList = new ArrayList<>(List.of(new Polygon(List.of(0, 1, 2)),
                new Polygon(List.of(0, 2, 3)),
                new Polygon(List.of(0, 3, 4)),
                new Polygon(List.of(5, 6, 8)),
                new Polygon(List.of(5, 8, 7))));

        for (int i = 0; i < expectedList.size(); i++) {
            System.out.println("Check polygon " + expectedList.get(i).getVerticesIndexes());
            Assertions.assertArrayEquals(expectedList.get(i).getVerticesIndexes().toArray(),
                    triangulatedModel.getPolygons().get(i).getVerticesIndexes().toArray());
        }
    }
}
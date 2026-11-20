package ru.edu.vsu.cs.kumitskiy_k_s.triangulation;

import ru.edu.vsu.cs.kumitskiy_k_s.models.Model;
import ru.edu.vsu.cs.kumitskiy_k_s.models.Polygon;

import java.util.ArrayList;
import java.util.List;

public class MyTriangulation implements Triangulation{
    @Override
    public TriangulatedModel triangulate(Model model) {
        if (model == null) {
            return new TriangulatedModel();
        }
        List<Polygon> triangles = new ArrayList<>();

        for (Polygon polygon : model.getPolygons()) {
            List<Polygon> addTrig = new ArrayList<>();
            List<Integer> verticesIndexes = polygon.getVerticesIndexes();
            if (verticesIndexes.size() > 3) {
                for (int i = 2; i < polygon.getVerticesIndexes().size(); i++) {
                    addTrig.add(new Polygon(List.of(verticesIndexes.getFirst(),
                            verticesIndexes.get(i - 1), verticesIndexes.get(i))));
                }
            } else {
                addTrig.add(polygon);
            }
            triangles.addAll(addTrig);
        }
        return new TriangulatedModel(model.getVertices(), triangles);
    }
}

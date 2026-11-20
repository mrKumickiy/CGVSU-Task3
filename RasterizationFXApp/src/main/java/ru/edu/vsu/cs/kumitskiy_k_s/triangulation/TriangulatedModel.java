package ru.edu.vsu.cs.kumitskiy_k_s.triangulation;

import ru.edu.vsu.cs.kumitskiy_k_s.math.Vector3d;
import ru.edu.vsu.cs.kumitskiy_k_s.models.Model;
import ru.edu.vsu.cs.kumitskiy_k_s.models.Polygon;

import java.util.List;

public class TriangulatedModel extends Model {
    public TriangulatedModel() {
        super();
    }

    public TriangulatedModel(List<Vector3d> vertices, List<Polygon> triangles) {
        super(vertices,triangles);
    }
}

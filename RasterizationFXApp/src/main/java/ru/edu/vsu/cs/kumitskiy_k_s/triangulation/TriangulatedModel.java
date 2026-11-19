package ru.edu.vsu.cs.kumitskiy_k_s.triangalization;

import ru.edu.vsu.cs.kumitskiy_k_s.math.Vector3d;
import ru.edu.vsu.cs.kumitskiy_k_s.models.Model;
import ru.edu.vsu.cs.kumitskiy_k_s.models.Polygon;

import java.util.List;

public class TrianglaziedModel extends Model {
    public TrianglaziedModel() {
        super();
    }

    public TrianglaziedModel(List<Vector3d> vertices, List<Polygon> triangles) {
        super(vertices,triangles);
    }
}

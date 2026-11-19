package ru.edu.vsu.cs.kumitskiy_k_s.triangalization.models;

import ru.edu.vsu.cs.kumitskiy_k_s.triangalization.math.Vector3d;

import java.util.ArrayList;
import java.util.List;

public class Model {
    private final List<Vector3d> vertices;
    private final List<Polygon> polygons;

    public Model() {
        vertices = new ArrayList<>();
        polygons = new ArrayList<>();
    }

    public List<Vector3d> getVertices() {
        return vertices;
    }

    public List<Polygon> getPolygons() {
        return polygons;
    }
}

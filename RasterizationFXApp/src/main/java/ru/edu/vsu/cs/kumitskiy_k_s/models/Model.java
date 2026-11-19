package ru.edu.vsu.cs.kumitskiy_k_s.models;

import ru.edu.vsu.cs.kumitskiy_k_s.math.Vector3d;

import java.util.ArrayList;
import java.util.List;

public class Model {
    private List<Vector3d> vertices;
    private List<Polygon> polygons;

    public Model() {
        vertices = new ArrayList<>();
        polygons = new ArrayList<>();
    }

    public Model(List<Vector3d> vertices, List<Polygon> polygons) {
        this.vertices = vertices;
        this.polygons = polygons;
    }

    public void setVertices(List<Vector3d> vertices) {
        this.vertices = vertices;
    }

    public void setPolygons(List<Polygon> polygons) {
        this.polygons = polygons;
    }

    public List<Vector3d> getVertices() {
        return vertices;
    }

    public List<Polygon> getPolygons() {
        return polygons;
    }
}

package ru.edu.vsu.cs.kumitskiy_k_s.triangalization.models;

import java.util.ArrayList;
import java.util.List;

public class Polygon {
    private List<Integer> verticesIndexes;

    public Polygon() {
        verticesIndexes = new ArrayList<>();
    }

    public List<Integer> getVerticesIndexes() {
        return verticesIndexes;
    }
}

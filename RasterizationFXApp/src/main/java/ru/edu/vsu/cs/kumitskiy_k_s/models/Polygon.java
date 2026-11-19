package ru.edu.vsu.cs.kumitskiy_k_s.models;

import java.util.List;

public class Polygon {
    private List<Integer> verticesIndexes;

    public Polygon(List<Integer> verticesIndexes) {
        setVerticesIndexes(verticesIndexes);
    }

    public List<Integer> getVerticesIndexes() {
        return verticesIndexes;
    }

    public void setVerticesIndexes(List<Integer> indexes) {
        if (indexes == null) {
            return;
        }
        assert indexes.size() >= 3;
        verticesIndexes = List.copyOf(indexes);
    }
}

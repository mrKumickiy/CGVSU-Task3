package ru.edu.vsu.cs.kumitskiy_k_s.rastarization;

import javafx.scene.canvas.GraphicsContext;
import ru.edu.vsu.cs.kumitskiy_k_s.rastarization.tools.Vertex;

public interface Rasterization {
    void draw(GraphicsContext graphicsContext, Vertex[] vertices);

}

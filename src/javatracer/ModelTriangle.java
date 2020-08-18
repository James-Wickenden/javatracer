package javatracer;

import java.awt.Color;
import com.sun.javafx.geom.Vec3f;

public class ModelTriangle {
	private Vec3f[] vertices;
	private Color colour;
	
	public ModelTriangle() {
		for (@SuppressWarnings("unused") Vec3f vertex : vertices) {
			vertex = new Vec3f(0.0f, 0.0f, 0.0f);
		}
		colour = Color.MAGENTA;
	}
	public ModelTriangle(Vec3f[] vertices) {
		this.vertices = vertices;
		colour = Color.MAGENTA;
	}
	public ModelTriangle(Vec3f[] vertices, Color colour) {
		this.vertices = vertices;
		this.colour = colour;
	}
	
	public Vec3f[] GetVertices() {
		return vertices;
	}
	
	public void SetVertices(Vec3f[] vertices) {
		this.vertices = vertices;
	}
	
	public Color GetColour() {
		return colour;
	}
	
	public void SetColour(Color colour) {
		this.colour = colour;
	}
}

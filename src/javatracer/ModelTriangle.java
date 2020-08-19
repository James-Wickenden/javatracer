package javatracer;

import java.awt.Color;

import com.badlogic.gdx.math.Vector3;

public class ModelTriangle {
	private Vector3[] vertices;
	private Color colour;
	
	public ModelTriangle() {
		for (@SuppressWarnings("unused") Vector3 vertex : vertices) {
			vertex = new Vector3(0.0f, 0.0f, 0.0f);
		}
		colour = Color.MAGENTA;
	}
	public ModelTriangle(Vector3[] vertices) {
		this.vertices = vertices;
		colour = Color.MAGENTA;
	}
	public ModelTriangle(Vector3[] vertices, Color colour) {
		this.vertices = vertices;
		this.colour = colour;
	}
	
	public Vector3[] GetVertices() {
		return vertices;
	}
	
	public void SetVertices(Vector3[] vertices) {
		this.vertices = vertices;
	}
	
	public Color GetColour() {
		return colour;
	}
	
	public void SetColour(Color colour) {
		this.colour = colour;
	}
}

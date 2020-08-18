package javatracer;

import java.util.ArrayList;
import java.util.List;

public class SceneObject {
	private String name;
	private List<ModelTriangle> faces;

	public SceneObject() {
		name = "EMPTY";
		faces = new ArrayList<ModelTriangle>();
	}
	
	public SceneObject(List<ModelTriangle> faces) {
		name = "UNNAMED";
		this.faces = faces;
	}
	
	public SceneObject(String name, List<ModelTriangle> faces) {
		this.name = name;
		this.faces = faces;
	}
	
	public String getName() { return name; }
	public List<ModelTriangle> getFaces() { return faces; }
}

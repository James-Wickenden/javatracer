package javatracer;

import java.util.ArrayList;
import java.util.List;

import com.sun.javafx.geom.Vec3f;
import java.awt.Color;

public class SceneParser {
	
	private List<SceneObject> generateTestScene() {
		List<SceneObject> scene = new ArrayList<SceneObject>();
		
		List<ModelTriangle> obj = new ArrayList<ModelTriangle>();
		Vec3f[] mt1Verts = { new Vec3f(100.0f, 100.0f, 100.0f),
							 new Vec3f(-100.0f, 100.0f, 100.0f),
							 new Vec3f(-100.0f, -100.0f, 100.0f)};

		Vec3f[] mt2Verts = { new Vec3f(100.0f, 100.0f, 100.0f),
							 new Vec3f(100.0f, -100.0f, 100.0f),
							 new Vec3f(-100.0f, -100.0f, 100.0f)};

		ModelTriangle mt1 = new ModelTriangle(mt1Verts, Color.WHITE);
		ModelTriangle mt2 = new ModelTriangle(mt2Verts, Color.WHITE);
		obj.add(mt1);
		obj.add(mt2);
		
		scene.add(new SceneObject("Wall", obj));
		return scene;
	}
	
	public List<SceneObject> ParseObj(String filename) {
		return generateTestScene();
	}
}

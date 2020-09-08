package javatracer;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.math.Vector3;

import java.awt.Color;

public class SceneParser {
	
	private List<SceneObject> generateTestScene() {
		List<SceneObject> scene = new ArrayList<SceneObject>();
		
		List<ModelTriangle> obj = new ArrayList<ModelTriangle>();
		Vector3[] mt1Verts = { new Vector3(100.0f, 100.0f, 100.0f),
							   new Vector3(-100.0f, 100.0f, 100.0f),
							   new Vector3(-100.0f, -100.0f, 100.0f)};

		Vector3[] mt2Verts = { new Vector3(100.0f, 100.0f, 100.0f),
							   new Vector3(100.0f, -100.0f, 100.0f),
							   new Vector3(-100.0f, -100.0f, 100.0f)};

		Vector3[] mt3Verts = { new Vector3(100.0f, 100.0f, 100.0f),
				   			   new Vector3(-100.0f, 100.0f, 100.0f),
				   			   new Vector3(-100.0f, 100.0f, -100.0f)};

		Vector3[] mt4Verts = { new Vector3(100.0f, 100.0f, 100.0f),
	   			   			   new Vector3(-100.0f, 100.0f, -100.0f),
	   			   			   new Vector3(100.0f, 100.0f, -100.0f)};

		Vector3[] mt5Verts = { new Vector3(100.0f, 100.0f, -100.0f),
							   new Vector3(-100.0f, 100.0f, -100.0f),
							   new Vector3(-100.0f, -100.0f, -100.0f)};

		Vector3[] mt6Verts = { new Vector3(100.0f, 100.0f, -100.0f),
							   new Vector3(100.0f, -100.0f, -100.0f),
							   new Vector3(-100.0f, -100.0f, -100.0f)};

		Vector3[] mt7Verts = { new Vector3(100.0f, -100.0f, 100.0f),
	   			   			   new Vector3(-100.0f, -100.0f, 100.0f),
	   			   			   new Vector3(-100.0f, -100.0f, -100.0f)};

		Vector3[] mt8Verts = { new Vector3(100.0f, -100.0f, 100.0f),
	   			   			   new Vector3(-100.0f, -100.0f, -100.0f),
	   			   			   new Vector3(100.0f, -100.0f, -100.0f)};


		ModelTriangle mt1 = new ModelTriangle(mt1Verts, Color.WHITE);
		ModelTriangle mt2 = new ModelTriangle(mt2Verts, Color.WHITE);
		ModelTriangle mt3 = new ModelTriangle(mt3Verts, Color.WHITE);
		ModelTriangle mt4 = new ModelTriangle(mt4Verts, Color.WHITE);
		ModelTriangle mt5 = new ModelTriangle(mt5Verts, Color.WHITE);
		ModelTriangle mt6 = new ModelTriangle(mt6Verts, Color.WHITE);
		ModelTriangle mt7 = new ModelTriangle(mt7Verts, Color.WHITE);
		ModelTriangle mt8 = new ModelTriangle(mt8Verts, Color.WHITE);
		obj.add(mt1);
		obj.add(mt2);
		obj.add(mt3);
		obj.add(mt4);
		obj.add(mt5);
		obj.add(mt6);
		obj.add(mt7);
		obj.add(mt8);
		scene.add(new SceneObject("Walls", obj));
		return scene;
	}
	
	public List<SceneObject> ParseObj(String filename) {
		return generateTestScene();
	}
}

package javatracer;

import com.badlogic.gdx.math.Matrix3;
import com.badlogic.gdx.math.Vector3;

public class Camera {
	private Matrix3 orientation;
	
	private Vector3 position;
	private float focalLength;
	
	public Camera() {
		float[] orientVals = { 0.0f, 0.0f, -1.0f,
							   0.0f, -1.0f, 0.0f,
							   -1.0f, 0.0f, 0.0f };
		
		orientation = new Matrix3(orientVals);
		position = new Vector3(0.0f, 0.0f, 200.0f);
		focalLength = 50.0f;
	}
	
	public float getFoc() { return focalLength; }
	public Vector3 getPos() { return position; }
	public Matrix3 getOri() { return orientation; }
	
	public void translateBy(float f, float g, float h) {
		Vector3 trVec = new Vector3(f, g, h);
		translateBy(trVec);
	}
	
	public void translateBy(Vector3 translationVector) {
		position.add(translationVector);
	}
	
}

package javatracer;

import com.sun.javafx.geom.Matrix3f;
import com.sun.javafx.geom.Vec3f;

public class Camera {
	private Matrix3f orientation = new Matrix3f(0,  0, -1,    // right
            									0, -1,  0,    // up
            								   -1,  0,  0);   // forward
	private Vec3f position = new Vec3f();
	private float focalLength = 100;
	
	public float getFoc() { return focalLength; }
	public Vec3f getPos() { return position; }
	public Matrix3f getOri() { return orientation; }
	
	public void translateBy(float f, float g, float h) {
		Vec3f trVec = new Vec3f(f, g, h);
		translateBy(trVec);
	}
	
	public void translateBy(Vec3f translationVector) {
		position.add(translationVector);
	}
	
}

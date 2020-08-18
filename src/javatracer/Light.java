package javatracer;

import java.awt.Color;

import com.sun.javafx.geom.Vec3f;

public class Light {
	private float intensity = 100.0f;
	private float spread = 8.0f;
	private Color colour = Color.WHITE;
	private Vec3f position = new Vec3f(0.0f, 0.0f, 0.0f);
	
	public float getIntensity() { return intensity; }
	public float getSpread() { return spread; }
	public Color getColour() { return colour; }
	public Vec3f getPosition() { return position; }
	
	public float getIntensityAtPoint(Vec3f point) {
		Vec3f point_to_light = point;
		Vec3f flippedPos = position;
		flippedPos.mul(-1);
		point_to_light.add(flippedPos);

		float intensityAtPoint =  intensity / (spread * (float)Math.PI * point_to_light.length());
		return intensityAtPoint;
	}
}

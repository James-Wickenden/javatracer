package javatracer;

import java.awt.Color;

import com.badlogic.gdx.math.Vector3;

public class Light {
	private float intensity = 100.0f;
	private float spread = 8.0f;
	private Color colour = Color.WHITE;
	private Vector3 position = new Vector3(0.0f, 0.0f, 0.0f);
	
	public float getIntensity() { return intensity; }
	public float getSpread() { return spread; }
	public Color getColour() { return colour; }
	public Vector3 getPosition() { return position; }
	
	public float getIntensityAtPoint(Vector3 point) {
		Vector3 point_to_light = point;
		Vector3 flippedPos = position;
		
		point_to_light.mulAdd(flippedPos, -1.0f);
		
		float intensityAtPoint =  intensity / (spread * (float)Math.PI * point_to_light.len());
		return intensityAtPoint;
	}
}

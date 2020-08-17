package javatracer;

import java.util.List;

public class SceneRaytracer {
	private int WIDTH, HEIGHT;
	private Integer[][] pixelBuffer;
	
	public SceneRaytracer(int width, int height) {
		this.WIDTH = width;
		this.HEIGHT = height;
		pixelBuffer = new Integer[width][height];
	}
	
	public void RaytraceTriangles(Camera camera, List<ModelTriangle> modelTriangles) {
		for (int x = 0; x < WIDTH; x++) {
			for (int y = 0; y < HEIGHT; y++) {
				Integer colour = ((x % 255) << 24) + ((y % 255) << 16) + 255;
				pixelBuffer[x][y] = colour;
			}
		}
	}
	
	public Integer[][] getPixelBuffer() { return pixelBuffer; }
}

package javatracer;

import java.util.List;
import com.badlogic.gdx.math.Vector3;

public class SceneRaytracer {
	private int WIDTH, HEIGHT;
	private Integer[][] pixelBuffer;
	
	public SceneRaytracer(int width, int height) {
		this.WIDTH = width;
		this.HEIGHT = height;
		pixelBuffer = new Integer[width][height];
	}
	
	private void testTrace() {
		for (int x = 0; x < WIDTH; x++) {
			for (int y = 0; y < HEIGHT; y++) {
				Integer colour = ((x % 255) << 16) + ((y % 255) << 8) + 255;
				pixelBuffer[x][y] = colour;
			}
		}
	}
	
	public void RaytraceTriangles(Camera camera, Light light, List<SceneObject> objects) {
		testTrace();
		
//		for (int i = 0; i < WIDTH; i++) {
//			for (int j = 0; j < HEIGHT; j++) {
//				int x =  i - WIDTH / 2;
//			    int y = -j + HEIGHT / 2;
//
//			    //Vector3 ray = new Vector3(x, y, camera.getFoc());
//			   //.(camera.getOri());
//			}
//		}
	}
	
	public Integer[][] getPixelBuffer() { return pixelBuffer; }
}

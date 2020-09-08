package javatracer;

import java.awt.Color;
import java.util.List;

import com.badlogic.gdx.math.Matrix3;
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

		// System.out.println("rtt obs: " + objects);
		for (int i = 0; i < WIDTH; i++) {
			for (int j = 0; j < HEIGHT; j++) {
				int x = i - WIDTH / 2;
				int y = -j + HEIGHT / 2;

				Vector3 ray = new Vector3(x, y, camera.getFoc());

				ray.mul(camera.getOri());
				RayTriangleIntersection RTI = getClosestIntersection(ray, camera, objects);

				if (RTI.getIsSolution()) {
					// Color colour = RTI.getIntersectedTriangle().GetColour();
					// pixelBuffer[i][j] = colour.getRGB();
					pixelBuffer[i][j] = Color.WHITE.getRGB();
				} else {
					pixelBuffer[i][j] = Color.BLACK.getRGB();
				}
			}
		}
	}

	private RayTriangleIntersection getPossibleIntersection(ModelTriangle triangle, Vector3 rayDir, Vector3 point) {

		Vector3 e0 = triangle.GetVertices()[1].cpy();
		e0.sub(triangle.GetVertices()[0].cpy());

		Vector3 e1 = triangle.GetVertices()[2].cpy();
		e1.sub(triangle.GetVertices()[0].cpy());
		
		Vector3 SPVector = point.cpy();
		SPVector.sub(triangle.GetVertices()[0].cpy());
		
		rayDir.scl(-1.0f);

		float[] DEVals = { rayDir.x, rayDir.y, rayDir.z, e0.x, e0.y, e0.z, e1.x, e1.y, e1.z };
		//float[] DEVals = { rayDir.x, e0.x, e1.x, rayDir.y, e0.y, e1.y, rayDir.z, e0.z, e1.z };
		
		Matrix3 DEMatrix = new Matrix3(DEVals);
		
		//System.out.println(rayDir);
		//System.out.println(DEMatrix);
		//System.out.println("");
		
		if (DEMatrix.det() == 0.0f) return new RayTriangleIntersection();

		DEMatrix.inv();
		SPVector.mul(DEMatrix);

		Vector3 possibleSolution = SPVector;

		float t = possibleSolution.x;
		float u = possibleSolution.y;
		float v = possibleSolution.z;

		if (((0.0f <= u) && (u <= 1.0f)) && ((0.0f <= v) && (v <= 1.0f)) && ((u + v) <= 1.0f) && (t >= 0)) {
			Vector3 e0_scaled = e0.cpy();
			e0_scaled.scl(u);
			Vector3 e1_scaled = e1.cpy();
			e1_scaled.scl(v);
			
			Vector3 e0_p_e1 = e0_scaled.cpy();
			e0_p_e1.add(e1_scaled);
			
			Vector3 point3d = triangle.GetVertices()[0].cpy();
			point3d.add(e0_p_e1);

			RayTriangleIntersection res = new RayTriangleIntersection(point3d, t * rayDir.len(), triangle, true);
			return res;
		}

		return new RayTriangleIntersection();
	}

	private RayTriangleIntersection getClosestIntersection(Vector3 rayDir, Camera camera, List<SceneObject> objects) {
		RayTriangleIntersection closestIntersectionFound = new RayTriangleIntersection();

		// System.out.println("gci obs: " + objects);
		for (SceneObject so : objects) {
			for (ModelTriangle face : so.getFaces()) {
				// System.out.println("so: " + so.getName() + "; face colour: " +
				// face.GetColour() + "; ray: " + rayDir);
				Vector3 ray = rayDir.cpy();
				//System.out.println(ray);
				RayTriangleIntersection possibleSolution = getPossibleIntersection(face, ray, camera.getPos());

				if (possibleSolution.getIsSolution()) {
					if (possibleSolution.getDistanceFromPoint() < closestIntersectionFound.getDistanceFromPoint()) {
						closestIntersectionFound = possibleSolution;
					}
				}
			}
		}

		return closestIntersectionFound;
	}

	public Integer[][] getPixelBuffer() {
		return pixelBuffer;
	}
}

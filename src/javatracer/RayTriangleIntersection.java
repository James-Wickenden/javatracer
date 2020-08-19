package javatracer;

import com.badlogic.gdx.math.Vector3;

public class RayTriangleIntersection {
    private Vector3 intersectionPoint;
    private float distanceFromPoint;
    private ModelTriangle intersectedTriangle;
    private boolean isSolution;
    private Vector3 e0;
    private Vector3 e1;
    
    public RayTriangleIntersection() {
        isSolution = false;
        distanceFromPoint = Float.POSITIVE_INFINITY;
    }
    
    public RayTriangleIntersection(Vector3 point, float distance, ModelTriangle triangle, boolean is_sol) {
        intersectionPoint = point;
        distanceFromPoint = distance;
        intersectedTriangle = triangle;
        isSolution = is_sol;

        e0 = intersectedTriangle.GetVertices()[1];
        e0.sub(intersectedTriangle.GetVertices()[0]);
        e1 = intersectedTriangle.GetVertices()[2];
        e1.sub(intersectedTriangle.GetVertices()[0]);
    }

    public Vector3 getIntersectionPoint() { return intersectionPoint; }
    public float getDistanceFromPoint() { return distanceFromPoint; }
    public boolean getIsSolution() { return isSolution; }
}

package javatracer;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JPanel;

import com.sun.javafx.geom.Vec3f;

@SuppressWarnings("serial")
class RayPanel extends JPanel {
	
	private SceneRaytracer srt;
	private List<SceneObject> scene;
	private Integer[][] pixelBuffer;
    private Camera camera = new Camera();
    private Light light = new Light();
    private int myWIDTH;
    private int myHEIGHT;
    
    public RayPanel(int width, int height) {
    	myWIDTH = width;
    	myHEIGHT = height;
    	
    	srt = new SceneRaytracer(width, height);
    	SceneParser parser = new SceneParser();
    	scene = parser.ParseObj("indev");
    	
    	paintScreen();
    	
        addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent e){
                // mouse click handler
            }
        });

    }

    private void paintScreen() {
    	srt.RaytraceTriangles(camera, light, null);
    	pixelBuffer = srt.getPixelBuffer();
    	repaint();
    }
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (int x = 0; x < myWIDTH; x++) {
        	for (int y = 0; y < myHEIGHT; y++) {
        		Integer pixColour = pixelBuffer[x][y];
        		Color colour = new Color(pixColour);
        		g.setColor(colour);
        		g.drawLine(x,y,x,y);
        	}
        }
        
        g.setColor(Color.WHITE);
        g.drawString("width: " + myWIDTH + "px. height: " + myHEIGHT + "px.",10,20);
        
        System.out.println("scene:");
        for (SceneObject so : scene) {
        	for (ModelTriangle mt : so.getFaces()) {
        		for (Vec3f vec : mt.GetVertices()) {
        			System.out.println("Point: " + vec + " colour: " + mt.GetColour() + " name: " + so.getName());
        		}
            }
        }
    }  
}


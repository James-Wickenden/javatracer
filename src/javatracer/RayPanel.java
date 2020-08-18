package javatracer;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;

@SuppressWarnings("serial")
class RayPanel extends JPanel {
	
	private SceneRaytracer srt;
	private Integer[][] pixelBuffer;
    private Camera camera = new Camera();
    private int myWIDTH;
    private int myHEIGHT;
    
    public RayPanel(int width, int height) {
    	myWIDTH = width;
    	myHEIGHT = height;
    	
    	srt = new SceneRaytracer(width, height);
    	paintScreen();
    	
        addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent e){
                // mouse click handler
            }
        });

    }

    private void paintScreen() {
    	srt.RaytraceTriangles(camera, null);
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
    }  
}


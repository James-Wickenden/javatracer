package javatracer;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import javafx.util.Pair;

@SuppressWarnings("serial")
class RayPanel extends JPanel {
	
    private PixelHolder pixels = new PixelHolder();
    private int myWIDTH;
    private int myHEIGHT;
    
    public RayPanel(int width, int height) {
        //setBorder(BorderFactory.createLineBorder(Color.black));
    	myWIDTH = width;
    	myHEIGHT = height;
    	
        addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent e){
                // mouse click handler
            	paintPixel(e.getX(), e.getY());
            }
        });

        addMouseMotionListener(new MouseAdapter(){
            public void mouseDragged(MouseEvent e){
            	// mouse drag handler
            	paintPixel(e.getX(), e.getY());
            }
        });

    }

    private void paintPixel(int x, int y){
        pixels.AddPixel(x, y);
        repaint();
    }
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.BLACK);	
        for (int x = 0; x < myWIDTH; x++) {
        	for (int y = 0; y < myHEIGHT; y++) {
        		g.drawLine(x,y,x,y);
        	}
        }
        
        g.setColor(Color.WHITE);
        g.drawString("Red pixel count: " + pixels.GetPixels().size(),10,20);
        g.drawString("width: " + myWIDTH + "px. height: " + myHEIGHT + "px.",10,35);
        
        
        for (Pair<Integer, Integer> pixel : pixels.GetPixels()) {
        	int x = pixel.getKey();
        	int y = pixel.getValue();
        	
        	g.setColor(Color.RED);
        	g.drawLine(x,y,x,y);
        }
    }  
}


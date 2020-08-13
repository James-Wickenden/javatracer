package javatracer;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import javafx.util.Pair;

@SuppressWarnings("serial")
class RayPanel extends JPanel {
	
    PixelHolder pixels = new PixelHolder();
    	
    public RayPanel() {
        //setBorder(BorderFactory.createLineBorder(Color.black));

        addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent e){
                // mouse click handler
            	paintPixel(e.getX(), e.getY());
            }
        });

        addMouseMotionListener(new MouseAdapter(){
            public void mouseDragged(MouseEvent e){
            	// mouse drag handler
            }
        });

    }

    private void paintPixel(int x, int y){
        pixels.AddPixel(x, y);
        repaint();
    }
    
//    
//    private void moveSquare(int x, int y){
//
//        // Current square state, stored as final variables 
//        // to avoid repeat invocations of the same methods.
//        final int CURR_X = redSquare.getX();
//        final int CURR_Y = redSquare.getY();
//        final int CURR_W = redSquare.getWidth();
//        final int CURR_H = redSquare.getHeight();
//        final int OFFSET = 1;
//
//        if ((CURR_X!=x) || (CURR_Y!=y)) {
//
//            // The square is moving, repaint background 
//            // over the old square location. 
//            repaint(CURR_X,CURR_Y,CURR_W+OFFSET,CURR_H+OFFSET);
//
//            // Update coordinates.
//            redSquare.setX(x);
//            redSquare.setY(y);
//
//            // Repaint the square at the new location.
//            repaint(redSquare.getX(), redSquare.getY(), 
//                    redSquare.getWidth()+OFFSET, 
//                    redSquare.getHeight()+OFFSET);
//        }
//    }
//
//    public Dimension getPreferredSize() {
//        return new Dimension(250,200);
//    }
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);       
        g.drawString("Red pixel count: " + pixels.GetPixels().size(),10,20);
        // redSquare.paintSquare(g);
        
        for (Pair<Integer, Integer> pixel : pixels.GetPixels()) {
        	int x = pixel.getKey();
        	int y = pixel.getValue();
        	
        	g.setColor(Color.RED);
        	g.drawLine(x,y,x,y);
        }
    }  
}


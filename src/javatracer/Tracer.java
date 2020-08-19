package javatracer;

import javax.swing.SwingUtilities;
import javax.swing.JFrame;
import java.awt.Dimension;

// built with help from https://docs.oracle.com/javase/tutorial/uiswing/painting/
public class Tracer {
    private static int WIDTH = 480;
    private static int HEIGHT = 360;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	setup();
            }
        });
    }
    
    private static void setup() {
        System.out.println("Created GUI on EDT? "+
        SwingUtilities.isEventDispatchThread());
        
        JFrame f = new JFrame("Raytracer");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        RayPanel rayPanel = new RayPanel(WIDTH, HEIGHT);
        rayPanel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        
        f.add(rayPanel);
        f.pack();
        f.setVisible(true);
        
        //System.out.println("End of GUI creation.");
    }

}
package javatracer;

import javax.swing.SwingUtilities;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics; 
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseMotionAdapter;

// built with https://docs.oracle.com/javase/tutorial/uiswing/painting/
public class Tracer {
    private static int WIDTH = 480;
    private static int HEIGHT = 360;
    
    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI(); 
            }
        });
    }

    private static void createAndShowGUI() {
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
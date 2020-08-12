package javatracer;
import javax.swing.SwingUtilities;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

// tutorial from:
// https://docs.oracle.com/javase/tutorial/uiswing/painting
public class tracer {
	public static void main(String[] args) {
		System.out.println("test III");
		
		SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
	}
	
	private static void createAndShowGUI() {
        System.out.println("Created GUI on EDT? "+
                SwingUtilities.isEventDispatchThread());
        JFrame f = new JFrame("Swing Paint Demo");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(400, 400);
        f.add(new RayPanel());
        f.pack();
        f.setVisible(true);
    }
}

@SuppressWarnings("serial")
class RayPanel extends JPanel {

    public RayPanel() {
        setBorder(BorderFactory.createLineBorder(Color.black));
    }

    public Dimension getPreferredSize() {
        return new Dimension(250,200);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);       

        g.drawString("This is my custom Panel!",10,20);
    }  
}

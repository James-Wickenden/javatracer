package javatracer;
import java.awt.Canvas;
import java.awt.Graphics;
import javax.swing.JFrame;

public class tracer {
	static Graphics graphics;
	static Canvas canvas;
	
	public static void main(String[] args) {
		System.out.println("Test");
		
		JFrame frame = new JFrame("My Drawing");
        canvas = new Canvas();
        graphics = canvas.getGraphics();
        canvas.setSize(400, 400);
        frame.add(canvas);
        frame.pack();
        frame.setVisible(true);
        
        paint();
        canvas.update(graphics);
	}
	
	public static void paint() {
        graphics.fillOval(100, 100, 200, 200);
    }
}

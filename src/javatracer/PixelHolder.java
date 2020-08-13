package javatracer;

import java.util.ArrayList;
import java.util.List;
import javafx.util.Pair;

public class PixelHolder {
	private List<Pair<Integer, Integer>> pixels = new ArrayList<>();
	
	public List<Pair<Integer, Integer>> GetPixels() {
		return pixels;
	}
	
	public void AddPixel(Integer x, Integer y) {
		for (Pair<Integer, Integer> pixel : pixels) {
        	int test_x = pixel.getKey();
        	int test_y = pixel.getValue();
        	
        	if (test_x == x && test_y == y) return;
        }
		
		pixels.add(new Pair<Integer, Integer>(x, y));
	}
}

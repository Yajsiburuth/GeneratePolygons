import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.awt.geom.Rectangle2D.Double;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JColorChooser;
import javax.swing.JOptionPane;
public class PolygonDrawing extends Frame{
	Scanner sc = new Scanner(System.in);
	Object[] options = {"Regular", "Irregular"};
	int x = JOptionPane.showOptionDialog(null, "Choose one",
            "Polygon chooser",
            JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, options, options[0]);
	private String numSide = JOptionPane.showInputDialog(null, "Enter line number");
	private Color lineColor = JColorChooser.showDialog(null, "Choose a color for the lines of the shape", Color.black);
	private Color fillColor = JColorChooser.showDialog(null, "Choose a color to fill the shape with	", Color.black);
	
	public void paint(Graphics g) {
		int numSides = Integer.parseInt(numSide);
		Graphics2D ga = (Graphics2D) g;
		RenderingHints rh = new RenderingHints(
	             RenderingHints.KEY_ANTIALIASING,
	             RenderingHints.VALUE_ANTIALIAS_ON);
	    ga.setRenderingHints(rh);
		Polygon p = new Polygon();
		if (x == 0) {
			for (int i = 0; i < numSides; i++) {
				p.addPoint((int) (250 + 50 * Math.cos(i * 2 * Math.PI / numSides)),
				          (int) (250 + 50 * Math.sin(i * 2 * Math.PI / numSides)));
				
			}   
			ga.setPaint(lineColor);
			ga.setStroke(new BasicStroke(10));
			ga.draw(p);
			ga.setPaint(fillColor);
			ga.fill(p);
		}else {
			int minX = 100;
			int maxX = 300;
			int minY = 100;
			int maxY = 200;
			for (int i = 0; i < numSides; i++) {
				int newRandX = (int)(Math.random() * (maxX - minX + 1) + minX);
				int newRandY = (int)(Math.random() * (maxY - minY + 1) + minY);
				p.addPoint((int) (250 + newRandX * Math.cos(i * 2 * Math.PI / numSides)),
				          (int) (250 + newRandY * Math.sin(i * 2 * Math.PI / numSides)));
			}     
			ga.setPaint(lineColor);
			ga.setStroke(new BasicStroke(10));
			ga.draw(p);
			ga.setPaint(fillColor);
			ga.fill(p);
		}
	    
	}
}

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.awt.geom.Rectangle2D.Double;
import java.util.Scanner;

import javax.swing.JColorChooser;
import javax.swing.JOptionPane;
public class PolygonDrawing extends Frame{
	Scanner sc = new Scanner(System.in);
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
	    for (int i = 0; i < numSides; i++)
	      p.addPoint((int) (250 + 50 * Math.cos(i * 2 * Math.PI / numSides)),
	          (int) (250 + 50 * Math.sin(i * 2 * Math.PI / numSides)));
		ga.setPaint(lineColor);
		ga.setStroke(new BasicStroke(5));
		ga.draw(p);
		ga.setPaint(fillColor);
		ga.fill(p);
	}
}

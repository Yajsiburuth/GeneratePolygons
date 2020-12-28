import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.awt.geom.Rectangle2D.Double;
import java.util.Random;

import javax.swing.JColorChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
public class PolygonDrawing extends JPanel{
	int x = 0;
	int numSides = 4;
	int thickness = 10;
	private Color lineColor = JColorChooser.showDialog(null, "Choose a color for the lines of the shape", Color.GRAY);
	private Color fillColor = JColorChooser.showDialog(null, "Choose a color to fill the shape with	", Color.black);
	
	@Override
    public Dimension getPreferredSize() {
        return new Dimension(852, 480);
    }
	public void setSides(int sides) {
        numSides = sides;
        repaint();
    }
	public void setThick(int thick) {
		thickness = thick;
        repaint();
    }
	public void setType(int type) {
		x = type;
		repaint();
		
	}
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D ga = (Graphics2D) g.create();
		RenderingHints rh = new RenderingHints(
	             RenderingHints.KEY_ANTIALIASING,
	             RenderingHints.VALUE_ANTIALIAS_ON);
	    ga.setRenderingHints(rh);
		Polygon p = new Polygon();
		if (x == 0) {
			for (int i = 0; i < numSides; i++) {
				p.addPoint((int) (426 + 100 * Math.cos(i * 2 * Math.PI / numSides)),
				          (int) (240 + 100 * Math.sin(i * 2 * Math.PI / numSides)));
				
			}
		}else {
			int minX = 100;
			int maxX = 300;
			int minY = 100;
			int maxY = 200;
			for (int i = 0; i < numSides; i++) {
				int newRandX = (int)(Math.random() * (maxX - minX + 1) + minX);
				int newRandY = (int)(Math.random() * (maxY - minY + 1) + minY);
				p.addPoint((int) (426 + newRandX * Math.cos(i * 2 * Math.PI / numSides)),
				          (int) (240 + newRandY * Math.sin(i * 2 * Math.PI / numSides)));
			}     
			
			
		}
		ga.setPaint(lineColor);
		ga.setStroke(new BasicStroke(thickness));
		ga.draw(p);
		ga.setPaint(fillColor);
		ga.fill(p);
		ga.dispose();
	    
	}
}

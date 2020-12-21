import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;

public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Frame frame = new PolygonDrawing();
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});
		frame.setSize(1280, 720);
		frame.setVisible(true);
	}

}

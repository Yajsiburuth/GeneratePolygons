import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Main {
	public static void main(String[] args) {
        new Main();
    }
	public Main() {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				JFrame frameOut = new JFrame("Polygon");
				JFrame frameIn = new JFrame("Settings");
			
				JPanel panel = new JPanel();
				panel.setLayout(new GridLayout(3,1,1,1));
				frameOut.setSize(852,480);	
				PolygonDrawing polygon = new PolygonDrawing();
				
				JSlider sliderLines = new JSlider(0,30);
				JSlider sliderThick = new JSlider(0,50);
				JLabel sliderLabel = new JLabel("Number of lines: 4",JLabel.CENTER); 
				JLabel sliderLabel1 = new JLabel("Thickness of line : 10 ", JLabel.CENTER);
				sliderLines.setMinorTickSpacing(1);  
				sliderLines.setMajorTickSpacing(5);  
				sliderLines.setPaintTicks(true);  
				sliderLines.setPaintLabels(true); 
				sliderLines.setSnapToTicks(true);
				sliderLines.setValue(4);
				
				sliderThick.setMinorTickSpacing(1);  
				sliderThick.setMajorTickSpacing(5);  
				sliderThick.setPaintTicks(true);  
				sliderThick.setPaintLabels(true); 
				sliderThick.setValue(10);
				
				JButton regular = new JButton("Regular");
				regular.setBackground(Color.cyan);
				JButton irregular = new JButton("Irregular");
				
				panel.add(sliderLabel);
				panel.add(sliderLines);
				panel.add(sliderLabel1);
				panel.add(sliderThick);
				panel.add(regular);
				panel.add(irregular);
				
				frameIn.add(panel, BorderLayout.CENTER);
				frameIn.setSize(600,250);
				frameIn.setVisible(true);
				frameIn.setLayout(new BorderLayout());
				
				sliderLines.addChangeListener(new ChangeListener() {
					@Override
					public void stateChanged(ChangeEvent arg0) {
						int sides = sliderLines.getValue();
						sliderLabel.setText("Number of lines: " + Integer.toString(sides));
		                polygon.setSides(sides);
					}
				});
				
				sliderThick.addChangeListener(new ChangeListener() {
					@Override
					public void stateChanged(ChangeEvent arg0) {
						int thick = sliderThick.getValue();
						sliderLabel1.setText("Thickness of line: " + Integer.toString(thick));
		                polygon.setThick(thick);
					}
				});
				
				regular.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						irregular.setBackground(null);
						regular.setBackground(Color.cyan);
						
						System.out.print(0);
		                polygon.setType(0);
					}
				});
				
				irregular.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						regular.setBackground(null);
						irregular.setBackground(Color.cyan);
						System.out.print(1);
		                polygon.setType(1);
					}
				});
				
				//frameOut.pack();
		        frameOut.setLocation(800,200);
		        frameOut.getContentPane().add(polygon);
		        frameOut.setVisible(true);
			}
		});
		
	}
}

import java.awt.Color;
import java.io.FileNotFoundException;

import javax.swing.JFrame;

public class MyFrame extends JFrame {
	
	private MyPanel panel;
	
	public MyFrame(String filePath, String regex) throws FileNotFoundException {
		panel = new MyPanel(filePath, regex);
		this.add(panel);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setVisible(true);
	}

}

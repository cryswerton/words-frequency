import java.awt.Color;
import java.io.FileNotFoundException;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

public class MyFrame extends JFrame {
	
	private MyPanel panel;
	private final int WIDTH = 700;
	private final int HEIGHT = 700;
	
	public MyFrame(String filePath, String regex) throws FileNotFoundException {
		panel = new MyPanel(filePath, regex);
		panel.setLayout(new WrapLayout());
		
		JScrollPane scroll = new JScrollPane(panel);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		this.setSize(this.WIDTH, this.HEIGHT);
		this.add(scroll);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

}

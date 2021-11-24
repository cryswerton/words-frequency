import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class MyFrame extends JFrame implements ActionListener {
	
	private JButton button;
	private MyPanel panel;
	private static final int WIDTH = 700;
	private static final int HEIGHT = 700;
	private static final int HEADER_HEIGHT = HEIGHT/3;
	private static final int HEADER_WIDTH = WIDTH;
	private static final int BODY_HEIGHT = HEIGHT/2;
	private static final int BTN_WIDTH = 210;
	private static final int BTN_HEIGHT = 70;
	private static final int BTN_Y = (HEADER_HEIGHT - BTN_HEIGHT) / 2;
	private static final int BTN_X = (HEADER_WIDTH - BTN_WIDTH) / 2;
	
	public MyFrame(String filePath, String regex) throws FileNotFoundException {
		button = new JButton("Select File");
		button.addActionListener(this);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setSize(this.WIDTH, this.HEIGHT);
	    setLocationRelativeTo(null);
	    setLayout(new BorderLayout());

	    JPanel header = new JPanel();
	    header.setPreferredSize(new Dimension(this.WIDTH, HEADER_HEIGHT));
	    header.setLayout(null);
	    header.setBackground(Color.gray);
	    button.setBounds(BTN_X, BTN_Y, BTN_WIDTH, BTN_HEIGHT);
	    button.setFont(new Font("Calibri", Font.PLAIN, 25));
	    button.setFocusable(false);
	    System.out.println(BTN_X+" "+BTN_Y);
	    header.add(button);

	    JPanel body = new JPanel();
	    body.setPreferredSize(new Dimension(this.WIDTH, BODY_HEIGHT));
	    body.setLayout(new BorderLayout());
	    body.setBackground(Color.black);
	    	    
	    MyPanel p1 = new MyPanel(filePath, regex);
//	    p1.setPreferredSize(new Dimension(400, 1000));
	    //p1.setPreferredSize(p1.getPreferredSize());
	    p1.setLayout(new WrapLayout());
	    p1.setBackground(Color.green);
	    
	    
	    JScrollPane scroll = new JScrollPane(p1);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	   
		body.add(scroll, BorderLayout.CENTER);
	    

	    add(header, BorderLayout.NORTH);
	    add(body, BorderLayout.CENTER);
	    setVisible(true);
	    System.out.println(p1.getHeight());
	}

	@Override
	public void actionPerformed(ActionEvent e) {


		if (e.getSource() == button) {

			JFileChooser fileChooser = new JFileChooser();

			fileChooser.setCurrentDirectory(new File("C:\\Users\\Documents")); // sets current directory

			int response = fileChooser.showOpenDialog(null); // select file to open
			// int response = fileChooser.showSaveDialog(null); //select file to save

			if (response == JFileChooser.APPROVE_OPTION) {
				File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
				System.out.println(file);
			}
		}
		
	}

}

import java.awt.*;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class WordLabel extends JLabel {

	private Word word;
	private final Border border = BorderFactory.createLineBorder(Color.blue, 2, true);
	
	public WordLabel(Word word) {
		this.setFont(new Font("Calibri", Font.PLAIN, 25));
		this.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.word = word;
		this.setText(word.getName() + "(" + word.getFrequency() + ")");
	}
	
	public WordLabel(String msg) {
		this.setFont(new Font("Calibri", Font.PLAIN, 25));
		this.setText(msg);
		this.setLayout(new FlowLayout());
	}
}

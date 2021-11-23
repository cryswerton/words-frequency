import java.awt.Font;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.border.Border;

public class WordLabel extends JLabel {

	private Word word;
	private Border border = BorderFactory.createLineBorder(Color.blue, 5);
	
	public WordLabel(Word word) {
		this.setFont(new Font("Arial", Font.PLAIN, 25));
		this.setBorder(border);
		this.word = word;
		this.setText(word.getName() + "(" + word.getFrequency() + ")");
	}
}

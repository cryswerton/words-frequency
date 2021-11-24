import java.awt.Dimension;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class MyPanel extends JPanel{
	
	static private final int WIDTH = 800;
	static private final int HEIGHT = 800;
	static private final Dimension SCREEN_SIZE = new Dimension(WIDTH, HEIGHT);
	
	private WordsContent  wdct;	
	private ArrayList<JLabel> labels;
	private String filePath;
	private String regexPattern;
	
	public MyPanel(String filePath, String regex) throws FileNotFoundException {
		this.filePath = filePath;
		this.regexPattern = regex;
		this.labels = new ArrayList<JLabel>();
		this.addLabelsToPanel();
		//this.setBackground(Color.green);
	}
	
	private void feedListOfWords() throws FileNotFoundException {
		this.wdct = new WordsContent(filePath, regexPattern);
		this.wdct.createListOfWords();
		this.wdct.createWordsFrequency();
		this.wdct.setWords(this.wdct.getUniqueListOfWords(this.wdct.getWords()));
		this.wdct.sortWords(true);
	}
	
	private void feedListOfLabels() throws FileNotFoundException {
		this.feedListOfWords();
		for(Word word: wdct.getWords()) {
			this.labels.add(new WordLabel(word));
		}
	}
	
	private void addLabelsToPanel() throws FileNotFoundException {
		this.feedListOfLabels();
		for(JLabel label: this.labels) {
			this.add(label);
		}
	}
	
	
	
	
	
}

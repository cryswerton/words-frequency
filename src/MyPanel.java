import java.awt.Dimension;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

//Need refactoring

public class MyPanel extends JPanel{
	
	static private final int WIDTH = 800;
	static private final int HEIGHT = 800;
	static private final Dimension SCREEN_SIZE = new Dimension(WIDTH, HEIGHT);
	
	private WordsContent  wdct;	
	private ArrayList<JLabel> labels;
	private String regex = "([a-zA-Z]+'?-?[a-zA-Z]+(-?[a-zA-Z])?)|[a-zA-Z]";
	
	public MyPanel() throws FileNotFoundException {
		this.labels = new ArrayList<JLabel>();
//		this.addLabelsToPanel();
		//this.setBackground(Color.green);
	}

	private void feedListOfWords(String filePath) throws FileNotFoundException {
		this.wdct = new WordsContent(filePath, this.regex);
		this.wdct.createListOfWords();
		this.wdct.createWordsFrequency();
		this.wdct.setWords(this.wdct.getUniqueListOfWords(this.wdct.getWords()));
		this.wdct.sortWords(true);
	}
	
	private void feedListOfLabels(String filePath) throws FileNotFoundException {
		this.feedListOfWords(filePath);
		for(Word word: wdct.getWords()) {
			this.labels.add(new WordLabel(word));
		}
	}
	
	public void addLabelsToPanel(String filePath) throws FileNotFoundException {
		this.labels.clear();
		this.feedListOfLabels(filePath);
		for(JLabel label: this.labels) {
			this.add(label);
		}
	}
	
	
	
	
	
}

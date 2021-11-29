import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class MyPanel extends JPanel {

    static private final int WIDTH = 800;
    static private final int HEIGHT = 800;
    static private final Dimension SCREEN_SIZE = new Dimension(WIDTH, HEIGHT);
    private WordsContent wdct;
    private ArrayList<JLabel> labels;
    private String regex = "([a-zA-Z]+'?-?[a-zA-Z]+(-?[a-zA-Z])?)|[a-zA-Z]";

    public MyPanel() {
        this.labels = new ArrayList<>();
    }

    private void feedListOfWords(String filePath) throws IOException {
        this.wdct = new WordsContent(filePath, this.regex);
        this.wdct.createListOfWords();
        this.wdct.createWordsFrequency();
        this.wdct.setWords(this.wdct.getUniqueListOfWords(this.wdct.getWords()));
        this.wdct.sortWords(true);
    }

    private void feedListOfLabels(String filePath) throws IOException {
        this.feedListOfWords(filePath);
        for (Word word : wdct.getWords()) {
            this.labels.add(new WordLabel(word));
        }
    }

    public void addLabelsToPanel(String filePath) throws IOException {
        this.labels.clear();
        this.feedListOfLabels(filePath);
        for (JLabel label : this.labels) {
            this.add(label);
        }
    }
}

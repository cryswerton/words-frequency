import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

	public static void main(String[] args) throws IOException {

		String filePath;
		String regexPattern = "([a-zA-Z]+'?-?[a-zA-Z]+(-?[a-zA-Z])?)|[a-zA-Z]";
		
		filePath = "C:\\Users\\crysw\\Documents\\bm-subs\\bvm-subs.srt";
		//filePath = "C:\\Users\\crysw\\Documents\\test.txt"; // change it to you're desired path.
		WordsContent wdct = new WordsContent(filePath, regexPattern);
		wdct.createListOfWords();
		wdct.createWordsFrequency();
		wdct.sortWords(true);
		wdct.printListOfWords();
		
		MyFrame frame = new MyFrame(filePath, regexPattern);
		
	}

}

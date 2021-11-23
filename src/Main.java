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
		filePath = "C:\\Users\\crysw\\Documents\\bm-subs\\bvm-subs.srt";
		//filePath = "C:\\Users\\crysw\\Documents\\notes2.txt";
		ArrayList<Word> words;
		
		File file = new File(filePath);
		Scanner scan = new Scanner(file, "UTF-8");
		
		String fileContent = "";
		while(scan.hasNextLine()) {
			fileContent = fileContent.concat(scan.nextLine() + "\n");
		}
		
//		System.out.println(fileContent);
//		System.out.println(matchFound("\\w+", fileContent));
		
		// Regex to get only words
		words = getWords("[a-zA-Z]+'?[a-zA-Z]+", fileContent);
		words = updateWordsFrequency(words);
		sortWords(true, words);
		
		printWords(words);
		
//		for(Word word: words) {
//			System.out.printf("%s; frequency: %d\n", word.getName(), word.getFrequency());
//		}
		
	}
	
	// Returns an array list with all the matches
	static ArrayList<Word> getWords(String patternText, String textContent){
		String s = textContent;
		Matcher m = Pattern.compile(patternText).matcher(s);
		ArrayList<Integer> positions = new ArrayList<Integer>();
		ArrayList<Word> words = new ArrayList<Word>();
		while (m.find())
		{
		    positions.add(m.start());
		    words.add(new Word(m.group()));
		}
		//System.out.println(positions);
		
		return words;
	}
	
	static int getWordFrequency(String word, ArrayList<Word> words) {
		int count = 0;
		for(Word wd: words) {
			if(wd.getName().equals(word)) {
				count++;
			}
		}
		return count;
	}
	
	static ArrayList<Word> updateWordsFrequency(ArrayList<Word> words) {
		for(Word word: words) {
			word.setFrequency(getWordFrequency(word.getName(), words));
		}
		return words;
	}
	
	static void sortWords(boolean option, ArrayList<Word> words) {
		// true = descending; false ascending.
		if(option) {
			words.sort(Comparator.comparing(Word::getFrequency).reversed());
		}else {
			words.sort(Comparator.comparing(Word::getFrequency));
		}
	}
	
	static void printWords(ArrayList<Word> words) {
		ArrayList<Word> uniqueWords = new ArrayList<Word>();
		ArrayList<String> wordsAlreadyAdded = new ArrayList<String>();
		int currentWordFrequency = 0;
		for(Word word: words) {
			if(!wordsAlreadyAdded.contains(word.getName())) {
				uniqueWords.add(word);
				wordsAlreadyAdded.add(word.getName());				
			}
		}
		
		for(Word word: uniqueWords) {
			System.out.printf("%s; frequency: %d\n", word.getName(), word.getFrequency());
		}
	}

}

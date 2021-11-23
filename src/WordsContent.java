import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordsContent {
	
	private String filePath;
	private File file;
	private String fileContent = "";
	private String regexPattern;
	private Scanner scan;
	private ArrayList<Word> words;
	
	public WordsContent(String filePath, String regexPattern) throws FileNotFoundException {
		this.filePath = filePath;
		this.file = new File(filePath);
		this.regexPattern = regexPattern;
		this.scan = new Scanner(file, "UTF-8");
		this.fileContent = getFileContent();
		this.words = new ArrayList<Word>();
	}
	
	
	
	public ArrayList<Word> getWords() {
		return words;
	}



	public void setWords(ArrayList<Word> words) {
		this.words = words;
	}



	public void createListOfWords(){
		Matcher matcher = Pattern.compile(this.regexPattern).matcher(this.fileContent);
		String wordstr = "";
		while (matcher.find())
		{
			wordstr = matcher.group(); 
			
			if(wordstr.equals("i")) {
				wordstr = wordstr.toUpperCase();
			}
			
			// get the group of words matched by the regex and assign each one to the ArrayList words.
			this.words.add(new Word(wordstr));
		}		
	}
	
	public void createWordsFrequency() {
		for(Word word: this.words) {
			word.setFrequency(this.getWordFrequency(word.getName()));
		}
	}
	
	public void sortWords(boolean option) {
		// true = descending; false ascending.
		if(option) {
			words.sort(Comparator.comparing(Word::getFrequency).reversed());
		}else {
			words.sort(Comparator.comparing(Word::getFrequency));
		}
	}
	
	public void printListOfWords() {
		for(Word word: getUniqueListOfWords()) {
			System.out.printf("%s; frequency: %d\n", word.getName(), word.getFrequency());
		}
	}
	
	private String getFileContent() {
		while(this.scan.hasNextLine()) {
			this.fileContent = this.fileContent.concat(scan.nextLine() + "\n");
		}
		return this.fileContent.toLowerCase();
	}
	
	private int getWordFrequency(String word) {
		int count = 0;
		for(Word wd: this.words) {
			if(wd.getName().equals(word)) {
				count++;
			}
		}
		return count;
	}
	
	private ArrayList<Word> getUniqueListOfWords() {
		ArrayList<Word> uniqueWords = new ArrayList<Word>();
		ArrayList<String> wordsAlreadyAdded = new ArrayList<String>();
		int currentWordFrequency = 0;
		for(Word word: this.words) {
			if(!wordsAlreadyAdded.contains(word.getName())) {
				uniqueWords.add(word);
				wordsAlreadyAdded.add(word.getName());				
			}
		}
		return uniqueWords;
	}
	
	public ArrayList<Word> getUniqueListOfWords(ArrayList<Word> words) {
		ArrayList<Word> uniqueWords = new ArrayList<Word>();
		ArrayList<String> wordsAlreadyAdded = new ArrayList<String>();
		int currentWordFrequency = 0;
		for(Word word: this.words) {
			if(!wordsAlreadyAdded.contains(word.getName())) {
				uniqueWords.add(word);
				wordsAlreadyAdded.add(word.getName());				
			}
		}
		return uniqueWords;
	}
	
	
	
	

}

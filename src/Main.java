import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class Main {

	public static void main(String[] args) throws IOException {

		String filePath = "C:\\Users\\crysw\\Documents\\bm-subs\\bvm-subs.srt";
		String regexPattern = "([a-zA-Z]+'?-?[a-zA-Z]+(-?[a-zA-Z])?)|[a-zA-Z]";
		
		MyFrame frame = new MyFrame(filePath, regexPattern);
		
		
	}

}

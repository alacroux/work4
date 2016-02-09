/**
 * 
 */
package com.work4.application;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Alex
 *
 */
public class Application {

	public static final String SEPARATOR = "\n\n----------------";
	public static final String OUPS = "Oups... not enough time !";
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Application app = new Application();
		
		app.questionZero();
		
		app.questionOneOne();
		app.questionOneTwo();
		app.questionOneThree();
		app.questionOneFor();
		
		app.questionTwoOne();
		app.questionTwoTwo();
		app.questionTwoThree();
		app.questionTwoFor();
		
		app.questionThreeOne();
		app.questionThreeTwo();
		app.questionThreeThree();
		app.questionThreeFor();
		
		app.questionForOne();
		app.questionForTwo();
		app.questionForThree();
	}
	
	/**
	 * Question 0
	 */
	public void questionZero() {
		System.out.println(SEPARATOR);
		System.out.println("Question 0 :\n");

		displayFile("question0.txt");
	}
	
	/**
	 * Question 1.1
	 */
	public void questionOneOne() {
		System.out.println(SEPARATOR);
		System.out.println("Question 1.1 :\n");

		displayFile("question1-1.txt");
	}

	/**
	 * Question 1.2
	 */
	public void questionOneTwo() {
		System.out.println(SEPARATOR);
		System.out.println("Question 1.2 :\n");

		displayFile("question1-2.txt");
	}
	

	/**
	 * Question 1.3
	 */
	public void questionOneThree() {
		System.out.println(SEPARATOR);
		System.out.println("Question 1.3 :\n");

		displayFile("question1-3.txt");
	}

	/**
	 * Question 1.4
	 */
	public void questionOneFor() {
		System.out.println(SEPARATOR);
		System.out.println("Question 1.4 :\n");

		displayFile("question1-4.txt");
	}

	/**
	 * Question 2.1
	 */
	public void questionTwoOne() {
		System.out.println(SEPARATOR);
		System.out.println("Question 2.1 :\n");
		
		final String firstText = "0x0f4";
		final String secondText = "0acdadecf822eeff32aca5830e438cb54aa722e3";
		final String thirdText = "8BADF00D";
		
		final String regex = "(0x)?[0-9a-fA-F]+";
		System.out.println("Regex : " + regex);
		Pattern pattern = Pattern.compile(regex);
		
		matches(pattern, firstText);
		matches(pattern, secondText);
		matches(pattern, thirdText);
	}
	
	private void matches(Pattern pattern, String text) {
		Matcher matcher = pattern.matcher(text);
		boolean result = matcher.matches();
		System.out.println(String.format("%s : %s", text, result ? "OK" : "KO"));
	}

	/**
	 * Question 2.2
	 */
	public void questionTwoTwo() {
		System.out.println(SEPARATOR);
		System.out.println("Question 2.2 :\n");

		displayFile("question2-2.txt");
	}

	/**
	 * Question 2.3
	 */
	public void questionTwoThree() {
		System.out.println(SEPARATOR);
		System.out.println("Question 2.3 :\n");

		System.out.println(OUPS);
	}

	/**
	 * Question 2.4
	 */
	public void questionTwoFor() {
		System.out.println(SEPARATOR);
		System.out.println("Question 2.4 :\n");

		for(int n = 0 ; n<=10 ; n++) {
			System.out.println(String.format("f(%d) = %d", n, f(n)));
		}
		System.out.println("...");
		System.out.println("See the sources for the details of the function");
	}
	
	/**
	 * f(0) = 1;
	 * f(1) = 3;
	 * f(n) = 3 * f(n ­ 1) ­ f(n ­ 2);
	 * @param n
	 * @return
	 */
	private int f(int n) {
		int res = 0;
		int f0 = 1;
		int f1 = 3;
		
		if(n == 0) {
			return f0;
		}
		else if(n == 1) {
			return f1;
		}
		else {
			for(int i = 2 ; i<=n ; i++) {
				res = 3 * f1 - f0;
				f0 = f1;
				f1 = res;
			}
			return res;
		}
	}

	/**
	 * Question 3.1
	 */
	public void questionThreeOne() {
		System.out.println(SEPARATOR);
		System.out.println("Question 3.1 :\n");

		displayFile("question3-1.txt");
	}

	/**
	 * Question 3.2
	 */
	public void questionThreeTwo() {
		System.out.println(SEPARATOR);
		System.out.println("Question 3.2 :\n");

		System.out.println("SELECT * FROM user ORDER BY created_at ASC LIMIT 10 ;");
	}

	/**
	 * Question 3.3
	 */
	public void questionThreeThree() {
		System.out.println(SEPARATOR);
		System.out.println("Question 3.3 :\n");

		System.out.println("SELECT email, COUNT(*) AS number FROM user GROUP BY email HAVING number > 1 ;");
	}

	/**
	 * Question 3.4
	 */
	public void questionThreeFor() {
		System.out.println(SEPARATOR);
		System.out.println("Question 3.4 :\n");
		
		System.out.println("SELECT DISTINCT a.email FROM user AS a LEFT JOIN user AS b ON a.email = b.email WHERE a.id <> b.id ;");
	}
	
	/**
	 * Question 4.1
	 */
	public void questionForOne() {
		System.out.println(SEPARATOR);
		System.out.println("Question 4.1 :\n");

		displayFile("question4-1.txt");
	}

	/**
	 * Question 4.2
	 */
	public void questionForTwo() {
		System.out.println(SEPARATOR);
		System.out.println("Question 4.2 :\n");

		System.out.println(OUPS);
	}

	/**
	 * Question 4.3
	 */
	public void questionForThree() {
		System.out.println(SEPARATOR);
		System.out.println("Question 4.3 :\n");

		System.out.println(OUPS);
	}
	
	/**
	 * Displays the content of a file in the console.
	 * @param file The file to display the content.
	 */
	private void displayFile(String file) {
	    BufferedReader br = new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream(file)));
	    try {
	        String line = br.readLine();
	        while (line != null) {
	            System.out.println (line);
	            line = br.readLine();
	        }
	        br.close();
	    }
	    catch (IOException exception) {
	        System.out.println ("Error while reading file : " + exception.getMessage());
	    }
	}

}

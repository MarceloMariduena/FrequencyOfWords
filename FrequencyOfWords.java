import java.util.*;
import java.io.*;


public class FrequencyOfWords {

	public static void main(String[] args) {
		
	    // Prompt user for file name
		Scanner input = new Scanner(System.in);
	    System.out.print("Enter filename: ");
	    String fileName = input.nextLine();
	    
	    File tempFile = new File(fileName);
	    if(!tempFile.exists()){
	    	System.out.println("The file '" + fileName + "' does not exist or is not found in the current directory.");
	    	System.exit(0); // terminates program successfully
	    }
	
	    try {
	    	/* Part 1: creates an list of a words of the input file */
	    	Scanner s = new Scanner(tempFile); // scans the tempFile
	    	ArrayList<String> words = new ArrayList<String>(); 
	    	while (s.hasNext()){ words.add(s.next().toLowerCase().replaceAll("[^a-z]", "")); }
	    	s.close();
	    	 
	    	/* Part 2: sorts the list of words in alphabetical order */
	    	Collections.sort(words, new Comparator<String>() {
	    		@Override
	            public int compare(String word1, String word2) {
	                    return word1.compareTo(word2);
	            }
	        });
	    	
	    	/* Part 3: display the frequency of each word */
	    	String currentWord = "";
	    	int currentCount = 1;
	    	System.out.println("\nFrequencies: ");
	    	for (int i = 0; i < words.size(); i++) {
	    		if (i == 0) {
	    			currentWord = words.get(i);
	    			continue;
	    		}
	    		if (words.get(i).equals(currentWord)) {
	    			currentCount++;
	    		}
	    		else {
	    			System.out.printf("[%s] = %d; ", currentWord, currentCount);
	    			currentCount = 1;
	    			currentWord = words.get(i);
	    		}
	    		if (i == words.size() - 1) {
	    			System.out.printf("[%s] = %d; ", words.get(i), currentCount);
	    		}
	    	}
	    } catch (FileNotFoundException E ){
	    	System.out.println("That is not a file!");
	    }
	    input.close();
	}
}


package eluett_problem1;




import java.io.BufferedWriter;
import java.io.File;
import java.util.*; 
import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;
import java.io.FileNotFoundException;

public class DuplicateRemover {
	
	private Set<String>  uniqueWords = new HashSet<String>();
	public void remove(String path) {
    Scanner iterator = new Scanner(System.in);
    try{
		  iterator = new Scanner(new File(path));
    }
    catch(FileNotFoundException e){
      System.err.println("Error: " + e.getMessage());
    }
		while(iterator.hasNextLine()){
			 String line = iterator.nextLine(); 
			 String[] bank = line.replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+");
			 for (int i = 0;i < bank.length;i++) {
				 uniqueWords.add(bank[i]);
			 }
	    }
		iterator.close();
	}
	public void write(String path) {
		 BufferedWriter out = null;
		 try {
			 File f = new File(path);
			 if (f.createNewFile()) {
				 List<String> stringsList = new ArrayList<>(uniqueWords);
				 FileWriter iterator = new FileWriter(path, false); 
				 out = new BufferedWriter(iterator);
				 for (int i = 0; i < stringsList.size();i++) {
					 out.write(stringsList.get(i) + "\n");
				 }
         out.close();
			 } 
			 else {
				 List<String> stringsList = new ArrayList<>(uniqueWords);
				 FileWriter iterator = new FileWriter(path, false); 
				 out = new BufferedWriter(iterator);
				 for (int i = 0; i < stringsList.size();i++) {
					 out.write(stringsList.get(i) + "\n");
				 }
         out.close();
			 }
			
		 }
		 catch (IOException e) {
			 System.err.println("Error: " + e.getMessage());
		 }
		
	}
}

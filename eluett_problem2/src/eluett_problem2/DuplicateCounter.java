package eluett_problem2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class DuplicateCounter {
	
	   private Map<String, Integer> wordCounter = new HashMap<String, Integer>();
	   public void count(String dataFile) {
          Scanner iterator = new Scanner(System.in);
          try{
		      iterator = new Scanner(new File(dataFile));
          }
          catch(FileNotFoundException e){
          System.err.println("Error: " + e.getMessage());
          }
	  	  while(iterator.hasNextLine()){
			   String line = iterator.nextLine(); 
			   String[] bank = line.replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+");
			   for (int i = 0;i < bank.length;i++) {
				   if (wordCounter.containsKey(bank[i])) {
				  	 wordCounter.put(bank[i],wordCounter.get(bank[i]) + 1);
				   }
				   else {
				  	 wordCounter.put(bank[i],1);
				   }
			   }
	      }
		iterator.close();
	   }
	   public void write(String  outputFile) {
			 BufferedWriter out = null;
			 
			 try {
				 File f = new File(outputFile);
				 if (f.createNewFile()) {
					 
					 FileWriter iterator = new FileWriter(outputFile, false); 
					 
					 out = new BufferedWriter(iterator);
                     for (Map.Entry<String, Integer> entry : wordCounter.entrySet()) {
                    	 
                    	   String key = entry.getKey();
                    	   int value = entry.getValue();
                    	   out.write(key + " : " + value + "\n");
                     }

	                 out.close();
				 } 
				 else {
					 
					 FileWriter iterator = new FileWriter( outputFile, false); 
					 out = new BufferedWriter(iterator);

                     for (Map.Entry<String, Integer> entry : wordCounter.entrySet()) {
                    	 
                  	   String key = entry.getKey();
                  	   int value = entry.getValue();
                  	   out.write(key + " : " + value + "\n");
                     }  

	                  out.close();
				 }
				
			 }
			 catch (IOException e) {
				 System.err.println("Error: " + e.getMessage());
			 }
			
	   }
}

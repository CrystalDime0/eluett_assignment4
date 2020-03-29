package eluett_problem2;



public class Application {

	  public static void main(String[] args) {
          DuplicateCounter createdObject = new DuplicateCounter();
          createdObject.count("problem2.txt");
          createdObject.write("unique_word_counts.txt"); 
	  }
}

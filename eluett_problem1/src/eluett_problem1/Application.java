package eluett_problem1;



public class Application{


    public static void main(String[] args){
        
               DuplicateRemover createdObject = new DuplicateRemover();
               createdObject.remove("problem1.txt");
               createdObject.write("unique_words.txt");
    }




}
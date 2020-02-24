package quiz;


import java.security.SecureRandom;
import java.util.Scanner;
public class CAI4 {

   public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       String Random;
       do {
  
           quiz(sc);
           System.out.print("\nDo you want another round?(yes/no): ");
           Random = sc.next();
           System.out.println();
       } while (Random.equalsIgnoreCase("yes"));
       sc.close();
   }
   public static void quiz(Scanner sc) {
       SecureRandom random = new SecureRandom();
       int countCorrect = 0;
       int difficulty = readDifficulty(sc);
       System.out.println();
       for (int i = 1; i <= 10; i++) {
    	   
           int number1 = generateQuestionArgument(random, difficulty);
           int number2 = generateQuestionArgument(random, difficulty);
           int correctAns = number1 * number2;
           askQuestion(number1, number2, i);
           int response = readResponse(sc);
           if (isAnswerCorrect(correctAns, response)) 
           {
               displayCorrectResponse(random);
               countCorrect++;
           } else
               displayIncorrectResponse(random);
       }
       displayCompletionMessage(countCorrect);
   }
   
   
   
 public static int generateQuestionArgument(SecureRandom rand, int difficulty) {
       int argument = 0;
      
       if (difficulty == 1)
           argument = rand.nextInt(10);
       else if (difficulty == 2)
           argument = rand.nextInt(100);
       else if (difficulty == 3)
           argument = rand.nextInt(1000);
       else
           argument = rand.nextInt(10000);
      
       return argument;
   }
    public static int readDifficulty(Scanner sc) {
       System.out.print("Enter difficulty level(1-4): ");
       return sc.nextInt();
   }
   public static void displayCompletionMessage(int countCorrect) {
       double percent = ((double) countCorrect / 10.0) * 100.0;
       System.out.println("\nYou Scored: " + percent + "%");
       if (percent < 75)
           System.out.println("Please ask your teacher for extra help.");
       else
           System.out.println("Congratulations, you are ready to go to next level!");

   }
       public static void askQuestion(int num1, int num2, int i) {
           System.out.println("Q." + i + " how much is " + num1 + " times " + num2 + "?");
       }

       public static int readResponse(Scanner sc) {
           System.out.print("Ans. ");
           int response = sc.nextInt();
           return response;
       }
   
       public static void displayCorrectResponse(SecureRandom rand) {
           String correctResponse[] = { "Very good!", "Excellent", "Nice work!", "Keep up the good work!" };
           int index = rand.nextInt(correctResponse.length);
           System.out.println(correctResponse[index]);
   }
   public static void displayIncorrectResponse(SecureRandom rand) {
       String incorrect[] = { "No try again", "Wrong. Try once more", "Don't give up!", "No. Keep trying" };
       int index = rand.nextInt(incorrect.length);
       System.err.println(incorrect[index]); 
   }
  public static boolean isAnswerCorrect(int num1, int num2) {
       return num1 == num2;
  }

}


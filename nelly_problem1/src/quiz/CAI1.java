package quiz;

import java.security.SecureRandom;
import java.util.Scanner;
public class CAI1
{
   public static void main(String[] args) {
   quiz();
   }
   public static void quiz(){
   SecureRandom secureRandom = new SecureRandom();
int number1 = secureRandom.nextInt(10);
int number2 = secureRandom.nextInt(10);
int expectedAnswer = number1 * number2;
int studentAnswer =-1;
while(true)
{
askQuestion(number1,number2);
studentAnswer = readResponse();
if (isAsnwerCorrect(expectedAnswer,studentAnswer))
{
displayCorrectResponse();
break;
}
else
{
displayInorrectResponse();
}
  
}
  
   }

   public static void askQuestion(int num1, int num2){
   System.out.print("How much " + num1 + " times " + num2 + "?");
   }
     public static int readResponse(){
   Scanner sc = new Scanner(System.in);
   int answer = sc.nextInt();
   return answer;
   }
  
   public static boolean isAsnwerCorrect(int expectedAnswer, int studentAnswer){
   return expectedAnswer == studentAnswer;
   }
  
   public static void displayCorrectResponse(){
   System.out.println("Very good!");
   }
  
   public static void displayInorrectResponse(){
   System.out.println("No. Please try again.");
   }
}

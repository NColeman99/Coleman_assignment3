package quiz;

import java.security.SecureRandom;
import java.util.Scanner;
public class CAI2 {
	
public static SecureRandom SecureRandom = new SecureRandom();

public static void main(String[] args) {
quiz();
}
public static void quiz()
{

boolean correct=false;

int number1=SecureRandom.nextInt(10);
int number2=SecureRandom.nextInt(10);
int expectedAnswer = number1*number2;
int studentAnswer = -1; 
while(true){
	
	askQuestion(number1,number2);
	studentAnswer = readResponse();
	if(isAnswerCorrect(number1,number2,studentAnswer))
	{
	correct=true;
	displayCorrectResponse();
	break;
	}
	else
	displayIncorrectResponse();
	}
	}


public static void askQuestion(int num1, int num2){
System.out.print("How much is "+num1+" times" +num2+ "?");
	}
	public static int readResponse(){
	Scanner sc=new Scanner(System.in);
	return sc.nextInt();
	}
		public static void displayCorrectResponse() {
		String correctResponse[]={"Very good!","Excellent!","Nice Work!","Keep up the good work!"};
		int r;
		r=SecureRandom.nextInt(4);
		System.out.println(correctResponse[r]);
		}

			public static void displayIncorrectResponse() {
			String incorrectResponse[]={"No Try again.","Wrong, Try once more.","Don't give up!","No. Keep trying."};
			int index = SecureRandom.nextInt(incorrectResponse.length);
			System.out.println(incorrectResponse[index]);
			}
			public static boolean isAnswerCorrect(int num1, int num2, int ans) {
			return (num1*num2)==ans;
			} 
			   }
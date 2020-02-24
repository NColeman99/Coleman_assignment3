package quiz;
import java.security.SecureRandom;
import java.util.Scanner;
public class CAI5 {
public static void main(String[] args) {
Scanner sc = new Scanner(System.in);

String Random;

do {

quiz(sc);
System.out.print("\nDo you want another round?(yes/no): ");
Random = sc.next();
System.out.println();
}
while(Random.equalsIgnoreCase("yes"));
sc.close();
}

public static void quiz(Scanner sc) {
SecureRandom rand = new SecureRandom();
int countCorrect = 0;
int x,i,correctAns=0;
int max = readDifficulty(sc);
int problemtype = readProblemType(sc);
for ( i = 1; i <= 10; i++) 

	{	
	int number1 = rand.nextInt(max);
	int number2 = rand.nextInt(max);
	
	switch(problemtype){
	
	case 1:
	correctAns = call_method(number1, number2, i,1);
	break;
	case 2:
		
		correctAns = call_method(number1, number2, i,2);
		break;
		case 3:
		
			correctAns = call_method(number1, number2, i,3);
			break;
			case 4:
		
				correctAns = call_method(number1, number2, i,4);
				break;
				case 5:
		
					x = rand.nextInt(4)+1; 
					correctAns = call_method(number1, number2, i,x);
					break;
					default:
		
	System.out.println("Wrong choice!!");
	break;
	
	}

int response = readResponse(sc);
if (isAnswerCorrect(correctAns, response))
{
displayCorrectResponse(rand);
countCorrect++;
} else
	displayIncorrectResponse(rand);
	}
		displayCompletionMessage(countCorrect);
		}

public static int readDifficulty(Scanner sc){
System.out.println("Choose the difficulty level");
System.out.print("Difficulty(1-4)? ");
int response = sc.nextInt();

switch (response){

case 1:
response = 10;
break;

case 2:
response = 100;
break;

case 3:
response = 1000;
break;

case 4:
response = 10000;
break;
default:
System.out.println("Wrong choice!!");
break;

}

return response;

}

public static int readProblemType(Scanner sc){
System.out.println("Choose the problem type");
System.out.print("Problem Type(1-5)? ");
int response = sc.nextInt();
return response;

}

public static int multiply(int num1, int num2, int i) {
System.out.println("Q."+i+" How much is " + num1 + " X " + num2 + "?");
int correctAns = num1 * num2;
return correctAns;

}

	public static int add(int num1, int num2, int i) {
	System.out.println("Q."+i+" How much is " + num1 + " + " + num2 + "?");
	int correctAns = num1 + num2;
	return correctAns;
	
	}

		public static int subtract(int num1, int num2, int i) {
		System.out.println("Q."+i+" How much is " + num1 + " - " + num2 + "?");
		int correctAns = num1 - num2;
		return correctAns;
		
		}
			
			public static int division(int num1, int num2, int i) {
			System.out.println("Q."+i+" How much is " + num1 + " / " + num2 + "?");
			int correctAns = num1 / num2;
			return correctAns;
			
			}

	public static int call_method(int num1,int num2,int i, int choice){
	int ans=0;
	switch (choice){
	
	case 1:
	ans = add(num1,num2,i);
	break;
	case 2:
	ans = subtract(num1,num2,i);
	break;
	case 3:
	ans = multiply(num1,num2,i);
	break;
	case 4:
	ans = division(num1,num2,i);
	break;
	}
	return ans;
	
	}

	public static void displayCompletionMessage(int countCorrect) {
	double percent = ((double) countCorrect / 10.0) * 100.0;
	System.out.println("\nYou Scored: " + percent + "%");
	if (percent < 75)
	System.out.println("Please ask your teacher for extra help.");
	else
	System.out.println("Congratulations, you are ready to go to next level!");

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
	String incorrect[] = { "No. Please try again", "Wrong. Try once more", "Don't give up!", "No. Keep trying" };
	int index = rand.nextInt(incorrect.length);
	System.out.println(incorrect[index]);
	
	}

		public static boolean isAnswerCorrect(int num1, int num2) {
		return num1 == num2;
		
		}
}


import java.util.*;
import java.lang.*;

public class Person{
	public String firstName;
	public String lastName;
	public int age;
	private final int ssn;
	public String securityQuestion;
	private String securityAnswer;
	Scanner keyboard = new Scanner(System.in);
	public Person(String firstName, String lastName, int age){
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		double rand = Math.random();
		rand = rand *1000000000;
		ssn = (int) rand;
		int questionNum = -1;
		while (questionNum!= 1 && questionNum!=2){
			try{
				System.out.println("Choose a security question:" + '\n' + "1. What is your mother's maiden name?" + '\n' + "2. What was the color of your first car?");
				questionNum = keyboard.nextInt();
				keyboard.nextLine();
			}catch(InputMismatchException exception){
				System.out.println("This is not an integer");
				keyboard.next();
			}
		}
		if (questionNum==1){
			securityQuestion = "What is your mother's maiden name?";
		} else {
			securityQuestion = "What was the color of your first car?";
		}
		String answer;
		String confirmAnswer;
		while (true){
			System.out.println("Answer the question: " + securityQuestion);
			answer = keyboard.nextLine();
			System.out.println("Confirm the answer to the question: " + securityQuestion);
			confirmAnswer = keyboard.nextLine();
			if (!answer.equalsIgnoreCase(confirmAnswer)){
				System.out.println("Responses do not match. Try again.");
			} else {
				break;
			}
		}
		securityAnswer = answer;
	}
	public int getSSN(){
		System.out.println(securityQuestion);
		String answer = keyboard.nextLine();
		int counter = 3;
		while (!answer.equals(securityAnswer) && counter!=0){
			System.out.println("Incorrect answer. " + securityQuestion);
			answer = keyboard.nextLine();
			counter--;
		}
		if (answer.equals(securityAnswer)){
			return ssn;
		}
		System.out.println("You have answer incorrectly 3 times. Please try again later.");
		return -1;
	}
	public int getAge(){
		return this.age;
	}
	public void setAge(int age){
		this.age = age;
	}
	public static void main(String[] args){
		Person Harsha = new Person("Harsha", "Honasoge", 22);
		int ssn = Harsha.getSSN();
		System.out.println(ssn);
	}
}
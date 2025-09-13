import java.util.Scanner;
import java.util.ArrayList;


public class VotingSystemFunctions {

public static String[] numOfCandidates(String[] array) {
Scanner input = new Scanner(System.in);

System.out.println("Candidates Registration for 4 candidates. Enter names ");
for (int index = 0; index < array.length; index++) {
	System.out.println("Candidate " + (index + 1));
	array[index] = input.nextLine();	
	}
return array;	
}

public static ArrayList<String> numOfVoters(ArrayList<String> voters) {
Scanner input = new Scanner(System.in);

String name = "";
int age = 0;
int index = 0;
String answer = "";
do {
	System.out.println("Voters Registration. Enter name: ");
	name = input.nextLine().toLowerCase();
	System.out.println("Voters Registration. Enter age: ");
	age = input.nextInt();
	if (age >= 18) {
		voters.add(name);
		System.out.println("Registerd as number " + (index + 1) + " Please keep number as temporal voters card") ;	
		index += 1;	
	}
	else {
		System.out.println("You're ineligible to vote due to age requirements. you're under 18!!!");
	}
	System.out.print("More voters ?, reply with (yes or no): ");
	answer = input.next().toLowerCase();
	input.nextLine();
} while (!answer.equals("no"));	
return voters;	
}

public static int[] votingProcess(String[] candidatesArray, ArrayList<String> voters, int[] counting) {
Scanner input = new Scanner(System.in);

String name = "";
int tries = 0;
int vote = 0;

for (int index1 = 0; index1 < voters.size(); index1 ++) {
	do {
		System.out.println("VOTING!!!, Enter name of registeration to verify: ");
v		name = input.nextLine().toLowerCase();
		for (int index = 0; index < voters.size(); index++) {
		if (name.equals(voters.get(index))) {
			tries += 1;
			System.out.println("Verified!!, proceed to vote");
			voters.get(index) = name + "V"
		break;
		}
		String voted = name + "V";
		if (voted.equals(voters.get(index))) {
			System.out.println("You voted already");
		}
		}
		if (tries != 1) {
			System.out.println("Name not found or user Voted, enter valid name");
		}
	} while (tries != 1);
tries = 0;	
for (int index2 = 0; index2 < candidatesArray.length; index2++) {
System.out.println((index2 + 1) + ". " + candidatesArray[index2]);
}

do {
System.out.println("Voter " + name + " Place your vote by selecting your candidates number.");
vote = input.nextInt();
System.out.println("You voted for " + candidatesArray[vote - 1]);

if (vote >= 1 && vote <= voters.size()) {
	counting[vote - 1] += 1;
	break;
	}
else {
	System.out.println("Incorrect input.");
	}
} while (vote <= 1 || vote >= voters.size());

}
return counting;
}

public static void result(int[] counting, String[] candidatesArray) {
for (int index = 0; index < candidatesArray.length; index++) {
System.out.println("ELECTION RESULTS :");
System.out.println(candidatesArray[index] + " have " + counting[index] + " votes");
}
}

}
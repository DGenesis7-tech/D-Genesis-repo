import java.util.Scanner;
import java.util.ArrayList;
public class VotingSystemApp {
public static void main(String[] args) { 
Scanner input = new Scanner(System.in);
VotingSystemFunctions object = new VotingSystemFunctions();

String[] candidatesArray = new String[4];
ArrayList<String> votersArray = new ArrayList<String>();



candidatesArray = object.numOfCandidates(candidatesArray);
votersArray = object.numOfVoters(votersArray);

int[] counting = new int[votersArray.size()];
for (int index3 = 0; index3 < votersArray.size(); index3++) {
counting[index3] = 0;
}


counting = object.votingProcess(candidatesArray, votersArray, counting);
object.result(counting, candidatesArray);


}

}
import java.util.Scanner;
public class Nokia3310{
public static void main (String [] args){
Scanner input = new Scanner(System.in);

int select = 0;
	while (select != 14){

System.out.println("###################################################");
System.out.println("##:::::::::::::::::::::::::::::::::::::::::::::::##");
System.out.println("##::::::::::::::    WELCOME    ::::::::::::::::::##");
System.out.println("##:::::::::::::    TO   YOUR    :::::::::::::::::##");
System.out.println("##:::::::::::::   NOKIA  3310   :::::::::::::::::##");
System.out.println("##::::::::::::::     PHONE    :::::::::::::::::::##");
System.out.println("##:::::::::::::::::::::::::::::::::::::::::::::::##");
System.out.println("###################################################");
System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::");
System.out.println("::  1. Phone book     ::        8. Games ['L']   ::");
System.out.println("::  2. Messages       ::        9. Calculator    ::"); 
System.out.println("::  3. Chat           ::        10. Reminders    ::");
System.out.println("::  4. Call register  ::        11. Clock        ::");
System.out.println("::  5. Tones          ::        12. Profiles     ::");
System.out.println("::  6. Settings       ::        13. SIM services ::");
System.out.println("::  7. Call diver               14. Shut down    ::");
System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::");
System.out.print("Please select an option from the ~Main-Menu~ (1 ~ 14): ");
select = input.nextInt();

switch(select){
case 1:
	int subSelect1 = 0;
	while (subSelect1 != 11){

	System.out.println("::::::> Phone book <::::::");
        System.out.println("1.  Search");
	System.out.println("2.  Service Nos.");
  	System.out.println("3.  Add name");
	System.out.println("4.  Erase");
	System.out.println("5.  Edit");
	System.out.println("6.  Assign tone");
	System.out.println("7.  Send b'card");
	System.out.println("8.  Options");
	System.out.println("9.  Speed dials");
	System.out.println("10. Voice tags");
	System.out.println("11. > Back <");

		System.out.print("Please select an option from the ~Phone book~ Menu (1 ~ 11): ");
 	        subSelect1 = input.nextInt();
		
		switch(subSelect1){
                case 1:
			int subSelectS = 0;
			while (subSelectS != 1){

			System.out.println(":::> Search <:::");
			System.out.println("1. > Back <");
				
				System.out.print("Search page is empty, please select (1) to go back: ");
				subSelectS = input.nextInt();
				
				switch(subSelectS){
				case 1:
					System.out.println("Back to Phone book Menu...");	
					break;				
				default :
					System.out.println("Wrong input !!!");}
				}
			break;

		case 2:
			int subSelectSn = 0;
			while (subSelectSn != 1){

			System.out.println(":::> Service Nos. <:::");
			System.out.println("1. > Back <");
				
				System.out.print("Service Nos. page is empty, please select (1) to go back: ");
				subSelectSn = input.nextInt();
				
				switch(subSelectSn){
				case 1:
					System.out.println("Back to Phone book Menu...");	
					break;				
				default :
					System.out.println("Wrong input !!!");}
				}
			break;

		case 3:
			int subSelectAn = 0;
			while (subSelectAn != 1){

			System.out.println(":::> Add name <:::");
			System.out.println("1. > Back <");
				
				System.out.print("Add name page is empty, please select (1) to go back: ");
				subSelectAn = input.nextInt();
				
				switch(subSelectAn){
				case 1:
					System.out.println("Back to Phone book Menu...");	
					break;				
				default :
					System.out.println("Wrong input !!!");}
				}
			break;
		
		case 4:
			int subSelectEr = 0;
			while (subSelectEr != 1){

			System.out.println(":::> Erase <:::");
			System.out.println("1. > Back <");
				
				System.out.print("Erase page is empty, please select (1) to go back: ");
				subSelectEr = input.nextInt();
				
				switch(subSelectEr){
				case 1:
					System.out.println("Back to Phone book Menu...");	
					break;				
				default :
					System.out.println("Wrong input !!!");}
				}
			break;
		case 5:
			int subSelectEd = 0;
			while (subSelectEd != 1){

			System.out.println(":::> Edit <:::");
			System.out.println("1. > Back <");
				
				System.out.print("Edit page is empty, please select (1) to go back: ");
				subSelectEd = input.nextInt();
				
				switch(subSelectEd){
				case 1:
					System.out.println("Back to Phone book Menu...");	
					break;				
				default :
					System.out.println("Wrong input !!!");}
				}
			break;

		case 6:
			int subSelectAt = 0;
			while (subSelectAt != 1){

			System.out.println(":::> Assign tone <:::");
			System.out.println("1. > Back <");
				
				System.out.print("Assign tone is empty, please select (1) to go back: ");
				subSelectAt = input.nextInt();
				
				switch(subSelectAt){
				case 1:
					System.out.println("Back to Phone book Menu...");	
					break;				
				default :
					System.out.println("Wrong input !!!");}
				}
			break;
		case 7:
			int subSelectSbc = 0;
			while (subSelectSbc != 1){

			System.out.println(":::> Send b'card <:::");
			System.out.println("1. > Back <");
				
				System.out.print("Send b'card is empty, please select (1) to go back: ");
				subSelectSbc = input.nextInt();
				
				switch(subSelectSbc){
				case 1:
					System.out.println("Back to Phone book Menu...");	
					break;				
				default :
					System.out.println("Wrong input !!!");}
				}
			break;
		case 8:
			int subSelectOpt = 0;
			while (subSelectOpt != 3){

			System.out.println(":::> Options <:::");
			System.out.println("1. Type of view");
			System.out.println("2. Memory status");
			System.out.println("3. > Back <");
				
				System.out.print("Please select an option from the ~Options~ Menu (1~3): ");
				subSelectOpt = input.nextInt();
				
				switch(subSelectOpt){
				case 1:
					System.out.println("Opening Type of view...");
					break;
				case 2:
					System.out.println("Opening Memory status...");
					break;
				case 3:
					System.out.println("Back to Phone book Menu...");	
					break;
				default :
					System.out.println("Wrong input !!!");}
				}

			break;

		case 9:
			int subSelectSds = 0;
			while (subSelectSds != 1){

			System.out.println(":::> Speed dials <:::");
			System.out.println("1. > Back <");
				
				System.out.print("Speed dials is empty, please select (1) to go back: ");
				subSelectSds = input.nextInt();
				
				switch(subSelectSds){
				case 1:
					System.out.println("Back to Phone book Menu...");	
					break;				
				default :
					System.out.println("Wrong input !!!");}
				}
			break;
		case 10:
			int subSelectVt = 0;
			while (subSelectVt != 1){

			System.out.println(":::> Voice tags <:::");
			System.out.println("1. > Back <");
				
				System.out.print("Voice tags is empty, please select (1) to go back: ");
				subSelectVt = input.nextInt();
				
				switch(subSelectVt){
				case 1:
					System.out.println("Back to Phone book Menu...");	
					break;				
				default :
					System.out.println("Wrong input !!!");}
				}
			break;
		case 11:
			System.out.println(" > Back < ");
			break;

		default:
			System.out.println("Wrong input !!!");
		}
}
break;

case 2:
int subSelect2 = 0;
	while (subSelect2 != 11){

	System.out.println("::::::> Messages <::::::");
	System.out.println("1.  Write messages");
	System.out.println("2.  Inbox");
  	System.out.println("3.  Outbox");
	System.out.println("4.  Picture messages");
	System.out.println("5.  Templates");
	System.out.println("6.  Smileys");
	System.out.println("7.  Message settings ");
	System.out.println("8.  Info service");
	System.out.println("9.  Voice mailbox number");
	System.out.println("10. Service command editor");
	System.out.println("11. > Back <");

		System.out.print("Please select an option from the ~Messages~ Menu (1 ~ 11): ");
 		subSelect2 = input.nextInt();

		switch(subSelect2){
		case 1:
			int subSelectWm = 0;
			while (subSelectWm != 1){

			System.out.println(":::> Write messages <:::");
			System.out.println("1. > Back <");
				
				System.out.print("Write messages is empty, please select (1) to go back: ");
				subSelectWm = input.nextInt();
				
				switch(subSelectWm){
				case 1:
					System.out.println("Back to Messages Menu...");	
					break;				
				default :
					System.out.println("Wrong input !!!");}
				}
			break;
		case 2:
			int subSelectIn = 0;
			while (subSelectIn != 1){

			System.out.println(":::> Inbox <:::");
			System.out.println("1. > Back <");
				
				System.out.print("Inbox is empty, please select (1) to go back: ");
				subSelectIn = input.nextInt();
				
				switch(subSelectIn){
				case 1:
					System.out.println("Back to Messages Menu...");	
					break;				
				default :
					System.out.println("Wrong input !!!");}
				}
			break;
		case 3:
			int subSelectOut = 0;
			while (subSelectOut != 1){

			System.out.println(":::> Outbox <:::");
			System.out.println("1. > Back <");
				
				System.out.print("Outbox is empty, please select (1) to go back: ");
				subSelectOut = input.nextInt();
				
				switch(subSelectOut){
				case 1:
					System.out.println("Back to Messages Menu...");	
					break;				
				default :
					System.out.println("Wrong input !!!");}
				}
			break;
		case 4:
			int subSelectPm = 0;
			while (subSelectPm != 1){

			System.out.println(":::> Picture messages <:::");
			System.out.println("1. > Back <");
				
				System.out.print("Picture messages is empty, please select (1) to go back: ");
				subSelectPm = input.nextInt();
				
				switch(subSelectPm){
				case 1:
					System.out.println("Back to Messages Menu...");	
					break;				
				default :
					System.out.println("Wrong input !!!");}
				}
			break;
		case 5: 
			int subSelectTm = 0;
			while (subSelectTm != 1){

			System.out.println(":::> Templates <:::");
			System.out.println("1. > Back <");
				
				System.out.print("Templates is empty, please select (1) to go back: ");
				subSelectTm = input.nextInt();
				
				switch(subSelectTm){
				case 1:
					System.out.println("Back to Messages Menu...");	
					break;				
				default :
					System.out.println("Wrong input !!!");}
				}
			break;
		case 6: 
			int subSelectSm = 0;
			while (subSelectSm != 1){

			System.out.println(":::> Smileys <:::");
			System.out.println("1. > Back <");
				
				System.out.print("Smileys is empty, please select (1) to go back: ");
				subSelectSm = input.nextInt();
				
				switch(subSelectSm){
				case 1:
					System.out.println("Back to Messages Menu...");	
					break;				
				default :
					System.out.println("Wrong input !!!");}
				}
			break;
		case 7:
		int subSelectMsgs = 0;
		while (subSelectMsgs != 3){
			System.out.println(":::> Message settings <:::");
			System.out.println("1. Set 1` ");
			System.out.println("2. Common ` ");
			System.out.println("3. > Back < ");
				System.out.print("Please select an option from the ~Message settings~ sub-Menu (1~3): ");
			        subSelectMsgs = input.nextInt();

				switch(subSelectMsgs){
				case 1:
					
					System.out.println(":::> Set 1` <:::");
					System.out.println("1. Message centre number ");
					System.out.println("2. Messages sent as ");
					System.out.println("3. Message validity ");
					break;
					case 2: 
						System.out.println(":::> Common ` <:::");
						System.out.println("1. Delivery reports ");
						System.out.println("2. Reply via same centre ");
						System.out.println("3. Character support ");
					break;
					case 3:
						System.out.println("> Back <");
					break;
					default :
						System.out.println("Wrong input !!!");
					}
					}
		break;
				
		case 8:
			int subSelectIs = 0;
			while (subSelectIs != 1){

			System.out.println(":::> Info service <:::");
			System.out.println("1. > Back <");
				
				System.out.print("Info service is empty, please select (1) to go back: ");
				subSelectIs = input.nextInt();
				
				switch(subSelectIs){
				case 1:
					System.out.println("Back to Messages Menu...");	
					break;				
				default :
					System.out.println("Wrong input !!!");}
				}
			break;
		case 9:
			int subSelectVmn = 0;
			while (subSelectVmn != 1){

			System.out.println(":::> Voice mailbox number <:::");
			System.out.println("1. > Back <");
				
				System.out.print("Voice mailbox number is empty, please select (1) to go back: ");
				subSelectVmn = input.nextInt();
				
				switch(subSelectVmn){
				case 1:
					System.out.println("Back to Messages Menu...");	
					break;				
				default :
					System.out.println("Wrong input !!!");}
				}
			break;
		case 10:
			int subSelectSce = 0;
			while (subSelectSce != 1){

			System.out.println(":::> Service command editor <:::");
			System.out.println("1. > Back <");
				
				System.out.print("Service command editor is empty, please select (1) to go back: ");
				subSelectSce = input.nextInt();
				
				switch(subSelectSce){
				case 1:
					System.out.println("Back to Messages Menu...");	
					break;				
				default :
					System.out.println("Wrong input !!!");}
				}
			break;
		case 11: 
			System.out.println("> Back <");
			break;
		default :
			System.out.println("Wrong input !!!");
		}
		}
break;

case 3:
	System.out.println("Opening Chat__!");
break;

case 4:
	System.out.println("1.  Missed calls");
	System.out.println("2.  Received calls");
  	System.out.println("3.  Dialled numbers");
	System.out.println("4.  Erase recent call lists");
	System.out.println("5.  Show call duration");
	System.out.println("6.  Show call costs");
	System.out.println("7.  Call cost settings");
	System.out.println("8.  Prepaid credit");

		System.out.print("Please select an option from the ~Call register~ Menu (1 ~ 8): ");
 		int subSelect4 = input.nextInt();

		switch(subSelect4){
		case 1:
			System.out.println("Opening Missed calls___!");
			break;
		case 2:
			System.out.println("Opening Received calls___!");
			break;
		case 3:
			System.out.println("Opening Dialled numbers___!");
			break;
		case 4:
			System.out.println("Opening Erase recent call lists___!");
			break;
		case 5:
			System.out.println("1. Last call duration ");
			System.out.println("2. All calls' duration ");
			System.out.println("3. Received calls' duration ");
			System.out.println("4. Dialled calls' duration ");
			System.out.println("5. Clear timers ");
			break;
		case 6:
			System.out.println("1. Last call cost ");
			System.out.println("2. All calls' cost ");
			System.out.println("3. Clear counters ");
			break;
		case 7:
			System.out.println("1. Call cost limit ");
			System.out.println("2. Show costs time ");
			break;
		case 8:
			System.out.println("Opening Prepaid credit ");
			break;
		default :
			System.out.println("Wrong input !!!");
		}
break;

case 5:
	System.out.println("1.  Ringing tone");
	System.out.println("2.  Ringing volume");
  	System.out.println("3.  Incoming call alert");
	System.out.println("4.  Composer");
	System.out.println("5.  Message alert tone");
	System.out.println("6.  Keypad tones");
	System.out.println("7.  Warning and game tones");
	System.out.println("8.  Vibrating alert");
	System.out.println("9.  Screen saver");
			
break;

case 6:
	System.out.println("1.  Call settings");
	System.out.println("2.  Phone settings");
  	System.out.println("3.  Security settings");
	System.out.println("4.  Restore factory settings");

		System.out.print("Please select an option from the ~Settings~ Menu (1 ~ 4): ");
 		int subSelect6 = input.nextInt();

		switch(subSelect6){
		case 1:
			System.out.println("1. Automatic redial ");
			System.out.println("2. Speed dialing ");
			System.out.println("3. Call waiting options ");
			System.out.println("4. Own number sending ");
			System.out.println("5. Phone line in use ");
			System.out.println("6. Automatic answer ");
		break;
		case 2: 
			System.out.println("1. Language ");
			System.out.println("2. Cell info display ");
			System.out.println("3. Welcome note ");
			System.out.println("4. Network selection ");
			System.out.println("5. Lights` ");
			System.out.println("6. Confirm SIM service actions ");
		break;
		case 3:
			System.out.println("1. PIN code request ");
			System.out.println("2. Call bearing service ");
			System.out.println("3. Fixed dialling ");
			System.out.println("4. Closed user group ");
			System.out.println("5. Phone security ");
			System.out.println("6. Change access codes ");
		break;
		case 4: 
			System.out.println("Restoring factory settings...");
		break;
		default :
			System.out.println("Wrong input !!!");
		}
break;

case 7:
	System.out.println("Opening Call divert___!");
	break;

case 8:
	System.out.println("Opening Games ['L']___!"); 
	break;

case 9:
	System.out.println("Opening Calculator___!");
	break;

case 10:
	System.out.println("Opening Reminders___!");
	break;

case 11:
	System.out.println("1.  Alarm clock");
	System.out.println("2.  Clock settings");
  	System.out.println("3.  Date settings");
	System.out.println("4.  Stopwatch");
	System.out.println("5.  Countdown timer");
	System.out.println("6.  Auto update of date and time");
break;

case 12:
	System.out.println("Opening Profiles___!");
	break;

case 13:
	System.out.println("Opening SIM services___!");
	break;

case 14:
	System.out.println("Shutting down___!");
	break;

default:
	System.out.println("Wrong input !!!");
	break;
}
}
}
}
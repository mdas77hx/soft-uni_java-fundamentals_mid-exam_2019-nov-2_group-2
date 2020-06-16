import java.util.*;

public class FriendListMaintenance 
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

		String firstLine = sc.nextLine();

		String[] friends = firstLine.split(", ");
		
		int blacklisted = 0;
		
		int lost = 0;
		
		String command = sc.nextLine();
		
		while( !command.equals("Report") ){
			String[] commandParts = command.split(" ");
			
			switch(commandParts[0]){
				
					case "Blacklist":
					int nameFound = 0;
					for(int i = 0; i < friends.length; i++){
							if(friends[i].equals(commandParts[1])){
									friends[i] = "Blacklisted";
									blacklisted++;
									System.out.println(commandParts[1] + " was blacklisted."); 
									nameFound = 1;
							}		 
					}
					if(nameFound == 0) System.out.println(commandParts[1] + " was not found.");
					break;
					
					case "Error":
					int index1 = Integer.parseInt(commandParts[1]);
					if( !friends[index1].equals("Blacklisted") && !friends[index1].equals("Lost") ){
						System.out.println(friends[index1] + " was lost due to an error.");
						friends[index1] = "Lost";
						lost++;
					}
					break;
					
					case "Change":
					int index2 = Integer.parseInt(commandParts[1]);
					if(index2 >= 0 && index2 < friends.length){
							System.out.println(friends[index2] + " changed his username to " + commandParts[2] + "." );
							friends[index2] = commandParts[2];
					}
					break;
			}
			if(sc.hasNextLine()) command = sc.nextLine();
		}
		System.out.println("Blacklisted names: " + blacklisted);
		System.out.println("Lost names: " + lost);
		System.out.println(String.join(" ", friends)); 
    }
}
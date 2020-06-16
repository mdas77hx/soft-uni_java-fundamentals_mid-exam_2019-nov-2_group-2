import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TanksCollector 
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

		String firstLine = sc.nextLine();
		
		List<String> tanks = new ArrayList<>( Arrays.asList( firstLine.split(", ") ) );

		
		
		while( sc.hasNextLine() ){
			
			String command = sc.nextLine();
			
			String[] commandParts = command.split(", ");
			
			switch(commandParts[0]){
				
					case "Add":
					if(!tanks.contains(commandParts[1])){
						tanks.add(commandParts[1]);
						System.out.println("Tank successfully bought");
					}else{
						System.out.println("Tank is already bought");
					}
					break;
					
					case "Remove":
					if(tanks.contains(commandParts[1])){
						tanks.remove(commandParts[1]);
						System.out.println("Tank successfully sold");			
					}else{
						System.out.println("Tank not found");
					}
					break;
					
					case "Remove At":
					int ind = Integer.parseInt(commandParts[1]);
					if(ind >= 0 && ind < tanks.size()){
						tanks.remove(ind);
						System.out.println("Tank successfully sold");		
					}else{
						System.out.println("Index out of range");
					}
					break;
					
					case "Insert":
					int ind1 = Integer.parseInt(commandParts[1]);
					if(ind1 >= 0 && ind1 < tanks.size()){
							if(!tanks.contains(commandParts[2])){
								tanks.add(ind1, commandParts[2]);
								System.out.println("Tank successfully bought"); 
							}else{
								System.out.println("Tank is already bought");
							}
					}else{
						System.out.println("Index out of range");
					}
					break;
			}
			 
		}
		String result = String.join(", ", tanks);
		System.out.println(result);
    }
}
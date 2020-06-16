import java.util.Scanner;

public class ExperienceGaining 
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

		double neededExp = Double.parseDouble(sc.nextLine());
		int battles = Integer.parseInt(sc.nextLine());
		double gainedExp = 0.0;
		int count = 0;
		
		for(int i = 1; i <= battles; i++){
			double exp = Double.parseDouble(sc.nextLine());

			count++;

			if(i % 3 == 0 && i % 5 != 0){
				exp += exp*0.15;
			}else if(i % 3 != 0 && i % 5 == 0){
				exp -= exp*0.1;
			}else if(i % 3 == 0 && i % 5 == 0){
				exp += exp*0.15;
				exp -= exp*0.1;
			}

			gainedExp += exp;
			
			if(gainedExp >= neededExp ){
				System.out.printf("Player successfully collected his needed experience for %d battles.%n", count);
				return;
			}
		}
		
		System.out.printf("Player was not able to collect the needed experience, %.2f more needed.%n", neededExp - gainedExp);
    }
}
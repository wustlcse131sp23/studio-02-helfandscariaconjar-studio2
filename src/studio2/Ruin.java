package studio2;

import java.util.Scanner;


public class Ruin {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter your start amount: ");
		int startAmountEntered = in.nextInt();
		int startAmount;
		System.out.println("Enter your win probability: (0-1)");
		double winChance = in.nextDouble();
		System.out.println("Enter your 'walk away' amount: ");
		int winLimit = in.nextInt();
		System.out.println("How many days do you want to play?: ");
		int totalSimulations = in.nextInt();
		String outcome;
		int gamesPlayed;
		int losses = 0;

		
		
		for (int daysPlayed = 1; daysPlayed <= totalSimulations; daysPlayed++) {
			startAmount = startAmountEntered;
			gamesPlayed = 0;
			while ((startAmount > 0) && (startAmount < winLimit)) {
				double gamble = Math.random();
				if (gamble <= winChance) {
					startAmount++;
				}
				else
					startAmount--;
				gamesPlayed++;
				
			}
			if (startAmount == winLimit) {
				outcome = "WIN"; }
					
			else {
				outcome = "LOSE";
				losses++;
			}
			System.out.println("Simulation " + daysPlayed + " : " + gamesPlayed + " " + outcome);

		}
		System.out.println("Losses: " + losses + " Simulations: " + totalSimulations);
		double ruinRate = (double) losses / totalSimulations;
		double alpha = (1-winChance) / winChance;
		double expectedRuin = (Math.pow(alpha, startAmountEntered) - Math.pow(alpha, winLimit) / (1-Math.pow(alpha, winLimit)));
		System.out.println("Ruin rate from simulation: " + ruinRate + " Expected Ruin Rate: " + expectedRuin);

		

		

	}

}

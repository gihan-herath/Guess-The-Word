package Game;

import java.util.Scanner;

public class GuessTheWord {
	
	private boolean play = true;
	private Words randomWord = new Words();
	private Scanner scanner = new Scanner(System.in);
	private int rounds = 10;
	private char lastRound;
	
	
	public void start() {
		
		do {
			
			showWord();
			getInput();
			checkInputs();
			
		}while(play);
	}
	
	void showWord () {
		System.out.println("You have " + rounds + " tries left.");
		System.out.println(randomWord);
	}
	
	void getInput() {
		
		System.out.println("Enter a letter to guess the word: ");
		String userGuess = scanner.nextLine();
		
		lastRound = userGuess.charAt(0);

		
	}
	
	void checkInputs() {
		
		boolean isGuessedRight = randomWord.guess(lastRound);
		
		if(isGuessedRight) {
			if (randomWord.isGuessedRight()) {
				System.out.println("Congrats, you Won!");
				System.out.println("The Word Is: " + randomWord);
				play = false;
			}
		}
		else {
			rounds --;
			
			if (rounds == 0) {
				System.out.println("Game Over!");
				play = false;
			}
		}
	}

	public void end() {
		scanner.close();
	}

}

import java.util.Scanner;

public class Main {

  private static Scanner input;
  private static String[] guesses;
  private static final int numOfGuesses = 6;
  private static String answer;
  private static final int maxWordLength = 5;

  private static final String ANSI_RESET = "\u001B[0m";
  private static final String ANSI_GREEN = "\u001B[32m";
  private static final String ANSI_YELLOW = "\u001B[33m";
  
  public static void main(String[] args) {
    gameIntro();
    gameSetup();
    initializeGuesses();
    displayGuesses();
    runGame();
  }

  public static void gameIntro() {
    
    input = new Scanner(System.in);
    System.out.println("Player 1 enters their word:");
    answer = input.nextLine();
    clearConsole();
    System.out.println("Player 2 begins guessing...");
  }

  public static void gameSetup() {
    guesses = new String[numOfGuesses];
  }

  public static void displayGuesses() {
    for(int i = 0; i < guesses.length; i++) {
      System.out.println(guesses[i]);
    }
  }

  public static void initializeGuesses() {
    for(int i = 0; i < guesses.length; i++) {
      guesses[i] = "-----";
        }
  }

  public static void clearConsole() {
    System.out.println("\033[H\033[2J");
  }

  public static void runGame() {
    for(int i = 0; i < numOfGuesses; i++) {
      String userGuess = validateGuess();
      clearConsole();

      StringBuilder colouredGuess = new StringBuilder(maxWordLength);
      for(int j = 0; j < userGuess.length(); j++) {
        char userGuessChar = userGuess.charAt(j);
        if(userGuessChar == answer.charAt(j)) {
          colouredGuess.append(ANSI_GREEN + userGuessChar + ANSI_RESET);
        } else {
          int index = answer.indexOf(userGuessChar);
          if(index >=0) {
             colouredGuess.append(ANSI_YELLOW +userGuessChar + ANSI_RESET);
          } else {
             colouredGuess.append(userGuessChar);
          }
        }
      }
      guesses[i] = colouredGuess.toString();
      displayGuesses();
      if (userGuess.equals(answer)) {
        System.out.println("You won! Press 'P' to play again");
        if(input.next().charAt(0) == 'P') {
          replayGame();
        }
        
      }

      if (!userGuess.equals(answer) && i == numOfGuesses-1) {
        System.out.println("You ran out of guesses! Press 'P' to play again");
        if(input.next().charAt(0) == 'P') {
          replayGame();
        }
      }
    }
  }

  public static void replayGame() {
    clearConsole();
    gameIntro();
    gameSetup();
    initializeGuesses();
    displayGuesses();
    runGame();
  }

  public static String validateGuess() {
    String userGuess = input.next();
    userGuess = userGuess.toLowerCase();
    while(userGuess.length() != 5 || hasNonLetters(userGuess)) {
      System.out.println("Please enter a word that is exactly 5 letters");
      userGuess = input.next();
    }
    return userGuess;
  }

  public static boolean hasNonLetters(String userGuess) {
    for(int i = 0; i < userGuess.length(); i++) {
      if(!Character.isLetter(userGuess.charAt(i))) {
        return true;
      }
    }
    return false;
  }
}
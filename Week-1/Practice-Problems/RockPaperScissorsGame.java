import java.util.Random;

public class RockPaperScissorsGame {
    public static String playRound(String playerMove, String computerMove) {
        if (playerMove.equals(computerMove)) {
            return "Draw";
        }
        if ((playerMove.equals("Rock") && computerMove.equals("Scissors")) ||
            (playerMove.equals("Paper") && computerMove.equals("Rock")) ||
            (playerMove.equals("Scissors") && computerMove.equals("Paper"))) {
            return "Player Wins";
        }
        return "Computer Wins";
    }

    public static void main(String[] args) {
        String[] options = {"Rock", "Paper", "Scissors"};
        Random random = new Random();
        
        int wins = 0;
        int losses = 0;
        int draws = 0;
        int rounds = 5;
        
        for (int i = 1; i <= rounds; i++) {
            String playerMove = options[random.nextInt(3)];
            String computerMove = options[random.nextInt(3)];
            
            String result = playRound(playerMove, computerMove);
            System.out.printf("Round %d - Player: %s, Computer: %s | Result: %s\n", i, playerMove, computerMove, result);
            
            if (result.equals("Player Wins")) {
                wins++;
            } else if (result.equals("Computer Wins")) {
                losses++;
            } else {
                draws++;
            }
        }
        
        double winPercentage = ((double) wins / rounds) * 100;
        System.out.printf("\nFinal Summary (after %d rounds)\n", rounds);
        System.out.printf("Wins: %d | Losses: %d | Draws: %d | Win %% = %.1f%%\n", wins, losses, draws, winPercentage);
    }
}

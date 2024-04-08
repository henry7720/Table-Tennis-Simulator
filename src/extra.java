// public class Player1 extends Player {

//     // -**Kernel Methods**:`int getScore()`, `void setScore(int changed)`, `int
//     // getRoundNumber()`, `int setRound(int new)` `int getTotalWins()`
//     // - **Secondary Methods**: `int addPoint()`, `int newRound()`, `void
//     // determineWinner(Player one, Player two)`, `void updateClientView(SimpleWriter
//     // file, int score, int roundNumber, int totalWins, Player one, Player two)`

//     private int score;
//     private int roundNumber;
//     private int wins;
//     // Basic convention, round number must 1 <= round <= 5 (best of 5)
//     // Score may never exceed eleven except when players are tied.
//     // winner is determined when one player has a score >= 11 and |playerOneScore -
//     // playerTwoScore| == 2

//     private final int getScore() {
//         return this.score;
//     }

//     private final void setScore(int changed) {
//         this.score = changed;
//     }

//     private final int getRoundNumber() {
//         return this.roundNumber;
//     }

//     private final void setRound(int changed) {
//         this.roundNumber = changed;
//     }

//     private final int getTotalWins() {
//         return this.wins;
//     }

//     // Secondary methods
//     private final void addPoint() {
//         this.setScore(this.getScore() + 1);
//     }

//     private final Player determineWinner(Player one, Player two) {
//         int oneScore = one.getScore();
//         int twoScore = two.getScore();

//         if (Math.abs(oneScore - twoScore) >= 2 && oneScore >= 11) {
//             return one;
//         } else {
//             return two;
//         }
//     }

//     public static void main(String[] args) {
//         // ...
//     }
// }
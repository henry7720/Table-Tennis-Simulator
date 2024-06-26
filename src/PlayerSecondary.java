import java.io.PrintWriter;
import java.util.Random;

/**
 * Layered implementations of secondary methods for {@code Player}.
 */
public abstract class PlayerSecondary implements Player {
    @Override
    public boolean equals(Object obj) {
        // Check if o is an alias of this
        if (obj == this) {
            return true;
        }

        // Check that o is not null
        if (obj == null) {
            return false;
        }

        // Ensure that o is a Player object
        if (!(obj instanceof Player)) {
            return false;
        }

        // Since it is Player object, formally cast
        Player p = (Player) obj;

        int[] thisArr = this.getScoreArr();
        int[] pArr = p.getScoreArr();

        for (int i = 0; i < thisArr.length; i++) {
            if (thisArr[i] != pArr[i]) {
                return false;
            }
        }

        // Check data rep value equality
        if (this.getRound() != p.getRound() || this.getWins() != p.getWins()
                || this.inProgress() != p.inProgress()) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        return this.getScore(this.getRound());
    }

    @Override
    public String toString() {
        return "Wins Thus Far: " + this.getWins() + ", Current Round Number: "
                + this.getRound() + ", Current Score: "
                + this.getScore(this.getRound() + 1);
    }

    @Override
    public void addPoint(int round) {
        this.setScore(round, this.getScore(round) + 1);
    }

    @Override
    public void nextRound() {
        this.setRound(this.getRound() + 1);
    }

    @Override
    public int determineWinner(Player two, int round) {
        int twoScore = two.getScore(round);
        int oneScore = this.getScore(round);

        if ((twoScore >= 11 || oneScore >= 11)
                && Math.abs(oneScore - twoScore) >= 2) {
            if (twoScore > oneScore) {
                two.setWins(two.getWins() + 1);
                return 1;
            }

            if (oneScore > twoScore) {
                this.setWins(this.getWins() + 1);
                return 0;
            }
        }

        return -1;

    }

    @Override
    public void simulateGame(Player two) {
        this.nextRound();
        two.nextRound();

        int round = Math.max(this.getRound(), two.getRound());

        while (this.determineWinner(two, round) < 0) {
            round = Math.max(this.getRound(), two.getRound());
            Random random = new Random();

            if (random.nextBoolean()) {
                this.addPoint(round);
            } else {
                two.addPoint(round);
            }
        }
    }

    @Override
    public void updateClientView(PrintWriter file, Player two) {
        file.println("<!DOCTYPE HTML>");
        file.println("<html lang=\"en\">");
        file.println("  <head>");
        file.println("    <title>Leaderboards</title>");
        file.println("    <style>");
        file.println("      body {");
        file.println("        font-family: 'Calibri', sans-serif;");
        file.println("      }");
        file.println("      table, th, td {");
        file.println("        border-collapse: collapse;");
        file.println("        border: 1px black solid;");
        file.println("        font-size: 4vh");
        file.println("      }");
        file.println("    </style>");
        file.println("  </head>");
        file.println("  <body>");
        file.println("    <h1>Leaderboards of Players</h1>");
        file.println("    <hr>");
        file.println("    <table>");
        file.println("      <tr>");
        file.println("        <th>Round Number</th>");
        file.println("        <th>Player One</th>");
        file.println("        <th>Player Two</th>");
        file.println("      </tr>");
        int thisRound = this.getRound();
        int twoRound = two.getRound();
        int number = Math.min(thisRound, twoRound);
        for (int i = 1; i <= number; i++) {
            file.println("      <tr>");
            file.println("        <td>" + i + "</td>");
            file.println("        <td>" + this.getScore(i) + "</td>");
            file.println("        <td>" + two.getScore(i) + "</td>");
            file.println("      </tr>");
        }
        file.println("      <tr>");
        file.println("        <th>Wins</th>");
        file.println("        <td>" + this.getWins() + "</td>");
        file.println("        <td>" + two.getWins() + "</td>");
        file.println("      </tr>");
        file.println("    </table>");
        file.println("  </body>");
        file.print("</html>");
    }
}

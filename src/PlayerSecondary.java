import components.simplewriter.SimpleWriter;

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

        // Check lengths
        if (this.getScore() != p.getScore()
                || this.getRoundNumber() != p.getRoundNumber()) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        return this.getScore() * this.getRoundNumber();
    }

    @Override
    public String toString() {
        return "Wins Thus Far: " + this.getWins() + ", Current Round Number: "
                + this.getRoundNumber() + ", Current Score: " + this.getScore();
    }

    @Override
    public void addPoint() {
        this.setScore(this.getScore() + 1);
    }

    @Override
    public void nextRound() {
        this.setRound(this.getRoundNumber() + 1);
    }

    @Override
    public int determineWinner(Player two) {
        int oneScore = this.getScore();
        int twoScore = two.getScore();

        if (Math.abs(oneScore - twoScore) >= 2) {

            if (oneScore >= 11) {
                return 0;
            }

            if (twoScore >= 11) {
                return 1;
            }
        }

        return -1;

    }

    @Override
    public void updateClientView(SimpleWriter file, Player two) {
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
        file.println("      }");
        file.println("    </style>");
        file.println("  </head>");
        file.println("  <body>");
        file.println("    <h1>Leaderboards of Players</h1>");
        file.println("    <hr>");
        file.println("    <table>");
        file.println("      <tr>");
        file.println("        <th></th>");
        file.println("        <th>Player One</th>");
        file.println("        <th>Player Two</th>");
        file.println("      </tr>");
        file.println("      <tr>");
        file.println("        <th>Wins</th>");
        file.println("        <td>" + this.getWins() + "</td>");
        file.println("        <td>" + two.getWins() + "</td>");
        file.println("      </tr>");
        file.println("      <tr>");
        file.println("        <th>Round Number(s)</th>");
        file.println("        <td>" + this.getRoundNumber() + "</td>");
        file.println("        <td>" + two.getRoundNumber() + "</td>");
        file.println("      </tr>");
        file.println("      <tr>");
        file.println("        <th>Last Known Score</th>");
        file.println("        <td>" + this.getScore() + "</td>");
        file.println("        <td>" + two.getScore() + "</td>");
        file.println("      </tr>");
        file.println("    </table>");
        file.println("  </body>");
        file.print("</html>");
    }
}

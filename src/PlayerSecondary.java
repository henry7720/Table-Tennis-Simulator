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

        // Ensure that o is a WaitingLine object
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
}

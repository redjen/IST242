package people;

/**
 * The interface Golfer represents a golf player.
 * 
 */
public interface Golfer {

   /**
    * Adds a handicap differential.
    * 
    * @param handicapDifferential the new handicap differential
    */
   public void addHandicapDifferential(double handicapDifferential);
   
   /**
    * Returns the player's current handicap index.
    * 
    * @return the handicap index, or -1 if there are too few differentials.
    */
   public double getHandicapIndex();
   
   /**
    * Calculates the player's course handicap.
    * 
    * @param slopeRating the slope rating for the course to be played
    * @return the course handicap
    */
   public int getCourseDifferential(int slopeRating);
}

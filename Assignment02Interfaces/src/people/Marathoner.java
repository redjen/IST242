package people;

/**
 *
 * The Marathoner interface represents a person who runs marathons.
 */
public interface Marathoner {
   
   /**
    * Gets the average of all recorded pace times in seconds.
    * 
    * @return average of all pace times
    */
   public int getAverageOverallPace();
   
   /**
    * Returns the best (fastest) recorded pace in seconds.
    * 
    * @return highest recorded pace
    */
   public int getBestPace();
   
   /**
    * Adds a new pace to the recorded times.
    * 
    * @param time the new pace in seconds.
    */
   public void addPace(int pace);
   
}

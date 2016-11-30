package people;

import java.util.List;
import java.util.TreeMap;

/**
 * The interface Athlete represents
 *
 */
public interface Athlete  {

   /**
    * Adds an award.
    *
    * @param year the year the award was earned
    * @param award the award name
    */
   public void addAthleticAward(int year, String award);

   public TreeMap<Integer, List<String>> getAwards();

   /**
    * Returns the athletic awards earned in the specified year.
    *
    * The awards are sorted by year then title
    *
    * @param year the year
    * @return the awards
    */
   public TreeMap<Integer, List<String>> getAwards(int year);

   /**
    * Returns the athletic awards earned in the specified time period.
    *
    * The awards are sorted by year then title
    *
    * @param startYear first year
    * @param endYear final year
    * @return the awards
    */
   public TreeMap<Integer, List<String>> getAwards(int startYear, int endYear);
   
   
}

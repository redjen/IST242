package gamehistory;

/**
 * The GameHistoryException class is a custom exception type used when reading and
 * writing game history files.
 * 
 */
public class GameHistoryException extends Exception {
   
   // this has to be static so that it can be used when calling the parent
   // class's constructor
   private final static String DEFAULT_MESSAGE = "Error encountered when parsing history file";

   public GameHistoryException(String message) {
      super(message);
   }

   public GameHistoryException() {
      super(DEFAULT_MESSAGE);
   }

}

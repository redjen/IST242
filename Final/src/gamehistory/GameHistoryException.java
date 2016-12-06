package gamehistory;

/**
 * The GameHistoryException class is a custom exception type used when reading and
 * writing game history files.
 * 
 */
public class GameHistoryException extends Exception {
 

   public GameHistoryException(String message) {
      super(message);
   }
   
   public GameHistoryException(String message, Throwable cause) {
      super(message, cause);
   }

   public GameHistoryException() {
      super();
   }
   

}

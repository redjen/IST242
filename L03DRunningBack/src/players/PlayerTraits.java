
package players;

/**
 *  Provides a list of traits that can be implemented in Player subclasses.
 * Traits can alter the Player's appearance and behavior, which must be
 * implemented in the class.
 */
public enum PlayerTraits {
    FAST          ("Increases the player's speed"),
    AGILE         ("Makes the player harder to tackle"),
    LUCKY         ("Gives the player a chance to evade a tackle"),
    PERCEPTIVE    ("Makes the player harder for opponents to follow"),
    NONE          ("No special traits.");

    private String helpText;
    
   private PlayerTraits(String helpText) {
      this.helpText = helpText;
   }
   
   public String getHelp() {
      return helpText;
   }
    
    
}

package people;

/**
 * The FootballPlayer interface defines the attributes and behavior of a 
 * football player.
 */
public interface FootballPlayer {

    public float getHeight();

    public void setHeight(float height);

    public float getWeight();

    public void setWeight(float weight);

    public String getExperience();

    public void setExperience(String experience);
    
    public String getPosition();

    public void setPosition(String position);
    
    public String getAllInfo();
}

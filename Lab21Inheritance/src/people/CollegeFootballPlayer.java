package people;

/**
 * The CollegeFootballPlayer class represents a college student who is also
 * a football player.
 * 
 */
public class CollegeFootballPlayer extends Student implements FootballPlayer {

    private float height;
    private float weight;
    private String experience;
    private String position;

    public CollegeFootballPlayer(String informedFirstName, String informedLastName, int informedAge, String informedMajor,
            float height, float weight, String experience, String position) {

        super(informedFirstName, informedLastName, informedAge, informedMajor);
        setHeight(height);
        setWeight(weight);
        setExperience(experience);
        setPosition(position);
    }

    public CollegeFootballPlayer() {
        this("Unknown", "Unknown", 0, "Unknown", 0.0f, 0.0f, "", "");
    }

    /**
     * Returns the player's height.
     *
     * @return the player's height.
     */
    @Override
    public float getHeight() {
        return this.height;
    }

    /**
     * Sets the player's height.
     *
     * @param height the new height
     * @throws IllegalArgumentException if the height is less than 0.
     */
    @Override
    public void setHeight(float height) {
        if (height < 0) {
            throw new IllegalArgumentException("Height must be greater than 0.");
        }
        this.height = height;
    }

    /**
     * Gets the player's weight.
     *
     * @return the player's weight.
     */
    @Override
    public float getWeight() {
        return this.weight;
    }

    /**
     * Sets the player's weight.
     *
     * @param the new weight
     * @throws IllegalArgumentException if the weight is less than 0.
     */
    @Override
    public void setWeight(float weight) {
        if (weight < 0) {
            throw new IllegalArgumentException("Weight must be greater than 0.");
        }
        this.weight = weight;
    }

    /**
     * Gets the player's experience level.
     * 
     * @return the player's experience level.
     */
    @Override
    public String getExperience() {
        return experience;
    }

    /**
     * Sets the player's experience level.
     * 
     * @param the new experience level
     */
    @Override
    public void setExperience(String experience) {
        this.experience = experience;
    }

    /**
     * Gets the player's position.
     * 
     * @return the player's position.
     */
    @Override
    public String getPosition() {
        return position;
    }

    /**
     * Sets the player's position.
     * 
     * @param position the new position.
     */
    @Override
    public void setPosition(String position) {
        this.position = position;
    }

    /**
     * Provides a formatted string containing all of the player's information.
     * @return 
     */
    @Override
    public String getAllInfo() {
        return getFirstName() + " " + getLastName() + " " + getAge() + " " + " " + getStatus() + " " + getMajor() + " " + getHeight() + " " + getWeight() + " " + getExperience() + " " + getPosition();
    }

}

/**
 * The Student class represents a college student with associated attributes
 * and behavior.
 * 
 * This class was provided in lesson 2.
 */
package people;

public class Student extends Person {
    	private String status;
	private String major;
	Student(String informedFirstName, String informedLastName, int informedAge, String informedMajor)
	{
		super(informedFirstName, informedLastName, informedAge);
		if (getAge() <= 25) status = "Traditional";
		else status = "Non-Traditional";
                major = informedMajor;
	}
	
        public String getStatus()
	{
		return this.status;
	}
        public void setStatus(String status) 
        {
            this.status = status;
        }
        
	public String getMajor()
	{
		return this.major;
	}
        public void setMajor(String major) 
        {
            this.major = major;
        }
        
	public String getAllInfo()
	{
		return getFirstName() + " " + getLastName() + " " + getAge() + " " + getMajor() + " " + getStatus() + " " + getMajor();
	}
}

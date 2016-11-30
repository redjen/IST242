package people;

class Student extends Person
{  
	private String status;
	private String major;
	Student(String informedFirstName, String informedLastName, int informedAge, String informedMajor)
	{
		super(informedFirstName, informedLastName, informedAge);
		if (getAge() <= 25) status = "Traditional";
		else status = "Non-Traditional";
                major = informedMajor;
	}
	String getStatus()
	{
		return this.status;
	}
        public void setStatus(String status) 
        {
            this.status = status;
        }
	String getMajor()
	{
		return this.major;
	}
        public void setMajor(String major) 
        {
            this.major = major;
        }
	String getAllInfo()
	{
		return getFirstName() + " " + getLastName() + " " + getAge() + " " + getMajor() + " " + getStatus() + " " + getMajor();
	}
}

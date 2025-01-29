package Task1;

/**
 * Competitor class to hold the details for every competitor
 */
public class ARCompetitor {
	private int compID;
	private int age;
	private String country;
	private String level;
	public ARCompetitor() {
		
	}
	/**
	 * setter method for Competitor ID
	 * @param id
	 */
	public void setcompID(int id) {
		compID=id;
	}
	/**
	 * setter method for Competitor Age
	 * @param age
	 */
	public void setage(int age) {
		this.age=age;
	}
	/**
	 * setter method for Competitor country
	 * @param country
	 */
	public void setcountry(String country) {
		this.country=country;
	}
	/**
	 * setter method for Competitor level
	 * @param level
	 */
	public void setlevel(String level) {
		this.level=level;
	}
	/**
	 * getter method for Competitor ID
	 * @return Competitor ID
	 */
	public int getcompID() {
		return compID;
	}
	/**
	 * getter method for Competitor age
	 * @return Competitor age
	 */
	public int getage() {
		return age;
	}
	/**
	 * getter method for Competitor country
	 * @return Competitor country
	 */
	public String getcountry() {
		return country;
	}
	/**
	 * getter method for Competitor level
	 * @return Competitor level
	 */
	public String getlevel() {
		return level;
	}
}

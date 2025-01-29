package Task1;

public class ARCompetitor {
	private int compID;
	private Name name;
	private int age;
	private String country;
	private String level;
	public ARCompetitor(int id,Name name,int age,String country,String level) {
		compID=id;
		this.name=name;
		this.age=age;
		this.country=country;
		this.level=level;
	}
	public void setcompID(int id) {
		compID=id;
	}
	public void setage(int age) {
		this.age=age;
	}
	public void setcountry(String country) {
		this.country=country;
	}
	public void setlevel(String level) {
		this.level=level;
	}
	public int getcompID() {
		return compID;
	}
	public int getage() {
		return age;
	}
	public String getcountry() {
		return country;
	}
	public String getlevel() {
		return level;
	}
	public double getOverallScore() {
		return 5;
	}
	public String getFullDetails() {
		return
	}
	public String getShortDetails() {
		return "CN "+compID+"("+name.getInitials()+") has overall score 5";
	}
    @Override
    public String toString() {
        return getFullDetails();
    }
}

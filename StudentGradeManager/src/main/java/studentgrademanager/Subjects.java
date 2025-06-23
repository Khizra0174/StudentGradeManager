package studentgrademanager;
import java.util.*;
public class Subjects {

	private String name;
	private int ID;
	private double totalMarks;
	private double obtainMarks;
	private double percentage;
	 public Subjects(int id,String name,double totalMarks,double obtainMarks) {
		 this.ID= id;
		 this.name= name;
		 this.totalMarks= totalMarks;
		 this.obtainMarks= obtainMarks;
		 this.percentage = 0.0;
	 }
	public String getName() {
		return name;
	}
	public int getID() {
		return ID;

	}
	public double getTotalMarks() {
		return totalMarks;

	}
	public double getObtainMarks() {
		return obtainMarks;

	}
	public double getPercentage() {
		return percentage;
	}

	public void setName(String name)
	{
		this.name = name;
	}
	public void setID(int ID)
	{
		this.ID = ID;
	}
	public void setTotalMarks(double tMarks)
	{
		totalMarks = tMarks;
	}
	public void setObtainMarks(double OMarks)
	{
		obtainMarks = OMarks;
	}
	public void calculatePercentage()
	{
		if(totalMarks > 0 && obtainMarks >= 0)
		{
			percentage = (obtainMarks*100)/totalMarks;
		}
		else
		{
			throw new ArithmeticException("Invalid! The Total is can not be zero");
		}
	}
	public void updateMarks(double newObtained, double newTotal) {
        if (newTotal <= 0) {
			throw new IllegalArgumentException("Total marks must be greater than zero.");
		}
        if (newObtained < 0 || newObtained > newTotal){
			throw new IllegalArgumentException("Obtained marks must be between 0 and total marks.");
		}

        this.obtainMarks = newObtained;
        this.totalMarks = newTotal;
    }
	public void updateName(String name) {
		this.name = name;
	}

	public String displaySubjectDetails() {
		String message = "";
		if (this != null) {
			 message = "Submitted Successfully!\n\n" +
					"Subject Name: " + this.getName() + "\n" +
					"Subject ID: " + this.getID();

			// Only include marks if both are entered
			if (this.getTotalMarks() > 0) {
				try {
					this.calculatePercentage();  // Safe to calculate
					message += "\nObtained Marks: " + this.getObtainMarks() +
							"\nTotal Marks: " + this.getTotalMarks() +
							"\nPercentage: " + String.format("%.2f", this.getPercentage()) + "%";
				} catch (ArithmeticException e) {
					message += "\n(Note: Percentage could not be calculated - " + e.getMessage() + ")";
				}
			}

		}
		return message;
	}
	public static boolean deleteSubject(List<Subjects> subjectList, String query) {
		Subjects toRemove = null;

		try {
			int id = Integer.parseInt(query);
			for (Subjects s : subjectList) {
				if (s.getID() == id) {
					toRemove = s;
					break;
				}
			}
		} catch (NumberFormatException e) {
			// Not an ID, so treat as name
			for (Subjects s : subjectList) {
				if (s.getName().equalsIgnoreCase(query)) {
					toRemove = s;
					break;
				}
			}
		}

		if (toRemove != null) {
			subjectList.remove(toRemove);
			return true;
		}

		return false;
	}

}

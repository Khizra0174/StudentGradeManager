package studentgrademanager;

import java.util.ArrayList;

public class StudentController {
	private ArrayList<Students> studentsList = new ArrayList<Students>();
	
	public void addStudent(String id,String name) {
		studentsList.add(new Students(id,name));
	}
	public void removeStudent(String id) {
		 studentsList.removeIf(student -> student.getId().equals(id));
	}
	public boolean findStudent(String id) {
		boolean isFound = false;
		for(Students student: studentsList) {
			if(student.getId().equals(id)) {
				isFound = true;
				break;
			}
		}
		return isFound;
	}
	public void updateStudentMarks(String id) {
		
	}
	public ArrayList<Students> getAllStudents() {
	    return studentsList;
	}
	public Students getStudentById(String id) {
        for (Students student : studentsList) {
            if (student.getId().equals(id)) {
                return student;
            }
        }
        return null;
    }
}

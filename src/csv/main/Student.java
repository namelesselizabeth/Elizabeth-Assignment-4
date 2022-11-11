package csv.main;

public class Student {

	private Integer studentID;
	private String studentName;
	private String course;
	private Integer grade;
	
	public Student() {
		
	}
	
	public Student(String[] values) {
		
		this.studentID = Integer.parseInt(values[0]);
		this.studentName = values[1];
		this.course = values[2];
		this.grade = Integer.parseInt(values[3]);
	}
	

	public Integer getStudentID() {
		return studentID;
	}
	
	public String getStudentName() {
		return studentName;
	}
	
	public String getCourse() {
		return course;
	}
	
	public Integer getGrade() {
		return grade;
	}
	
}

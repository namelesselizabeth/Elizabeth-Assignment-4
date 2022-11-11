package csv.main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;

public class CSVApplication {
	
private Student[] students = new Student[100];

	public static void main(String[] args) throws IOException {

		CSVApplication app = new CSVApplication();
		app.createStudentArray();

		BufferedWriter writer = null;

		for (Student student : app.students) {
			
			app.sortArrayByGrade();
				
				if (student.getCourse().contains("APMTH")) {
					try (
					BufferedWriter writer1 = new BufferedWriter(new FileWriter("src\\csv\\files\\course1.csv")) ) {
			
					writer1.write("Student ID" + "," + "Student Name" + "," + "Course" + "," + "Grade\n");
					writer1.write(student.getStudentID() + "," + student.getStudentName() + "," + student.getCourse()
								+ "," + student.getGrade() +"\n");
					}
				}
				
				else if (student.getCourse().contains("COMPSCI")) {
					
					try(
					BufferedWriter writer1 = new BufferedWriter(new FileWriter("src\\csv\\files\\course2.csv")) ) {
					writer1.write("Student ID" + "," + "Student Name" + "," + "Course" + "," + "Grade\n");
					writer1.write(student.getStudentID() + "," + student.getStudentName() + "," + student.getCourse()
							+ "," + student.getGrade() +"\n");
					}
				}
				
				else if (student.getCourse().contains("STAT")) {
					
					try (
					BufferedWriter writer1 = new BufferedWriter(new FileWriter("src\\csv\\files\\course3.csv")) ) {
					writer1.write("Student ID" + "," + "Student Name" + "," + "Course" + "," + "Grade\n");
					writer1.write(student.getStudentID() + "," + student.getStudentName() + "," + student.getCourse()
							+ "," + student.getGrade() +"\n");
					}
				}
			
			}

		}
	

	/**
	 * Create Student Array.  HeaderLine skips first line of file
	 * @throws IOException
	 */
	public void createStudentArray() throws IOException {
		
		BufferedReader reader = null;
		
		try {
			reader = new BufferedReader(new FileReader("src\\\\csv\\\\main\\\\student-master-list.csv"));
			String line;
			int i = 0;
			@SuppressWarnings("unused")
			String headerLine = reader.readLine();
			while ((line = reader.readLine()) != null) {
				students[i] = new Student(line.split(","));
				i++;
			}

		} finally {
			reader.close();
		}
	}
	
	public void sortArrayByGrade() {
		Arrays.sort(students, new Comparator<Student>() {
			
			@Override
			public int compare(Student o1, Student o2) {
				
				return o1.getGrade().compareTo(o2.getGrade());
			}
		});
	}
}

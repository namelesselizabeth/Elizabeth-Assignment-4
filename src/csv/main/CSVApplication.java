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
		app.sortArrayByGrade();
		
		BufferedWriter writer = null;
		
		writer = new BufferedWriter(new FileWriter("src\\csv\\files\\course1.csv"));
		writer.write("Student ID" + "," + "Student Name" + "," + "Course" + "," + "Grade\n");
			for (Student student : app.students) {
				if (student.getCourse().contains("APMTH")) {
		
					writer.write(student.getStudentID() + "," + student.getStudentName() + "," + student.getCourse()
								+ "," + student.getGrade() +"\n");
					
				}
			
			}
			
		if(writer != null) writer.close();
			
		writer = null;
		writer = new BufferedWriter(new FileWriter("src\\csv\\files\\course2.csv"));
		writer.write("Student ID" + "," + "Student Name" + "," + "Course" + "," + "Grade\n");
			for (Student student : app.students) {
				if (student.getCourse().contains("COMPSCI")) {

					writer.write(student.getStudentID() + "," + student.getStudentName() + "," + student.getCourse()
							+ "," + student.getGrade() +"\n");
					}
			}
		
		if(writer != null) writer.close();
		
		writer = null;
		writer = new BufferedWriter(new FileWriter("src\\csv\\files\\course3.csv"));
		writer.write("Student ID" + "," + "Student Name" + "," + "Course" + "," + "Grade\n");
			for (Student student : app.students) {
				if (student.getCourse().contains("STAT")) {
					
					writer.write(student.getStudentID() + "," + student.getStudentName() + "," + student.getCourse()
							+ "," + student.getGrade() +"\n");
				}
				
		
		}
		
		if(writer != null) writer.close();
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
				
				return o2.getGrade().compareTo(o1.getGrade());
			}
		});
	}
}

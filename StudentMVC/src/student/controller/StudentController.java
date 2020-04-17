package student.controller;

import student.model.vo.Student;

public class StudentController {

	private Student [] stds;
	private int index;
	
	public StudentController() {
		stds = new Student[10];
		index = 0;
	}
	
	public void insertStudent(Student student) {
		stds[index] = student;
		index++;
	}
	
	public Student [] selectAll() {
		return stds;
	}
	
	public Student selectOne(int searchNum) {
		for ( int i = 0; i < stds.length; i++ ) {
			int storedNum = stds[i].getClassNumber();
			if ( searchNum == storedNum ) {
				return stds[i];
			}
		}
		return null;
	}
	
	public void deleteStudent(int removeNum) {
		for ( int i = 0 ; i < stds.length ; i++ ) {
			int storedNumber = stds[i].getClassNumber();
			if ( removeNum == storedNumber ) {
				stds[i] = null;
				break;
			}
			
		}
	}
}

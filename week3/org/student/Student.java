package org.student;

import org.department.Department;

public class Student extends Department {
	/*
	 * Prints the name of the student
	 */
	public void studentName() {
		System.out.println("Student Name : John");
	}

	/*
	 * Prints the department of the student
	 */
	public void studentDept() {
		System.out.println("Student Department : Information Technology");
	}

	/*
	 * Prints the Id number of the student
	 */
	public void studentId() {
		System.out.println("Student ID : 5643");
	}

	public static void main(String[] args) {
		Student student = new Student();
		student.collegeName();
		student.collegeCode();
		student.collegeRank();
		student.deptName();
		student.studentName();
		student.studentId();
		student.studentDept();
	}

}

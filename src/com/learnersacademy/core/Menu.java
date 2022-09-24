package com.learnersacademy.core;

import java.sql.SQLException;
import java.util.Scanner;

public class Menu {

	public Menu() throws ClassNotFoundException, SQLException {
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("1. Class List");
			System.out.println("2. Teacher List");
			System.out.println("3. Subject List");
			System.out.println("4. Student List");
			System.out.println("5. Assigned List");
			System.out.println("6. Class Report");
			System.out.println("7. Exit");
			System.out.print("Enter option: ");
			String opt = null;
			if(sc.hasNext()) {
			   opt = sc.nextLine();
			}else {
				System.out.println("Thank you..!");
				System.exit(0);
			}
			switch(opt) {
			case "1":
				ClassList cL = new ClassList();
				cL.getClassList();
				break;
			case "2":
				TeacherList tL = new TeacherList();
				tL.getTeacherList();
				break;
			case "3":
				SubjectList subL = new SubjectList();
				subL.getSubjectList();
				break;
			case "4":
				StudentList studL = new StudentList();
				studL.getStudentList();
				break;
			case "5":
				AssignedList assignL = new AssignedList();
				assignL.getAssignList();
				break;
			case "6":
				ClassReport cR = new ClassReport();
				cR.showReport();
				break;
			case "7":
					System.out.println("Thank You ...");
				  System.exit(0);
			 default:
				 System.out.println("Invalid Input !. \n Try again.");
			}			
		}while(true);
	}

}

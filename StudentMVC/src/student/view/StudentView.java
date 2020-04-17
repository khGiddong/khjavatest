package student.view;

import java.util.Scanner;

import student.controller.StudentController;
import student.model.vo.Student;

public class StudentView {

	private Scanner sc;
	private StudentController stdCtrl; // 초기화 잊지말자!
	
	public StudentView() {
		sc = new Scanner(System.in);
		stdCtrl = new StudentController();
	}
	
	public void mainMenu() {
		int choice = 0;
		while(true) {
			System.out.println("======== 회원관리 프로그램 =======");
			System.out.println("1. 학생 전체 정보 출력");
			System.out.println("2. 학생 정보 조회(학번)");
			System.out.println("3. 학생 정보 입력");
			System.out.println("4. 학생 정보 변경");
			System.out.println("5. 학생 삭제");
			System.out.println("0. 프로그램 종료");
			System.out.print("메뉴 선택 : ");
			choice = sc.nextInt();
			
			switch(choice) {
			case 1 : 
				Student [] stds = stdCtrl.selectAll();
				if ( stds != null ) {
					for ( int i = 0 ; i < stds.length; i++ ) {
						if ( stds[i] != null ) {
							System.out.println("이름 : " + stds[i].getName()
									+ " 학번 : " + stds[i].getClassNumber()
									+ " 나이 : " + stds[i].getAge()
									+ " 주소 : " + stds[i].getAddress()
									+ " 학점 : " + stds[i].getGrade());
							break;
						}
					}
				}
				
				break;
			case 2 : 
				System.out.print("조회할 학번 입력 : ");
				int searchNum = sc.nextInt();
				Student std = stdCtrl.selectOne(searchNum);
				if ( std != null) {
					System.out.println("이름 : " + std.getName() 
							+ " 학번 : " + std.getClassNumber()
							+ " 나이 : " + std.getAge()
							+ " 주소 : " + std.getAddress()
							+ " 학점 : " + std.getGrade());
				}
				break;
			case 3 : 
				Student stdOne = new Student();
				
				System.out.print("#학번 : ");
				stdOne.setClassNumber(sc.nextInt());
				
				System.out.print("#이름 : ");
				stdOne.setName(sc.next());
				
				System.out.print("#나이 : ");
				stdOne.setAge(sc.nextInt());
				sc.nextLine();
				System.out.print("#주소 : ");
				stdOne.setAddress(sc.nextLine());
				
				System.out.print("#학점 : ");
				stdOne.setGrade(sc.nextDouble());
				
				stdCtrl.insertStudent(stdOne);
				break;
			case 4 : break;
			case 5 : 
				System.out.println("=== 학생 정보 삭제 ===");
				System.out.print("삭제할 학번 입력 : ");
				int removeNum = sc.nextInt();
				stdCtrl.deleteStudent(removeNum);
				break;
			case 0 : System.out.println("프로그램을 종료합니다.");
					return;
			}
		}
	}
}

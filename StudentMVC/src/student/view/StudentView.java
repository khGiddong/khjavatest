package student.view;

import java.util.Scanner;

import student.controller.StudentController;
import student.model.vo.Student;

public class StudentView {

	private Scanner sc;
	private StudentController stdCtrl; // �ʱ�ȭ ��������!
	
	public StudentView() {
		sc = new Scanner(System.in);
		stdCtrl = new StudentController();
	}
	
	public void mainMenu() {
		int choice = 0;
		while(true) {
			System.out.println("======== ȸ������ ���α׷� =======");
			System.out.println("1. �л� ��ü ���� ���");
			System.out.println("2. �л� ���� ��ȸ(�й�)");
			System.out.println("3. �л� ���� �Է�");
			System.out.println("4. �л� ���� ����");
			System.out.println("5. �л� ����");
			System.out.println("0. ���α׷� ����");
			System.out.print("�޴� ���� : ");
			choice = sc.nextInt();
			
			switch(choice) {
			case 1 : 
				Student [] stds = stdCtrl.selectAll();
				if ( stds != null ) {
					for ( int i = 0 ; i < stds.length; i++ ) {
						if ( stds[i] != null ) {
							System.out.println("�̸� : " + stds[i].getName()
									+ " �й� : " + stds[i].getClassNumber()
									+ " ���� : " + stds[i].getAge()
									+ " �ּ� : " + stds[i].getAddress()
									+ " ���� : " + stds[i].getGrade());
							break;
						}
					}
				}
				
				break;
			case 2 : 
				System.out.print("��ȸ�� �й� �Է� : ");
				int searchNum = sc.nextInt();
				Student std = stdCtrl.selectOne(searchNum);
				if ( std != null) {
					System.out.println("�̸� : " + std.getName() 
							+ " �й� : " + std.getClassNumber()
							+ " ���� : " + std.getAge()
							+ " �ּ� : " + std.getAddress()
							+ " ���� : " + std.getGrade());
				}
				break;
			case 3 : 
				Student stdOne = new Student();
				
				System.out.print("#�й� : ");
				stdOne.setClassNumber(sc.nextInt());
				
				System.out.print("#�̸� : ");
				stdOne.setName(sc.next());
				
				System.out.print("#���� : ");
				stdOne.setAge(sc.nextInt());
				sc.nextLine();
				System.out.print("#�ּ� : ");
				stdOne.setAddress(sc.nextLine());
				
				System.out.print("#���� : ");
				stdOne.setGrade(sc.nextDouble());
				
				stdCtrl.insertStudent(stdOne);
				break;
			case 4 : break;
			case 5 : 
				System.out.println("=== �л� ���� ���� ===");
				System.out.print("������ �й� �Է� : ");
				int removeNum = sc.nextInt();
				stdCtrl.deleteStudent(removeNum);
				break;
			case 0 : System.out.println("���α׷��� �����մϴ�.");
					return;
			}
		}
	}
}

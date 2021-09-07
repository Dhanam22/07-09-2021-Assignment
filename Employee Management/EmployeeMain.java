package Employee;

import java.util.List;
import java.util.Scanner;

import Employee.Employee;
import Employee.EmployeeDAO;

public class EmployeeMain {

	public static void main(String[] args) {
		Employee e=new Employee();
		EmployeeDAO eda=new EmployeeDAO();
		int ch=0;
		Scanner sc=new Scanner(System.in);
		do
		{
			System.out.println("Welcome to Employee Management");
			System.out.println("Choose From the Following Option");
			System.out.println("1. Add Employee");
			System.out.println("2. Get Employee");
			System.out.println("3. All Employee Details");
			System.out.println("4. Delete Employee");
			System.out.println("5. Update Employee");
			System.out.println("6. Exit");
		    ch=sc.nextInt();
		switch(ch)
		{
		case 1:
			Employee e1=new Employee();
			System.out.println("Enter Id");
			e1.setId(sc.nextInt());
			System.out.println("Enter Name");
			e1.setName(sc.next());
			System.out.println("Enter Dateofbirth");
			e1.setDateofbirth(sc.next());
			System.out.println("Enter Salary");
			e1.setSalary(sc.nextInt());
			System.out.println("Enter Designation");
			e1.setDesignation(sc.next());
			System.out.println("Enter Start date");
			e1.setStartdate(sc.next());
			System.out.println("Enter End date");
			e1.setEnddate(sc.next());
			eda.insertEmployee(e1);
			System.out.println("Data Inserted Successfully");
			break;
		case 2:
			System.out.println("Enter Id");
			int id=sc.nextInt();
			
			e=eda.selectEmployee(id);
			if(e!=null)
			{
			System.out.println(e.getId()+" | "+e.getName()+" | "+e.getDateofbirth()+" | "+e.getSalary()+" | "+e.getDesignation()+" | "+e.getStartdate()+" | "+e.getEnddate());
			}
			else
			{
				System.out.println("Id Doesn't Exists");
			}
			break;
		case 3:
			List<Employee> e2=eda.selectAllEmployee();
			for(Employee emp:e2)
			{
				System.out.println(emp);
			}
			break;
		case 4 :
		{
			System.out.println("Enter Id");
			int id1=sc.nextInt();
			boolean res=eda.deleteEmployee(id1);
			if(res)
			{
				System.out.println("Deleted Succesfully");
			}
			else
			{
				System.out.println("The ID is not Present");
			}
			break;
		}
		case 5 :
			boolean res1=false;
			Employee e3=new Employee();
			System.out.println("Enter Id");
			e3.setId(sc.nextInt());
			System.out.println("Enter Name");
			e3.setName(sc.next());
			System.out.println("Enter Dateofbirth");
			e3.setDateofbirth(sc.next());
			System.out.println("Enter Salary");
			e3.setSalary(sc.nextInt());
			System.out.println("Enter Designation");
			e3.setDesignation(sc.next());
			System.out.println("Enter Start date");
			e3.setStartdate(sc.next());
			System.out.println("Enter End date");
			e3.setEnddate(sc.next());
			res1=eda.updateEmployee(e3);
			if(res1)
			{
				System.out.println("Updated Succesfully");
			}
			else
			{
				System.out.println("UserName Doesn't Exist");
			}
			break;
			
			case 6:
				System.out.println("Goodbyee");
				break;
			default:
				System.out.println("Enter a Correct Option");
				break;
		}
		
		}while(ch!=6);
			
		}
}
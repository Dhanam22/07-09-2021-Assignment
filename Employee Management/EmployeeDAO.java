package Employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Employee.Employee;

public class EmployeeDAO implements EmployeeImplement{

	@Override
	public Connection getConnection() {
		Connection con=null;
			try {
				Class.forName(driverclass);
				con=DriverManager.getConnection(jdbcurl,username,password);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return con;
	}

	@Override
	public void insertEmployee(Employee e) {
		// TODO Auto-generated method stub
		
		String query="insert into Employee values(?,?,?,?,?,?,?)";
		try(Connection con=getConnection())
		{
			PreparedStatement ps=con.prepareStatement(query);
			ps.setInt(1, e.getId());
			ps.setString(2, e.getName());
			ps.setString(3, e.getDateofbirth());
			ps.setInt(4, e.getSalary());
			ps.setString(5, e.getDesignation());
			ps.setString(6, e.getStartdate());
			ps.setString(7, e.getEnddate());
			ps.executeUpdate();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
				
		
	}

	@Override
	public Employee selectEmployee(int id) {
		// TODO Auto-generated method stub
		Employee e=null;
		String query="select * from Employee where id=?";
		try(Connection con=getConnection())
		{
			
			PreparedStatement ps=con.prepareStatement(query);
            ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				e=new Employee();
				e.setId(id);
				e.setName(rs.getString(2));
				e.setDateofbirth(rs.getString(3));
				e.setSalary(rs.getInt(4));
				e.setDesignation(rs.getString(5));
				e.setStartdate(rs.getString(6));
				e.setEnddate(rs.getString(7));
			}
		} catch (NullPointerException | SQLException e1) {
			e1.printStackTrace();
		}
		return e;
	}

	@Override
	public List<Employee> selectAllEmployee() {
		 List<Employee> list=new ArrayList();
		 String query="select * from employee";
		 try(Connection con=getConnection()){
			 PreparedStatement ps=con.prepareStatement(query);
			 ResultSet rs=ps.executeQuery();
			 while(rs.next())
				{
					Employee e=new Employee();
					e.setId(rs.getInt(1));
					e.setName(rs.getString(2));
					e.setDateofbirth(rs.getString(3));
					e.setSalary(rs.getInt(4));
					e.setDesignation(rs.getString(5));
					e.setStartdate(rs.getString(6));
					e.setEnddate(rs.getString(7));
					list.add(e);
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return list;
	}


@Override
	public boolean deleteEmployee(int id) {
		// TODO Auto-generated method stub
		boolean Result=false;
		String query="delete from Employee where id=?";
		try(Connection con=getConnection())
		{
			
			PreparedStatement ps=con.prepareStatement(query);
			ps.setInt(1, id);
			Result = ps.executeUpdate()>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Result;
	}

@Override
public boolean updateEmployee(Employee e) {
	// TODO Auto-generated method stub
	boolean Result=false;
	String query="update employee set name=?,dateofbirth=?,salary=?,designation=?,startdate=?,enddate=?  where id=?" ;
	try(Connection con=getConnection())
	{
		
		PreparedStatement ps=con.prepareStatement(query);
		ps.setString(1, e.getName());
		ps.setString(2,e.getDateofbirth());
		ps.setInt(3, e.getSalary());
		ps.setString(4, e.getDesignation());
		ps.setString(5, e.getStartdate());
		ps.setString(6, e.getEnddate());
		ps.setInt(7, e.getId());
		
		Result = ps.executeUpdate()>0;
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	return Result;
}


}
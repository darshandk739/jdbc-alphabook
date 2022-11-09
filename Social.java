package jdbc_alphabook;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;




public class Social {
	private User user;
	
	
public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


public void signUp(User user) throws Exception
{
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/sys","root","Dk@731999");
	PreparedStatement preparedstatement =connection.prepareStatement("Insert into social values(?,?,?,?,?,?,?,?)");
	preparedstatement.setString(1,user.getFirst_name());
	preparedstatement.setString(2, user.getLast_name());
	preparedstatement.setLong(3, user.getContact_number());
	preparedstatement.setString(4,user.getGender());
	preparedstatement.setString(5, user.getYear_of_birth());
	preparedstatement.setString(6,user.getMail_id());
	preparedstatement.setString(7, user.getPassword());
	preparedstatement.setString(8, user.getStatus());

	
	preparedstatement.executeUpdate();
	connection.close();
}
public void login(String mail_id,String password,User user)throws Exception
{
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/sys","root","Dk@731999");
	PreparedStatement preparedstatement =connection.prepareStatement("select * from social where mail_id=? and password=?");
	preparedstatement.setString(1,user.getMail_id());
	preparedstatement.setString(2,user.getPassword());
	
	ResultSet resultset=preparedstatement.executeQuery();
	String mail_id1="";
	String password1="";
	while (resultset.next())
	{
		
		resultset.getString(1);
		resultset.getString(2);
		mail_id1=resultset.getString(6);
		password1=resultset.getString(7);
	}
	if(mail_id1.equals(mail_id)&& (password1.equals(password)))
	{
		System.out.println("Login operation successfull");
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter 1 to add status");
		System.out.println("Enter 2 to go back to home page");
		int choice1=scanner.nextInt();
		switch(choice1)
		{
		case 1:
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection1=DriverManager.getConnection("jdbc:mysql://localhost:3306/sys","root","Dk@731999");
			PreparedStatement preparedstatement1 =connection.prepareStatement("Update social set status=?,datetime=? where mail_id=?");
			preparedstatement1.setString(1,user.getStatus());
			preparedstatement1.setString(2,user.getDatetime());
			preparedstatement1.setString(3,user.getMail_id());
			preparedstatement1.executeUpdate();
			connection.close();
		}
		break;
		case 2:
		{
			System.out.println("Status not added ");
		}
		}
		
 	}
	else
	{
		System.out.println("Invalid MailId or Password");
	}
	
	
}
}

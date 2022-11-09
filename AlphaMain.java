package jdbc_alphabook;
import java.sql.Date;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
public class AlphaMain {

	public static void main(String[] args) throws Exception {
		Scanner scanner =new Scanner(System.in);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		   LocalDateTime now = LocalDateTime.now();
		  
  
		System.out.println("Enter 1 to LOGIN");
		System.out.println("Enter 2 to SIGNUP");
		System.out.println("Enter 3 to EXIT");
		
		
		int choice=scanner.nextInt();
		switch(choice)
		{
		case 1:
		{
		
			System.out.println("Enter the MailId");
			String mail_id=scanner.next();
			System.out.println("Enter the password");
			String password=scanner.next();
			User user=new User();
			user.setMail_id(mail_id);
			user.setPassword(password);
			System.out.println("Enter the staus to be entered");
			String status=scanner.next();
			String datetime=dtf.format(now);
			user.setStatus(status);
			user.setDatetime(datetime);
			Social social =new Social();
			social.login(mail_id, password, user);
			
			
	
		}
		break;
		case 2:
		{
			System.out.println("Enter the FirstName");
			String first_name=scanner.next();
			System.out.println("Enter the LastName");
			String last_name=scanner.next();
			System.out.println("Enter the ContactNumber");
			long contactnumber=scanner.nextLong();
			System.out.println("Enter the Gender");
			String gender=scanner.next();
			System.out.println("Enter the Year-of-Birth");
			String year_of_birth=scanner.next();
			System.out.println("Enter the Mailid");
			String mail_id=scanner.next();
			System.out.println("Enter the Password");
			String password=scanner.next();
			System.out.println("Enter the status");
			String status=scanner.next();
			
			User user=new User();
			user.setFirst_name(first_name);
			user.setLast_name(last_name);
			user.setContact_number(contactnumber);
			user.setGender(gender);
			user.setYear_of_birth(year_of_birth);
			user.setMail_id(mail_id);
			user.setPassword(password);
			user.setStatus(status);
			
			Social social=new Social();
			social.signUp(user);
			
			
			
		}
		break;
		case 3:
		{
			System.out.println("THANK YOU FOR VISITING ALPHA-BOOK");
		}
		}
		
	}

}

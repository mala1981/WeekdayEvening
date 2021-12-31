

import org.testng.annotations.Test;

public class TC002_TestCasesPriority {
	//login
	//book
	//logout 
	@Test(priority = 1 )
	public void login() {
		System.out.println("Login into application");
		
	}
@Test (priority = 2)
	public void bookTickets() {
		System.out.println("Book Tickets");
	}
@Test (priority = 3)
	public void logout() {
		System.out.println("Loging out from application");
	}
}


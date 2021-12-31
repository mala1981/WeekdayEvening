

import org.testng.annotations.Test;

//no main metod (public main) in testNG
//Every line should be written inside methods  
public class TC001_DisplayMessages {
	
	@Test // To execute any test 
	
	public void displayMessage() {
		System.out.println("We are learning Test NG");
	}
 @Test
	public void dispalyName() {
		System.out.println("Mala");
	}
}

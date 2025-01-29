package Task1;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class testcases {
	//tests for Name class
	@Test
	public void  testfullName(String n, Name name) {
		assertEquals(n,name);
	}
}

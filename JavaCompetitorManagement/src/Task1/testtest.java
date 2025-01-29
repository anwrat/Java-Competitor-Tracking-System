package Task1;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class testtest {
	@Test
	public void testnum() {
		assertEquals(5,3+2);
	}
	public static void main(String[] args) {
		testtest t=new testtest();
		t.testnum();
	}
}

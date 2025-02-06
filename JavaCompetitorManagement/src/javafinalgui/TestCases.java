package javafinalgui;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

public class TestCases {
	@Test
	public void TestAdminLogin() {
		String name="Anweshadmin";
		String password="admin@123";
		AdminLogin a=new AdminLogin();
		assertTrue(a.login(name, password));
	}
	@Test
	public void TestUserLogin() {
		String name="Hari";
		String level="Beginner";
		UserLogin a=new UserLogin();
		assertTrue(a.login(name, level));
	}
	@Test
	public void Testcheckans() {
		int qid=1;//1 id question is about founder of Java
		String ans="James Gosling";
		assertTrue(QuizGame.checkans(qid, ans));
	}
	@Test
	public void TestsearchbyID() {
		assertAll(()->assertTrue(Questions.searchbyID(1)),()->assertTrue(Questions.searchbyID(5)));
	}
	@Test
	public void Testgetqncat() {
		String cat="Sports";
		assertEquals(Questions.getcat(10),cat);
	}
	@Test
	public void Testgetqn() {
		String qn="Who is the founder of Java?";
		assertEquals(Questions.getqn(1),qn);
	}
	@Test
	public void Testgetqndetails() {
		ArrayList<String> a=Questions.getqndetails(1);
		assertEquals(a.get(6),"Java");
	}
	@Test
	public void Testgetscore() {
		ArrayList<Integer> a=Competitor.getscore("Hari", "Beginner");
		assertEquals(a.get(0),2);
	}
	@Test
	public void TestgetTotalPlayers() {
		assertEquals(Reports.getTotalPlayers(),10);
	}
	@Test
	public void TestgetHighestLevel() {
		String expected="Best Beginner player: Hari - 11";
		assertEquals(Reports.getHighestLevel("Beginner"),expected);
	}
}

package practice.homepageTest;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HomePageSampleTest {
@Test

public void homePageTest(Method mtd)

{
	System.out.println(mtd.getName() +" Test Start");
	SoftAssert sa=new SoftAssert();
	System.out.println("Step-1");
	System.out.println("Step-2");
	Assert.assertEquals("Home", "Home");
	System.out.println("Step-3");
	sa.assertEquals("Home-CRM", "Home-");
	System.out.println("Step-4");
	sa.assertAll();
	System.out.println(mtd.getName() +" Test End");
}
@Test
public void verifyLogoHomePageTest(Method mtd) {
	
	System.out.println(mtd.getName() +" Test Start");
	SoftAssert sa=new SoftAssert();
	System.out.println("Step-1");
	System.out.println("Step-2");
	sa.assertTrue(true);
	System.out.println("Step-3");
	sa.assertTrue(true);
	System.out.println("Step-4");
	sa.assertAll();
	System.out.println(mtd.getName() +" Test End");
}
}

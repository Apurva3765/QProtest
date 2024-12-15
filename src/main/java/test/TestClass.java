package test;

import java.io.IOException;
import java.util.*;

import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.*;

public class TestClass implements objectRepo {

	public static WebDriver driver = FunctionClass.driver;
	public static FunctionClass func = new FunctionClass();
	public static List<WebElement> eleList = new ArrayList<WebElement>();

	@Test
	@Parameters("strParams")
	public static void testLaunchUrl(String strParams) throws InterruptedException {
		try {
			String[] params = func.getKeywordParam(strParams);
			String browserName = params[0];
			String url = params[1];
			driver = func.launchBrowser(browserName, url);
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	@Parameters("strParamst2")
	public static void testSingleSelect(String strParamst2) {
		try {
			func.click(btnSubmit);
			Thread.sleep(2000);
			Assert.assertTrue(func.displayStatus(error_singleSelect));
			Assert.assertEquals(func.readProperties("singleSelectErrorMessage"),
					func.getElementText(error_singleSelect));
			eleList = func.getElementList(singleSelectOptions);
			func.click(eleList.get(3));
			Thread.sleep(3000);
			func.click(btnSubmit);

			Thread.sleep(2000);
			Assert.assertEquals(func.readProperties("errorTextOther"), func.getElementText(error_Other));
			if (func.displayStatus(singleSelectTextOther)) {
				func.enterText(func.createElement(singleSelectTextOther), strParamst2);
			} else {
				Assert.assertTrue(func.displayStatus(singleSelectTextOther));
			}
			func.click(btnSubmit);
			Thread.sleep(3000);
			Assert.assertTrue(func.displayStatus(fnbQuestion));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	@Parameters("strParamst3")
	public static void testComment(String strParamst3) {
		String[] params = func.getKeywordParam(strParamst3);
		String favFood = params[0];
		String favBev = params[1];

		func.click(btnSubmit);
		Assert.assertTrue(func.displayStatus(fnbFoodError));
		Assert.assertTrue(func.displayStatus(fnbBevError));

		func.enterText(fnbFood, favFood);
		func.enterText(fnbBev, favBev);

		func.click(btnSubmit);
		try {
			Thread.sleep(4000);
			Assert.assertTrue(func.getCurrentUrl().contains(func.readProperties("pageUrl")));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	@Parameters("strParamst4")
	public static void testSelect(String strParamst4) throws IOException {

		try {
			String[] params = func.getKeywordParam(strParamst4);
			String firstChoice = params[0];
			int choice1 = Integer.valueOf(firstChoice);
			String choice2 = params[1];
			String choice3 = params[2];

			String txtQ = func.getElementText(questiontext);
			Assert.assertEquals(txtQ, func.readProperties("rankingQuestionText"));
			func.click(btnSubmit);

			Assert.assertTrue(func.displayStatus(rankingError));

			func.selectByIndex(rankSkiing, choice1);
			func.selectByText(rankSnowBoarding, choice2);
			func.selectByValue(rankBiking, choice3);
			Assert.assertFalse(func.displayStatus(rankingError));

			func.click(btnSubmit);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
//	@Parameters("strParamst5")
	public static void testDragNDrop() throws IOException {

		try {

			Thread.sleep(4000);
			String txtQ = func.getElementText(cardSortingPage);
			Assert.assertEquals(txtQ, func.readProperties("cardsQuestionText"));
			func.click(btnSubmit);

			Assert.assertTrue(func.displayStatus(cardsError));

			Thread.sleep(3000);
			func.dragAndDrop(cardApple, fieldFruits);
			func.dragAndDrop(cardBanana, fieldFruits);
			func.dragAndDrop(cardOrange, fieldFruits);

			func.dragAndDrop(cardLettuce, fieldVegies);
			func.dragAndDrop(cardSpinach, fieldVegies);
			func.dragAndDrop(cardBroccoli, fieldVegies);

			func.click(btnSubmit);

			Thread.sleep(3000);
			WebElement ele = func.getElementList(cardSortingPage).get(0);
			Assert.assertTrue(func.displayStatus(ele));
			Assert.assertEquals(func.getElementText(ele), func.readProperties("matrixQ"));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	@Parameters("strParamst5")
	public static void testMatrix(String strParamst5) throws IOException {
		try {
			String[] params = strParamst5.split("@#");
			String keyCommunication = params[0];
			String keyAptitude = params[1];
			String keySkillset = params[2];

			func.click(btnSubmit);
			Assert.assertTrue(func.displayStatus(func.createElement(matrixError1)));
			Assert.assertTrue(func.displayStatus(func.createElement(matrixError2)));
			Assert.assertTrue(func.displayStatus(func.createElement(matrixError3)));

			eleList = func.getElementList(matix);
			func.click(eleList.get(func.getMatrixIndex(keyCommunication)));
			func.click(eleList.get(func.getMatrixIndex(keyAptitude)));
			func.click(eleList.get(func.getMatrixIndex(keySkillset)));
			Thread.sleep(3000);

			func.click(btnSubmit);
			Thread.sleep(2000);

		} catch (Exception e) {

		}
	}

	@Test
	public static void testThankYou(String strParamst5) {
		try {
			func.waitExplicitely(func.createElement(thankYou), "visibility", 30);
			Assert.assertTrue(func.displayStatus(thankYou));
		} catch (Exception e) {

		}
	}

	@AfterClass
	public static void closeConnection() {
		func.quit();
		System.gc();
	}
}

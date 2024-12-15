package test;

import org.openqa.selenium.By;

public interface objectRepo {

	public static By singleSelectOpt1 = By.id("558420262ID");
	public static By singleSelectOpt2 = By.id("558420263ID");
	public static By singleSelectOpt3 = By.id("558420267ID");
	public static By singleSelectOpt4 = By.id("558420268ID");
	public static By singleSelectOpt5 = By.id("558420269ID");
	public static By singleSelectOptions = By.tagName("label");
	public static By singleSelectTextOther = By.id("t_558420268_ID");
	public static By error_Other = By.id("errorSpan_103875150_o");
	public static By btnSubmit = By.id("SurveySubmitButtonElement");
	public static By error_singleSelect = By.id("errorSpan_103875150");
	public static By questiontext = By.className("question-text-span");

	public static By fnbQuestion = By.id("QuestionSection_103875159");
	public static By fnbQ = By.className("question-text-span");
	public static By fnbFood = By.id("558420301ID");
	public static By fnbBev = By.id("558420303ID");
	public static By fnbFoodError = By.id("errorSpan_103875159");
	public static By fnbBevError = By.id("errorSpan_103875160");

	public static By rankingPage = By.id("legend_103875187");
	public static By rankingError = By.id("errorSpan_103875187");
	public static By rankSkiing = By.id("558420500ID");
	public static By rankSnowBoarding = By.id("558420501ID");
	public static By rankBiking = By.id("558420502ID");

	public static By cardSortingPage = By.className("question-text-span");
	public static By cardsError = By.id("errorSpan_103875200");
	public static By cardApple = By.id("558420518");
	public static By cardBanana = By.id("558420520");
	public static By cardOrange = By.id("558420519");
	public static By cardLettuce = By.id("558420521");
	public static By cardSpinach = By.id("558420522");
	public static By cardBroccoli = By.id("558420523");

	public static By fieldFruits = By.id("2306");
	public static By fieldVegies = By.id("2307");
	// public static By cardApple=By.id("558420518");

	public static By matrixFirstRow = By.xpath("//tbody/tr[1]/td");
	public static By matrixSecondRow = By.xpath("//tbody/tr[3]/td");
	public static By matrixThirdRow = By.xpath("//tbody/tr[5]/td");
	public static By matix = By.tagName("td");
	public static By matrixError1=By.id("errorSpan_103875211");
	public static By matrixError2=By.id("errorSpan_103875212");
	public static By matrixError3=By.id("errorSpan_103875215");

	public static By thankYou = By.id("finishText");

}

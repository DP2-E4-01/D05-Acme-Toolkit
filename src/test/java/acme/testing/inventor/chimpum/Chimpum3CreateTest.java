package acme.testing.inventor.chimpum;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class Chimpum3CreateTest extends TestHarness{

	// Test cases -------------------------------------------------------------------------------------
	

	@ParameterizedTest
	@CsvFileSource(resources = "/inventor/chimpum/chimpumCreate.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void InventorCreateChimpumPositiveTest(final int recordIndex, final String code, 
		final String title, final String description, final String startsAt, final String finishesAt, final String budget, 
		final String link) {

	super.signIn("administrator", "administrator");
	
	super.clickOnMenu("Inventor", "List Own Components");
	super.checkListingExists();
	super.sortListing(2, "desc");
	super.clickOnListingRecord(recordIndex);

	super.clickOnButton("Create Chimpum");
	
	super.fillInputBoxIn("code", code);
	super.fillInputBoxIn("title", title);
	super.fillInputBoxIn("description", description);
	super.fillInputBoxIn("startsAt", startsAt);
	super.fillInputBoxIn("finishesAt", finishesAt);
	super.fillInputBoxIn("budget", budget);
	super.fillInputBoxIn("link", link);
	
	super.clickOnSubmit("Create");

	super.signOut();
	}
	
	@ParameterizedTest
	@CsvFileSource(resources = "/inventor/chimpum/chimpumCreateN.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void InventorCreateChimpumNegativeTest(final int recordIndex,  
		final String title, final String description, final String startsAt, final String finishesAt, final String budget, 
		final String link) {

	super.signIn("administrator", "administrator");
	
	super.clickOnMenu("Inventor", "List Own Components");
	super.checkListingExists();
	super.sortListing(2, "desc");
	super.clickOnListingRecord(recordIndex);

	super.clickOnButton("Create Chimpum");
	
	super.fillInputBoxIn("title", title);
	super.fillInputBoxIn("description", description);
	super.fillInputBoxIn("startsAt", startsAt);
	super.fillInputBoxIn("finishesAt", finishesAt);
	super.fillInputBoxIn("budget", budget);
	super.fillInputBoxIn("link", link);
	
	super.clickOnSubmit("Create");


	super.signOut();
	}
	
	@Test
    @Order(10)
    public void hackingTest() {

		super.checkNotLinkExists("Account");
        super.navigate("/inventor/item/list-component");
        super.checkPanicExists();

 
    }
}

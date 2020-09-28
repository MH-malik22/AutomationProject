package com.zoho.landingpage;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.zoho.Automation.TestSetup.TestSetup;

public class signupTest extends TestSetup {

// sign up with valid email and invalid password

	@Test(priority = 1)

	public void signUpWithvalidemailandInvalidPassword() {

		driver.findElement(By.linkText("Free Sign Up")).click();
		driver.findElement(By.id("emailfield")).sendKeys("mujamalik@aol.com");
		driver.findElement(By.id("password")).sendKeys("00");
		Select select = new Select(driver.findElement(By.className("za-globalstate-signup")));
		select.selectByValue("florida");
		driver.findElement(By.id("signup-termservice")).click();
		driver.findElement(By.id("signupbtn")).click();
		Assert.assertTrue(true, "Password cannot be less than 8 characters");

	}

// sign up with invalid email and valid password
	@Test(priority = 2)
	public void signUpWithInvalidEmailAndValidPassword() {

		driver.findElement(By.linkText("Free Sign Up")).click();
		driver.findElement(By.id("emailfield")).sendKeys("mujamalik@aol");
		driver.findElement(By.id("password")).sendKeys("Test@0321 ");
		Select select = new Select(driver.findElement(By.className("za-globalstate-signup")));
		select.selectByValue("florida");
		driver.findElement(By.id("signup-termservice")).click();
		driver.findElement(By.id("signupbtn")).click();
		driver.findElement(By.id("emailfield-error")).isDisplayed();
		Assert.assertTrue(true, "please enter a valid email address");

	}

// sign up with invalid email and invalid password
	@Test(priority = 3)
	public void signUpWithInvalidEmailandInvalidPassword() {

		driver.findElement(By.linkText("Free Sign Up")).click();
		driver.findElement(By.id("emailfield")).sendKeys("mujamalik@a");
		driver.findElement(By.id("password")).sendKeys("T1 ");
		Select select = new Select(driver.findElement(By.className("za-globalstate-signup")));
		select.selectByValue("florida");
		driver.findElement(By.id("signup-termservice")).click();
		driver.findElement(By.id("signupbtn")).click();
		driver.findElement(By.id("emailfield-error")).isDisplayed();
		Assert.assertTrue(true, "Please enter a valid email address");
		Assert.assertTrue(true, "Password cannot be less than 8 characters");

	}

// sign up without selecting selecting terms and conditions checkbox
	@Test(priority = 4)
	public void signUpWithOutSelectingTermsAndConditionsCheckboc() {

		driver.findElement(By.linkText("Free Sign Up")).click();
		driver.findElement(By.id("emailfield")).sendKeys("mujamalik@a");
		driver.findElement(By.id("password")).sendKeys("T1 ");
		Select select = new Select(driver.findElement(By.className("za-globalstate-signup")));
		select.selectByValue("florida");
		driver.findElement(By.id("signupbtn")).click();
		driver.findElement(By.id("emailfield-error")).isDisplayed();
		Assert.assertTrue(true, "Please enter a valid email address");
		Assert.assertTrue(true, "Password cannot be less than 8 characters");
		String toserror = driver.findElement(By.id("tos-error")).getText();
		Assert.assertTrue(true, toserror);

	}

//sign up with valid email and valid password 	

}

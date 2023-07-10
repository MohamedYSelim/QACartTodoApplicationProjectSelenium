package com.qacart.todo.testcases;

import com.qacart.todo.api.RegisterApi;
import com.qacart.todo.base.BaseTest;
import com.qacart.todo.pages.LoginPage;
import com.qacart.todo.utils.ConfigUtils;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;

@Feature("Auth Feature")
public class LoginTest extends BaseTest {
    @Story("Login using Email and Password")
    @Description("It will login by filling the email and the password and navigate to the todo page")
    @Test(description = "Test the login functionality using email and password")
    public void shouldBeAbleToLoginWithEmailAndPassword() {
        RegisterApi registerApi = new RegisterApi();
        registerApi.register();
        LoginPage loginPage = new LoginPage(getDriver());

        Boolean isWelcomeDisplayed = loginPage.load()
                .login(registerApi.getEmail(), registerApi.getPassword())
                .isWelcomeMessageDisplayed();

        Assert.assertTrue(isWelcomeDisplayed);
    }
}

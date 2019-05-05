package hellocucumber;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

public class Stepdefs {

    String today;
    String isFriday;

    private RequestSpecification request;
    private Response response;

    private static final String LOGIN_URI = "https://localhost:8080/v3/login/";

    @Given("^today is sunday$")
    public void todayIsSunday(){
        today = "sunday";
    }

    @Given("^I'm (.*)$")
    public void defineEmail(String email){
        request = given().pathParam("email",email);
    }
    @When("I want to login")
    public void login(){

        response = request.when().get(LOGIN_URI + "email/{email}/check");
    }
    @Then("^I get a response code (\\d+)$")
    public void checkResponseStatus(int status){
        assertEquals(status,response.statusCode());
    }

    @When("^I ask it it's friday$")
    public void IsItFriday(){
        isFriday =IsItFriday.day(today);
    }
    @Then("^I should be told \\\"([^\\\"]*)\\\"$")
    public void IshouldBeTold(String expectedAnswers){
        assertEquals(expectedAnswers,isFriday);
    }
}
class IsItFriday{
    public static String day(String day){
        return day.equals("Friday")?"Yep" : "Nope";
    }
}

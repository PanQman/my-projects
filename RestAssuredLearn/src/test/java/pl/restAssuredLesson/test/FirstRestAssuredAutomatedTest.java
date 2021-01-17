package pl.restAssuredLesson.test;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class FirstRestAssuredAutomatedTest {

    @Test
    public void givenNonExistingPetIdWhenGetPetThenPetNotFoundTest() {
        given().when().get("https://swaggerpetstore.przyklady.javastart.pl/v2/pet/0").then().statusCode(404);
    }



}

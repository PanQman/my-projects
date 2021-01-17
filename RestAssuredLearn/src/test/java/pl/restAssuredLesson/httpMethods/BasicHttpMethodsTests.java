package pl.restAssuredLesson.httpMethods;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pl.restAssuredLesson.main.pojo.Category;
import pl.restAssuredLesson.main.pojo.Pet;
import pl.restAssuredLesson.main.pojo.Tag;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.*;

public class BasicHttpMethodsTests {

    @BeforeClass
    public void setupConfiguration(){
        RestAssured.baseURI = "https://swaggerpetstore.przyklady.javastart.pl";
        RestAssured.basePath = "v2";
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());

        RestAssured.requestSpecification = new RequestSpecBuilder().setContentType("application/json").build();
        //RestAssured.responseSpecification = new ResponseSpecBuilder().expectStatusCode(200).build();
        ResponseSpecBuilder responseSpecBuilder = new ResponseSpecBuilder();
        responseSpecBuilder
                .expectStatusCode(200)
                .expectResponseTime(Matchers.lessThan(2L), TimeUnit.SECONDS);

        RestAssured.responseSpecification = responseSpecBuilder.build();
    }

    @Test
    public void givenPetWhenPostPetThenPetIsCreatedTest() {

        Category category = new Category();
        category.setId(1);
        category.setName("dogs");

        Tag tag = new Tag();
        tag.setId(1);
        tag.setName("dogs-category");

        Pet pet = new Pet();
        pet.setId(123);
        pet.setCategory(category);
        pet.setPhotoUrls(Collections.singletonList("http://photos.com/dog1.jpg"));
        pet.setTags(Collections.singletonList(tag));
        pet.setStatus("available");

        given().body(pet)
                .when().post("pet");
    }

    @Test
    public void givenExistingPetIdWhenGetPetThenReturnPetTest() {
        given().pathParam("petId", 1)
                .when().get("pet/{petId}");
    }

    @Test
    public void givenExistingPetWhenUpdatePetNameThenPetIsChangedTest() {

        Category category = new Category();
        category.setId(1);
        category.setName("dogs");

        Tag tag = new Tag();
        tag.setId(1);
        tag.setName("dogs-category");

        Pet pet = new Pet();
        pet.setId(123);
        pet.setCategory(category);
        pet.setPhotoUrls(Collections.singletonList("http://photos.com/dog1.jpg"));
        pet.setTags(Collections.singletonList(tag));
        pet.setStatus("available");

        given().body(pet)
                .when().post("pet");

        pet.setName("Reksio");

        given().body(pet)
                .when().put("pet");
    }




}


package studentAPI;
import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import org.testng.Assert;
import org.testng.annotations.Test;



public class SampleGetTest {
    @Test
    public void getTest() {

        /*
         * given application is up and running and performing the GET request with get(url)
         * Then response should have first email as given below
         */
      
    String   resp=  given()
       .accept(ContentType.JSON)
       .when().get("http://localhost:8080/api/students-list").
        thenReturn().asString();
       System.out.println("resp : "+resp);
    	
    	       

        JsonPath jsonpath= new JsonPath(resp);
        System.out.println("email : "+jsonpath.getString("student_email[0]"));
        Assert.assertEquals("adheesh_bhattacharya@windler.org",jsonpath.getString("student_email[0]"));
    }
}
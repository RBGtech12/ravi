package studentAPI;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;

public class SampleDeleteTest 
{
	

    @Test
    public void getTest() {

        /*
         * given application is up and running and performing the GET request with get(url)
         * Then response should have first email as given below
         */
       
    String   resp=  given()
       .accept(ContentType.JSON)
       .when().delete("http://localhost:8080/api/delete-student/1").
        thenReturn().asString();
       System.out.println("resp : "+resp);
    	
    	       

//        JsonPath jsonpath= new JsonPath(resp);
//        System.out.println("email : "+jsonpath.getString("student_email[0]"));
//        Assert.assertEquals("RBGtest1@gmail.com",jsonpath.getString("student_email[0]"));
    }

}

package studentAPI;
import static io.restassured.RestAssured.given;

import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

/**
 * 
 * @author Mandeep kaur
 *
 */

public class SamplePostRestTest {

	@Test
	public void createUser_whenSuccess() {


		JSONObject jsonObject = new JSONObject();

		//insert key value pair to jsonObject
		jsonObject.put("student_name", "Test Automation");
		jsonObject.put("student_email", "Male");
		jsonObject.put("student_branch", "testAutomation14@gmail.com");
		

		String resp=  given().log().all().header("authorization", "Bearer 0431655cfe7ba40a791e0ce32d83ad33363348919c11627f409a3228f205e15f23")
				.accept(ContentType.JSON)
				.contentType("application/json")
				.and()
				.body(jsonObject.toString())
				.post("http://localhost:8080/api/save-student")   //hit the post end point
				.thenReturn().asString();

		System.out.println(resp);

	}
}
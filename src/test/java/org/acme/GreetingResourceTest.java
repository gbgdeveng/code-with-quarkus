package org.acme;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class GreetingResourceTest {

    @Test
    public void testHelloEndpoint() {
        given()
          .when().get("/hello-resteasy")
          .then()
             .statusCode(200)
             .body(is("Hello RESTEasy"));
    }

    @Test
    public void coding__() {
//        {
//            "gym": false,
//                "school": true,
//                "store": false
//        },
//        {
//            "gym": true,
//                "school": false,
//                "store": false
//        },
//        {
//            "gym": true,
//                "school": true,
//                "store": false
//        },
//        {
//            "gym": false,
//                "school": true,
//                "store": false
//        },
//        {
//            "gym": false,
//                "school": true,
//                "store": true
//        }
// reqs: [gym,  school, store]
    }

}
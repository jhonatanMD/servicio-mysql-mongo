package com.ws.controller;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.Header;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

@QuarkusTest
public class AppControllerTest {


    @Test
    public void getPostByIdTest(){

        given()
                .when()
                .get("/v1/post/1")
                .then()
                .statusCode(200)
                .body(containsString("\"title\":\"sunt aut facere repellat provident occaecati excepturi optio reprehenderit\""));
    }


    @Test
    public void getPostTest(){

        Map<String,String> headers = new HashMap<>();
        headers.put("Autorization","Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJieXRlLWNvbXBhbnkiLCJzdWIiOiJieXRlLWNvbXBhbnktdG9rZW4iLCJncm91cHMiOlsicmVhZCIsImFkbWluIl0sImV4cCI6MTY2NzY2NDY4Mjc3MiwiaWF0IjoxNjY3NjY0Njc0LCJqdGkiOiJjZjRkZmIzZi0xOTU4LTQ2ODgtOWM1ZC0yNTVhOGVlY2MxNzgifQ.yJbZZHAn2mu8G_sbvkZd6Skul_CPL0j-nUcEAEoxIgxVu62PAJPhMmHhnMG9yPgYYOA2B0PNxJhJyv-j-SAlhjTm2T-1BeafvLs44mZovHVdNBxeTWRt3nDRAzdeZdd5-KpTZ8CKEpmj2dgFxRbAOz1PjSWv3zeygCDI6HjsV350z3_On-ZTvUEgVczHaZ-e8KM4Afp9P48H47JfMyy9DZzY_w4L4Tp0J5d2GUmmKUVeF0pGjQ2YLQI2gd9Jx0rkLluDaoNF2xOEUEO-x_64-cRkDzGwiqXWTSFGO_5b5BMkWI9WhBxFqBaZE_JSIBXNxoeLlMPcampVA_526jwJZA");

        given()
                .when()
                   // .header(new Header("Autorization","Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJieXRlLWNvbXBhbnkiLCJzdWIiOiJieXRlLWNvbXBhbnktdG9rZW4iLCJncm91cHMiOlsicmVhZCIsImFkbWluIl0sImV4cCI6MTY2NzY2NDY4Mjc3MiwiaWF0IjoxNjY3NjY0Njc0LCJqdGkiOiJjZjRkZmIzZi0xOTU4LTQ2ODgtOWM1ZC0yNTVhOGVlY2MxNzgifQ.yJbZZHAn2mu8G_sbvkZd6Skul_CPL0j-nUcEAEoxIgxVu62PAJPhMmHhnMG9yPgYYOA2B0PNxJhJyv-j-SAlhjTm2T-1BeafvLs44mZovHVdNBxeTWRt3nDRAzdeZdd5-KpTZ8CKEpmj2dgFxRbAOz1PjSWv3zeygCDI6HjsV350z3_On-ZTvUEgVczHaZ-e8KM4Afp9P48H47JfMyy9DZzY_w4L4Tp0J5d2GUmmKUVeF0pGjQ2YLQI2gd9Jx0rkLluDaoNF2xOEUEO-x_64-cRkDzGwiqXWTSFGO_5b5BMkWI9WhBxFqBaZE_JSIBXNxoeLlMPcampVA_526jwJZA"))
                .get("/v1/post")
                .then()
                .statusCode(200);
    }


}

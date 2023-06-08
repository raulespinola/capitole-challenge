package com.capitole.challenge.integration;

import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;


@Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD,
        config = @SqlConfig(encoding = "utf-8", transactionMode = SqlConfig.TransactionMode.ISOLATED),
        scripts = "classpath:/data_test.sql")
class PricesFunctionalTest extends RestAssuredIntegrationTest{

    @Test
    void test_1__get_price_at_10hs_day14_product_35455_brand1_return_price_35_5() {
            float priceExpected= 35.5f;
            given()
                    .contentType(ContentType.JSON)
                    .when()
                    .queryParam("productId", 35455L)
                    .queryParam("brandId", 1L)
                    .queryParam("date", "2020-06-14T10:00:00.000")
                    .get("/")
                    .then()
                    .log().all()
                    .statusCode(HttpStatus.SC_OK)
                    .body("price[0]", is(priceExpected));
    }

    @Test
    void test_2_get_price_at_16hs_day14_product_35455_brand1_return_price_25_45() {
        float priceExpected= 25.45f;
        given()
                .contentType(ContentType.JSON)
                .when()
                .queryParam("productId", 35455L)
                .queryParam("brandId", 1L)
                .queryParam("date", "2020-06-14T16:00:00.000")
                .get("/")
                .then()
                .log().all()
                .statusCode(HttpStatus.SC_OK)
                .body("price[0]", is(priceExpected));
    }

    @Test
    void test_3_get_price_at_21hs_day14_product_35455_brand1_return_price_35_5() {
        float priceExpected= 35.5f;
        given()
                .contentType(ContentType.JSON)
                .when()
                .queryParam("productId", 35455L)
                .queryParam("brandId", 1L)
                .queryParam("date", "2020-06-14T21:00:00.000")
                .get("/")
                .then()
                .log().all()
                .statusCode(HttpStatus.SC_OK)
                .body("price[0]", is(priceExpected));
    }


    @Test
    void test_4_get_price_at_10hs_day15_product_35455_brand1_return_price_30_5() {
        float priceExpected= 30.5f;
        given()
                .contentType(ContentType.JSON)
                .when()
                .queryParam("productId", 35455L)
                .queryParam("brandId", 1L)
                .queryParam("date", "2020-06-15T10:00:00.000")
                .get("/")
                .then()
                .log().all()
                .statusCode(HttpStatus.SC_OK)
                .body("price[0]", is(priceExpected));
    }

    @Test
    void test_5_get_price_at_21hs_day16_product_35455_brand1_return_price_38_95() {
        float priceExpected= 38.95f;
        given()
                .contentType(ContentType.JSON)
                .when()
                .queryParam("productId", 35455L)
                .queryParam("brandId", 1L)
                .queryParam("date", "2020-06-16T21:00:00.000")
                .get("/")
                .then()
                .log().all()
                .statusCode(HttpStatus.SC_OK)
                .body("price[0]", is(priceExpected));
    }
}
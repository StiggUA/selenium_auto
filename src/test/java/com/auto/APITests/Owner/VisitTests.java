package com.auto.APITests.Owner;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

public class VisitTests extends ApiTestPreconditions{
//Visit visit;
    @Test
    public void addingVisit(){
        owner = new Owner();
        owner.setFirstName("Pavlo");
        owner.setLastName("Zibrov");
        owner.setAddress("Khreschatik");
        owner.setCity("Kyiv");
        owner.setTelephone("2589631470");
        owner = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(owner)
                .post("/owners")
                .then()
                .statusCode(201)
                .extract().body()
                .as(Owner.class);

        type = new Type();
        type.setName("Duck");
        type = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(type)
                .post("/pettypes")
                .then()
                .statusCode(201)
                .extract().body()
                .as(Type.class);

        pet = new Pet();
        pet.setName("Villy");
        pet.setType(type);
        pet.setBirthDate("2019/01/01");
        pet.setOwner(owner);
        pet = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(pet)
                .post("/pets")
                .then()
                .statusCode(201)
                .extract().body()
                .as(Pet.class);
//
//        pet.setBirthDate("2020/10/10");
//        RestAssured.given()
//                .contentType(ContentType.JSON)
//                .body(pet)
//                .put("/pets/"+ pet.getId())
//                .then()
//                .statusCode(204)
//                .log().all();

        Visit visit = new Visit();
        visit.setDate("2020/01/01");
        visit.setDescription("Test visit");
        visit.setId(1);
        visit.setPet(pet);
                RestAssured.given()
                .contentType(ContentType.JSON)
                .body(visit)
                .post("/visits")
                .then()
                .statusCode(201)
                .log().all()
                        .extract().body()
                        .as(Visit.class);
        System.out.println((visit.toString()));
    }
}
//    ApiTestPreconditions apiTest = new ApiTestPreconditions();
//        apiTest.addOwnerAndPets();
//                Visit visit = new Visit();
//                visit.setDate("2020/10/10");
//                visit.setDescription("Test visit");
//                visit.setPet(apiTest.pet);
//                visit.setId(1);
//                RestAssured.given()
//                //.body(apiTest.pet)
//                //.get("visits")
//                .contentType(ContentType.JSON)
//                .body(visit)
//                .put("/visits")
//                .then()
//                .statusCode(201)
//                .log().all();
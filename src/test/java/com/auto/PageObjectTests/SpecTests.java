package com.auto.PageObjectTests;

import com.auto.TestPreconditions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SpecTests extends TestPreconditions {
    @Test
    public void pageCheck(){
        goToSpecialtiesPage();
        assertUrl(driver.getCurrentUrl());
    }
    @Test
    public void petTypeAddTest() {
        goToSpecialtiesPage();
        SpecPage specPage = new SpecPage(driver);
        specPage.addBtn();
        specPage.setName("X-Ray");
        specPage.saveBtn();
        assertThat(specPage.specList()).isEqualTo("X-Ray");
    }
    @Test
    public void addingEmptyPet(){
        goToSpecialtiesPage();
        SpecPage specPage = new SpecPage(driver);
        List<WebElement> before = driver.findElements(By.xpath(specPage.specRow));
        specPage.addBtn();
        specPage.saveBtn();
        List<WebElement> after = driver.findElements(By.xpath(specPage.specRow));
        assertThat(before.size()).isEqualTo(after.size());
    }
    @Test
    public void petTypeDeleteTest() {
        goToSpecialtiesPage();
        SpecPage specPage = new SpecPage(driver);
        List<WebElement> before = driver.findElements(By.xpath(specPage.specRow));
        specPage.addBtn();
        specPage.setName("LOR");
        specPage.saveBtn();
        assertThat(specPage.specList()).isEqualTo("LOR");
        List<WebElement> afterAdding = driver.findElements(By.xpath(specPage.specRow));
        assertThat(before.size()+1).isEqualTo(afterAdding.size());
        specPage.deleteLast();
        List<WebElement> afterDeleting = driver.findElements(By.xpath(specPage.specRow));
        assertThat(before.size()).isEqualTo(afterDeleting.size());
    }
    @Test
    public void homeButtonTest() {
        goToSpecialtiesPage();
        SpecPage specPage = new SpecPage(driver);
        specPage.homeBtn();
        assertUrl(home);
    }
}
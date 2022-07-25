package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;


public class FormTests {
    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }

    @Test
    void dataCheckTest(){
        open("https://demoqa.com/automation-practice-form");

        $("#firstName").setValue("Valera");
        $("#lastName").setValue("Dushnila");
        $("#userEmail").setValue("ggg@gg.com");
        $(".custom-control-label").click();
        $("#userNumber").setValue("6854351665");
        $("#dateOfBirthInput").click();
        $(byXpath("//*[@id=\"dateOfBirth\"]/div[2]/div[2]/div/div/div[2]/div[2]/div[1]/div[1]")).click();
        $("#subjectsInput").setValue("Hey, you! Yes, you! Get OFF!");
        $(byXpath("//*[@id='hobbiesWrapper']/div[2]/div[2]/label")).click();
        $("#uploadPicture").uploadFile(new File("src/test/java/resources/cuppy.jpg"));
        $("#currentAddress").setValue("Kukuevo 21b");

        $("#state").click();
        $("#react-select-3-option-1").click();
        $("#city").click();
        $("#react-select-4-option-2").click();
        $("#submit").click();

        $(".modal-content").shouldHave(text("Valera Dushnila"),
                text("ggg@gg.com"),
                text("6854351665"),
                text("Kukuevo 21b"),
                text("Male"),
                text("Reading"),
                text("Uttar Pradesh Merrut"));

    }
}

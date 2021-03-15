package ru.netology;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class ApplicationFormTest {
    @BeforeEach
    void setUp() {
        open("http://localhost:9999");
    }

    @Test
    public void shouldReturnSuccessfullyForm() {

        $(".form_theme_alfa-on-white");
        $("[data-test-id=name] input").setValue("Пугачева Алла");
        $("[data-test-id=phone] input").setValue("+7963221123");
        $("[data-test-id=agreement]").click();
        $("[type=button]").click();
        $("[data-test-id=order-success]").shouldHave(exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));
    }

    @Test
    public void shouldReturnErrorIfInvalidName() {

        $(".form_theme_alfa-on-white");
        $("[data-test-id=name] input").setValue("Max");
        $("[data-test-id=phone] input").setValue("+79875554123");
        $("[data-test-id=agreement]").click();
        $("[type=button]").click();
        $(".input_type_text .input__sub").shouldHave(exactText("Имя и Фамилия указаны неверно. Допустимы только русские буквы, пробелы и дефисы."));
    }

    @Test
    public void shouldReturnErrorIfInvalidTel() {

        $(".form_theme_alfa-on-white");
        $("[data-test-id=name] input").setValue("Пугачева Алла");
        $("[data-test-id=phone] input").setValue("5874");
        $("[data-test-id=agreement]").click();
        $("[type=button]").click();
        $(".input_type_tel .input__sub").shouldHave(exactText("Телефон указан неверно. Должно быть 11 цифр, например, +79012345678."));

    }

    @Test
    public void shouldReturnErrorIfFieldNameIsEmpty() {
        $(".form_theme_alfa-on-white");
        $("[data-test-id=name] input").setValue("");
        $("[data-test-id=phone] input").setValue("+79874565321");
        $("[data-test-id=agreement]").click();
        $("[type=button]").click();
        $(".input_type_text .input__sub").shouldHave(exactText("Поле обязательно для заполнения"));
    }
}



package ru.netology;

    import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ApplicationFormTest {
        @Test
        void shouldTest() {
            open("http://localhost:9999");
            $("[data-test-id=name] input").setValue("Настя");
            $("[data-test-id=phone] input").setValue("+7923665588");
            $("[data-test-id=agreement]").click();
            $("[data-test-id=submit]").click();
            $(".alert-success").shouldHave(exactText("Ваша заявка успешно отправлена!"));
        }
    }



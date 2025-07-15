package org.iftm.exemplo_selenium_webdriver;

import java.time.Duration;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VeterinarioTest {
    private static WebDriver driver;
    private static WebDriverWait wait;
    
    @BeforeAll
    public static void configurarDriverBrowser(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    /**
     * Cenário : informar um cep válido e verificar se a resposta esperada foi obtida
     * 38400236
     * Rua Senador Salgado Filho
     */
    @Test
    public void testarBuscaCepCorreto(){
        driver.get("http://localhost:8080/home");
    }

    @AfterAll
    public static void fecharBrowser(){
        //driver.close();
    }
}

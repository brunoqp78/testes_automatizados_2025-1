package org.iftm.exemplo_selenium_webdriver;

import java.time.Duration;

import org.junit.jupiter.api.AfterAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CepTest {
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
        //arrange
        String tituloEsperado = "Busca CEP 38400-236 em Minas Gerais - MG";
        //act
        driver.get("http://achecep.com.br");
        WebElement campoCep = driver.findElement(By.id("q"));
        WebElement botaoConsultar = driver.findElement(By.id("btnConsultar"));
        campoCep.sendKeys("38400-236");
        botaoConsultar.click();

        WebElement textoRua = wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//span[2]/a"))));
        String ruaObtida = textoRua.getText();
        String tituloObtido = driver.getTitle();

        //assert
        assertEquals(tituloEsperado, tituloObtido);
        assertEquals("Rua Senador Salgado Filho", ruaObtida);
    }

    @AfterAll
    public static void fecharBrowser(){
        //driver.close();
    }
}

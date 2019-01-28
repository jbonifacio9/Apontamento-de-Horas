package Tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;


public class ApontamentoDeHorasTest {
    private WebDriver navegador;

    @Before
    public void setUp() {
        //Abrindo o Navegador
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\jefferson.santana\\Drivers\\chromedriver.exe");
        navegador = new ChromeDriver();
        navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        //Navegando para a pagina do Calrizen
        navegador.get("https://www.clarizen.com/");
        navegador.manage().window().maximize();
    }

    @Test
    public void testApontamentoDeHorasClarizen() {
       //Clicar no link que possui o texto "Login"
        navegador.findElement(By.linkText("Login")).click();

        //Clicar no campo com o nome de ID LoginTitle
        WebElement formularioLogin = navegador.findElement(By.id("txtLogin"));

        //Digitar no campo com o nome User name que está dentro do ID LoginTitle o texto "jefferson.santana@yaman.com.br"
        formularioLogin.findElement(By.id("txtLogin")).sendKeys("jefferson.santana@yaman.com.br");

        //Clicar no campo com o nome de ID txtPassword
        WebElement formularioPassword = navegador.findElement(By.id("txtPassword"));

        //Digitar no campo com o nome User name que está dentro do ID LoginTitle o texto "Jbonifacio9@3"
        formularioPassword.findElement(By.id("txtPassword")).sendKeys("998154725");

        //Clicar no link com o Texto "Login" que esta dentro do campo "lbtLogin"
        navegador.findElement(By.id("lbtLogin")).click();

        // Validar que dentro do elemento com class "me" está o campo "Página inicial"
        WebElement text = navegador.findElement(By.className("h2"));
        String textoNome = text.getText();
        assertEquals("Página inicial", textoNome);

        // Clicar na class "nav-icons" para ir ao menu
        navegador.findElement(By.xpath("//*[@id=\'nav-dynamic-container\']/ul/li/div/ul/li[2]")).click();
    }

      @After
      public void tearDown() {
//        // Fechar o navegador
//        navegador.close();

    }
}


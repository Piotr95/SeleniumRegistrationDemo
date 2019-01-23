import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class DemoTest {

    private WebDriver driver;

    @BeforeMethod
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
        driver = new ChromeDriver();
        driver.navigate().to("http://demo.automationtesting.in/Register.html");

    }

    @Test
    public void register() throws InterruptedException {


        driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[1]/div[1]/input")).sendKeys("Piotr");
        driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[1]/div[2]/input")).sendKeys("Szczepaniak");

        driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[2]/div/textarea")).sendKeys("ladny");
        driver.findElement(By.xpath("//*[@id=\"eid\"]/input")).sendKeys("Szczepaniak@piotr.pl");
        driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[4]/div/input")).sendKeys("0122346789");

        driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[5]/div/label[1]")).click();
        driver.findElement(By.xpath("//*[@id=\"checkbox2\"]")).click();



        driver.findElement(By.xpath("//*[@id=\"msdd\"]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath(" //*[@id=\"basicBootstrapForm\"]/div[7]/div/multi-select/div[2]/ul/li[28]")).click();


        driver.findElement(By.xpath("//*[@id=\"Skills\"]/option[39]")).click();

        driver.findElement(By.xpath("//*[@id=\"countries\"]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"countries\"]/option[180]")).click();

        driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[10]/div/span/span[1]/span")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"select2-country-results\"]/li[2]")).click();

        driver.findElement(By.xpath("//*[@id=\"yearbox\"]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"yearbox\"]/option[81]")).click();

        driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[11]/div[2]/select")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[11]/div[2]/select/option[5]")).click();

        driver.findElement(By.xpath("//*[@id=\"daybox\"]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"daybox\"]/option[17]")).click();

        driver.findElement(By.xpath("//*[@id=\"firstpassword\"]")).sendKeys("Piotrek1995");
        driver.findElement(By.xpath("//*[@id=\"secondpassword\"]")).sendKeys("Piotrek1995");

        driver.findElement(By.xpath("//*[@id=\"submitbtn\"]")).click();

        Thread.sleep(3000);

        WebElement edit=driver.findElement(By.xpath("/html/body/section/div[1]/div/div[2]/h4[1]"));
        WebElement delete=driver.findElement(By.xpath("/html/body/section/div[1]/div/div[2]/h4[2]"));

        assertTrue(edit.getText().contains("EDIT"));
        assertTrue(delete.getText().contains("DELETE"));
    }

    @AfterMethod
    public void afterTest() {
       driver.close();
       driver.quit();
    }
}


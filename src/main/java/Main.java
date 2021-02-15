import constants.Constants;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static WebDriver driver;

    private Pokemon myPokemon;
    private Pokemon enemyPokemon;

    boolean isWorking = true;
    private long fps = 0;

    @Test
    public void startWorking() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", Constants.DRIVER_PATH);
        driver = new ChromeDriver();
        driver.get(Constants.WEBSITE);

        myPokemon = new Pokemon("myPokemon", 0, 0, (byte) 0, 0, new PokemonAttack());
        enemyPokemon = new Pokemon("enemyPokemon", 0, 0, (byte) 0, 0);

        driver.findElement(new By.ByXPath(Constants.BUTTON_LOGIN)).sendKeys(Constants.NICKNAME);
        driver.findElement(new By.ByXPath(Constants.BUTTON_PASSWORD)).sendKeys(Constants.PASSWORD);
        driver.findElement(new By.ByXPath(Constants.BUTTON_ENTER)).click();
        GeneralMethods.getPause();
        List<String> pathWayToPokeCenter = Arrays.asList();

        while(isWorking) {
            if(fps > System.currentTimeMillis()) return;
            fps = System.currentTimeMillis() + (1000);

            if(GeneralMethods.exists(Constants.BUTTON_PLAY)) {
                GeneralMethods.findElement(Constants.BUTTON_PLAY).click();
            }
            if(GeneralMethods.exists(Constants.BUTTON_SOUND)) {
                GeneralMethods.findElement(Constants.BUTTON_SOUND).click();
            }

            


        }
    }
}

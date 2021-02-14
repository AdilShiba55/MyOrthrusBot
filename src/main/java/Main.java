import constants.Constants;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {

    public static WebDriver driver;

    Pokemon myPokemon;
    Pokemon enemyPokemon;

    @Test
    public void startWorking() {
        System.setProperty("webdriver.chrome.driver", Constants.DRIVER_PATH);
        driver = new ChromeDriver();
        driver.get(Constants.WEBSITE);

        myPokemon = new Pokemon("myPokemon", 0, 0, (byte) 0, 0, new PokemonAttack());
        enemyPokemon = new Pokemon("enemyPokemon", 0, 0, (byte) 0, 0);


    }


}

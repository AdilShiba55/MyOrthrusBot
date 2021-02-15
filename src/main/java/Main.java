import constants.AlolaWays.HealButtons;
import constants.AlolaWays.Pony;
import constants.Buttons;
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

    private int MY_ATTACK_NUM = 4;

    @Test
    public void startWorking() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", Constants.DRIVER_PATH);
        driver = new ChromeDriver();
        driver.get(Constants.WEBSITE);

        myPokemon = new Pokemon("myPokemon", 0, 0, (byte) 0, 0, new PokemonAttack());
        enemyPokemon = new Pokemon("enemyPokemon", 0, 0, (byte) 0, 0);

        driver.findElement(new By.ByXPath(Buttons.BUTTON_LOGIN)).sendKeys(Constants.NICKNAME);
        driver.findElement(new By.ByXPath(Buttons.BUTTON_PASSWORD)).sendKeys(Constants.PASSWORD);
        driver.findElement(new By.ByXPath(Buttons.BUTTON_ENTER)).click();
        GeneralMethods.getPause();
        List<String> pathWayToPokeCenter = Arrays.asList(Pony.PLAIN, Pony.SIFFOLK_VILLAGE, Pony.EXIT_TO_VILLAGE_FROM_POKECENTER, Pony.SIFFOLK_VILLAGE_POKECENTER);
        if (GeneralMethods.exists(Buttons.BUTTON_PLAY)) {
            GeneralMethods.findElement(Buttons.BUTTON_PLAY).click();
        }
        GeneralMethods.getPause();
        if (GeneralMethods.exists(Buttons.BUTTON_SOUND)) {
            GeneralMethods.findElement(Buttons.BUTTON_SOUND).click();
        }

        while (isWorking) {
            if (fps > System.currentTimeMillis()) continue;
            fps = System.currentTimeMillis() + (1000);

            GeneralMethods.hunterMode("on");

            String mainLoc = GeneralMethods.findElement(Buttons.MY_CURRENT_LOCATION).getText(); //Получение названия текущей Локации

            if (mainLoc.equals("Покецентр")) {
                goFromPokeCenter(pathWayToPokeCenter);
            } else {
                battleScript(pathWayToPokeCenter);
            }


        }
    }


    public void battleScript(List<String> pathToPokecenter) throws InterruptedException {
        if (GeneralMethods.isBattle()) {
            GeneralMethods.initialize(myPokemon, enemyPokemon);
            GeneralMethods.getPause();
            GeneralMethods.clickAttack(MY_ATTACK_NUM);
            GeneralMethods.getPause();
            GeneralMethods.initialize(myPokemon, enemyPokemon);
            if(enemyPokemon.getCurrentHP() == 0) {
                if(GeneralMethods.exists(Buttons.BATTLE_RUN)) {
                    GeneralMethods.findElement(Buttons.BATTLE_RUN).click();
                }
            }
            if(myPokemon.getCurrentHP() < (myPokemon.getFullHP() / 2) || myPokemon.getMyAttack().getAttackOD()[MY_ATTACK_NUM - 1] <= 2) {
                gotoPokeCenter(pathToPokecenter);
            }
        }
    }

    public void gotoPokeCenter(List<String> theWayToPokeCenter) throws InterruptedException {
        GeneralMethods.hunterMode("off");
        for (String path : theWayToPokeCenter) {
            GeneralMethods.getPause();
            if (GeneralMethods.exists(path)) {
                GeneralMethods.findElement(path).click();
            }
        }
    }

    public void goFromPokeCenter(List<String> theWayToPokeCenter) throws InterruptedException {
        healInPokeCenter();
        for (int i = theWayToPokeCenter.size(); i > 0; i--) {
            GeneralMethods.getPause();
            String theBackPath = theWayToPokeCenter.get(i - 1);
            if (GeneralMethods.exists(theBackPath)) {
                GeneralMethods.findElement(theBackPath).click();
            }
        }
        GeneralMethods.hunterMode("on");
    }

    public void healInPokeCenter() throws InterruptedException {
        if (GeneralMethods.exists(HealButtons.BUTTON_HEAL_SIFFOLK_VILLAGE)) {
            GeneralMethods.findElement(HealButtons.BUTTON_HEAL_SIFFOLK_VILLAGE).click();
        }
        GeneralMethods.getPause();
        String healAllWithIndex = String.format(HealButtons.BUTTON_HEAL_ALL, Integer.toString(3));
        if (GeneralMethods.exists(healAllWithIndex)) {
            GeneralMethods.findElement(healAllWithIndex).click();
        }
        healAllWithIndex = String.format(HealButtons.BUTTON_HEAL_ALL, Integer.toString(2));
        if (GeneralMethods.exists(healAllWithIndex)) {
            GeneralMethods.findElement(healAllWithIndex).click();
        }
    }
}

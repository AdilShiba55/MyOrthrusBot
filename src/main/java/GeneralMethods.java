import constants.Buttons;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class GeneralMethods {

    public static void getPause() throws InterruptedException {
        Thread.sleep(1000);
    }

    public static WebElement findElement(String xPath) {
        return Main.driver.findElement(new By.ByXPath(xPath));
    }

    public static void clickAttack(int attackNumber) {
        String BUTTON_MY_ATTACK = String.format("//*[@id=\"battle\"]/div/div/div/div[4]/div[1]/div[%s]", Integer.toString(attackNumber));
        if(exists(BUTTON_MY_ATTACK)) {
            findElement(BUTTON_MY_ATTACK).click();
        }
    }

    public static void initialize(Pokemon myPokemon, Pokemon enemyPokemon) {
        myPokemon.setName(PokemonConstants.getMyName());
        myPokemon.setLevel(PokemonConstants.getMyLevel());
        myPokemon.setSex(PokemonConstants.getMySex());
        myPokemon.setCurrentHP(PokemonConstants.getMyCurrentHP());
        myPokemon.setFullHP(PokemonConstants.getMyFullHP());

        initializeMyPokemonAttack(myPokemon);

        enemyPokemon.setName(PokemonConstants.getEnemyName());
        enemyPokemon.setLevel(PokemonConstants.getEnemyLevel());
        enemyPokemon.setSex(PokemonConstants.getEnemySex());
        enemyPokemon.setCurrentHP(PokemonConstants.getEnemyCurrentHP());
        enemyPokemon.setFullHP(PokemonConstants.getEnemyFullHP());
    }

    public static void initializeMyPokemonAttack(Pokemon myPokemon) {
        for (int i = 0; i < 4; i++) {
            String attackNamePath = String.format(Buttons.ATTACK_NAME_PATH, Integer.toString(i + 1));
            if (exists(attackNamePath)) {
                String string = findElement(attackNamePath).getText();
                myPokemon.getMyAttack().getAttackName()[i] = string;
            }
            String attackODPath = String.format(Buttons.ATTACK_OD_PATH, Integer.toString(i + 1));
            if (exists(attackODPath)) {
                String string = findElement(attackODPath).getText();
                int count = Integer.parseInt(string.replaceAll("/\\d+\\sОД", ""));
                myPokemon.getMyAttack().getAttackOD()[i] = count;
            }
        }
    }


    public static boolean exists(String xPath) {
        try {
            List<WebElement> elements = Main.driver.findElements(new By.ByXPath(xPath));
            int exist = elements.size();
            elements = null;
            if (exist > 0) {
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isBattle() { // 0 - Боя нет. 1 - Бой идет. 2 - Бой закончился.
        if (exists("//*[@id=\"battle\"]/div/div/div/div[3]/div[4]/div[2]/div[2]/div[1]/b")) {
            String string = findElement("//*[@id=\"battle\"]/div/div/div/div[3]/div[4]/div[2]/div[2]/div[1]/b").getText();
            int enemyHP = 0;
            if (!string.isEmpty()) {
                enemyHP = Integer.parseInt(string);
            }
            if (enemyHP > 0) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public static void hunterMode(String doing) {
        if (doing.equals("on")) {
            WebElement element = Main.driver.findElement(new By.ByXPath("//*[@id=\"wildBtn\"]/div"));
            String name = element.getAttribute("class");
            element = null;
            if (name.equals("fa fa-paw")) {
                Main.driver.findElement(new By.ByXPath("//*[@id=\"wildBtn\"]/div")).click();
            }
            name = null;
        } else {
            WebElement element = Main.driver.findElement(new By.ByXPath("//*[@id=\"wildBtn\"]/div"));
            String name = element.getAttribute("class");
            element = null;
            if (name.equals("fa fa-paw active")) {
                Main.driver.findElement(new By.ByXPath("//*[@id=\"wildBtn\"]/div")).click();
            }
            name = null;
        }
    }
}

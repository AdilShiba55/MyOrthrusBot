import constants.Buttons;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class GeneralMethods {

    public static WebElement findElement(String xPath) {
        return Main.driver.findElement(new By.ByXPath(xPath));
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
            if(exists(attackODPath)) {
                String string = findElement(attackODPath).getText();
                int count = Integer.parseInt(string.replaceAll("/\\d+\\sОД", ""));
                myPokemon.getMyAttack().getAttackOD()[i] = count;
            }
        }
    }

        public static boolean exists (String xPath){
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
    }

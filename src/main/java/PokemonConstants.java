public class PokemonConstants extends GeneralMethods {
    private static final String MY_POKEMON_NAME = "//*[@id=\"battle\"]/div/div/div/div[3]/div[4]/div[1]/strong/span";
    private static final String MY_POKEMON_LEVEL = "//*[@id=\"battle\"]/div/div/div/div[3]/div[4]/div[1]/strong/small"; //Убрать \\sур.
    private static final String MY_POKEMON_SEX = "//*[@id=\"battle\"]/div/div/div/div[3]/div[4]/div[1]/strong/small/i";
    public static final String MY_HP = "//*[@id=\"battle\"]/div/div/div/div[3]/div[4]/div[1]/div[2]/div[1]";


    public static String getMyName() {
        return findElement(MY_POKEMON_NAME).getText();
    }

    public static int getMyLevel() {
//        return findElement(MY_POKEMON_LEVEL).getText().replaceAll("\\sур.", "");
        return Integer.parseInt(findElement(MY_POKEMON_LEVEL).getText().replaceAll("ур.", ""));
    }

    public static byte getMySex() { // -1 = Самка. 1 = Самец
        String sex = findElement(MY_POKEMON_SEX).getAttribute("class");
        if(sex.equals("fa fa-mars")) {return 1;}
        else {return -1;}
    }

    public static int getMyCurrentHP() {
        if (exists(MY_HP)) {
            String hpString = findElement(MY_HP).getText().replaceAll("/\\d+", "");
            return Integer.parseInt(hpString);
        } else {
            return 0;
        }
    }

    public static int getMyFullHP() {
        if (exists(MY_HP)) {
            String hpString = findElement(MY_HP).getText().replaceAll("\\d+/", "");
            return Integer.parseInt(hpString);
        } else {
            return 0;
        }
    }

    private static final String ENEMY_POKEMON_NAME = "//*[@id=\"battle\"]/div/div/div/div[3]/div[4]/div[2]/strong/span";
    private static final String ENEMY_POKEMON_LEVEL = "//*[@id=\"battle\"]/div/div/div/div[3]/div[4]/div[2]/strong/small"; //Убрать \\sур.
    private static final String ENEMY_POKEMON_SEX = "//*[@id=\"battle\"]/div/div/div/div[3]/div[4]/div[2]/strong/small/i";
    public static final String ENEMY_HP = "//*[@id=\"battle\"]/div/div/div/div[3]/div[4]/div[2]/div[2]/div[1]";

    public static String getEnemyName() {
        return findElement(ENEMY_POKEMON_NAME).getText();
    }

    public static int getEnemyLevel() {
//        return findElement(MY_POKEMON_LEVEL).getText().replaceAll("\\sур.", "");
        return Integer.parseInt(findElement(ENEMY_POKEMON_LEVEL).getText().replaceAll("ур.", ""));
    }

    public static byte getEnemySex() { // -1 = Самка. 1 = Самец
        String sex = findElement(ENEMY_POKEMON_SEX).getAttribute("class");
        if(sex.equals("fa fa-mars")) {return 1;}
        else {return -1;}
    }

    public static int getEnemyCurrentHP() {
        if (exists(ENEMY_HP)) {
            String hpString = findElement(ENEMY_HP).getText().replaceAll("/\\d+", "");
            return Integer.parseInt(hpString);
        } else {
            return 0;
        }
    }

    public static int getEnemyFullHP() {
        if (exists(ENEMY_HP)) {
            String hpString = findElement(ENEMY_HP).getText().replaceAll("\\d+/", "");
            return Integer.parseInt(hpString);
        } else {
            return 0;
        }
    }

}

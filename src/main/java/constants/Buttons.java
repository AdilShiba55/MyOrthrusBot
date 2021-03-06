package constants;

import java.util.HashMap;
import java.util.Map;

public class Buttons {
    public static final String BUTTON_LOGIN = "//*[@id=\"username\"]";
    public static final String BUTTON_PASSWORD = "//*[@id=\"password\"]";
    public static final String BUTTON_ENTER = "//*[@id=\"signin\"]/div[2]/button";
    public static final String BUTTON_PLAY = "//*[@id=\"playbtn\"]";
    public static final String BUTTON_SOUND = "//*[@id=\"soundsBtn\"]/i";

    public static final String MY_CURRENT_LOCATION = "//*[@id=\"map\"]/div[1]/div[1]/span";

    public static final String ATTACK_NAME_PATH = "//*[@id=\"battle\"]/div/div/div/div[4]/div[1]/div[%s]/div/h5";
    public static final String ATTACK_OD_PATH = "//*[@id=\"battle\"]/div/div/div/div[4]/div[1]/div[%s]/div/p";

    public static final String BATTLE_RUN = "//*[@id=\"run-btn\"]";
    public static final String BATTLE_RUN_CONFIRM = "/html/body/form/div[2]/button[2]";
}

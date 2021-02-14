public class Pokemon {
    private String name;
    private int fullHP;
    private int currentHP;
    private byte sex;
    private int level;

    private PokemonAttack myAttack;

    public Pokemon(String name, int fullHP, int currentHP, byte sex, int level, PokemonAttack attack) {
        this.name = name;
        this.fullHP = fullHP;
        this.currentHP = currentHP;
        this.sex = sex;
        this.level = level;

        this.myAttack = attack;
    }

    public Pokemon(String name, int fullHP, int currentHP, byte sex, int level) {
        this.name = name;
        this.fullHP = fullHP;
        this.currentHP = currentHP;
        this.sex = sex;
        this.level = level;
    }

    public PokemonAttack getMyAttack() {
        return myAttack;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFullHP() {
        return fullHP;
    }

    public void setFullHP(int fullHP) {
        this.fullHP = fullHP;
    }

    public int getCurrentHP() {
        return currentHP;
    }

    public void setCurrentHP(int currentHP) {
        this.currentHP = currentHP;
    }

    public byte getSex() {
        return sex;
    }

    public void setSex(byte sex) {
        this.sex = sex;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}

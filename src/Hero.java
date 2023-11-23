public class Hero {
    private int level = 0; //Level this hero begin 0
    private int maximum_HP; //Contain Maximum HP
    private int mana; //Contain Mana
    private final double base_runSpeed = 10; //Base Speed shouldn't change
    private double runSpeed; //Run Speed
    private String name; //Hero name
    private boolean equipSword = false; //This hero equip sword?
    private boolean equipShield = false; //This hero equip shield?
    private double atk = 0; //This hero ATK begin 0. Increase when hero use sword
    private double def = 0; //This hero DEF begin 0. Increase when hero use shield
    private double hp; //Current this hero HP
    private double max_speed; //Max speed when hero unquip sword and shield
    Sword s1; //sword object
    Shield d1;//shield object
    Hero (String name){ //Constructor Create Hero and Assign name maxHP mana maxSpeed hp and notice the user.
        this.name = name;
        maximum_HP = 100;
        mana = 50;
        max_speed = base_runSpeed;
        hp = maximum_HP;
        System.out.println("Create Hero complete hero name: " + this.name + " Maximum HP: "+maximum_HP+" HP "+this.hp+" Mana: "+mana + " Speed: "+base_runSpeed);
    }
    public void level_UP(){ //Method levelUp level up the hero increase maxHP mana maxSpeed RunSpeed hp(recover when level up) and notice user
        level = level+1;
        maximum_HP = 100 + (10*level);
        mana = 50 + (2*level);
        max_speed = base_runSpeed*(1+0.03*level);
        runSpeed = base_runSpeed*(1+0.03*level);
        if(equipShield || equipSword){ //When equip sword or shield runSpeed should decrease although level are increase.
            runSpeed = base_runSpeed - base_runSpeed*(0.1+0.08*level);
        }
        hp = maximum_HP;
        System.out.println("Level Up "+ this.name+ " Level: "+this.level + " Maximum HP: "+this.maximum_HP +" HP "+this.hp+" Mana: "+this.mana+ " Speed: "+this.runSpeed);
    }
    public void Sword_levelUp(){ //Call sword level up and use stat of sword
        s1.sword_levelUp();
        atk = s1.Stat();
    }
    public void Shield_levelUp(){ //Call shield level up and use stat of shield
        d1.shield_levelUp();
        def = d1.Stat();
    }
    public void equipSword(String name){ //Equip sword use the stat and decrease runSpeed
        s1 = new Sword(name);
        atk = s1.Stat();
        runSpeed = base_runSpeed - base_runSpeed*(0.1+0.04*level);
        this.equipSword = true;
        this.equipShield = false;
    }

    public void equipShield(String name){ //Equip shield use the stat and decrease runSpeed
        d1 = new Shield(name);
        def = d1.Stat();
        runSpeed = base_runSpeed - base_runSpeed*(0.1+0.08*level);
        this.equipShield = true;
        this.equipSword = false;
    }

    public double Attack(Hero hero){ //This hero attack another hero and Check when the game end
        if(hero.hp <= 0){
            System.out.println("This round was end please restart a match ");
            return 0;
        }else{
            System.out.println("Hero "+this.name+" ATK "+this.atk + " Attack Hero "+hero.name+" DEF "+hero.def + " HP "+hero.hp);
            if(this.equipSword && hero.equipShield){
                double Total_ATK = this.atk - hero.def;
                if(Total_ATK < 0){
                    return 0;
                }
                System.out.println("Your use sword and "+hero.name + " use shield ATK: "+Total_ATK);
                hero.hp -= Total_ATK;
                System.out.println("Hero "+hero.name+ " HP :"+hero.hp);
                check_HP(hero);
                return atk - hero.def;
            }else if(this.equipSword && !hero.equipShield){
                System.out.println("Your use sword and "+hero.name + " doesn't shield ATK: "+atk);
                System.out.println("ATK: "+this.atk);
                hero.hp = hero.hp - atk;
                System.out.println("Hero "+hero.name+ " HP :"+hero.hp);
                check_HP(hero);
                return atk;
            }else {
                System.out.println("ATK: "+this.atk);
                hero.hp -= 0;
                System.out.println("Hero "+hero.name+ " HP :"+hero.hp);
                check_HP(hero);
                return 0;
            }
        }
    }
    private String check_HP(Hero hero){ //Check HP hero was hit by this Hero
        if(hero.hp <= 0){
            System.out.println("Hero "+hero.name + " died Hero " + this.name + " win!!!");
            return "GAME END";
        }else{
            return "";
        }
    }
    public void unequip(){ //Unquip the shield and sword
        equipSword = false;
        equipShield = false;
        runSpeed = max_speed;
    }
    public void getInfo(){//Show Stat of this hero
        System.out.println("Hero name: "+this.name +" Hero HP: "+this.hp+" Hero ATK: "+this.atk + " Hero DEF: "+this.def + " Hero Speed :"+this.runSpeed);
    }
}

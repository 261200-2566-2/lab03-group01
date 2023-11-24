public class Shield {
    private String name; //Contain hero name
    private final double base_def = 10; //Base DEF of this shield
    private double shield_def; //Current DEF of this shield
    private int shield_level = 0; //Current shield level
    Shield(String name){ //Create shield object and notice to user about this shield
        this.name = name;
        shield_def = base_def;
        System.out.println("Equip shield name: "+this.name + " Shield DEF: "+this.shield_def);
    }
    public void shield_levelUp(){ //Level up this shield and tell the user about this shield
        shield_level +=1;
        shield_def = base_def*(1+0.05*shield_level);
        System.out.println("Your shield is level up "+this.name + " Shield level: "+this.shield_level+" Shield DEF: "+this.shield_def);
    }

    public double Stat(){ //Give the stat to Hero class
        return shield_def;
    }
}

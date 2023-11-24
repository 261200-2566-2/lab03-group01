public class Sword {
    private String name; //Contain name of Object
    private int Sword_level = 0; //Current sword level
    private final double base_atk = 10; //Base ATK in this sword
    private double sword_atk;//Current ATK in this sword

    Sword(String name){ //Create sword object and notice the user about this object
        this.name = name;
        sword_atk = base_atk;
        System.out.println("Equip sword name: "+this.name + " Sword ATK: "+this.sword_atk);
    }

    public void sword_levelUp(){ //Level up the sword and tell the stat to user
        Sword_level +=1;
        sword_atk = base_atk*(1+0.1*Sword_level);
        System.out.println("Your sword is level up "+this.name + " Sword level: "+this.Sword_level+" Sword ATK: "+this.sword_atk);
    }

    public double Stat(){ //Give the stat to class hero
        return sword_atk;
    }
}

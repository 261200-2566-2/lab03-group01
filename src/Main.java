// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Hero h1 = new Hero("A"); //Create Object Hero name A
        Hero h2 = new Hero("B"); //Create Object Hero name B
        h1.equipSword("ThepMorana"); //Hero A equip sword name "ThepMorana"
        h1.level_UP(); //Hero A level Up
        h1.getInfo(); //Show information about hero A
        h2.equipShield("Captain Shield"); //Hero B equip shield name "Captain Shield"
        h2.getInfo();//Show information about hero B
        h1.Attack(h2); //Hero A use sword attack Hero B use shield
        h1.Sword_levelUp(); //Hero A enhance the sword
        h1.Attack(h2); //Hero A use sword attack Hero B use shield
        h2.equipSword("Beach"); //Hero B change shield to sword name "Beach"
        h2.Attack(h1); //Hero B use sword attack Hero A use sword
        h1.Attack(h2); //Hero A use sword attack Hero B use sword
        h1.Attack(h2); //Hero A use sword attack Hero B use sword
        h1.Attack(h2); //Hero A use sword attack Hero B use sword
        h1.Attack(h2); //Hero A use sword attack Hero B use sword
        h1.Attack(h2); //Hero A use sword attack Hero B use sword
        h1.Attack(h2); //Hero A use sword attack Hero B use sword
        h1.Attack(h2); //Hero A use sword attack Hero B use sword
        h1.Attack(h2); //Hero A use sword attack Hero B use sword
        h2.unequip(); //Hero B unequip sword
        h2.getInfo(); //Get information about hero B
        h1.Attack(h2); //Hero A use sword attack Hero B use sword
        h1.Attack(h2); //Hero A use sword attack Hero B use sword
    }
}
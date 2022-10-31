import java.util.ArrayList;
public class ThingTester {

    public static void main(String[] args) {
        Cat cT = new Cat("Tabby", 176.2f, 3.5f);
        Cat c2 = new Cat("Tabby", 176.5f, 3.2f);
        Dog dG = new Dog("Golden Retriever", 200.75f, 5.0f);
        Octopus billy = new Octopus("Atlantic", 990.2f, 2.3f);
        Fish fG = new Fish("Goldfish", 90.75f, 1.0f);
        ArrayList<Pet> pets = new ArrayList<Pet>();
        pets.add(cT);
        pets.add(dG);
        pets.add(billy);
        pets.add(fG);
        for(Pet pet : pets) {
            System.out.println(pet.toString());
        }
        System.out.print(cT.equals(c2));
    }

}

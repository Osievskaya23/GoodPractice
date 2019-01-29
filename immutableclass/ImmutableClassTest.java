package immutableclass;

public class ImmutableClassTest {
    public static void main(String[] args) throws CloneNotSupportedException{
        ImmutableAnimal cat = new ImmutableAnimal("Cat", 3, new Family("father Cat", "mother Cat"));
        System.out.println("Cat before changing family:" +
                "cat name = " + cat.getName() + ";\n" +
                "cat age = " + cat.getAge() + ";\n" +
                "cat's father = " + cat.getFamily().getFather() + ";\n" +
                "cat's mother = " + cat.getFamily().getMother() + ";");
        cat.getFamily().setFather("father Dog");
        cat.getFamily().setMother("mother Dog");
        System.out.println("\nCat after changing family:" +
                "cat name = " + cat.getName() + ";\n" +
                "cat age = " + cat.getAge() + ";\n" +
                "cat's father = " + cat.getFamily().getFather() + ";\n" +
                "cat's mother = " + cat.getFamily().getMother() + ";");
    }
}
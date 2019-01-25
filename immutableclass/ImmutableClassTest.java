package immutableclass;

public class ImmutableClassTest {
    public static void main(String[] args) {
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

final class ImmutableAnimal {

    private final String name;
    private final int age;
    private final Family family;

    ImmutableAnimal(String name, int age, Family family) {
        this.name = name;
        this.age = age;
        //this.family = family;
        Family familyClone = new Family(family.getFather(), family.getMother());
        this.family = familyClone;
    }

    String getName() {
        return name;
    }

    int getAge() {
        return age;
    }

    Family getFamily() {
        //return family;
        return new Family(this.family.getFather(), this.family.getMother());
    }
}

class Family {

    private String father;
    private String mother;

    Family(String father, String mother) {
        this.father = father;
        this.mother = mother;
    }

    String getFather() {
        return father;
    }

    void setFather(String father) {
        this.father = father;
    }

    String getMother() {
        return mother;
    }

    void setMother(String mother) {
        this.mother = mother;
    }
}
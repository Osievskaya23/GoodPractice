package immutableclass;

public final class ImmutableAnimal {

    private final String name;
    private final int age;
    private final Family family;

    public ImmutableAnimal(String name, int age, Family family) {
        this.name = name;
        this.age = age;
        //this.family = family;
        Family familyClone = new Family(family.getFather(), family.getMother());
        this.family = familyClone;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Family getFamily() {
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
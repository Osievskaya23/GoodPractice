package immutableclass;

public final class ImmutableAnimal {

    private final String name;
    private final int age;
    private final Family family;

    ImmutableAnimal(String name, int age, Family family) throws CloneNotSupportedException{
        this.name = name;
        this.age = age;
        this.family = family.clone();
    }

    String getName() {
        return name;
    }

    int getAge() {
        return age;
    }

    Family getFamily() throws CloneNotSupportedException{
        return family.clone();
    }
}

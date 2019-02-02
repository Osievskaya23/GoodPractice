package immutableclass;

public final class ImmutableAnimal {

    private final String name;
    private final int age;
    private final Family family;

    public ImmutableAnimal(String name, int age, Family family) throws CloneNotSupportedException{
        this.name = name;
        this.age = age;
        this.family = family.clone();
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Family getFamily() throws CloneNotSupportedException{
        return family.clone();
    }
}

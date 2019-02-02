package immutableclass;

public class Family implements Cloneable{

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

    @Override
    protected Family clone() throws CloneNotSupportedException {
        return (Family)super.clone();
    }
}

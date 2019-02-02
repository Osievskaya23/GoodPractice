package immutableclass;

public class Family implements Cloneable{

    private String father;
    private String mother;

    public Family(String father, String mother) {
        this.father = father;
        this.mother = mother;
    }

    public String getFather() {
        return father;
    }

    public void setFather(String father) {
        this.father = father;
    }

    public String getMother() {
        return mother;
    }

    public void setMother(String mother) {
        this.mother = mother;
    }

    @Override
    protected Family clone() throws CloneNotSupportedException {
        return (Family)super.clone();
    }
}

package patterns.composite;

import java.util.ArrayList;
import java.util.List;

class Team {
    private List<Developer> developers = new ArrayList<>();

    void addDeveloper(Developer developer) {
        developers.add(developer);
    }

    void removeDeveloper(Developer developer) {
        developers.remove(developer);
    }

    void createProject() {
        System.out.println("Team creates project...\n");
        for(Developer developer : developers) {
            developer.writeCode();
        }
    }
}

package com.serialization;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Group {
    private String name;
    private List<Figure> figures = new ArrayList<>();
    private List<Group> groups = new ArrayList<>();

    public Group(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Figure> getFigures() {
        return figures;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void addFigures(Figure ... neadAddingFigures) {
        figures.addAll(Arrays.asList(neadAddingFigures));
    }

    public void addGroups(Group ... neadAddGroups) {
        groups.addAll(Arrays.asList(neadAddGroups));
    }

    public void getFigureSquares() {
        System.out.print("This group figure squares: \n");
        System.out.println(name + ": \n");
        for (Figure figure : figures) {
            System.out.println("\t" + figure.getName() + " square = " + figure.getSquare());
        }
        System.out.print("\nInternal groups figure squares: ");
        for (Group group : groups) {
            System.out.println("\n" + group.getName() + ":\n");
            for (Figure figure : group.getFigures()) {
                System.out.println("\t" + figure.getName() + " square = " + figure.getSquare());
            }
        }
    }
}

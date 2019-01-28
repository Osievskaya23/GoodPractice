package serialization.encoder;

import serialization.Figure;
import serialization.Group;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;

public class JSONEncoder {
    public void writeToJSON(File file, Group group) {
        Class clazz = group.getClass();
        StringBuilder groupToXML = serializeToJSON(group, clazz, 0);

        try(FileWriter fileWriter = new FileWriter(file)) {
            fileWriter.write(groupToXML.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private StringBuilder serializeToJSON(Group group, Class clazz, int tabs) {
        StringBuilder string = new StringBuilder();
        string.append(getTabs(tabs));
        string.append("{\n");
        string.append(serializeGroupFieldsToJSON(group, clazz, tabs + 1));
        string.append(getTabs(tabs));
        string.append("}\n");
        return string;
    }

    private StringBuilder serializeGroupFieldsToJSON(Group group, Class clazz, int tabs) {
        StringBuilder string = new StringBuilder();
        Field[] fields = clazz.getDeclaredFields();
        for (Field f : fields) {
            string.append(getGroupFieldLine(group, clazz, f.getName(), tabs));
        }
        return string;
    }

    private StringBuilder serializeFigureFieldsToJSON(Figure figure, Class clazz, int tabs) {
        StringBuilder string = new StringBuilder();
        Field[] fields = clazz.getFields();
        string.append(getTabs(tabs));
        string.append("{\n");
        string.append(getTabs(tabs + 1));
        string.append(getFigureFieldLine(fields[0].getName(), figure.getName()));
        string.append(getTabs(tabs + 1));
        string.append(getFigureFieldLine(fields[1].getName(), Double.toString(figure.getSquare())));
        string.deleteCharAt(string.length() - 2);
        string.append(getTabs(tabs));
        string.append("},\n");
        return string;
    }

    private StringBuilder getFigureFieldLine(String fieldName, String fieldValue) {
        StringBuilder string = new StringBuilder();
        string.append("\"");
        string.append(fieldName);
        string.append("\":\"");
        string.append(fieldValue);
        string.append("\",\n");
        return string;
    }

    private StringBuilder getGroupFieldLine(Group group, Class clazz, String fieldName, int tabs) {
        StringBuilder string = new StringBuilder();
        switch (fieldName) {
            case "name":
                string.append(getNameFieldLine(group, tabs));
                return string;
            case "figures":
                string.append(getFigureListItemsLine(group, tabs));
                return string;
            case "groups":
                string.append(getGroupListItemsLine(group, tabs));
                return string;
        }
        return string;
    }

    private StringBuilder getNameFieldLine(Group group, int tabs) {
        StringBuilder string = new StringBuilder();
        string.append(getTabs(tabs));
        string.append("\"name\":\"");
        string.append(group.getName());
        string.append("\",\n");
        return string;
    }

    private StringBuilder getFigureListItemsLine(Group group, int tabs) {
        StringBuilder string = new StringBuilder();
        string.append(getTabs(tabs));
        string.append("\"figures\":[\n");
        for (Figure figure : group.getFigures()) {
            string.append(serializeFigureFieldsToJSON(figure, figure.getClass(), tabs + 2));
        }
        string.deleteCharAt(string.length() - 2);
        string.append(getTabs(tabs + 1));
        string.append("],\n");
        return string;
    }

    private StringBuilder getGroupListItemsLine(Group group, int tabs) {
        StringBuilder string = new StringBuilder();
        string.append(getTabs(tabs));
        string.append("\"groups\":[\n");
        for (Group g : group.getGroups()) {
            string.append(serializeToJSON(g, g.getClass(), tabs + 2));
        }
        //string.deleteCharAt(string.length() - 3);
        string.append(getTabs(tabs + 1));
        string.append("]\n");
        return string;
    }

    private StringBuilder getTabs(int tabs) {
        StringBuilder tab = new StringBuilder();
        while (tabs != 0) {
            tab.append("\t");
            tabs--;
        }
        return tab;
    }
}
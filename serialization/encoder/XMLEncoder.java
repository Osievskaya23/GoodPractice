package serialization.encoder;

import serialization.Figure;
import serialization.Group;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.List;

public class XMLEncoder {
    public void writeToXML(File file, Group group) throws IllegalAccessException{
        Class clazz = group.getClass();
        StringBuilder groupToXML = serializeToXML(group, clazz, 1);

        try(FileWriter fileWriter = new FileWriter(file)) {
            fileWriter.write(groupToXML.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private StringBuilder serializeToXML(Group group, Class clazz, int tabs) throws IllegalAccessException{
        StringBuilder string = new StringBuilder();
        string.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
        string.append(getGroupXMLCode(group, clazz, tabs));
        return string;
    }

    private StringBuilder getGroupXMLCode(Group group, Class clazz, int tabs) throws IllegalAccessException{
        StringBuilder string = new StringBuilder();
        string.append(getOpenClassName(clazz, tabs));
        string.append(getGroupFieldsLine(group, clazz, tabs + 1));
        string.append(getCloseClassName(clazz, tabs));
        return string;
    }

    private StringBuilder getCloseClassName(Class clazz, int tabs) {
        StringBuilder string = new StringBuilder();
        string.append(getTabs(tabs));
        string.append("</");
        string.append(clazz.getSimpleName().toLowerCase());
        string.append( ">\n");
        return string;
    }

    private StringBuilder getOpenClassName(Class clazz, int tabs) {
        StringBuilder string = new StringBuilder();
        string.append(getTabs(tabs));
        string.append("<");
        string.append(clazz.getSimpleName().toLowerCase());
        string.append( ">\n");
        return string;
    }

    private StringBuilder getFigureListObjectItemsToXML(Group group, int tabs) throws IllegalAccessException {
        List<Figure> figures = group.getFigures();
        StringBuilder string = new StringBuilder();
        for (Figure figure : figures) {
            Class clazz = figure.getClass();
            string.append(getOpenClassName(clazz, tabs));
            string.append(getFigureFieldsLine(figure, clazz, tabs + 1));
            string.append(getCloseClassName(clazz, tabs));
        }
        return string;
    }

    private StringBuilder getFigureFieldsLine(Figure figure, Class clazz, int tabs) throws IllegalAccessException{
        StringBuilder string = new StringBuilder();
        Field[] fields = clazz.getDeclaredFields();
        for (Field f : fields) {
            f.setAccessible(true);
            string.append(getOpenFieldName(f, tabs));
            string.append(f.get(figure));
            string.append(getCloseFieldName(f, tabs));
        }
        return string;
    }

    private StringBuilder getCloseFieldName(Field field, int tabs) {
        StringBuilder string = new StringBuilder();
        string.append("</");
        string.append(field.getName());
        string.append(">\n");
        return string;
    }

    private StringBuilder getOpenFieldName(Field field, int tabs) {
        StringBuilder string = new StringBuilder();
        string.append(getTabs(tabs));
        string.append("<");
        string.append(field.getName());
        string.append(">");
        return string;
    }

    private StringBuilder getGroupListObjectItemsToXML(Group group, Class clazz, int tabs) throws IllegalAccessException{
        List<Group> groups = group.getGroups();
        StringBuilder string = new StringBuilder();
        for (Group g : groups) {
            string.append(getGroupXMLCode(g, clazz, tabs));
        }
        return string;
    }

    private StringBuilder getGroupFieldsLine(Group group, Class clazz, int tabs) throws IllegalAccessException{
        StringBuilder string = new StringBuilder();
        Field[] fields = clazz.getDeclaredFields();
        for (Field f : fields) {
            f.setAccessible(true);
            string.append(getOpenFieldName(f, tabs));
            string.append(getFieldObjectValue(group, clazz, f, f.getName(), tabs + 1));
            string.append(getCloseFieldName(f, tabs));
        }
        return string;
    }

    private StringBuilder getFieldObjectValue(Group group, Class clazz, Field field, String fieldName, int tabs) throws IllegalAccessException{
        StringBuilder string = new StringBuilder();
        switch (fieldName) {
            case "name" :
                return string.append(field.get(group));
            case "figures":
                string.append("\n");
                string.append(getFigureListObjectItemsToXML(group, tabs));
                string.append(getTabs(tabs - 1));
                return string;
            case "groups":
                string.append("\n");
                string.append(getGroupListObjectItemsToXML(group, clazz, tabs));
                string.append(getTabs(tabs - 1));
                return string;
        }
        return string;
    }

    private StringBuilder getTabs(int tabs) {
        StringBuilder tab = new StringBuilder();
        while (tabs != 0) {
            tab.append("    ");
            tabs--;
        }
        return tab;
    }
}

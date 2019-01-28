package serialization.encoder;

import static java.lang.System.identityHashCode;

import serialization.Figure;
import serialization.Group;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

public class XMLEncoder {
    public void writeToXML(File file, Group group) {
        Class clazz = group.getClass();
        StringBuilder groupToXML = serializeToXML(group, clazz, 1);

        try(FileWriter fileWriter = new FileWriter(file)) {
            fileWriter.write(groupToXML.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private StringBuilder serializeToXML(Group group, Class clazz, int tabs) {
        StringBuilder string = new StringBuilder();
        string.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
        string.append(getClassHeader(clazz));
        string.append(getGroupXMLCode(group, clazz, tabs));
        string.append("</java>\n");
        return string;
    }

    private StringBuilder getGroupXMLCode(Group group, Class clazz, int tabs) {
        StringBuilder string = new StringBuilder();

        string.append(getObjectClassLine(clazz, tabs));

        string.append(getObjectFieldsLine(group, clazz, tabs + 1));
        string.append(getObjectMethodLine(clazz, tabs + 1));

        string.append(getTabs(tabs));
        string.append("</object>\n");
        return string;
    }

    private StringBuilder getObjectMethodLine(Class clazz, int tabs) {
        StringBuilder string = new StringBuilder();
        Method[] methods = clazz.getDeclaredMethods();
        for (Method m : methods) {
            string.append(getMethodPropertyLine(clazz, m, tabs));
        }
        return string;
    }

    private StringBuilder getMethodPropertyLine(Class clazz, Method m, int tabs) {
        StringBuilder string = new StringBuilder();
        string.append(getTabs(tabs));
        string.append("<void method=\"");
        string.append(m.getName());

        string.append("\"> </void>\n");
        return string;
    }

    private StringBuilder getFigureListObjectItemsToXML(Group group, int tabs) {
        List<Figure> figures = group.getFigures();
        StringBuilder string = new StringBuilder();
        for (Figure figure : figures) {
            Class clazz = figure.getClass();
            string.append(getObjectClassLine(clazz, tabs));
            string.append(getObjectFieldsLine(group, clazz, tabs + 1));
            string.append(getObjectMethodLine(clazz, tabs + 1));
            string.append(getTabs(tabs));
            string.append("</object>\n");
        }
        return string;
    }

    private StringBuilder getGroupListObjectItemsToXML(Group group, Class clazz, int tabs) {
        List<Group> groups = group.getGroups();
        StringBuilder string = new StringBuilder();
        for (Group g : groups) {
            string.append(getGroupXMLCode(g, clazz, tabs));
        }
        return string;
    }

    private StringBuilder getObjectFieldsLine(Group group, Class clazz, int tabs) {
        StringBuilder string = new StringBuilder();
        Field[] fields = clazz.getDeclaredFields();
        for (Field f : fields) {
            string.append(getPropertyNameLine(f, tabs));
            string.append(getPropertyValueLine(f, tabs + 1));
            string.append(getFieldObjectValue(group, clazz, f.getName(), tabs + 2));
            string.append(getTabs(tabs));
            string.append("</void>\n");
        }
        return string;
    }

    private StringBuilder getFieldObjectValue(Group group, Class clazz, String fieldName, int tabs) {
        StringBuilder string = new StringBuilder();
        switch (fieldName) {
            case "figures":
                string.append(getFigureListObjectItemsToXML(group, tabs));
                return string;
            case "groups":
                string.append(getGroupListObjectItemsToXML(group, clazz, tabs));
                return string;
        }
        return string;
    }

    private StringBuilder getPropertyValueLine(Field f, int tabs) {
        StringBuilder string = new StringBuilder();
        string.append(getTabs(tabs));
        string.append("<");
        string.append(f.getType().getSimpleName().toLowerCase());
        string.append(">");
        string.append("VALUE");
        string.append("</");
        string.append(f.getType().getSimpleName().toLowerCase());
        string.append(">\n");
        return string;
    }

    private StringBuilder getPropertyNameLine(Field f, int tabs) {
        StringBuilder string = new StringBuilder();
        string.append(getTabs(tabs));
        string.append("<void property=\"");
        string.append(f.getName());
        string.append("\">\n");
        return string;
    }

    private StringBuilder getObjectClassLine(Class clazz, int tabs) {
        StringBuilder string = new StringBuilder();
        string.append(getTabs(tabs));
        string.append("<object class=\"");
        string.append(clazz.getSimpleName());
        string.append("\" id=\"");
        string.append(identityHashCode(clazz));
        string.append( "\">\n");
        return string;
    }

    private StringBuilder getClassHeader(Class clazz) {
        StringBuilder string = new StringBuilder();
        string.append("<java version=\"10.0.2\" class=\"");
        string.append(clazz.getName());
        string.append("\">\n");
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

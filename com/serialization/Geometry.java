package com.serialization;

import com.serialization.encoder.JsonEncoder;
import com.serialization.encoder.XmlEncoder;

import java.io.File;

public class Geometry {
    private final static String PATH_XML = "C:\\Users\\38066\\IdeaProjects\\GoodPractice\\src\\files\\group.xml";
    private final static String PATH_JSON = "C:\\Users\\38066\\IdeaProjects\\GoodPractice\\src\\files\\group.json";

    public static void main(String[] args) throws IllegalAccessException{
        Group firstGroup = new Group("Group_1");
        Group secondGroup = new Group("Group_2");

        Figure firstTriangle = new Triangle("Triangle_1",3, 4, 5);
        Figure secondTriangle = new Triangle("Triangle_2", 4, 4, 4);

        Figure firstCircle = new Circle("Circle_1", 5);

        Figure firstSquare = new Square("Square_1", 2);
        Figure secondSquare = new Square("Square_2", 4);
        Figure thirdSquare = new Square("Square_3", 6);

        firstGroup.addFigures(firstTriangle, firstCircle, firstSquare);

        secondGroup.addFigures(secondTriangle, secondSquare, thirdSquare);
        secondGroup.addGroups(firstGroup);

        secondGroup.getFigureSquares();

        XmlEncoder xmlEncoder = new XmlEncoder();
        File secondGroupXMLFile = new File(PATH_XML);

        xmlEncoder.writeToXML(secondGroupXMLFile, secondGroup);

        JsonEncoder jsonEncoder = new JsonEncoder();
        File secondGroupJSONFile = new File(PATH_JSON);

        jsonEncoder.writeToJSON(secondGroupJSONFile, secondGroup);
    }
}

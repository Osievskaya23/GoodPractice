package serialization;

import serialization.encoder.JSONEncoder;
import serialization.encoder.XMLEncoder;

import java.io.File;

public class Geometry {
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

        XMLEncoder xmlEncoder = new XMLEncoder();
        String xmlFilePath = "C:\\Users\\38066\\IdeaProjects\\GoodPractice\\src\\files\\group.xml";
        File secondGroupXMLFile = new File(xmlFilePath);

        xmlEncoder.writeToXML(secondGroupXMLFile, secondGroup);

        JSONEncoder jsonEncoder = new JSONEncoder();
        String jsonFilePath = "C:\\Users\\38066\\IdeaProjects\\GoodPractice\\src\\files\\group.json";
        File secondGroupJSONFile = new File(jsonFilePath);

        jsonEncoder.writeToJSON(secondGroupJSONFile, secondGroup);
    }
}

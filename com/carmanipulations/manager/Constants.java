package com.carmanipulations.manager;

public class Constants {
    private static String CHANGES_LIST_TITLE = "\n=================  CAR INFORMATION  ===================";
    public static String CAR_INFORMATION_TITLE = "=================  CAR INFORMATION  ===================";
    public static String DOWN_LINE = "\n========================================================";
    public static String WELCOME_MESSAGE = "\nHello! In this game you can perform your first " +
            "driving.And I will help you with it.\nFirst of all, you have to create your " +
            "own car. Let's do it together.\n";
    public static String CAR_CREATING_MESSAGE = "\nOk, it's time to create your new car. If " +
            "you wont to get default car, enter \"default\",\nbut if you wont to create new " +
            "one, enter \"new\".";
    public static String CHECK_CAR_BEFORE_DRIVING = "\nSplendid! Now you have you own car! but " +
            "before your first driving you have to check everything.\n";
    public static String DRIVING = "Good! It's for driving. You can use this to do list:\n" +
            "1. Open the door\n2. Close the door\n3. Open the window\n4. Close the window\n" +
            "5. Open the door if it's open and close if it's open\n6. Open the window if " +
            "it's open and close if it's open\n7. To know is the door closed\n8. To know is " +
            "the window closed";
    public static String STOP_MESSAGE = "Enter \"stop\" to stop";
    static String ENTER_CAR_PARAMETERS = "\nEnter parameters in such sequence:\ndate of manufacture " +
            "(dd/mm/yyyy), engines type, max speed (kph), acceleration time, passengers capacity.";
    static String ENTER_CAR_DATE_OF_MANUFACTURE = "\nEnter date of manufacture in such way: " +
            "(dd/mm/yyyy).";
    static String GET_CHANGES = "\nIf you want to change something, enter \"need changes\", " +
            "case not, enter \"ok\".";
    static String CHANGES_LIST = "\nEnter parameter, you want to change.If changes are not needed " +
            "enter \"ok\"\n" + CHANGES_LIST_TITLE + "\n1. Change current speed\n2. Add passenger\n" +
            "3. Remove passenger\n4. Remove all passengers\n5. Take off all wheels\n6. Change wheel\n" +
            "7. Wipe wheel\n8. Calculate current possible mas speed\n9. Show car information" + DOWN_LINE;
}

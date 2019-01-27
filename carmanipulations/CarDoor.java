package carmanipulations;

public class CarDoor {
    private boolean doorStatus;
    private boolean windowStatus;

    // open = true
    // close = false
    public CarDoor() {
        this.doorStatus = false;
        this.windowStatus = false;
    }

    public CarDoor(boolean doorStatus, boolean windowStatus) {
        this.doorStatus = doorStatus;
        this.windowStatus = windowStatus;
    }

    public void openDoor() {
        doorStatus = true;
    }

    public void closeDoor() {
        doorStatus = false;
    }

    public void openCloseDoor() {
        doorStatus = !doorStatus;
    }

    public void openWindow() {
        windowStatus = true;
    }

    public void closeWindow() {
        windowStatus = false;
    }

    public void openCloseWindow() {
        windowStatus = !windowStatus;
    }

    public void getDoorStatus() {
        if (doorStatus)
            System.out.println("The door is open.");
        else
            System.out.println("The door is closed.");
    }

    public void getWindowStatus() {
        if (windowStatus)
            System.out.println("The window is open.");
        else
            System.out.println("The window is closed.");
    }
}

package carmanipulations;

public class CarWheel {
    private double integrityStatus;

    public CarWheel() {
        this.integrityStatus = 1;
    }

    public CarWheel(double integrityStatus) {
        this.integrityStatus = integrityStatus;
    }

    public void changeWheel() {
        integrityStatus = 1;
        System.out.println("Wheel was changed on new.");
    }

    public void wipeWheel(double percent) {
        integrityStatus -= integrityStatus * percent;
        showInfo();
    }

    public double getIntegrityStatus() {
        return integrityStatus;
    }

    public String showInfo() {
        return "integrity status = " + getIntegrityStatus();
    }
}

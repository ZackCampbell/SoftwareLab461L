package command;

public class VibrationMotor {
    private volatile static VibrationMotor uniqueInstance;

    public VibrationMotor() {
    }

    public static VibrationMotor getInstance() {
        if (uniqueInstance == null) {
            synchronized (Console.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new VibrationMotor();
                }
            }
        }
        return uniqueInstance;
    }

    public void vibrate() {
	    System.out.println("Motor VIBRATE");
    }
}
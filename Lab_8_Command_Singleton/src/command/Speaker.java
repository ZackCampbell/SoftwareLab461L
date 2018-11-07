package command;

public class Speaker {
    private volatile static Speaker uniqueInstance;

    public Speaker() {
    }

    public static Speaker getInstance() {
        if (uniqueInstance == null) {
            synchronized (Console.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new Speaker();
                }
            }
        }
        return uniqueInstance;
    }

    public void beep() {
	    System.out.println("Speaker BEEP!");
    }
}
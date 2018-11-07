package command;

public class Console {
    private volatile static Console uniqueInstance;
    public Console(){
    }

    public static Console getInstance() {
        if (uniqueInstance == null) {
            synchronized (Console.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new Console();
                }
            }
        }
        return uniqueInstance;
    }

    public static void print(String toPrint){
        System.out.println(toPrint);
    }
}
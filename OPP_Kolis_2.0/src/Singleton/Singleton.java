package Singleton;

public class Singleton {
    private static Singleton instance = null;

    private Singleton()
    {
        System.out.println("Initiating singleton");
    }

    public static synchronized Singleton getInstance()
    {
        if(instance == null)
            instance = new Singleton();

        return instance;
    }
}

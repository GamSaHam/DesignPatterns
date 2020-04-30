package block;

import java.io.File;
import java.io.IOException;

public class StaticBlockSingleton {

    private StaticBlockSingleton() throws IOException{
        System.out.println("Singleton is initializing");
       // File.createTempFile(".", ".");
    }

    private static StaticBlockSingleton instance;

    static{

        try{
            instance = new StaticBlockSingleton();
        }catch (Exception e){
            System.out.println("failed to create singleton");
        }
    }

    public static StaticBlockSingleton getInstance(){
        return instance;
    }
}


class Demo{

    public static void main(String[] args) {
        StaticBlockSingleton instance = StaticBlockSingleton.getInstance();
        StaticBlockSingleton instance2 = StaticBlockSingleton.getInstance();

    }

}

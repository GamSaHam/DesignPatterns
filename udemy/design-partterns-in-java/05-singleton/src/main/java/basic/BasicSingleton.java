package basic;

import lombok.Data;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

@Data
public class BasicSingleton {

    private BasicSingleton(){


    }

    private static final BasicSingleton INSTANCE = new BasicSingleton();

    public static BasicSingleton getInstance(){
        return INSTANCE;
    }


    private int value = 0;


}



class Demo{

    static void saveToFile(BasicSingleton singleton, String fileName) throws  Exception{

        try(FileOutputStream fileOut = new FileOutputStream(fileName);
            ObjectOutputStream out = new ObjectOutputStream(fileOut)){

            out.writeObject(singleton);
        }
    }

    public static void main(String[] args) {

        BasicSingleton singleton = BasicSingleton.getInstance();
        singleton.setValue(123);

        System.out.println(singleton.getValue());

        // 1. reflection

        // 2. serialization

        //


    }

}



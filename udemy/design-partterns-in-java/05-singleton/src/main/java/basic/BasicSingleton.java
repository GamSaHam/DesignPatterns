package basic;

import lombok.Data;

import java.io.*;

@Data
public class BasicSingleton implements Serializable {

    private BasicSingleton() {
    }

    private static final BasicSingleton INSTANCE = new BasicSingleton();

    public static BasicSingleton getInstance() {
        return INSTANCE;
    }

    private int value = 0;

    protected Object readResolve(){
        return INSTANCE;
    }

}


class Demo {

    static void saveToFile(BasicSingleton singleton, String fileName) throws Exception {

        try (FileOutputStream fileOut = new FileOutputStream(fileName);
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(singleton);
        }

    }

    static BasicSingleton readFromFile(String fileName) throws Exception {
        try (
                FileInputStream fileIn = new FileInputStream(fileName);
                ObjectInputStream in = new ObjectInputStream(fileIn)
        ) {
            return (BasicSingleton) in.readObject();

        }
    }

    public static void main(String[] args) throws Exception {

        BasicSingleton singleton = BasicSingleton.getInstance();
        singleton.setValue(111);

        String fileName = "singleton.bin";
        saveToFile(singleton, fileName);

        singleton.setValue(222);

        BasicSingleton singleton2 = readFromFile(fileName);

        System.out.println(singleton == singleton2);
        System.out.println(singleton.getValue());
        System.out.println(singleton2.getValue());

    }

}



package srp;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Single Responsibility Principle
 * 각각 함수, 클래스, 컴포넌트는 한가지의 기능만 수행하도록 개발되어야 한다.
 */
public class Journal {
    private List<String> entries = new ArrayList<>();

    private int count = 0;


    public void addEntry(String text){
        entries.add("" + (++count) + ": " + text);
    }

    public void removeEntry(int index){
        entries.remove(index);
    }

    @Override
    public String toString() {
        return String.join(System.lineSeparator(), entries);
    }

    public void save(String fileName) throws FileNotFoundException {
        try (PrintStream out = new PrintStream(fileName)){
            out.println(toString());
        }
    }

    public void load(String fileName){

    }

    public void load(URL url){


    }


    public static void main(String[] args) throws IOException {
        Journal j = new Journal();
        j.addEntry("I cried today");
        j.addEntry("I ate a bug");

        System.out.println(j);

        Persistence p = new Persistence();
        String fileName = "c:\\temp\\journal.txt";

        p.saveToFile(j, fileName, true);

        Runtime.getRuntime().exec("notepad.exe " + fileName);

    }

}


class Persistence{
    public void saveToFile(Journal journal, String fileName, boolean overwrite) throws FileNotFoundException {
        if(overwrite || new File(fileName).exists()){

            try (PrintStream out = new PrintStream(fileName)){
                out.println(journal.toString());
            }
        }
    }

    public Journal load(String fileName){
        return null;
    }

    public Journal load(URL fileName){
        return null;
    }
}

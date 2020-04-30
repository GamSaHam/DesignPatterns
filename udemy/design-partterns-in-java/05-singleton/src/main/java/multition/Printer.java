package multition;




import java.util.HashMap;

enum SubSystem{
    PRIMARY,
    AUXILIARY,
    FALLBACK
}

public class Printer {

    private static int instanceCount = 0;

    private Printer(){

        instanceCount++;

        System.out.println("A total of " + instanceCount + " instances created so fat.");

    }

    private static HashMap<SubSystem, Printer> instances = new HashMap<>();

    public static Printer get(SubSystem ss){

        if(instances.containsKey(ss)){
            return instances.get(ss);
        }

        Printer printer = new Printer();
        instances.put(ss, printer);

        return printer;
    }

}



class Multion{

    public static void main(String[] args) {

        Printer main = Printer.get(SubSystem.PRIMARY);

        Printer aux = Printer.get(SubSystem.AUXILIARY);
        Printer aux2 = Printer.get(SubSystem.AUXILIARY);


    }

}
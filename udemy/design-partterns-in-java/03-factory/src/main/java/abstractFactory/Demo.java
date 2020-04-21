package abstractFactory;


import javafx.util.Pair;
import org.reflections.Reflections;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

interface HotDrink {
    void consume();
}

interface HotDrinkFactory {
    HotDrink prepare(int amount);
}

class Tea implements HotDrink {

    @Override
    public void consume() {
        System.out.println("This tea is delicious");
    }
}

class Coffee implements HotDrink {


    @Override
    public void consume() {
        System.out.println("This coffee is delicious");
    }
}

class TeaFactory implements HotDrinkFactory {

    @Override
    public HotDrink prepare(int amount) {
        System.out.println("Put in tea bag, boil water, pour " + amount
                + "ml, add lemon, enjoy!");

        return new Tea();
    }
}


class CoffeeFactory implements HotDrinkFactory {


    @Override
    public HotDrink prepare(int amount) {
        System.out.println("Grind some beans, boil water, pout"
                + amount + "ml, add cream and sugar, enjoy!");
        return new Coffee();
    }
}

class HotDrinkMachine {

    private List<Pair<String, HotDrinkFactory>> namedFactories = new ArrayList<>();

    public HotDrinkMachine() throws Exception {

        Set<Class<? extends HotDrinkFactory>> types = new Reflections("").getSubTypesOf(HotDrinkFactory.class);

        for (Class<? extends HotDrinkFactory> type : types) {
            namedFactories.add(new Pair<>(type.getSimpleName().replace("Factory", ""),
                    type.getDeclaredConstructor().newInstance()));


        }
    }

    public HotDrink makeDrink() throws Exception {
        System.out.println("Avaliable drinks");

        for (int index = 0; index < namedFactories.size(); index++) {
            Pair<String, HotDrinkFactory> item = namedFactories.get(index);
            System.out.println("" + index + ": " + item.getKey());
        }
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String s;
            int i, amount;

            if ((s = reader.readLine()) != null
                    && (i = Integer.parseInt(s)) > 0
                    && i < namedFactories.size()) {
                System.out.println("Specify amount");
                s = reader.readLine();

                if (s != null && (amount = Integer.parseInt(s)) > 0) {
                    return namedFactories.get(i).getValue().prepare(amount);
                }
            }

            System.out.println("Incorrect Input, try again.");
        }
    }

}


public class Demo {

    public static void main(String[] args) throws Exception {
        HotDrinkMachine machine = new HotDrinkMachine();

        HotDrink drink = machine.makeDrink();
        drink.consume();
        ;


    }


}












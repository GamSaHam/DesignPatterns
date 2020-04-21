package clone;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
class Address implements Cloneable{
    public String streetName;
    public int houseNumber;

    // deep copy
    @Override
    public Object clone() throws CloneNotSupportedException {
        return new Address(streetName, houseNumber);
    }
}

@Data
@AllArgsConstructor
class Person implements Cloneable{

    public String [] names;
    public Address  address;


    @Override
    public Object clone() throws CloneNotSupportedException {

        return new Person(names.clone(), (Address)address.clone());
    }
}


public class Demo {

    public static void main(String[] args) throws CloneNotSupportedException {

        Person john = new Person(new String[]{"John", "Smith"}, new Address("London Road", 123));


        Person jane = (Person)john.clone();
        jane.names[0] = "Jane";
        jane.address.houseNumber = 124;

        System.out.println(john);
        System.out.println(jane);



    }



}

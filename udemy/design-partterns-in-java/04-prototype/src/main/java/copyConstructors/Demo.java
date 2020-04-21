package copyConstructors;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
class Address{
    public String streetAddress, city, country;


    public Address(Address other){
        this(other.streetAddress, other.city, other.country);
    }

}

@Data
@AllArgsConstructor
class Emplyee{

    public String name;
    public Address address;

    public Emplyee(Emplyee other){
        name = other.name;
        address = new Address(other.address);
    }

}


public class Demo {

    public static void main(String[] args) {

        Emplyee john = new Emplyee("John", new Address("123", "London Road","UK"));

        Emplyee chris = new Emplyee(john);

        chris.name = "Chris";

        System.out.println(john);
        System.out.println(chris);

    }

}

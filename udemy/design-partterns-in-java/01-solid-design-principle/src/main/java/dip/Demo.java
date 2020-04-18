package dip;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.val;
import org.javatuples.Triplet;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Dependency Inversion Principle  (DIP)
 */
enum Relationship {
    PARENT,
    CHILD,
    SIBLING
}

interface RelationshipBrowser {
    List<Person> findAllChildrenOf(String name);
}

@Data
@AllArgsConstructor
class Person {
    String name;
}

/**
 * low-level
 */
@Data
class Relationships implements RelationshipBrowser {
    private List<Triplet<Person, Relationship, Person>> relations = new ArrayList<>();


    public void addParentAndChild(Person parent, Person child) {
        relations.add(new Triplet<>(parent, Relationship.PARENT, child));
        relations.add(new Triplet<>(child, Relationship.CHILD, parent));
    }

    @Override
    public List<Person> findAllChildrenOf(String name) {
        return relations.stream()
                .filter(x -> x.getValue0().getName().equals(name) && x.getValue1() == Relationship.PARENT)
                .map(Triplet::getValue2)
                .collect(Collectors.toList());
    }
}

/**
 * high-level
 * low-level 상위 모듈은 하위모듈에서 호출할때 하위모듈은 인터페이스를 통해 접근한다.
 * 확장에 유연하고
 */
class Research {

//    public Research(Relationships relationships) {
//        List<Triplet<Person, Relationship, Person>> relations = relationships.getRelations();
//        relations.stream()
//                .filter(x -> x.getValue0().getName().equals("John")
//                        && x.getValue1() == Relationship.PARENT)
//                .forEach(ch -> System.out.println("John has a child called " + ch.getValue2().getName()));
//
//    }

    public Research(RelationshipBrowser browser) {
        List<Person> children = browser.findAllChildrenOf("John");

        children.forEach(child -> {
            System.out.println("John has a child called" + child.getName());
        });

    }

}


public class Demo {

    public static void main(String[] args) {
        Person parent = new Person("John");
        Person child1 = new Person("Chris");
        Person child2 = new Person("Matt");


        Relationships relationships = new Relationships();
        relationships.addParentAndChild(parent, child1);
        relationships.addParentAndChild(parent, child2);

        new Research(relationships);
    }

}


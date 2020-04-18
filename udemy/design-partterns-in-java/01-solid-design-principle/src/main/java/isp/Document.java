package isp;


import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * ISP(Interface segregation principle)
 * 인터페이스 분리 원칙
 * 클래스가 인터페이스를 상속받을때 인터페이스에 기능을 구현을 안하는 경우
 * 그 인터페이스는 분리하는게 원칙이다.
 */
@Data
public class Document {



}

interface  Machine{

    void print(Document d);
    void fax(Document d) throws Exception;
    void scan(Document d);
}


class MultiFunctionPrinter implements Machine{


    @Override
    public void print(Document d) {

    }

    @Override
    public void fax(Document d) {

    }

    @Override
    public void scan(Document d) {

    }
}

class OldFashionedPrinter implements Machine{


    @Override
    public void print(Document d) {
        //
    }

    // Can't use this function@Override
    public void fax(Document d) throws Exception {
        throw new Exception();
    }

    // Can't use this function
    @Override
    public void scan(Document d) {

    }
}

interface Printer{
    void print(Document d);
}

interface Scanner{
    void scan(Document d);
}

// YAGNI = You Ain't Going to Need It

class JustAPrinter implements Printer{

    @Override
    public void print(Document d) {

    }
}

class Photocopier implements Printer, Scanner{


    @Override
    public void print(Document d) {
        //
    }

    @Override
    public void scan(Document d) {
        //
    }
}


interface  MultiFunctionDevice extends Printer, Scanner{

}

@Data
@AllArgsConstructor
class MultiFunctionMachine implements MultiFunctionDevice{

    private Printer printer;
    private Scanner scanner;

    @Override
    public void print(Document d) {
        printer.print(d);
    }

    @Override
    public void scan(Document d) {
        scanner.scan(d);
    }
}









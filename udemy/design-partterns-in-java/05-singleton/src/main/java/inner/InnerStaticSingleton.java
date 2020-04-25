package inner;

public class InnerStaticSingleton {

    private InnerStaticSingleton(){
    }

    private static class Impl{
        private static final InnerStaticSingleton INSTANCE = new InnerStaticSingleton();
    }

    public InnerStaticSingleton getInstance(){
        return Impl.INSTANCE;
    }

}

class Demo{

    public static void main(String[] args) {

    }

}
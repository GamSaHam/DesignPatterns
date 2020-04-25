package laziness;

public class LazySingleton {

    private static LazySingleton instance;

    private LazySingleton(){
        System.out.println("initializing a lazy singleton");
    }


    //Thead 를 사용할 경우 synchronized 를 사용한다.
//    public static synchronized LazySingleton getInstance(){
//
//        if(instance == null){
//            instance = new LazySingleton();
//        }
//
//        return instance;
//    }

    public static LazySingleton getInstance()
    {
        if(instance == null){
            synchronized (LazySingleton.class){
                if(instance == null){
                    instance = new LazySingleton();
                }
            }
        }

        return instance;
    }
}

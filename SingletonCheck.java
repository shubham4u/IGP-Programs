//Q2. Singleton


import java.io.Serializable;

class Singleton implements Serializable {

    private static volatile Singleton sSoleInstance;

    //private constructor.
    private Singleton(){

        //Prevent form the reflection api.
        if (sSoleInstance != null){
            throw new RuntimeException("Use getInstance() method to get the single instance of this class.");
        }
    }

    public static Singleton getInstance() {
        if (sSoleInstance == null) { //if there is no instance available... create new one
            synchronized (Singleton.class) {
                if (sSoleInstance == null) sSoleInstance = new Singleton();
            }
        }

        return sSoleInstance;
    }

    //Make singleton from serialize and deserialize operation.
    protected Singleton readResolve() {
        return getInstance();
    }
}

class SingletonCheck {

    // Main driver method

    public static void main(String args[])

    {

        // Instantiating Singleton class with variable x

        Singleton x = Singleton.getInstance();
 

        // Instantiating Singleton class with variable y

        Singleton y = Singleton.getInstance();
 

        // Instantiating Singleton class with variable z

        Singleton z = Singleton.getInstance();
 

        // Printing the hash code for above variable as

        // declared

        System.out.println("Hashcode of x is "+ x.hashCode());

        System.out.println("Hashcode of y is "+ y.hashCode());

        System.out.println("Hashcode of z is "+ z.hashCode());
 
        if (x == y && y == z) {
            System.out.println("Three objects point to the same memory location on the heap i.e, to the same object");
        }
        else {
            System.out.println("Three objects DO NOT point to the same memory location on the heap");
        }

    }
}
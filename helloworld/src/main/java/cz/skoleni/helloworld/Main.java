package cz.skoleni.helloworld;

import com.google.gson.Gson;

public class Main {

    // main
    public static void main(String[] args) {
        // sout
        System.out.println("Hello World!");
        Dog dog = new Dog();
        dog.setName("Alík");
        dog.setRace("Pitbull");
        dog.setAge(5);
        System.out.println("Dog name: " + dog.getName());
        String json = new Gson().toJson(dog);
        System.out.println(json);
        dog.print();
        dog.printToFile();
        Dog dog2 = new Dog("Puňťa", "Vlkodav", 10);
        dog2.print();
    }

}

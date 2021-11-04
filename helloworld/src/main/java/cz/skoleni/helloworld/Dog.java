package cz.skoleni.helloworld;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Dog {

    private String name;

    private String race;

    private int age;

    public void print() {
        System.out.println("Pejsek:");
        System.out.println("Name: " + name);
    }

}

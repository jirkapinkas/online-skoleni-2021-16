package cz.skoleni.helloworld;

import lombok.Getter;
import lombok.Setter;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Dog extends Animal {

    private String name;

    private String race;

    public void print() {
        System.out.println("Pejsek:");
        System.out.println("Name: " + name);
    }

    public void printToFile() {
        try {
            List<String> lines = new ArrayList<>();
            lines.add("Dog:");
            lines.add("Name: " + name);
            Files.write(Paths.get("target","dogs.txt"), lines);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

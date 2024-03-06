package module5._541.serializeArrayOfObject;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

public class SerializeArrayOfObject {
    public static void main(String[] args) {
        Animal[] animals = {
                new Animal("animal1"),
                new Animal("animal2"),
                new Animal("animal3"),
                new Animal("animal4"),
                new Animal("animal5"),
        };
        serializeAnimals(animals);

        try {
            File file = getAnimalsFile();
            FileInputStream fis = new FileInputStream(file);
            byte[] data = fis.readAllBytes();
            System.out.println(Arrays.toString(deserializeAnimalArray(data)));
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Animal[] deserializeAnimalArray(byte[] data) {
        Animal[] animals;
        try (ByteArrayInputStream bais = new ByteArrayInputStream(data);
                ObjectInputStream ois = new ObjectInputStream(bais)) {
            int length = ois.readInt();
            animals = new Animal[length];
            for (int i = 0; i < length; i++) {
                animals[i] = (Animal) ois.readObject();
            }
            return animals;
        } catch (IOException | ClassNotFoundException | ClassCastException e) {
            throw new IllegalArgumentException();
        }
    }

    public static void serializeAnimals(Animal[] animals) {
        File fileAnimals = getAnimalsFile();
        try (FileOutputStream fos = new FileOutputStream(fileAnimals);
                ObjectOutputStream oos = new ObjectOutputStream(fos);) {
            if (!fileAnimals.exists()) {
                fileAnimals.createNewFile();
            }
            oos.writeInt(animals.length);
            for (Animal animal : animals) {
                oos.writeObject(animal);
            }
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static File getAnimalsFile() {
        String sep = File.separator;
        String fPath = String.join(
                sep,
                "module5",
                "_541",
                "serializeArrayOfObject",
                "animals");
        File fileAnimals = new File(fPath);
        return fileAnimals;
    }
}

class Animal implements Serializable {
    private final String name;

    public Animal(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Animal) {
            return Objects.equals(name, ((Animal) obj).name);
        }
        return false;
    }

    @Override
    public String toString() {
        return "Animal [name=" + name + "]";
    }
}
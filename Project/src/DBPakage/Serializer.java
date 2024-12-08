package DBPakage;

import java.io.*;

public class Serializer {
	// Сохранение объекта в файл
    public static <T> void saveObject(String filePath, T object) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(object);
            System.out.println("Object has been serialized to: " + filePath);
        } catch (IOException e) {
            System.err.println("Error during serialization: " + e.getMessage());
        }
    }

    // Загрузка объекта из файла
    public static <T> T loadObject(String filePath) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            @SuppressWarnings("unchecked")
            T object = (T) ois.readObject();
            System.out.println("Object has been deserialized from: " + filePath);
            return object;
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error during deserialization: " + e.getMessage());
            return null;
        }
    }
}

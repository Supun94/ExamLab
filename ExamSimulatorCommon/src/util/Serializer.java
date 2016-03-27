package util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Serializer {

    public static <T> void serialize(T obj, String filePath) {

        try (FileOutputStream foStream = new FileOutputStream(filePath)) {

            try (ObjectOutputStream ooStream = new ObjectOutputStream(foStream)) {
                ooStream.writeObject(obj);
            } catch (IOException ex) {
                Logger.getLogger(Serializer.class.getName())
                        .log(Level.SEVERE, null, ex);
            }

        } catch (Exception ex) {
            Logger.getLogger(Serializer.class.getName())
                    .log(Level.SEVERE, null, ex);
        }

    }

    public static <T> T deserialize(String filePath) {
        T obj = null;

        try (FileInputStream fiStream = new FileInputStream(filePath)) {

            try (ObjectInputStream oiStream = new ObjectInputStream(fiStream)) {
                obj = (T) oiStream.readObject();
            } catch (ClassNotFoundException | IOException ex) {
                Logger.getLogger(Serializer.class.getName())
                        .log(Level.SEVERE, null, ex);
            }

            return obj;
        } catch (Exception ex) {
            Logger.getLogger(Serializer.class.getName()).log(Level.SEVERE, null, ex);
        }

        return obj;
    }

}

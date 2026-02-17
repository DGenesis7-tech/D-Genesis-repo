import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class PostSerializer {

    public static void serialize(Post post, String filename) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filename))) {
            objectOutputStream.writeObject(post);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public static void serialize(Post post, Path path) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(Files.newOutputStream(path))) {
            objectOutputStream.writeObject(post);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}

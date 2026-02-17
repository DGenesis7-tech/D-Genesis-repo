import org.junit.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

public class PostSerializerTest {

    @Test
    public void testSerialization() {
        String complexTitle = "This is a my name";
        String id = "0147";
        String body = "This is a body of the post";

        Post post = new Post(id, complexTitle, body);
        String fileName = "post";
        String fileLocation ="C:\\Users\\Daniel Genesis\\Desktop\\D-Genesis-repo\\Revision\\readingData\\src\\Post";

        Path path = Paths.get(fileLocation, fileName);

        PostSerializer.serialize(post, fileLocation);
    }

    @Test
    public void testDeserialization() {
        String fileName = "post";
        String fileLocation = "C:\\Users\\Daniel Genesis\\Desktop\\D-Genesis-repo\\Revision\\readingData\\src\\Post";
        Path path = Paths.get(fileLocation, fileName);
        Post post = PostDeserializer.deserialize(path);


        assertEquals("0147", post.getUserId());
        assertEquals("This is a my name", post.getTitle());
        assertEquals("This is a body of the post", post.getBody());
        assertNotNull(post);
    }

}
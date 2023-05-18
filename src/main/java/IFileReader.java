import java.io.ByteArrayOutputStream;
import java.io.IOException;

public interface IFileReader {
    ByteArrayOutputStream read() throws IOException;

    boolean open(String fileName) throws IOException;
}

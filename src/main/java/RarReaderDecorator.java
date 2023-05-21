import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class RarReaderDecorator extends ArchReaderDecorator {

    public RarReaderDecorator(IFileReader reader) {
        logDependencyAdding(reader, "constructor");
        this.reader = reader;
    }

    protected boolean isValidFileType(String fileName) {
        System.out.println("-RarReaderDecorator.isValidFileType with parameter: " + fileName);
        return true;
    }

    protected boolean isPasswordRequired(String fileName) {
        System.out.println("-RarReaderDecorator.isPasswordRequired with parameter: " + fileName);
        return false;
    }

    protected ByteArrayOutputStream unArch(ByteArrayOutputStream stream) {
        System.out.println("-RarReaderDecorator.unRar with parameter having a hashcode: " + stream.hashCode());
        return stream;
    }
}

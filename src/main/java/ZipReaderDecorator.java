import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class ZipReaderDecorator extends ArchReaderDecorator {

    public ZipReaderDecorator(IFileReader reader) {
        logDependencyAdding(reader, "constructor");
        this.reader = reader;
    }

    protected boolean isValidFileType(String fileName) {
        System.out.println("-ZipReaderDecorator.isValidFileType with parameter: " + fileName);
        return true;
    }

    protected boolean isPasswordRequired(String fileName) {
        System.out.println("-ZipReaderDecorator.isPasswordRequired with parameter: " + fileName);
        return false;
    }

    protected ByteArrayOutputStream unArch(ByteArrayOutputStream stream) {
        System.out.println("-ZipReaderDecorator.unZip with parameter having a hashcode: " + stream.hashCode());
        return stream;
    }
}

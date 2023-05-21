import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class MD5EncryptReaderDecorator extends EncryptReaderDecorator {

    public MD5EncryptReaderDecorator(IFileReader reader) {
        logDependencyAdding(reader, "constructor");
        this.reader = reader;
    }

    protected boolean isValidFileType(String fileName) {
        System.out.println("-MD5EncryptReaderDecorator.isValidFileType with parameter: " + fileName);
        return true;
    }

    protected boolean isPasswordRequired(String fileName) {
        System.out.println("-MD5EncryptReaderDecorator.isPasswordRequired with parameter: " + fileName);
        return false;
    }

    protected ByteArrayOutputStream encrypt(ByteArrayOutputStream stream) {
        System.out.println("-MD5EncryptReaderDecorator.encrypt with parameter having a hashcode: " + stream.hashCode());
        return stream;
    }
}

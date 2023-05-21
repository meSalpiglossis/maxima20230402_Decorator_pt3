import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class RSAEncryptReaderDecorator extends EncryptReaderDecorator {

    public RSAEncryptReaderDecorator(IFileReader reader) {
        logDependencyAdding(reader, "constructor");
        this.reader = reader;
    }

    protected boolean isValidFileType(String fileName) {
        System.out.println("-RSAEncryptReaderDecorator.isValidFileType with parameter: " + fileName);
        return true;
    }

    protected boolean isPasswordRequired(String fileName) {
        System.out.println("-RSAEncryptReaderDecorator.isPasswordRequired with parameter: " + fileName);
        return false;
    }

    protected ByteArrayOutputStream encrypt(ByteArrayOutputStream stream) {
        System.out.println("-RSAEncryptReaderDecorator.encrypt with parameter having a hashcode: " + stream.hashCode());
        return stream;
    }
}

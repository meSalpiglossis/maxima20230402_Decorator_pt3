import java.io.ByteArrayOutputStream;
import java.io.IOException;

public abstract class EncryptReaderDecorator extends ReaderDecorator {

    protected boolean preProcess(String fileName) {
        boolean result = isValidFileType(fileName) && !isPasswordRequired(fileName);
        //TODO: Open file (in a default way)
        System.out.println("EncryptReaderDecorator::open/preProcess::Trying to open encrypted file: " + fileName);
        return result;
    }

    protected ByteArrayOutputStream process(ByteArrayOutputStream readerStream) throws IOException {
        System.out.println("+EncryptReaderDecorator.read/process with parameter having a hashcode: " + readerStream.hashCode());;
        //TODO: Read file (in a default way)
        System.out.println("EncryptReaderDecorator::read::Reading ZIP file");
        return encrypt(readerStream);
    }

    protected abstract boolean isValidFileType(String fileName);

    protected abstract boolean isPasswordRequired(String fileName);

    protected abstract ByteArrayOutputStream encrypt(ByteArrayOutputStream stream);
}

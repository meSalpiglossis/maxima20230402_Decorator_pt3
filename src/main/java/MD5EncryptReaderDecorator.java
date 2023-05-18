import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class MD5EncryptReaderDecorator implements IFileReader {

    private IFileReader reader;

    public MD5EncryptReaderDecorator(IFileReader reader) {
        logDependencyAdding(reader, "constructor");
        this.reader = reader;
    }

    public void setReader(IFileReader reader) {
        logDependencyAdding(reader, "setReader");
        this.reader = reader;
    }

    @Override
    public boolean open(String fileName) throws IOException {
        //TODO Possibly: with reader usage
        boolean isFileExist = true;
        if(reader != null) {
            isFileExist = reader.open(fileName);
        }

        System.out.println("+MD5EncryptReaderDecorator.open with parameter: " + fileName);
        //TODO: Open file (in a default way)
        System.out.println("MD5EncryptReaderDecorator::open::Trying to open MD5 file: " + fileName);
        return isFileExist && isValidFileType(fileName) && !isPasswordRequired(fileName);
    }

    @Override
    public ByteArrayOutputStream read() throws IOException {
        //TODO: Implement additional behavior using reader
        ByteArrayOutputStream readerStream = null;
        if(reader != null) {
            readerStream = reader.read();
        } else {
            readerStream = new ByteArrayOutputStream();
        }

        System.out.println("+MD5EncryptReaderDecorator.read without parameters");
        //TODO: Read file (in a default way)
        System.out.println("MD5EncryptReaderDecorator::read::Reading MD5 file");
        return encrypt(readerStream);
    }

    private void logDependencyAdding(IFileReader reader, String methodName) {
        String msg = "+MD5EncryptReaderDecorator " + methodName + " with parameter IFileReader: ";

        if(reader != null) {
            msg += reader;
        } else {
            msg += "null";
        }

        System.out.println(msg);
    }

    private boolean isValidFileType(String fileName) {
        System.out.println("-MD5EncryptReaderDecorator.isValidFileType with parameter: " + fileName);
        return true;
    }

    private boolean isPasswordRequired(String fileName) {
        System.out.println("-MD5EncryptReaderDecorator.isPasswordRequired with parameter: " + fileName);
        return false;
    }

    private ByteArrayOutputStream encrypt(ByteArrayOutputStream stream) {
        System.out.println("-MD5EncryptReaderDecorator.encrypt with parameter having a hashcode: " + stream.hashCode());
        return stream;
    }
}

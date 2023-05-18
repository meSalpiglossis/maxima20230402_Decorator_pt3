import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class FileReaderDecorator implements IFileReader {

    private IFileReader reader;

    public FileReaderDecorator(IFileReader reader) {
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

        System.out.println("+FileReaderDecorator.open with parameter: " + fileName);
        //TODO: Open file (ina default way)
        System.out.println("FileReaderDecorator::open::Trying to open TXT file: " + fileName);
        return isFileExist;
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

        System.out.println("+FileReaderDecorator.read without parameters");
        //TODO: Read file (in a default way)
        System.out.println("FileReaderDecorator::read::Reading TXT file");

        return readerStream;
    }

    private void logDependencyAdding(IFileReader reader, String methodName) {
        String msg = "+FileReaderDecorator " + methodName + " with parameter IFileReader: ";

        if(reader != null) {
            msg += reader;
        } else {
            msg += "null";
        }

        System.out.println(msg);
    }
}

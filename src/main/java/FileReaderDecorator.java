import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class FileReaderDecorator extends ReaderDecorator {

    public FileReaderDecorator(IFileReader reader) {
        logDependencyAdding(reader, "constructor");
        this.reader = reader;
    }

    protected boolean preProcess(String fileName) {
        boolean result = true;
        //TODO: Open file (ina default way)
        System.out.println("FileReaderDecorator::open/preProcess::Trying to open TXT file: " + fileName);
        return result;
    }

    protected ByteArrayOutputStream process(ByteArrayOutputStream readerStream) throws IOException {
        System.out.println("+FileReaderDecorator.read/process with parameter having a hashcode: " + readerStream.hashCode());
        //TODO: Read file (in a default way)
        System.out.println("FileReaderDecorator::read/process::Reading TXT file");
        return readerStream;
    }
}

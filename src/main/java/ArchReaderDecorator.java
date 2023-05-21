import java.io.ByteArrayOutputStream;
import java.io.IOException;

public abstract class ArchReaderDecorator extends ReaderDecorator {

    protected boolean preProcess(String fileName) {
        boolean result = isValidFileType(fileName) && !isPasswordRequired(fileName);
        //TODO: Open file (in a default way)
        System.out.println("ArchReaderDecorator::open/preProcess::Trying to open archived file: " + fileName);
        return result;
    }

    protected ByteArrayOutputStream process(ByteArrayOutputStream readerStream) throws IOException {
        System.out.println("+ArchReaderDecorator.read/process with parameter having a hashcode: " + readerStream.hashCode());;
        //TODO: Read file (in a default way)
        System.out.println("ArchReaderDecorator::read::Reading ZIP file");
        return unArch(readerStream);
    }

    protected abstract boolean isValidFileType(String fileName);

    protected abstract boolean isPasswordRequired(String fileName);

    protected abstract ByteArrayOutputStream unArch(ByteArrayOutputStream stream);
}

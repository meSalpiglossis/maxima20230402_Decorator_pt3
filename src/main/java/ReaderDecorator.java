import java.io.ByteArrayOutputStream;
import java.io.IOException;

public abstract class ReaderDecorator implements IFileReader{
    protected IFileReader reader;

    public void setReader(IFileReader reader) {
        logDependencyAdding(reader, "setReader");
        this.reader = reader;
    }

    public boolean open(String fileName) throws IOException {
        //TODO Possibly: with reader usage
        boolean isFileExist = true;
        if (reader != null) {
            isFileExist = reader.open(fileName);
        }

        System.out.println("+ReaderDecorator.open with parameter: " + fileName);

        return isFileExist && preProcess(fileName);
    }

    protected abstract boolean preProcess(String fileName);

    @Override
    public ByteArrayOutputStream read() throws IOException {
        //TODO: Implement additional behavior using reader
        ByteArrayOutputStream readerStream = null;
        if (reader != null) {
            readerStream = reader.read();
        } else {
            readerStream = new ByteArrayOutputStream();
        }

        System.out.println("+ReaderDecorator.read without parameters");

        return process(readerStream);
    }

    protected abstract ByteArrayOutputStream process(ByteArrayOutputStream readerStream) throws IOException;

    protected void logDependencyAdding(IFileReader reader, String methodName) {
        String classToLog = this.getClass().getSimpleName();
        String msg = "+" + classToLog + " " + methodName + " with parameter IFileReader: ";

        if (reader != null) {
            msg += reader;
        } else {
            msg += "null";
        }

        System.out.println(msg);
    }

}

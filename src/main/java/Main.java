import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        final String DIVIDER = "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~";

        try {
            IFileReader reader = FileProcessingEngineBuilder.buildSimpleTxtReader();
            reader.open("SimpleTxt.txt");
            ByteArrayOutputStream readerStream = reader.read();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println(DIVIDER);

        try {
            IFileReader reader = FileProcessingEngineBuilder.buildZipTxtReader();
            reader.open("Txt.zip");
            ByteArrayOutputStream readerStream = reader.read();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println(DIVIDER);

        try {
            IFileReader reader = FileProcessingEngineBuilder.buildMD5TxtReader();
            reader.open("Txt.md5");
            ByteArrayOutputStream readerStream = reader.read();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println(DIVIDER);

        try {
            IFileReader reader = FileProcessingEngineBuilder.buildMD5ZipTxtReader();
            reader.open("Txt.zip.md5");
            ByteArrayOutputStream readerStream = reader.read();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println(DIVIDER);

        try {
            IFileReader reader = FileProcessingEngineBuilder.buildRsaZipMD5TxtReader();
            reader.open("Txt.md5.zip.rsa");
            ByteArrayOutputStream readerStream = reader.read();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println(DIVIDER);

        try {
            IFileReader reader = FileProcessingEngineBuilder.buildRarZipMD5TxtReader();
            reader.open("Txt.md5.zip.rar");
            ByteArrayOutputStream readerStream = reader.read();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

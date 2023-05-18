import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        final String DIVIDER = "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~";

        //READ txt
        try {
            IFileReader additionalReaderFeature = null;
            IFileReader reader = new FileReaderDecorator(additionalReaderFeature);
            reader.open("SimpleTxt.txt");
            ByteArrayOutputStream readerStream = reader.read();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println(DIVIDER);

        //READ txt AFTER unzip
        try {
            IFileReader additionalReaderFeature = new ZipReaderDecorator(null);
            IFileReader reader = new FileReaderDecorator(additionalReaderFeature);
            reader.open("Txt.zip");
            ByteArrayOutputStream readerStream = reader.read();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println(DIVIDER);

        //READ txt AFTER md5encrypt
        try {
            IFileReader additionalReaderFeature = new MD5EncryptReaderDecorator(null);
            IFileReader reader = new FileReaderDecorator(additionalReaderFeature);
            reader.open("Txt.md5");
            ByteArrayOutputStream readerStream = reader.read();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println(DIVIDER);

        //READ txt AFTER unzip AFTER md5_encrypt
        try {
            IFileReader additionalReaderFeature = new ZipReaderDecorator(new MD5EncryptReaderDecorator(null));
            IFileReader reader = new FileReaderDecorator(additionalReaderFeature);
            reader.open("Txt.zip.md5");
            ByteArrayOutputStream readerStream = reader.read();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println(DIVIDER);

        //READ txt AFTER md5_encrypt AFTER unzip AFTER rsa_encrypt
        try {
            IFileReader additionalReaderFeature = new MD5EncryptReaderDecorator(new ZipReaderDecorator(new RSAEncryptReaderDecorator(null)));
            IFileReader reader = new FileReaderDecorator(additionalReaderFeature);
            reader.open("Txt.md5.zip.rsa");
            ByteArrayOutputStream readerStream = reader.read();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println(DIVIDER);

        //READ txt AFTER md5_encrypt AFTER unzip AFTER unrar
        try {
            IFileReader additionalReaderFeature = new MD5EncryptReaderDecorator(new ZipReaderDecorator(new RarReaderDecorator(null)));
            IFileReader reader = new FileReaderDecorator(additionalReaderFeature);
            reader.open("Txt.md5.zip.rar");
            ByteArrayOutputStream readerStream = reader.read();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

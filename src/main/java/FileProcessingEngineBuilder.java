public class FileProcessingEngineBuilder {

    public static IFileReader buildSimpleTxtReader() {
        IFileReader additionalReaderFeature = null;
        IFileReader reader = new FileReaderDecorator(additionalReaderFeature);
        return reader;
    }

    public static IFileReader buildZipTxtReader() {
        IFileReader additionalReaderFeature = new ZipReaderDecorator(null);
        IFileReader reader = new FileReaderDecorator(additionalReaderFeature);
        return reader;
    }

    public static IFileReader buildMD5TxtReader() {
        IFileReader additionalReaderFeature = new MD5EncryptReaderDecorator(null);
        IFileReader reader = new FileReaderDecorator(additionalReaderFeature);
        return reader;
    }

    public static IFileReader buildMD5ZipTxtReader() {
        IFileReader additionalReaderFeature = new ZipReaderDecorator(new MD5EncryptReaderDecorator(null));
        IFileReader reader = new FileReaderDecorator(additionalReaderFeature);
        return reader;
    }

    public static IFileReader buildRsaZipMD5TxtReader() {
        IFileReader additionalReaderFeature = new MD5EncryptReaderDecorator(new ZipReaderDecorator(new RSAEncryptReaderDecorator(null)));
        IFileReader reader = new FileReaderDecorator(additionalReaderFeature);
        return reader;
    }

    public static IFileReader buildRarZipMD5TxtReader() {
        IFileReader additionalReaderFeature = new MD5EncryptReaderDecorator(new ZipReaderDecorator(new RarReaderDecorator(null)));
        IFileReader reader = new FileReaderDecorator(additionalReaderFeature);
        return reader;
    }
}

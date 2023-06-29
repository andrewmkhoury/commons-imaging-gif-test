import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.imaging.ImageFormat;
import org.apache.commons.imaging.ImageFormats;
import org.apache.commons.imaging.ImageParser;
import org.apache.commons.imaging.ImageReadException;
import org.apache.commons.imaging.Imaging;
import org.apache.commons.imaging.common.bytesource.ByteSource;
import org.apache.commons.imaging.common.ImageMetadata;
import org.apache.commons.imaging.common.ImageMetadata.ImageMetadataItem;
import org.apache.commons.imaging.common.bytesource.ByteSourceFile;

public class Test {
    public static void main(String[] args) throws ImageReadException, IOException {
        if (args.length < 1) {
            System.out.println("Usage: java Test <image file path>");
            System.exit(1);
        }
        String filePath = args[0];
        File imgFile = new File(filePath);
        if (!imgFile.exists()) {
            System.out.println("File not found: " + filePath);
            System.exit(1);
        }
        ByteSourceFile bs = new ByteSourceFile(imgFile);
        ImageParser imageParser = getImageParser(bs);
        ImageMetadata metadata = imageParser.getMetadata(bs);
        for ( ImageMetadataItem meta : metadata.getItems() ) {
            System.out.println(meta.toString(""));
        }
    }

    private static ImageParser getImageParser(ByteSource byteSrc) throws ImageReadException, IOException {
        final ImageFormat format = Imaging.guessFormat(byteSrc);
        if (!format.equals(ImageFormats.UNKNOWN)) {

            final List<ImageParser<?>> imageParsers = ImageParser.getAllImageParsers();

            for (final ImageParser imageParser : imageParsers) {
                if (imageParser.canAcceptType(format)) {
                    return imageParser;
                }
            }
        }
        return null;
    }
}
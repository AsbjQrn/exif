import com.drew.imaging.ImageMetadataReader;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.Tag;
import com.drew.metadata.exif.ExifSubIFDDescriptor;
import com.drew.metadata.exif.ExifSubIFDDirectory;

import java.io.File;

public class Main {

    public static void main(String args[]) {

        File jpegFile = new File("DSC_0140.JPG");
        try {
            Metadata metadata = ImageMetadataReader.readMetadata(jpegFile);
            for (Directory directory : metadata.getDirectories()) {
                for (Tag tag : directory.getTags()) {
                    System.out.println(tag);
                }
            }
            ExifSubIFDDirectory directory
                    = metadata.getFirstDirectoryOfType(ExifSubIFDDirectory.class);

// create a descriptor
            ExifSubIFDDescriptor descriptor
                    = new ExifSubIFDDescriptor(directory);

// get tag description
            String program = descriptor.getExposureProgramDescription();

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}

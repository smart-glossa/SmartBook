package image;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ImageBL {

    SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");

    public static ImageBL getObject() {
        return new ImageBL();
    }

    public ImageVO addImage(String imagePath, int imageSize, int imageType, String time) throws ClassNotFoundException, SQLException, ParseException {
        ImageVO image = new ImageVO().setImageContent(imagePath).setImageSize(imageSize)
                .setImageType(imageType).setUploadedTime(sdf.parse(time).getTime());
        ImageDB.getObject().addImage(image);
        return image;
    }

    public ImageVO updateImage(Long imageId, String imagePath, int imageSize, int imageType, String time) throws ClassNotFoundException, SQLException, ParseException {
        ImageVO image = new ImageVO().setImageContent(imagePath).setImageSize(imageSize)
                .setImageType(imageType).setUploadedTime(sdf.parse(time).getTime()).setImageId(imageId);
        ImageDB.getObject().updateImage(image);
        return image;
    }

    public void deleteImage(long imageId) throws ClassNotFoundException, SQLException {
        ImageDB.getObject().deleteImage(imageId);
    }

    public ImageVO getImage(long imageId) throws ClassNotFoundException, SQLException {
        return ImageDB.getObject().getImage(imageId);
    }
}

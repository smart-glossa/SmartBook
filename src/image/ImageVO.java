package image;

public class ImageVO {

    long imageId;
    String imagePath = null;
    int imageSize;
    int imageType;
    long uploadedTime;
    
    public long getImageId() {
        return imageId;
    }
    public ImageVO setImageId(long imageId) {
        this.imageId = imageId;
        return this;
    }
    public String getImageContent() {
        return imagePath;
    }
    public ImageVO setImageContent(String imageContent) {
        this.imagePath = imageContent;
        return this;
    }
    public int getImageSize() {
        return imageSize;
    }
    public ImageVO setImageSize(int imageSize) {
        this.imageSize = imageSize;
        return this;
    }
    public int getImageType() {
        return imageType;
    }
    public ImageVO setImageType(int imageType) {
        this.imageType = imageType;
        return this;
    }
    public long getUploadedTime() {
        return uploadedTime;
    }
    public ImageVO setUploadedTime(long uploadedTime) {
        this.uploadedTime = uploadedTime;
        return this;
    }
    
}

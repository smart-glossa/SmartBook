package image;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import common.MySQLConstants;

public class ImageDB {

    public static ImageDB getObject() {
        return new ImageDB();
    }
    
    public void addImage(ImageVO image) throws ClassNotFoundException, SQLException {
        Class.forName(MySQLConstants.mysqlDriver);
        Connection connection = DriverManager.getConnection(MySQLConstants.mysqlPath + MySQLConstants.database,
                MySQLConstants.userName, MySQLConstants.password);
        Statement statement = connection.createStatement();
        String query = "Insert into Image(imageContent, imageSize, imageType, uploadedTime) Values (" + image.getImageContent()
                + ", " + image.getImageSize() + ",'" + image.getImageType() + "'," + image.getUploadedTime()
                + ")";
        ResultSet rs = statement.executeQuery(query);
        image.setImageId(rs.getLong(0));
    }
    
    public void updateImage(ImageVO image) throws ClassNotFoundException, SQLException {
        Class.forName(MySQLConstants.mysqlDriver);
        Connection connection = DriverManager.getConnection(MySQLConstants.mysqlPath + MySQLConstants.database,
                MySQLConstants.userName, MySQLConstants.password);
        Statement statement = connection.createStatement();
        String query = "Update Image set imageContent =" + image.getImageContent() + ", imageSize="
                + image.getImageSize() + ", imageType='" + image.getImageType() + "', uploadedTime="
                + image.getUploadedTime() + " where imageId = " + image.getImageId();
        statement.execute(query);
    }
    
    public void deleteImage(long imageId) throws ClassNotFoundException, SQLException{
        Class.forName(MySQLConstants.mysqlDriver);
        Connection connection = DriverManager.getConnection(MySQLConstants.mysqlPath 
                + MySQLConstants.database, 
                MySQLConstants.userName, MySQLConstants.password);
        Statement statement = connection.createStatement();
        String query = "Delete from Image where imageId =" + imageId;
        statement.execute(query);
    }
    
    public ImageVO getImage(long imageId) throws ClassNotFoundException, SQLException {
        ImageVO image = new ImageVO();
        Class.forName(MySQLConstants.mysqlDriver);
        Connection connection = DriverManager.getConnection(MySQLConstants.mysqlPath 
                + MySQLConstants.database, 
                MySQLConstants.userName, MySQLConstants.password);
        Statement statement = connection.createStatement();
        String query = "Select * from Image where imageId =" + imageId;
        ResultSet rs = statement.executeQuery(query);
        if (rs.next()) {
            image.setImageId(rs.getLong("imageId"));
            image.setImageContent(rs.getString("imagePath"));
            image.setImageSize(rs.getInt("imageSize"));
            image.setImageType(rs.getInt("imageType"));
            image.setUploadedTime(rs.getLong("uploadedTime"));
        }
        return image;
    }
}

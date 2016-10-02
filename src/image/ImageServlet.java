package image;

import java.sql.SQLException;
import java.text.ParseException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

public class ImageServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws JSONException {
        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws JSONException {
        int mode = Integer.parseInt(request.getParameter("mode"));
        switch (mode) {
        case ImageConstants.req_CreateMode:
            createImage(request, response);
            break;
        case ImageConstants.req_UpdateMode:
            updateImage(request, response);
            break;
        case ImageConstants.req_DeleteMode:
            deleteImage(request, response);
            break;
        case ImageConstants.req_GetMode:
            getImageDetail(request, response);
            break;
        }
    }

    private void createImage(HttpServletRequest request, HttpServletResponse response) throws JSONException{
        JSONObject result = new JSONObject();
        String imagePath= request.getParameter("imagePath");
        int imageSize = Integer.parseInt(request.getParameter("imageSize"));
        int imageType = Integer.parseInt(request.getParameter("imageType"));
        String uploadedTime = request.getParameter("uploadedTime");

        try {
            ImageVO project = ImageBL.getObject().addImage(imagePath, imageSize, imageType, uploadedTime);
            result.put("status", 1);
            result.put("projectId", project.getImageId());
        } catch (ClassNotFoundException e) {
            result.put("status", 0);
            result.put("message", "Internal Error Occurs");
            e.printStackTrace();
        } catch (SQLException e) {
            result.put("status", 0);
            result.put("message", "SQL Error Occurs");
            e.printStackTrace();
        } catch (ParseException e) {
            result.put("status", 0);
            result.put("message", "Parse Error Occurs");
            e.printStackTrace();
        }

    }

    private void updateImage(HttpServletRequest request, HttpServletResponse response) throws JSONException {
        JSONObject result = new JSONObject();
        long imageId = Long.parseLong(request.getParameter("imageId"));
        String imagePath= request.getParameter("imagePath");
        int imageSize = Integer.parseInt(request.getParameter("imageSize"));
        int imageType = Integer.parseInt(request.getParameter("imageType"));
        String uploadedTime = request.getParameter("uploadedTime");


        try {
            ImageBL.getObject().updateImage(imageId, imagePath, imageSize, imageType, uploadedTime);
            result.put("status", 1);
        } catch (ClassNotFoundException e) {
            result.put("status", 0);
            result.put("message", "Internal Error Occurs");
            e.printStackTrace();
        } catch (SQLException e) {
            result.put("status", 0);
            result.put("message", "SQL Error Occurs");
            e.printStackTrace();
        } catch (ParseException e) {
            result.put("status", 0);
            result.put("message", "Parse Error Occurs");
            e.printStackTrace();
        }

    }

    private void deleteImage(HttpServletRequest request, HttpServletResponse response) throws JSONException {
        JSONObject result = new JSONObject();
        long imageId = Long.parseLong(request.getParameter("imageId"));
        try {
            ImageBL.getObject().deleteImage(imageId);
            result.put("status", 1);
        } catch (ClassNotFoundException e) {
            result.put("status", 0);
            result.put("message", "Internal Error Occurs");
            e.printStackTrace();
        } catch (SQLException e) {
            result.put("status", 0);
            result.put("message", "SQL Error Occurs");
            e.printStackTrace();
        }
    }

    private void getImageDetail(HttpServletRequest request, HttpServletResponse response) throws JSONException {
        JSONObject result = new JSONObject();
        long imageId = Long.parseLong(request.getParameter("imageId"));
        try {
            ImageVO image = ImageBL.getObject().getImage(imageId);
            result.put("status", 1);
            if (image.getImageId() != -1l) {
                result.put("imageId", image.getImageId());
                result.put("imagePath", image.getImageContent());
                result.put("imageSize", image.getImageSize());
                result.put("imageType", image.getImageType());
                result.put("uploadedTime", image.getUploadedTime());
            }
        } catch (ClassNotFoundException e) {
            result.put("status", 0);
            result.put("message", "Internal Error Occurs");
            e.printStackTrace();
        } catch (SQLException e) {
            result.put("status", 0);
            result.put("message", "SQL Error Occurs");
            e.printStackTrace();
        }
    }
}

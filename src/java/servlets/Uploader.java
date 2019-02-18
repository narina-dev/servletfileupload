package servlets;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.FileUploadException;

import org.apache.commons.fileupload.servlet.ServletFileUpload;


//path give


public class Uploader extends HttpServlet {
@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        boolean isMultiPart = ServletFileUpload.isMultipartContent(request);
        if (isMultiPart) {
            ServletFileUpload upload = new ServletFileUpload();
            try {
                FileItemIterator itr = upload.getItemIterator(request);
                while (itr.hasNext()) {
                    FileItemStream item = itr.next();
                    if (item.isFormField()) {
                        //field specific process
                        String fieldName = item.getFieldName();
                        InputStream is = item.openStream();
                        byte[] b = new byte[is.available()]; 
                        is.read(b); 
                        String value = new String(b);
                        response.getWriter().println(fieldName+":"+ value + "<br/>");
                    } else {
                        //file specific
                        String path = getServletContext().getRealPath("/");
                        //method to upload
                        if(FileUploader.processFile(path,item)){
                        response.getWriter().println("file uploaded sucesfully");
                       // response.getWriter().println(request.getServletContext().getRealPath(path));
                        }
                        else response.getWriter().println("file uploading failed");
                    }
                }
            } catch (FileUploadException fue) {
                fue.printStackTrace();
            }

        } else {
            
        }
    }
  

    
}

package com.luv2code.userpostbackend.util;

import java.io.*;
import java.nio.file.*;

import org.springframework.web.multipart.MultipartFile;
public class FileUploadUtil {
	
    public static void saveFile(String uploadDir, String fileName,
            MultipartFile multipartFile) throws IOException {
    	//System.out.println("saveFile");
        Path uploadPath = Paths.get(uploadDir);
         //System.out.println("uploadPath :" + uploadPath);
        if (!Files.exists(uploadPath)) {
        	//System.out.println("if files uploadpath");
            Files.createDirectories(uploadPath);
        }
         
        try (InputStream inputStream = multipartFile.getInputStream()) {
            Path filePath = uploadPath.resolve(fileName);
            //System.out.println("filepath :" + filePath);
            Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException ioe) {        
            throw new IOException("Could not save image file: " + fileName, ioe);
        } 
        //System.out.println("End of saveFile");
    }
}

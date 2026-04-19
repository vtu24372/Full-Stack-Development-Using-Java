package com.jobportal.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class FileUploadUtil {
    
    private static final String UPLOAD_DIR = "./uploads/";
    private static final String RESUME_DIR = UPLOAD_DIR + "resumes/";
    private static final String PROFILE_DIR = UPLOAD_DIR + "profiles/";
    
    static {
        // Create directories if they don't exist
        createDirectoryIfNotExists(UPLOAD_DIR);
        createDirectoryIfNotExists(RESUME_DIR);
        createDirectoryIfNotExists(PROFILE_DIR);
    }
    
    private static void createDirectoryIfNotExists(String dirPath) {
        File directory = new File(dirPath);
        if (!directory.exists()) {
            directory.mkdirs();
        }
    }
    
    public static String uploadFile(byte[] fileBytes, String fileName, String subDirectory) {
        try {
            String uploadPath = UPLOAD_DIR;
            if (subDirectory != null && !subDirectory.isEmpty()) {
                uploadPath = UPLOAD_DIR + subDirectory + "/";
                createDirectoryIfNotExists(uploadPath);
            }
            
            // Generate unique filename to avoid duplicates
            String uniqueFileName = System.currentTimeMillis() + "_" + fileName;
            Path path = Paths.get(uploadPath + uniqueFileName);
            Files.write(path, fileBytes);
            
            return "/uploads/" + (subDirectory != null ? subDirectory + "/" : "") + uniqueFileName;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public static String uploadResume(byte[] fileBytes, String fileName) {
        return uploadFile(fileBytes, fileName, "resumes");
    }
    
    public static String uploadProfilePicture(byte[] fileBytes, String fileName) {
        return uploadFile(fileBytes, fileName, "profiles");
    }
    
    public static boolean deleteFile(String filePath) {
        if (filePath == null || filePath.isEmpty()) {
            return false;
        }
        
        try {
            // Remove the /uploads/ prefix to get relative path
            String relativePath = filePath.replaceFirst("^/uploads/", "");
            Path path = Paths.get(UPLOAD_DIR + relativePath);
            return Files.deleteIfExists(path);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public static boolean fileExists(String filePath) {
        if (filePath == null || filePath.isEmpty()) {
            return false;
        }
        
        String relativePath = filePath.replaceFirst("^/uploads/", "");
        Path path = Paths.get(UPLOAD_DIR + relativePath);
        return Files.exists(path);
    }
    
    public static String getFileExtension(String fileName) {
        if (fileName == null || fileName.lastIndexOf(".") == -1) {
            return "";
        }
        return fileName.substring(fileName.lastIndexOf(".") + 1);
    }
    
    public static boolean isValidResumeFile(String fileName) {
        String extension = getFileExtension(fileName).toLowerCase();
        return extension.equals("pdf") || extension.equals("doc") || extension.equals("docx");
    }
    
    public static boolean isValidImageFile(String fileName) {
        String extension = getFileExtension(fileName).toLowerCase();
        return extension.equals("jpg") || extension.equals("jpeg") || extension.equals("png") || extension.equals("gif");
    }
    
    public static long getFileSize(String filePath) {
        if (filePath == null || filePath.isEmpty()) {
            return 0;
        }
        
        String relativePath = filePath.replaceFirst("^/uploads/", "");
        Path path = Paths.get(UPLOAD_DIR + relativePath);
        try {
            return Files.size(path);
        } catch (IOException e) {
            return 0;
        }
    }
}
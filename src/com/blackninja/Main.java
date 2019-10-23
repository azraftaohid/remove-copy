package com.blackninja;

import java.io.File;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<File> foldersInQue = new ArrayList<>();
        ArrayList<String> deletedFilesPath = new ArrayList<>();

        int totalScannedFiles = 0;

        String basePath = "C:\\Users\\azraf\\OneDrive\\Documents\\Projects";
        File baseFolder = new File(basePath);

        foldersInQue.add(baseFolder);
        for (int i = 0; i < foldersInQue.size(); i++) {
            File operatingFolder = foldersInQue.get(i);
            File[] subFiles = operatingFolder.listFiles();

            for (File file : subFiles != null ? subFiles : new File[0]) {
                if (file.isFile()) {
                    totalScannedFiles++;

                    String fileNameWithExt = file.getName();
                    String fileName = fileNameWithExt.substring(0, fileNameWithExt.lastIndexOf('.'));
                    String fileExt = fileNameWithExt.substring(fileNameWithExt.lastIndexOf('.'));
                    String copyFilePath = operatingFolder.getPath() + "\\" + fileName + " - Copy" + fileExt;

                    File copyFile = new File(copyFilePath);
                    if (copyFile.exists()) {
                        if (copyFile.lastModified() == file.lastModified()) {
                            if (copyFile.delete()) {
                                deletedFilesPath.add(copyFilePath);
                            } else {
                                System.out.println(copyFile.getName() + " could not be deleted");
                            }
                        } else {
                            System.out.println("Copy file exists but last modification time doesn't match");
                        }
                    }

                } else {
                    foldersInQue.add(file);
                }
            }
        }

        System.out.println("Files that are deleted: ");
        System.out.println(deletedFilesPath);

        System.out.println("Scanned directories: " + foldersInQue.size());
        System.out.println("Scanned files: " + totalScannedFiles);
        System.out.println("Deleted files: " + deletedFilesPath.size());
    }
}

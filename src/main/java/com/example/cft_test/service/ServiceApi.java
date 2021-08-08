package com.example.cft_test.service;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;

@Service
public class ServiceApi {
    private static final String FILE_DIR = "/opt/app/tmp";

    public List<File> listOfFiles() {

        File dir = new File(FILE_DIR);
        File[] arrFiles = dir.listFiles();
        List<File> lst = Arrays.asList(arrFiles);
        return lst;
    }

    public Resource download(String fileName) {
        Resource resource = new FileSystemResource(FILE_DIR + fileName);
        return resource;
    }


    public void upload(Resource resource, String fileName) {
        File fileUp = new File(FILE_DIR + fileName);
        try {
            OutputStream outStream = new FileOutputStream(fileUp);
            outStream.write(resource.getInputStream().readAllBytes());
            outStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

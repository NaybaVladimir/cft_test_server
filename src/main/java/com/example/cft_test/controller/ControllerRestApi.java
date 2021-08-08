package com.example.cft_test.controller;

import com.example.cft_test.service.ServiceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.util.List;


@RestController
@RequestMapping("/api")
public class ControllerRestApi {

    @Autowired
    private ServiceApi serviceApi;

    //Получить список файлов
    @GetMapping("/allFiles")
    public List<File> listOfFiles() {
        return serviceApi.listOfFiles();
    }

    //Сервер отдает файл
    @GetMapping("/getFile/{fileName}")
    public Resource download(@PathVariable("fileName") String fileName) {
        return serviceApi.download(fileName);
    }

    //Сервер принимает файл
    @PutMapping("/putFile/{fileName}")
    public ResponseEntity<Void> upload(@RequestBody Resource resource, @PathVariable("fileName") String fileName) {
        serviceApi.upload(resource, fileName);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}

package org.cosenza.apache.controller;

import org.cosenza.apache.service.ExcelService;
import org.cosenza.apache.utils.FileUtilities;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

@RestController
public class UploadController {

    private final ExcelService excelService;

    public UploadController(ExcelService excelService) {
        this.excelService = excelService;
    }

    @PostMapping("/upload")
    public String uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
        String content = new String(file.getBytes());

        //richiama qui excel service e lavoraci

        return content;
    }

    @PostMapping("/upload/csv")
    public List<List<String>> uploadCsvFile(@RequestParam("file") MultipartFile file) throws IOException {
        List<List<String>> fileContent = FileUtilities.readCsvFile(file);

        //richiama qui excel service e lavoraci

        return fileContent;
    }
}

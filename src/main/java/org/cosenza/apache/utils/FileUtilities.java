package org.cosenza.apache.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class FileUtilities {

    private FileUtilities() {
    }

    private final static String DELIMITER = ";";

    public static List<List<String>> readCsvFile(MultipartFile file) throws IOException {
        List<List<String>> result = new LinkedList<>();
        InputStream is = file.getInputStream();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(DELIMITER);
                result.add(Arrays.asList(values));
            }
        }
        return result;
    }
}

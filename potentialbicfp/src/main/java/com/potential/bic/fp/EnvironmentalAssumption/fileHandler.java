package com.potential.bic.fp.EnvironmentalAssumption;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class fileHandler {
    public static void saveFile(String path, String content) throws IOException {
        File file = new File(path);

        // Check if the file exists without considering case sensitivity
        if (!file.exists()) {
            Files.write(Paths.get(path), content.getBytes());
        } else {
            System.out.println("File already exists: " + path);
        }
    }
}

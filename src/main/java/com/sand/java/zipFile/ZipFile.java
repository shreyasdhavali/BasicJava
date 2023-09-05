package com.sand.java.zipFile;

import java.io.BufferedWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.*;
import java.util.HashMap;
import java.util.Map;

public class ZipFile {
    public static void main(String[] args) {

        try(FileSystem fs = openZip(Paths.get("src/com/shreyas/zipFile/mydata.zip"))) {
            copyToZip(fs);
            String[] data = {
                    "hello",
                    "Hey",
                    "How you doing?",
                    "Coffee?"
            };
            writeToZip1(fs, data);
            writeToZip2(fs, data);
        } catch (Exception e) {

        }
    }


    private static FileSystem openZip(Path zipPath) throws IOException, URISyntaxException {
        Map<String, String> mapping = new HashMap<>();
        mapping.put("create", "true");
//        URI zipUri = zipPath.toUri();
        URI zipUri = new URI("jar:file", zipPath.toUri().getPath(), null);
        FileSystem fs = FileSystems.newFileSystem(zipUri, mapping);
        return fs;
    }

    private static void copyToZip(FileSystem fs) throws IOException {
        Path sourceFile = Paths.get("src/com/shreyas/streams/file1.txt");
//        Path sourceFile = FileSystems.getDefault().getPath("src/com/shreyas/streams/file1.txt");
        Path destPath = fs.getPath("/file1copied.txt");
        Files.copy(sourceFile, destPath, StandardCopyOption.REPLACE_EXISTING);
    }

    private static void writeToZip1(FileSystem fs, String[] data) {
        try(BufferedWriter br = Files.newBufferedWriter(fs.getPath("/file1.txt"))) {
            for (String d: data) {
                br.write(d);
                br.newLine();
            }
            br.close();
        }catch (Exception e) {

        }
    }

    private static void writeToZip2(FileSystem fs, String[] data) {
        try(BufferedWriter br = Files.newBufferedWriter(fs.getPath("/file2.txt"))) {
            for (String d: data) {
                br.write(d);
                br.newLine();
            }
            br.close();
        }catch (Exception e) {

        }
    }
}

package com.sand.java.FileInputOutputStreams;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;

public class FileImplementation {
        public static void main(String[] args) {

            File f =  new File("java8-features.png");
            String encodstring = encodeFileToBase64Binary(f);
            System.out.println(encodstring);
        }

        private static String encodeFileToBase64Binary(File file){
            String encodedfile = null;
            try {
                FileInputStream fileInputStreamReader = new FileInputStream(file);
                byte[] bytes = new byte[(int)file.length()];
                fileInputStreamReader.read(bytes);
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            return encodedfile;
        }

        // For huge file reader
        public static void hugeFileReader() {
            String filePath = "path/to/your/largefile.txt";

            try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    // Process the line here
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void readLargeIMages() {
            String imagePath = "path/to/your/largeimage.jpg";

            try {
                BufferedImage image = ImageIO.read(new File(imagePath));
                // Process the image here
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void readLargeVideos() {
            String videoPath = "path/to/your/largevideo.mp4";

//            try (FFmpegFrameGrabber grabber = new FFmpegFrameGrabber(videoPath)) {
//                grabber.start();
//
//                Frame frame;
//                while ((frame = grabber.grab()) != null) {
//                    // Process the video frame here
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
        }
}

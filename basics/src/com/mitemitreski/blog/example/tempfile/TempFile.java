package com.mitemitreski.blog.example.tempfile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class TempFile {

   public static void main(String[] args) {

    try {
      // create a temp file
      File tempFile = File.createTempFile("old-file", ".tmp");
      tempFile.deleteOnExit();
      System.out.println("Temp file : " + tempFile.getAbsolutePath());
      // nio style
      final Path path = Files.createTempFile("nio-temp", ".tmp");
      System.out.println("Temp file : " + path);
      //call the same delete on exit
      path.toFile().deleteOnExit();

      Runtime.getRuntime().addShutdownHook(new Thread() {
        public void run() {
          try {
            Files.delete(path);
            System.out.println("deleted file at "+path);
          } catch (IOException e) {
            e.printStackTrace();
          }
        }
      });

    } catch (IOException e) {
      e.printStackTrace();

    }

  }

}

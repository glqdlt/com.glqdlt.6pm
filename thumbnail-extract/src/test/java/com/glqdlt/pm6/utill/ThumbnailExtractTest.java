package com.glqdlt.pm6.utill;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.*;
import java.util.concurrent.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class ThumbnailExtractTest {


    @Test
    public void zip() {
        File file = new File("E:\\glqdlt\\DeskTop\\zzzzzz\\aa");
        ExecutorService executorService = Executors.newFixedThreadPool(8);
        List<Future> l = new ArrayList<>();
        if (file.isDirectory()) {
            File[] ee = file.listFiles();
            for (File e : ee) {
                Future<?> future = executorService.submit(() -> {
                    if (e.isFile()) {
                        try {
                            if (e.getName().endsWith(".zip")) {
                                ZipFile zipFile = new ZipFile(e);
                                Enumeration<? extends ZipEntry> y = zipFile.entries();
                                ZipEntry d = y.nextElement();
                                try (InputStream zzz = zipFile.getInputStream(d)) {
                                    Files.copy(zzz, new File(e.getPath() + "_" + d.getName()).toPath(), StandardCopyOption.REPLACE_EXISTING);
                                }
                            }
                        } catch (IOException ex) {
                            ex.printStackTrace();
                            System.out.println(e.getName());
                        }
                    }
                });
                l.add(future);
            }
        }

        l.stream().forEach(x -> {
            try {
                x.get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        });

    }
}
package com.glqdlt.pm6.thumbnail;

import com.glqdlt.pm6.thumbnailextract.impl.ZipExtract;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.util.Scanner;

public class ApplicationMain {

    private static Logger logger = LoggerFactory.getLogger(ApplicationMain.class);

    public static void main(String[] args) throws IOException {

        Scanner aaa = new Scanner(System.in);
        logger.info("헬로우");
        String eeee = aaa.nextLine();
        URI target = new File(eeee).toURI();
        ZipExtract extractUtil = new ZipExtract(logger);
        String[] zz = extractUtil.extract(new File(target.getPath()));

        aaa.close();
    }
}

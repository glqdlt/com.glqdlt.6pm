package com.glqdlt.pm6.utill;

import org.junit.Ignore;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class PdfExtracterTest {

    @Ignore
    @Test
    public void name() throws IOException {
        PdfExtracter pdfExtracter = new PdfExtracter();
        String[] eee = pdfExtracter.extract(new File("E:\\Books\\abc.pdf"), new File("E:\\"));
        System.out.println(eee[0]);
    }
}
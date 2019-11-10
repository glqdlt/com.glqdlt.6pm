package com.glqdlt.pm6.utill;

import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageTree;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.graphics.PDXObject;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.apache.pdfbox.rendering.PDFRenderer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Date 2019-11-10
 * <p>
 * PDF 내용 첫장을 추출하려했는 데, 사실상 현재 하는 것은 pdf 내용을 캡처링 하는 것과 동일하다.
 *
 * @author glqdlt
 * @see <a href='https://www.baeldung.com/java-pdf-creation'>https://www.baeldung.com/java-pdf-creation</a>
 */
public class PdfExtracter implements Extracter {

    /**
     * 첫 page 의 엘리먼트를 순회하면서 이미지가 있으면 이를 저장하는 행위이다.
     * pdf 는 여러 문서 엘리먼트로 만들수있으니깐 이럼..
     * 내가만든 북스캔 pdf 는 어차피 통 이미지 이기 때문에.. COSName 에서 하나의 엘리먼트 통 이미지만 나올거라.. 문제가 없다.
     *
     * @param input
     * @param outputDir
     * @return
     * @throws IOException
     */
    @Override
    public String[] extract(File input, File outputDir) throws IOException {
        if (!outputDir.isDirectory()) {
            throw new RuntimeException("asdasd");
        }
        PDDocument document = PDDocument.load(input);
        PDPage firstPage = document.getPage(0);
        PDResources pageResources = firstPage.getResources();
        Iterable<COSName> els = pageResources.getXObjectNames();
        List<String> path = new LinkedList<>();
        for (COSName el : els) {
            PDXObject elObj = pageResources.getXObject(el);
            if (elObj instanceof PDImageXObject) {
                PDImageXObject imageOrigin = ((PDImageXObject) elObj);
                File f = makeImagePath(outputDir, imageOrigin.getSuffix());
                boolean result = ImageIO.write(imageOrigin.getImage(),
                        imageOrigin.getSuffix(),
                        f);
                if (result) {
                    path.add(f.getCanonicalPath());
                }
            }
        }
        return path.toArray(new String[0]);
    }

    private File makeImagePath(File dir, String suffix) throws IOException {
        Random random = new Random();
        int ran = random.nextInt(99);
        String target = dir.getCanonicalPath()
                + File.separator
                + LocalDateTime.now().format(DateTimeFormatter.ofPattern("YYYY_MM_dd_HH_mm_ss_"))
                + ran
                + "."
                + suffix;
        return new File(target);
    }

    // 아래는 pdf 를 캡처하는 방식이다.
//    @Override
//    public String extract(File pdf, File save) throws IOException {
//        PDDocument d = PDDocument.load(pdf);
//        PDFRenderer pdfRenderer = new PDFRenderer(d);
//        BufferedImage zz = pdfRenderer.renderImageWithDPI(0, getDpi());
//        ImageIO.write(zz, "PNG", new File("d:\\aa.png"));
//        d.close();
//
//        return null;
//    }
}

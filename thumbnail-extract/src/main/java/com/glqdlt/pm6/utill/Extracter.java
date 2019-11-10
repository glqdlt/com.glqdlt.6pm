package com.glqdlt.pm6.utill;

import java.io.File;
import java.io.IOException;

/**
 * Date 2019-11-10
 *
 * @author glqdlt
 */
public interface Extracter {
    String[] extract(File input, File output) throws IOException;
}

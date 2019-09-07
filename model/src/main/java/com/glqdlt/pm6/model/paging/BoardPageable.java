package com.glqdlt.pm6.model.paging;

import com.glqdlt.pm6.model.bbs.BoardContents;

import java.util.List;

/**
 * Date 2019-09-07
 *
 * @author glqdlt
 */
public interface BoardPageable<T extends BoardContents> {
    List<T> getContents();

    Long getAllElementsCount();

    Integer getOffset();

    Integer getPageNumb();
}

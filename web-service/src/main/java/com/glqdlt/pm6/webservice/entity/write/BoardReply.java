package com.glqdlt.pm6.webservice.entity.write;

import java.util.List;

/**
 * Date 2019-08-04
 *
 * @author glqdlt
 */
public interface BoardReply<T extends Reply> {
    void setReplies(List<T> replies);

    List<T> getReplies();
}

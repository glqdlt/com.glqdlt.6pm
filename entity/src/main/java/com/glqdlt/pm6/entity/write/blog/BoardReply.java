package com.glqdlt.pm6.entity.write.blog;

import java.util.List;

/**
 * Date 2019-08-04
 *
 * @author glqdlt
 */
@Deprecated
public interface BoardReply<T extends Reply> {
    void setReplies(List<T> replies);

    void addReply(T reply);

    List<T> getReplies();
}

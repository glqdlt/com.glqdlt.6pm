package com.glqdlt.pm6.webservice.entity.write.blog;

import com.glqdlt.pm6.webservice.entity.write.BoardReply;
import com.glqdlt.pm6.webservice.entity.write.UploadPost;

import java.util.List;

/**
 * Date 2019-08-04
 *
 * @author glqdlt
 */
public class BlogPost extends UploadPost implements BoardReply<BlogReply> {
    private List<BlogReply> replies;

    @Override
    public void setReplies(List<BlogReply> replies) {
        this.replies = replies;
    }

    @Override
    public List<BlogReply> getReplies() {
        return replies;
    }
}

package com.glqdlt.pm6.entity.write.blog;

import com.glqdlt.pm6.entity.write.BoardReply;
import com.glqdlt.pm6.entity.write.UploadPost;

import java.util.LinkedList;
import java.util.List;

/**
 * Date 2019-08-04
 *
 * @author glqdlt
 */
public class BlogPost extends UploadPost implements BoardReply<BlogReply> {
    private List<BlogReply> replies;

    {
        replies = new LinkedList<>();
    }

    @Override
    public void setReplies(List<BlogReply> replies) {
        this.replies = replies;
    }

    @Override
    public void addReply(BlogReply reply) {
        replies.add(reply);
    }

    @Override
    public List<BlogReply> getReplies() {
        return replies;
    }
}

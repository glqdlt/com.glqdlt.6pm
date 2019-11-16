package com.glqdlt.pm6.webcms.web.model.form.tag.author;

import com.glqdlt.pm6.persistence.author.entity.Pm6AuthorEntityBase;
import com.glqdlt.pm6.webcms.web.model.form.tag.TagForm;

/**
 * @author Jhun
 * 2019-11-15
 */
public class AuthorTag extends TagForm<Pm6AuthorEntityBase> {

    public AuthorTag(Pm6AuthorEntityBase ref) {
        super(ref);
    }

    @Override
    public String getInnerText() {
        return getRef().getName();
    }

    @Override
    public String getValue() {
        return String.valueOf(getRef().getNo());
    }
}

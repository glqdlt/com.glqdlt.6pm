package com.glqdlt.pm6.webcms.web.model.author;

import com.glqdlt.general.api.model.TextPairForm;
import com.glqdlt.pm6.persistence.author.entity.Pm6AuthorEntityBase;

/**
 * @author Jhun
 * 2019-11-15
 */
public class AuthorTag implements TextPairForm {

    private Pm6AuthorEntityBase pm6AuthorEntityBase;

    public AuthorTag(Pm6AuthorEntityBase pm6AuthorEntityBase) {
        this.pm6AuthorEntityBase = pm6AuthorEntityBase;
    }

    @Override
    public String getInnerText() {
        return this.pm6AuthorEntityBase.getName();
    }

    @Override
    public String getValue() {
        return String.valueOf(this.pm6AuthorEntityBase.getNo());
    }
}

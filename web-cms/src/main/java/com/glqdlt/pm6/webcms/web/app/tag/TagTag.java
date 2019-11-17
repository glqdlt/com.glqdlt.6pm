package com.glqdlt.pm6.webcms.web.app.tag;

import com.glqdlt.pm6.persistence.tag.entity.Pm6TagEntity;
import com.glqdlt.pm6.webcms.web.model.TagForm;

/**
 * Date 2019-11-16
 *
 * @author glqdlt
 */
public class TagTag extends TagForm<Pm6TagEntity> {
    public TagTag(Pm6TagEntity ref) {
        super(ref);
    }

    @Override
    public String getInnerText() {
        return getRef().getTagName();
    }

    @Override
    public String getValue() {
        return String.valueOf(getRef().getNo());
    }
}

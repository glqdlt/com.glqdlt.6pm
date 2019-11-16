package com.glqdlt.pm6.webcms.web.controller.restful.metadata;

import com.glqdlt.pm6.persistence.tag.entity.Pm6TagEntity;
import com.glqdlt.pm6.webcms.web.model.form.tag.tag.TagTag;

import java.util.List;

/**
 * Date 2019-11-16
 *
 * @author glqdlt
 */
public interface TagService extends DuplicateFindOrPersist<Pm6TagEntity> {
    List<TagTag> findAllTagTags();
}

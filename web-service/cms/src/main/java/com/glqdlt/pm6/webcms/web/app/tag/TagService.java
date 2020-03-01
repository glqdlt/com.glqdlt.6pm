package com.glqdlt.pm6.webcms.web.app.tag;

import com.glqdlt.pm6.jpapersistence.tag.entity.Pm6TagEntity;
import com.glqdlt.pm6.webcms.web.app.DuplicateFindOrPersist;

import java.util.List;

/**
 * Date 2019-11-16
 *
 * @author glqdlt
 */
public interface TagService extends DuplicateFindOrPersist<Pm6TagEntity> {
    List<TagTag> findAllTagTags();
}

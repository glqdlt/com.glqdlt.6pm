package com.glqdlt.pm6.webcms.web.controller.restful.metadata;

import com.glqdlt.pm6.persistence.tag.entity.Pm6TagEntity;
import com.glqdlt.pm6.persistence.tag.repo.Pm6TagRepo;
import com.glqdlt.pm6.webcms.web.model.form.tag.tag.TagTag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Date 2019-11-16
 *
 * @author glqdlt
 */
@Service
public class TagServiceImpl implements TagService {
    @Autowired
    private Pm6TagRepo pm6TagRepo;

    @Override
    public List<TagTag> findAllTagTags() {
        return pm6TagRepo.findAll().stream().map(TagTag::new).collect(Collectors.toList());
    }

    @Override
    public List<Pm6TagEntity> saveAll(List<Pm6TagEntity> entity) {
        return pm6TagRepo.saveAll(entity);
    }

    @Override
    public List<Pm6TagEntity> findAllByNames(List<String> names) {
        return pm6TagRepo.findAllByTagNameIsIn(names.toArray(new String[0]));
    }

    @Override
    public Pm6TagEntity createNewItem(String name) {
        return Pm6TagEntity.of(name);
    }

    @Override
    public List<Pm6TagEntity> createNewItem(List<String> names) {
        return Pm6TagEntity.of(names);
    }

}

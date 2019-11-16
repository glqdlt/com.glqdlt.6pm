package com.glqdlt.pm6.webcms.web.controller.restful.metadata;

import com.glqdlt.pm6.persistence.author.entity.Pm6AuthorEntity;
import com.glqdlt.pm6.persistence.author.repo.Pm6AuthorRepo;
import com.glqdlt.pm6.webcms.web.model.form.tag.author.AuthorTag;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Date 2019-11-16
 *
 * @author glqdlt
 */
@Service
public class AuthorServiceImpl implements AuthorService {

    private Pm6AuthorRepo pm6AuthorRepo;

    public AuthorServiceImpl(Pm6AuthorRepo pm6AuthorRepo) {
        this.pm6AuthorRepo = pm6AuthorRepo;
    }

    public List<AuthorTag> findAllAuthorTags() {
        List<Pm6AuthorEntity> originTags = pm6AuthorRepo.findAll();
        return originTags.stream().map(AuthorTag::new)
                .collect(Collectors.toList());
    }


    @Override
    public List<Pm6AuthorEntity> saveAll(List<Pm6AuthorEntity> entity) {
        return pm6AuthorRepo.saveAll(entity);
    }

    @Override
    public List<Pm6AuthorEntity> findAllByNames(List<String> names) {
        return pm6AuthorRepo.findAllByNameIn(names);
    }

    @Override
    public Pm6AuthorEntity createNewItem(String name) {
        return Pm6AuthorEntity.of(name);
    }

    @Override
    public List<Pm6AuthorEntity> createNewItem(List<String> names) {
        return Pm6AuthorEntity.of(names);
    }

}

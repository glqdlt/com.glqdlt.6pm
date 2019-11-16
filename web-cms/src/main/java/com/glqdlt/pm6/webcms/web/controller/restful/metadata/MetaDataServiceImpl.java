package com.glqdlt.pm6.webcms.web.controller.restful.metadata;

import com.glqdlt.pm6.persistence.author.entity.Pm6AuthorEntity;
import com.glqdlt.pm6.persistence.author.repo.Pm6AuthorRepo;
import com.glqdlt.pm6.webcms.web.model.author.AuthorTag;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Date 2019-11-16
 *
 * @author glqdlt
 */
@Service
public class MetaDataServiceImpl implements MetaDataService {

    private Pm6AuthorRepo pm6AuthorRepo;

    public MetaDataServiceImpl(Pm6AuthorRepo pm6AuthorRepo) {
        this.pm6AuthorRepo = pm6AuthorRepo;
    }

    public List<AuthorTag> findAllAuthorTags() {
        List<Pm6AuthorEntity> originTags = pm6AuthorRepo.findAll();
        return originTags.stream().map(AuthorTag::new)
                .collect(Collectors.toList());
    }
}

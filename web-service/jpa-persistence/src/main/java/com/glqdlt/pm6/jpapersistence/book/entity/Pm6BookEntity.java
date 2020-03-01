package com.glqdlt.pm6.jpapersistence.book.entity;

import com.glqdlt.pm6.jpapersistence.author.entity.Pm6AuthorEntity;
import com.glqdlt.pm6.jpapersistence.tag.entity.Pm6TagEntity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Date 2019-11-14
 *
 * @author glqdlt
 */
@Entity
@Table(name = "tb_book")
public class Pm6BookEntity extends Pm6BookEntityBase<Pm6TagEntity, Pm6AuthorEntity> {

    @Column(name = "thumbnail")
    @Override
    public String getThumbnailUrl() {
        return super.getThumbnailUrl();
    }

    @Override
    public LocalDateTime getRegDate() {
        return super.getRegDate();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Override
    public Long getNo() {
        return super.getNo();
    }

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "tb_book_and_tags",
            joinColumns = @JoinColumn(name = "book_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "tags_id", referencedColumnName = "id"))
    @Override
    public List<Pm6TagEntity> getTags() {
        return super.getTags();
    }

    @Override
    public String getDescription() {
        return super.getDescription();
    }

    @Override
    @Column(unique = true)
    public String getTitle() {
        return super.getTitle();
    }

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "tb_book_and_authors",
            joinColumns = @JoinColumn(name = "book_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "author_id", referencedColumnName = "id"))
    @Override
    public List<Pm6AuthorEntity> getAuthors() {
        return super.getAuthors();
    }

}

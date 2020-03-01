package com.glqdlt.pm6.webcms.web.app;

import com.glqdlt.general.api.model.NameWithNo;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Date 2019-11-16
 *
 * @author glqdlt
 */
public interface DuplicateFindOrPersist<E extends NameWithNo> {
    List<E> saveAll(List<E> entity);

    List<E> findAllByNames(List<String> names);

    E createNewItem(String name);

    List<E> createNewItem(List<String> names);


    @Transactional
    default List<E> onDuplicateAuthorFindOrPersist(List<String> names) {
        List<E> existItems = findAllByNames(names);
        if (existItems.size() == 0) {
            return saveAll(createNewItem(names));
        } else if (names.size() != existItems.size()) {
            List<E> newItems = isNotExistsCreateItem(names, existItems);
            List<E> savedNewItem = saveAll(newItems);
            return Stream.of(existItems, savedNewItem).flatMap(Collection::stream)
                    .collect(Collectors.toList());
        } else {
            return existItems;
        }
    }

    default List<E> isNotExistsCreateItem(List<String> names, List<E> existItems) {
        return names.stream()
                .filter(x -> existItems.stream().map(NameWithNo::getName).noneMatch(y -> y.equals(x)))
                .map(this::createNewItem)
                .collect(Collectors.toList());
    }
}

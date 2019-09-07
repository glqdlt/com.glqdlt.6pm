package com.glqdlt.pm6.entity.score;

/**
 * Date 2019-08-04
 *
 * @author glqdlt
 */
public class BadStar extends StarImpl {
    @Override
    public Long getScore() {
        return (long) -(getStar() * 2);
    }
}

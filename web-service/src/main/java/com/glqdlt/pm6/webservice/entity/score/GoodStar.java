package com.glqdlt.pm6.webservice.entity.score;

/**
 * Date 2019-08-04
 *
 * @author glqdlt
 */
public class GoodStar extends StarImpl {

    public GoodStar() {
    }

    public GoodStar(Integer star) {
        super(star);
    }

    @Override
    public Long getScore() {
        return (long) (getStar() * 5);
    }
}

package com.glqdlt.pm6.webservice.entity.score;

/**
 * Date 2019-08-04
 *
 * @author glqdlt
 */
public abstract class StarImpl implements Star {
    private Integer star;

    {
        this.star = 0;
    }

    public StarImpl() {

    }


    public StarImpl(Integer star) {
        this.star = star;
    }

    @Override
    public void setStar(Integer star) {
        this.star = star;
    }

    @Override
    public Integer getStar() {
        return this.star;
    }

    @Override
    public String getName() {
        return this.getClass().getName();
    }
}

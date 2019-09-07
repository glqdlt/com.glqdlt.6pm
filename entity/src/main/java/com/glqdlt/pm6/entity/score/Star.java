package com.glqdlt.pm6.entity.score;

/**
 * Date 2019-08-04
 *
 * @author glqdlt
 */
public interface Star extends WriteScore {
    void setStar(Integer star);

    Integer getStar();

    default Integer addStar() {
        Integer _star = this.getStar();
        this.setStar(_star + 1);
        return this.getStar();
    }

}

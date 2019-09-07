package com.glqdlt.pm6.entity.score;

import org.junit.Assert;
import org.junit.Test;

public class StarTest {
    @Test
    public void name() {
        StarImpl starDefault = new StarImpl() {
            @Override
            public Long getScore() {
                return Long.valueOf(getStar());
            }
        };
        Assert.assertEquals(StarImpl.class.getName(), starDefault.getName());

        GoodStar goodStar = new GoodStar();
        Assert.assertEquals(GoodStar.class.getName(), goodStar.getName());
    }

    @Test
    public void starPoint() {
        Star goodStar = new GoodStar(2);
        Assert.assertEquals(2, (int) goodStar.getStar());
        goodStar.addStar();
        Assert.assertEquals(3, (int) goodStar.getStar());
        Assert.assertEquals(15L, (long) goodStar.getScore());

        GoodStar goodStar1 = new GoodStar();
        Assert.assertEquals(0L, (long) goodStar1.getScore());

        BadStar badStar = new BadStar();
        Assert.assertEquals(0L, (long) badStar.getScore());
        badStar.addStar();
        Assert.assertEquals(-2L, (long) badStar.getScore());
    }
}

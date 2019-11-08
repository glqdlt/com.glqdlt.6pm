package com.glqdlt.pm6.utill;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Date 2019-09-22
 *
 * @author glqdlt
 */
public class SomGeneric {

    @Test
    public void name() {

        AAA_B[] aa = new AAA_B[1];
        aa[0] = new AAA_B();


        AAA_C[] bb = new AAA_C[1];
        bb[0] = new AAA_C();

        AAA[] eee = (AAA[]) bb;
        System.out.println(eee);

        List<AAA_B> aaa_bList = new ArrayList<>();
        List<AAA> yy = aaa_bList.stream().map(x -> (AAA) x).collect(Collectors.toList());

    }

    static class AAA_B extends AAA {


    }

    static class AAA_C extends AAA {


    }

    static class AAA {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}

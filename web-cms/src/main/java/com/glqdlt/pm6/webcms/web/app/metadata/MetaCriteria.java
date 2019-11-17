package com.glqdlt.pm6.webcms.web.app.metadata;

/**
 * Date 2019-11-17
 *
 * @author glqdlt
 */
public enum MetaCriteria implements MetaDataStore.MetaDataCriteria {

    AUTHOR {
        @Override
        public String getType() {
            return name();
        }
    },
    TAG {
        @Override
        public String getType() {
            return name();
        }
    };

}

package com.glqdlt.pm6.thumbnail;

import java.util.Locale;

public class LocaleHandler {

    public String getSystemLocale() {
        Locale l = Locale.getDefault();
        return l.getLanguage();
    }

    public SupportLocale matchLocale(String lang) {
        SupportLocale[] sls = SupportLocale.values();

        for (SupportLocale s : sls) {
            if (s.isSupported(lang)) {
                return s;
            }
        }
        return SupportLocale.ENGLISH;
    }

    enum SupportLocale {
        KOREAN("ko"),
        ENGLISH("en");

        SupportLocale(String locale) {
            this.locale = locale;
        }

        public String getLocale() {
            return locale;
        }

        public String getPropertyFileName() {
            return getLocale() + ".properties";
        }

        public Boolean isSupported(String locale) {
            return getLocale().equals(locale.toLowerCase());
        }

        private String locale;
    }
}

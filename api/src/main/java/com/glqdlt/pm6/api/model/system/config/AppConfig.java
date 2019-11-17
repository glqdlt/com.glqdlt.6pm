package com.glqdlt.pm6.api.model.system.config;

/**
 * Date 2019-11-17
 *
 * 시스템 초기값 설정 하는 엔티티에 쓸 예정
 * @author glqdlt
 */
public interface AppConfig {
    String getAppName();
    Boolean isAdminFirstPasswordSetup();
}

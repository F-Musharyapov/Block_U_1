package config;

import org.aeonbits.owner.Config;

/**
 * Интерфейс с основной конфигурацией проекта
 */
@Config.Sources({"classpath:config.properties"})
public interface BaseConfig extends Config {

    String formUrl();

    String authUrl();

    String driverPathChrome();

    String driverPropertyChrome();

    String driverPathEdge();

    String driverPropertyEdge();

    String driverPathIE();

    String driverPropertyIE();

    String remoteUrl();

    String fileCookiesAdress();

    String cookiesUrl();

    String cookieslogin();

    String cookiespass();

    String alertUrl();
}
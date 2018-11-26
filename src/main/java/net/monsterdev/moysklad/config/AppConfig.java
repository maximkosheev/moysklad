package net.monsterdev.automosreg.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({
        "net.monsterdev.moysklad.config",
        "net.monsterdev.moysklad.model",
        "net.monsterdev.moysklad.services",
        "net.monsterdev.moysklad.ui"})
public class AppConfig {

}

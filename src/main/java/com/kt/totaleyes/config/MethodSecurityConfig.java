package com.kt.totaleyes.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@Configurable
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class MethodSecurityConfig {

}

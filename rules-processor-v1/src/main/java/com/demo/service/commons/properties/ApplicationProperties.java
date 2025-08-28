package com.demo.service.commons.properties;

import com.demo.commons.properties.ConfigurationBaseProperties;
import com.demo.service.commons.properties.rules.RuleTemplate;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "configuration")
public class ApplicationProperties extends ConfigurationBaseProperties {

  private RuleTemplate rules;
}

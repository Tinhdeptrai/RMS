package com.ptit.rms.configuration;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.tps.audit")
public class AppConfig extends WebMvcConfigurerAdapter {

  /**
   * Configure ViewResolvers to deliver preferred views.
   */
  @Override
  public void configureViewResolvers(ViewResolverRegistry registry) {
    TilesViewResolver viewResolver = new TilesViewResolver();
    registry.viewResolver(viewResolver);
  }

  /**
   * Configure TilesConfigurer.
   */
  @Bean
  public TilesConfigurer tilesConfigurer() {
    TilesConfigurer tilesConfigurer = new TilesConfigurer();
    tilesConfigurer.setDefinitions(new String[] { "/WEB-INF/layouts/layout_without_authencatied.xml",
        "/WEB-INF/layouts/layout_with_authencatied.xml" });
    tilesConfigurer.setCheckRefresh(true);
    return tilesConfigurer;
  }

  /**
   * Configure ResourceHandlers to serve static resources like CSS/ Javascript
   * etc...
   */
  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    registry.addResourceHandler("/static/**").addResourceLocations("/static/");
    registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
    registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
  }

  @Bean
  public MessageSource messageSource() {
    ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
    messageSource.setBasename("messages");
    return messageSource;
  }

  /**
   * Optional. It's only required when handling '.' in @PathVariables which
   * otherwise ignore everything after last '.' in @PathVaidables argument. It's
   * a known bug in Spring [https://jira.spring.io/browse/SPR-6164], still
   * present in Spring 4.1.7. This is a workaround for this issue.
   */
  @Override
  public void configurePathMatch(PathMatchConfigurer matcher) {
    matcher.setUseRegisteredSuffixPatternMatch(true);
  }

  @Override
  public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
    configurer.enable();
  }

}

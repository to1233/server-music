package com.example.music.config;

import com.example.music.constant.SysConstant;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * @ClassName SysConfig
 * @Description 跨域配置类
 * @Author zhangyang
 * @Date 2022/5/29 17:41
 * @Version 1.0
 */
@Configuration
public class CorsConfiguration implements WebMvcConfigurer {


    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOriginPatterns("*")
                .allowedMethods("GET", "HEAD", "POST", "PUT", "DELETE", "OPTIONS")
                .allowCredentials(true)
                .maxAge(3600)
                .allowedHeaders("*");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/song/**")
                .addResourceLocations(SysConstant.SONG_PATH);
        registry.addResourceHandler("/img/singerPic/**")
                .addResourceLocations(SysConstant.SINGER_PIC_PATH);
        registry.addResourceHandler("/img/songListPic/**")
                .addResourceLocations(SysConstant.SONGLIST_PIC_PATH);
        registry.addResourceHandler("/img/songPic/**")
                .addResourceLocations(SysConstant.SONG_PIC_PATH);
        registry.addResourceHandler("/img/avatorImages/**")
                .addResourceLocations(SysConstant.AVATOR_IMAGES_PATH);
    }

    /**
     * 乱码处理
     */
    public HttpMessageConverter<String> responseBodyConverter() {
        final StringHttpMessageConverter converter = new StringHttpMessageConverter(StandardCharsets.UTF_8);
        converter.setWriteAcceptCharset(false);
        return converter;
    }

    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        if (converters.size() > 0) {
            converters.add(converters.get(0));
            converters.set(0, responseBodyConverter());
        } else {
            converters.add(responseBodyConverter());
        }
    }

}

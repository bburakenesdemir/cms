package com.burakenesdemir.cms.utils;

import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.FileCopyUtils;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UncheckedIOException;
import java.lang.reflect.Field;

import static java.nio.charset.StandardCharsets.UTF_8;

public class MailTemplateEngine {

    public static String bindHtml(Object dto, String fileName) throws IllegalAccessException {
        String htmlContent;

        ResourceLoader resourceLoader = new DefaultResourceLoader();
        Resource resource = resourceLoader.getResource("classpath:" + fileName);
        try (Reader reader = new InputStreamReader(resource.getInputStream(), UTF_8)) {
            htmlContent = FileCopyUtils.copyToString(reader);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }

        Field[] fs = dto.getClass().getDeclaredFields();
        for (Field f : fs) {
            f.setAccessible(true);
            String fieldName = f.getName();
            String value = String.valueOf(f.get(dto));
            if (value == null) {
                continue;
            }
            htmlContent = htmlContent.replace("${" + fieldName + "}", value);
        }

        return htmlContent;
    }
}


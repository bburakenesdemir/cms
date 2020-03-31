package com.burakenesdemir.cms.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;

import static com.burakenesdemir.cms.utils.StringUtil.SPECIAL_CHARS_REGEX;
import static com.burakenesdemir.cms.utils.StringUtil.replaceSpecialChars;

@Slf4j
@Service
public class FileService {

    @Value("${spring.image.url}")
    public String uploadDir;
    @Value("${spring.image.domain}")
    public String domain;

    public String uploadSliderImage(MultipartFile file) throws Exception {
        String filePath;
        if (file.isEmpty()) {
            throw new Exception("Could not found file {}");
        } else {
            filePath = uploadImage(file.getBytes(), file.getOriginalFilename());
        }

        return filePath;
    }

    public String uploadImage(byte[] file, String originalFileName) throws Exception {
        String fileName = replaceSpecialChars(originalFileName);
        fileName = fileName.replaceAll(SPECIAL_CHARS_REGEX, "");
        String millis = String.valueOf(System.currentTimeMillis());

        try (ByteArrayInputStream bis = new ByteArrayInputStream(file)) {
            BufferedImage bImage = ImageIO.read(bis);
            String[] imageNameArray = fileName.split("\\.");
            File outputFile = new File(uploadDir + File.separator + millis + fileName);
            ImageIO.write(bImage, imageNameArray[imageNameArray.length - 1], outputFile);
        } catch (Exception e) {
            log.info("Couldn't store the file {}", fileName);
            throw new Exception("Could not store file " + fileName
                    + ". Please try again!", e);
        }

        return domain + millis + fileName;
    }
}

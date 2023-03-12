//package com.api.aluguelcarro.service;
//
//import com.api.aluguelcarro.service.impl.ImgurService;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mock;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.nio.file.Files;
//import java.nio.file.Paths;
//import java.util.Base64;
//
//@SpringBootTest
//public class ImgurServiceTest {
//
//    @Mock
//    private ImgurService imgurService;
//
//    @Test
//    public void testUploadImage() throws Exception {
//
//        String base64 = "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";
//
//        MultipartFile multipartFile = ImgurService.base64ToMultipart(base64);
//
//        String link = imgurService.uploadImage(base64);
//
//        Assertions.assertNull(link);
//    }
//}

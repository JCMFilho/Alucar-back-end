//package com.api.aluguelcarro.service.impl;
//
//import java.io.*;
//
//import org.apache.http.HttpEntity;
//import org.apache.http.HttpHeaders;
//import org.apache.http.HttpResponse;
//import org.apache.http.client.methods.HttpPost;
//import org.apache.http.entity.ContentType;
//import org.apache.http.entity.mime.MultipartEntityBuilder;
//import org.apache.http.impl.client.HttpClientBuilder;
//import org.apache.http.util.EntityUtils;
//import org.springframework.core.io.Resource;
//import org.springframework.stereotype.Service;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.IOException;
//import java.nio.file.Path;
//import java.util.Base64;
//
//@Service
//public class ImgurService {
//
//    private static final String API_URL = "https://api.imgur.com/3/image";
//
//    private static final String API_KEY = "sua_chave_de_api";
//    private static final String API_SECRET = "seu_secret_de_api";
//
//    public String uploadImage(String base64) throws Exception {
//
//        MultipartFile imageFile = base64ToMultipart(base64);
//        MultipartEntityBuilder builder = MultipartEntityBuilder.create();
//        builder.addBinaryBody("image", imageFile.getBytes(), ContentType.APPLICATION_OCTET_STREAM, imageFile.getOriginalFilename());
//        HttpEntity entity = builder.build();
//        HttpPost request = new HttpPost("https://api.imgur.com/3/image");
//        request.addHeader(HttpHeaders.AUTHORIZATION, "Client-ID " + "e16a9ff2c31232b");
//        request.setEntity(entity);
//        HttpResponse response = HttpClientBuilder.create().build().execute(request);
//        String responseBody = EntityUtils.toString(response.getEntity());
//        String link = responseBody.split("\"link\":\"")[1].split("\",\"")[0];
//        return link;
//
//    }
//
//    public static MultipartFile base64ToMultipart(String base64) throws IOException {
//        byte[] bytes = Base64.getDecoder().decode(base64);
//
//        ByteArrayInputStream inputStream = new ByteArrayInputStream(bytes);
//
//        MultipartFile multipartFile = new MultipartFile() {
//            @Override
//            public String getName() {
//                return "file";
//            }
//
//            @Override
//            public String getOriginalFilename() {
//                return "file.jpg";
//            }
//
//            @Override
//            public String getContentType() {
//                return "image/jpeg";
//            }
//
//            @Override
//            public boolean isEmpty() {
//                return bytes.length == 0;
//            }
//
//            @Override
//            public long getSize() {
//                return bytes.length;
//            }
//
//            @Override
//            public byte[] getBytes() throws IOException {
//                return bytes;
//            }
//
//            @Override
//            public InputStream getInputStream() throws IOException {
//                return inputStream;
//            }
//
//            @Override
//            public Resource getResource() {
//                return MultipartFile.super.getResource();
//            }
//
//
//            @Override
//            public void transferTo(Path dest) throws IOException, IllegalStateException {
//                MultipartFile.super.transferTo(dest);
//            }
//
//            @Override
//            public void transferTo(File dest) throws IOException, IllegalStateException {
//
//            }
//        };
//
//        return multipartFile;
//    }
//
//}

package com.yagmurbeyru.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yagmurbeyru.controller.IAdminDuyuruController;
import com.yagmurbeyru.dto.DtoDuyuru;
import com.yagmurbeyru.exception.BaseException;
import com.yagmurbeyru.exception.ErrorMessage;
import com.yagmurbeyru.exception.MessageType;
import com.yagmurbeyru.services.impl.DuyuruServiceImpl;

@RestController
@RequestMapping("/rest/api/adminduyuru")
public class AdminDuyuruControllerImpl implements IAdminDuyuruController {

    @Autowired
    private DuyuruServiceImpl duyuruService;

    @PostMapping(value = "/save", consumes = {"multipart/form-data"})
    @Override
    public DtoDuyuru saveDuyuru(
            @RequestPart("duyuru") String duyuruJson, // JSON string olarak al
            @RequestPart(value = "file", required = false) MultipartFile file) {

        try {
            System.out.println("Gelen JSON: " + duyuruJson); // Debug için
            
            // JSON string'i DtoDuyuru'ya çevirme işlemi
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.registerModule(new com.fasterxml.jackson.datatype.jsr310.JavaTimeModule());
            objectMapper.disable(com.fasterxml.jackson.databind.SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
            
            DtoDuyuru duyuru = objectMapper.readValue(duyuruJson, DtoDuyuru.class);
            
            System.out.println("Parse edilen DTO: " + duyuru.getKonu()); // Debug için
            
            return duyuruService.saveDuyuru(duyuru, file);
            
            
        } catch (JsonProcessingException e) {
            throw new BaseException(new ErrorMessage(MessageType.JSON_PARSE_ERROR, e.getOriginalMessage()));
        } catch (Exception e) {
            throw new BaseException(new ErrorMessage(MessageType.GENERAL_EXCEPTION, e.getMessage()));
        }
    }

    @PutMapping(value = "/update/{id}", consumes = {"multipart/form-data"})
    @Override
    public DtoDuyuru updateDuyuru(
            @PathVariable(name = "id") Integer id,
            @RequestPart("duyuru") String duyuruJson,
            @RequestPart(value = "file", required = false) MultipartFile file) {

        try {
            
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.registerModule(new com.fasterxml.jackson.datatype.jsr310.JavaTimeModule());
            objectMapper.disable(com.fasterxml.jackson.databind.SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

            DtoDuyuru updatedduyuru = objectMapper.readValue(duyuruJson, DtoDuyuru.class);

            
            return duyuruService.updateDuyuru(id, updatedduyuru, file);

        } catch (JsonProcessingException e) {
            throw new BaseException(new ErrorMessage(MessageType.JSON_PARSE_ERROR, e.getOriginalMessage()));
        } catch (Exception e) {
            throw new BaseException(new ErrorMessage(MessageType.GENERAL_EXCEPTION, e.getMessage()));
        }
    }


    @DeleteMapping("/delete/{id}")
    @Override
    public boolean deleteDuyuru(@PathVariable(name="id") Integer id) {
        return duyuruService.deleteDuyuru(id);
    }
}
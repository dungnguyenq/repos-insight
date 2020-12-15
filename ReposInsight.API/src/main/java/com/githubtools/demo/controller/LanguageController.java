package com.githubtools.demo.controller;


import com.githubtools.demo.entity.dto.LanguageReturnDTO;
import com.githubtools.demo.enumeration.APIDefinition;
import com.githubtools.demo.service.LanguageService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/languages")
public class LanguageController {

    @Autowired
    LanguageService languageService;

    final static Logger logger = LogManager.getLogger(LanguageController.class);

    @GetMapping(value = APIDefinition.LANGUAGE_ALL)
    public List<LanguageReturnDTO> getLanguages(){
        List<LanguageReturnDTO> data = new ArrayList<>();
        try{
            data = languageService.getLanguages();
        } catch (Exception ex){
            logger.error(ex.getMessage());
        }
        return data;
    }

}

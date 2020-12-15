package com.githubtools.demo.service;

import com.githubtools.demo.entity.dto.*;
import com.githubtools.demo.enumeration.Constant;
import com.githubtools.demo.helper.GithubAPIHelper;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class LanguageServiceImpl implements LanguageService {

    @Override
    public List<LanguageReturnDTO> getLanguages() {
        String apiURL = String.format(Constant.GithubAPI.LIST_LANGUAGES);
        String json = GithubAPIHelper.get(apiURL);

        Gson g = new Gson();
        Type mapType = new TypeToken<Map<String, Long>>() {}.getType();
        Map<String, Long> languagesMap= g.fromJson(json, mapType);

        Long totalBytes = languagesMap.values().stream().reduce(Long.valueOf(0), Long::sum);

        DecimalFormat df = new DecimalFormat("#.##");
        df.setRoundingMode(RoundingMode.DOWN);

        List<LanguageReturnDTO> results = languagesMap.entrySet().stream().map(l -> new LanguageReturnDTO(l.getKey().toString(),
                df.format((((double)l.getValue() * 100)/(double)totalBytes)))).collect(Collectors.toList());

        return Collections.unmodifiableList(results);
    }
}

package com.githubtools.demo.service;

import com.githubtools.demo.entity.dto.LanguageReturnDTO;
import java.util.List;

public interface LanguageService {
    public List<LanguageReturnDTO> getLanguages();
}

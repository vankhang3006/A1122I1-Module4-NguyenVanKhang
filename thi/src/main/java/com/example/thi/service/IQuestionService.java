package com.example.thi.service;

import com.example.thi.model.Question;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IQuestionService extends IGeneralService<Question>{
    Page<Question> findByTitleContainingAndType_NameContaining(String title, String type, Pageable pageable);

}

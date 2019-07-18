package com.launchacademy.rescuemission.repositories;

import com.launchacademy.rescuemission.models.Question;
import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface QuestionRepository extends PagingAndSortingRepository<Question, Integer> {

  Question findById(int id);
  Question findByTitle(String title);
  public List<Question> findAllByOrderByQuestionTimeStampAsc();
  public List<Question> findAllByOrderByQuestionTimeStampDesc();
}

package com.launchacademy.rescuemission.repositories;

import com.launchacademy.rescuemission.models.Answer;
import com.launchacademy.rescuemission.models.Question;
import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface AnswerRepository extends PagingAndSortingRepository<Answer, Integer> {

  Answer findById(int id);
  Answer findByAnswerDescription(String answer);
  Answer findByQuestion(Question question);
  public List<Answer> findByQuestion_Id(int question_id);
}

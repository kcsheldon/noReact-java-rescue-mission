package com.launchacademy.rescuemission.controllers;

import com.launchacademy.rescuemission.models.Answer;
import com.launchacademy.rescuemission.models.Question;
import com.launchacademy.rescuemission.repositories.AnswerRepository;
import com.launchacademy.rescuemission.repositories.QuestionRepository;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class AnswerController {

  private final AnswerRepository answerRepository;
  private final QuestionRepository questionRepository;

  @Autowired
  public AnswerController(AnswerRepository answerRepository, QuestionRepository questionRepository) {
    this.answerRepository = answerRepository;
    this.questionRepository = questionRepository;
  }

  @GetMapping("/answers/new/{questionId}")
  public String getNewAnswer(@PathVariable int questionId, @ModelAttribute Answer answer, Model model) {
    model.addAttribute("answer", answer);

    Question question = questionRepository.findById(questionId);
    model.addAttribute("question", question);
    return "answers/new";
  }
  @PostMapping("/answers/{questionId}")
  public String postNewAnswer(
      @ModelAttribute @Valid Answer answer,
      BindingResult binding,
      Model model,
      @PathVariable Integer questionId) {
        if (binding.hasErrors()) {
          return "answers/new";
        } else {
          Question question = questionRepository.findById(questionId).orElse(null);
          answer.setQuestion(question);
          answerRepository.save(answer);
        //return "redirect:/questions/index";
          return "redirect:/questions/{questionId}";
    }
  }
}

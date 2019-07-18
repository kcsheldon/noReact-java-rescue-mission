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
  public class QuestionController {

    private final QuestionRepository questionRepository;
    private final AnswerRepository answerRepository;

    @Autowired
    public QuestionController(QuestionRepository questionRepository, AnswerRepository answerRepository) {
      this.questionRepository = questionRepository;
      this.answerRepository = answerRepository;
    }

    @GetMapping("/questions/new")
    public String getNewQuestion(@ModelAttribute Question question, Model model) {
      model.addAttribute("question", question);
      return "questions/new";
    }

    @GetMapping("/questions/index")
    public String getIndex(Model model) {
      model.addAttribute("questions", questionRepository.findAll());
      //model.addAttribute("aordered", questionRepository.findAllByOrderByQuestionTimeStampAsc());
      model.addAttribute("dordered", questionRepository.findAllByOrderByQuestionTimeStampDesc());
      return "questions/index";
    }

    @PostMapping("/questions")
    public String create(@ModelAttribute @Valid Question question, BindingResult binding,
        Model model) {

      if (binding.hasErrors()) {
        return "questions/new";
      } else {
        questionRepository.save(question);
        return "redirect:/questions/index";
      }
    }
    @GetMapping("/questions/{questionId}")
    public String getQuestionDetails(@PathVariable int questionId, @ModelAttribute Answer answer, Model model) {

      Question question = questionRepository.findById(questionId);
      model.addAttribute("question", question);
      model.addAttribute("answers", answerRepository.findByQuestion_Id(questionId));
      return "questions/show";
    }
  }

package com.launchacademy.rescuemission.models;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.NonNull;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenerationTime;
import org.hibernate.annotations.Generated;

@Entity
  @Table(name="answers")
  @Getter
  @Setter
  @NoArgsConstructor
  @ToString
  public class Answer {

    @Id
    @SequenceGenerator(name = "answer_generator",
        sequenceName = "answers_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
        generator = "answer_generator")
    @Column(name="id", nullable=false, unique=true)
    private Integer id;

    @NotBlank
    //@Size(min=50, max =500)
    @NonNull
    @Column(name="answerdescription", nullable = false)
    private String answerDescription;

    //@Column(name="question_id")
    //private Integer question_id;

    @Column(name = "answertimestamp")
    @CreationTimestamp
    private Timestamp answerTimeStamp;

  @ManyToOne
  @JoinColumn(name = "question_id", nullable = false)
  private Question question;

  }

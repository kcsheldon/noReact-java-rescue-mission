package com.launchacademy.rescuemission.models;

import java.sql.Timestamp;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

@Entity
@Table(name="questions")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Question {
  @Id
  @SequenceGenerator(name = "question_generator",
      sequenceName = "questions_id_seq", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE,
      generator = "question_generator")
  @Column(name="id", nullable=false, unique=true)
  private Integer id;

  @NotBlank
  //@Size(min=20)
  @NonNull
  @Column(name="title", nullable = false)
  private String title;

  @NotBlank
  //@Size(min = 50)
  @Column(name="description", nullable = false)
  private String description;

  @Column(name = "questiontimestamp")
  @CreationTimestamp
  private Timestamp questionTimeStamp;

  @OneToMany(mappedBy = "question")
  private Set<Answer> answers;

}

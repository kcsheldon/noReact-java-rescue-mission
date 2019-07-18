CREATE TABLE questions(
  id SERIAL PRIMARY KEY,
  title VARCHAR(255) NOT NULL,
  description TEXT NOT NULL,
  questiontimestamp TIMESTAMP
);

CREATE TABLE answers (
    id SERIAL PRIMARY KEY,
    answerdescription TEXT NOT NULL,
    answertimestamp TIMESTAMP,
    question_id INTEGER REFERENCES questions(id)
);
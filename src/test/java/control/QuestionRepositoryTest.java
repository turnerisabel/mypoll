package control;

import at.htl.control.AnswerRepository;
import at.htl.control.QuestionRepository;
import at.htl.entity.Answer;
import at.htl.entity.AnswerOption;
import at.htl.entity.Question;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import javax.transaction.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@QuarkusTest
public class QuestionRepositoryTest {

        @BeforeEach
        @Transactional
        void setUp() {
            questionRepository.deleteAll();
        }

        @AfterEach
        @Transactional
        void cleanUp() {
            questionRepository.deleteAll();
        }

        @Inject
        QuestionRepository questionRepository;

        @Inject
        AnswerRepository answerRepository;

        @DisplayName("test question creation")
        @Test
        void t01_createQuestion() {

            Answer answer = new Answer("198.168.0.1", new AnswerOption("A"));
            List<AnswerOption> answerOptions = new ArrayList<>(Arrays.asList(new AnswerOption("A"), new AnswerOption("B"), new AnswerOption("C")));

            Question question = new Question(answer,answerOptions);
            questionRepository.persist(question);

            assertThat(questionRepository.findById(question.getId())).isEqualTo(question);
        }

        @DisplayName("test question updating")
        @Test
        void t02_updateQuestion() {
            Answer answer = new Answer("198.168.0.1", new AnswerOption("A"));
            List<AnswerOption> answerOptions = new ArrayList<>(Arrays.asList(new AnswerOption("A"), new AnswerOption("B"), new AnswerOption("C")));
            Question question = new Question(answer, answerOptions);

            questionRepository.persist(question);

            answer = new Answer("198.168.0.1", new AnswerOption("B"));
            answerRepository.persist(answer);
            question.setAnswer(answer);
            questionRepository.save(question);

            assertThat(questionRepository.findById(question.getId())).isEqualTo(question);
        }

        @DisplayName("test question deleting")
        @Test
        void t03_deleteQuestion() {
            Answer answer = new Answer("198.168.0.1", new AnswerOption("A"));
            List<AnswerOption> answerOptions = new ArrayList<>(Arrays.asList(new AnswerOption("A"), new AnswerOption("B"), new AnswerOption("C")));
            Question question = new Question(answer, answerOptions);

            questionRepository.persist(question);

            questionRepository.deleteById(question.getId());

            assertThat(questionRepository.findById(question.getId())).isNull();
        }
}

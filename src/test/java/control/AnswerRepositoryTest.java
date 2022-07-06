package control;

import at.htl.control.AnswerRepository;
import at.htl.entity.Answer;
import at.htl.entity.AnswerOption;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import javax.transaction.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@QuarkusTest
public class AnswerRepositoryTest {

    @BeforeEach
    @Transactional
    void setUp() {
        answerRepository.deleteAll();
    }

    @AfterEach
    @Transactional
    void cleanUp() {
        answerRepository.deleteAll();
    }

    @Inject
    AnswerRepository answerRepository;

    @DisplayName("test answer creation")
    @Test
    void t01_createAnswer() {
        Answer answer = new Answer("198.168.0.1", new AnswerOption("A"));
        answerRepository.persist(answer);

        assertThat(answerRepository.findById(answer.getId())).isEqualTo(answer);
    }

    @DisplayName("test answer updating")
    @Test
    void t02_updateAnswer() {
        Answer answer = new Answer("198.168.0.1", new AnswerOption("A"));
        answerRepository.persist(answer);

        answer.setAnswerOption(new AnswerOption("B"));
        answerRepository.save(answer);

        assertThat(answerRepository.findById(answer.getId())).isEqualTo(answer);
    }

    @DisplayName("test answer deleting")
    @Test
    void t03_deleteAnswer() {
        Answer answer = new Answer("198.168.0.1", new AnswerOption("A"));
        answerRepository.persist(answer);

        answerRepository.deleteById(answer.getId());

        assertThat(answerRepository.findById(answer.getId())).isNull();
    }
}

package control;

import at.htl.control.AnswerOptionRepository;
import at.htl.entity.Answer;
import at.htl.entity.AnswerOption;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@QuarkusTest
public class AnswerOptionRepositoryTest {

    @BeforeEach
    @Transactional
    void setUp() {
        answerOptionRepository.deleteAll();
    }

    @AfterEach
    @Transactional
    void cleanUp() {
        answerOptionRepository.deleteAll();
    }

    @Inject
    AnswerOptionRepository answerOptionRepository;

    @DisplayName("test answer option creation")
    @Test
    void t01_createAnswerOption() {
        AnswerOption answerOption = new AnswerOption("A");
        answerOptionRepository.persist(answerOption);

        assertThat(answerOptionRepository.findById(answerOption.getId())).isEqualTo(answerOption);
    }

    @DisplayName("test answer option updating")
    @Test
    void t02_updateAnswerOption() {
        AnswerOption answerOption = new AnswerOption("A");
        answerOptionRepository.persist(answerOption);

        answerOption.setAnswerOption("B");
        answerOptionRepository.save(answerOption);

        assertThat(answerOptionRepository.findById(answerOption.getId())).isEqualTo(answerOption);
    }

    @DisplayName("test answer deleting")
    @Test
    void t03_deleteAnswerOption() {
        AnswerOption answerOption = new AnswerOption("A");
        answerOptionRepository.persist(answerOption);

        answerOptionRepository.deleteById(answerOption.getId());

        assertThat(answerOptionRepository.findById(answerOption.getId())).isNull();
    }
}

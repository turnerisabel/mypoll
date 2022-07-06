package control;

import at.htl.control.AnswerOptionRepository;
import at.htl.entity.Answer;
import at.htl.entity.AnswerOption;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;


import javax.inject.Inject;
import javax.persistence.EntityManager;

public class AnswerOptionRepositoryTest {

    @Inject
    AnswerOptionRepository answerOptionRepository;

    @Test
    void t01_createAnswer(){
        AnswerOption answerOption = new AnswerOption("A");
        answerOptionRepository.persist(answerOption);

        assertThat(answerOptionRepository.isPersistent(answerOption)).isTrue();

    }
}

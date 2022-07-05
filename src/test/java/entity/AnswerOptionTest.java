package entity;

import at.htl.entity.AnswerOption;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AnswerOptionTest {

    @Test
    void t010_addAnswerOption(){
        AnswerOption answerOption = new AnswerOption("A");

        assertThat(answerOption.toString()).isEqualTo("{answerOption='A'}");

    }
}

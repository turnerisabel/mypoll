package entity;

import at.htl.entity.AnswerOption;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AnswerOptionTest {

    @DisplayName("test answerOption creation")
    @Test
    void t01_createAnswerOption(){
        AnswerOption answerOption = new AnswerOption("A");

        assertThat(answerOption.toString()).isEqualTo("{answerOption='A'}");
    }
}

package entity;

import at.htl.entity.Answer;
import at.htl.entity.AnswerOption;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;


public class AnswerTest {

    @DisplayName("test answer creation")
    @Test
    void t01_createAnswer(){
        //Long id = 1L;
        String IpAdress = "192.168.0.1";
        AnswerOption answerOption = new AnswerOption("A");
        Answer answer = new Answer(IpAdress, answerOption);

        assertThat(answer.toString()).isEqualTo("Answer{id=null, IpAdress='192.168.0.1', {answerOption='A'}");

    }
}

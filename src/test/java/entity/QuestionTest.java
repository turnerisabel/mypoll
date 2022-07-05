package entity;

import at.htl.entity.Answer;
import at.htl.entity.AnswerOption;
import at.htl.entity.Question;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;


public class QuestionTest {

    @Test
    void addQuestion(){

        AnswerOption answerOption = new AnswerOption("A");
        Answer answer = new Answer("198.168.0.1", answerOption);

        Question question = new Question(
                answer,
                answerOption
        );

        assertThat(question.toString()).isEqualTo("Question{id=null, IpAdress=198.168.0.1, answerOption=A");
    }
}

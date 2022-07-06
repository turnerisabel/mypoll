package entity;

import at.htl.entity.Answer;
import at.htl.entity.AnswerOption;
import at.htl.entity.Question;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class QuestionTest {

    @DisplayName("Test Question creation with three answers")
    @Test
    void t01_createQuestion(){

        List<AnswerOption> answerOptions = new ArrayList<>(Arrays.asList(new AnswerOption("A"), new AnswerOption("B"), new AnswerOption("C")));
        Answer answer = new Answer("198.168.0.1", answerOptions.get(0));

        Question question = new Question(
                answer,
                answerOptions
        );

        System.out.println(question.toString());
        assertThat(question.toString()).isEqualTo("Question{id=null, answer=Answer{id=null, IpAdress='198.168.0.1', {answerOption='A'}, answerOptions=[{answerOption='A'}, {answerOption='B'}, {answerOption='C'}]}");
    }
}

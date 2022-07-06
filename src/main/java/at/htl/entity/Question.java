package at.htl.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "QUESTION")
public class Question extends PanacheEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Q_ID")
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "A_ID")
    private Answer answer;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "AO_ID")
    private AnswerOption answerOption;

    public Question() {
    }

    public Question(Answer answer, AnswerOption answerOption) {
        this.answer = answer;
        this.answerOption = answerOption;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }

    public AnswerOption getAnswerOption() {
        return answerOption;
    }

    public void setAnswerOption(AnswerOption answerOption) {
        this.answerOption = answerOption;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Question question = (Question) o;
        return Objects.equals(id, question.id) && Objects.equals(answer, question.answer) && Objects.equals(answerOption, question.answerOption);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, answer, answerOption);
    }

    @Override
    public String toString() {
        return "Question{" +
                //"id=" + id +
                " " + answer;
                //", " + answerOption +
    }
}

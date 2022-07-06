package at.htl.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "P_QUESTION")
public class Question extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "QUESTION_ID")
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ANSWER_ID")
    private Answer answer;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "QUESTION_ID")
    private List<AnswerOption> answerOptions;

    public Question() {
    }

    public Question(Answer answer, List<AnswerOption> answerOptions) {
        this.answer = answer;
        this.answerOptions = answerOptions;
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

    public List<AnswerOption> getAnswerOptions() {
        return answerOptions;
    }

    public void setAnswerOptions(List<AnswerOption> answerOptions) {
        this.answerOptions = answerOptions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Question question = (Question) o;
        return Objects.equals(id, question.id) && Objects.equals(answer, question.answer) && Objects.equals(answerOptions, question.answerOptions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, answer, answerOptions);
    }


    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", answer=" + answer +
                ", answerOptions=" + answerOptions +
                '}';
    }
}

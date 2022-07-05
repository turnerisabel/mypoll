package at.htl.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "ANSWER_OPTION")
public class AnswerOption extends PanacheEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AO_ID")
    private Long id;

    @Column(name = "AO_ANSWER_OPTION")
    private String answerOption;

    public AnswerOption() {
    }

    public AnswerOption(String answerOption) {
        this.answerOption = answerOption;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOption() {
        return answerOption;
    }

    public void setAnswerOption(String answerOption) {
        this.answerOption = answerOption;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AnswerOption that = (AnswerOption) o;
        return Objects.equals(id, that.id) && Objects.equals(answerOption, that.answerOption);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, answerOption);
    }

    @Override
    public String toString() {
        return "{" +
                "answerOption='" + answerOption + '\'' +
                '}';
    }
}

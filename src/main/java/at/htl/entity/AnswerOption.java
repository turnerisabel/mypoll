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

    @Column(name = "AO_OPTION")
    private String option;

    public AnswerOption() {
    }

    public AnswerOption(String option) {
        this.option = option;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AnswerOption that = (AnswerOption) o;
        return Objects.equals(id, that.id) && Objects.equals(option, that.option);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, option);
    }

    @Override
    public String toString() {
        return "AnswerOption{" +
                "id=" + id +
                ", option='" + option + '\'' +
                ", id=" + id +
                '}';
    }
}

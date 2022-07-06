package at.htl.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "P_ANSWER")
public class Answer extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ANSWER_ID")
    private Long id;

    @Column(name = "ANSWER_IP_ADRESS")
    private String IpAdress;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ANSWER_OPTION_ID")
    private AnswerOption answerOption;

    public Answer() {
    }

    public Answer(String ipAdress, AnswerOption answerOption) {
        IpAdress = ipAdress;
        this.answerOption = answerOption;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIpAdress() {
        return IpAdress;
    }

    public void setIpAdress(String ipAdress) {
        IpAdress = ipAdress;
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
        Answer answer = (Answer) o;
        return Objects.equals(id, answer.id) && Objects.equals(IpAdress, answer.IpAdress) && Objects.equals(answerOption, answer.answerOption);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, IpAdress, answerOption);
    }

    @Override
    public String toString() {
        return "Answer{" +
                "id=" + id +
                ", IpAdress='" + IpAdress + '\'' +
                ", " + answerOption;
    }
}


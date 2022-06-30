package at.htl.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "ANSWER")
public class Answer extends PanacheEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "A_ID")
    private Long id;

    @Column(name = "A_IP_ADRESS")
    private String IpAdress;

    @Column(name = "A_OPTION")
    private String option;

    public Answer() {
    }

    public Answer(String ipAdress, String option) {
        IpAdress = ipAdress;
        this.option = option;
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
        Answer answer = (Answer) o;
        return Objects.equals(id, answer.id) && Objects.equals(IpAdress, answer.IpAdress) && Objects.equals(option, answer.option);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, IpAdress, option);
    }

    @Override
    public String toString() {
        return "Answer{" +
                "id=" + id +
                ", IpAdress='" + IpAdress + '\'' +
                ", option='" + option + '\'' +
                ", id=" + id +
                '}';
    }
}

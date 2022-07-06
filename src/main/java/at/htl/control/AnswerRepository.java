package at.htl.control;

import at.htl.entity.Answer;
import at.htl.entity.AnswerOption;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@ApplicationScoped
@Transactional
public class AnswerRepository implements PanacheRepository<Answer> {

    public void save(Answer answer){
        this.getEntityManager().merge(answer);
    }
}

package com.kcodes.studygame.repositories;


import com.kcodes.studygame.model.Question;
import com.kcodes.studygame.model.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface QuestionRepo extends JpaRepository<Question, Integer> {
        Set<Question> getByTopic(Topic topic);

}

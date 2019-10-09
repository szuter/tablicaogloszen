package pl.coderslab.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.app.model.Message;
import pl.coderslab.app.model.User;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {

    List<Message> findAllByRecipientOrderByCreatedDesc(User user);

   List<Message> findAllBySenderOrderByCreatedDesc(User user);
}

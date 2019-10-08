package pl.coderslab.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.app.model.Comment;

public interface CommentRepository extends JpaRepository<Comment,Long> {
}

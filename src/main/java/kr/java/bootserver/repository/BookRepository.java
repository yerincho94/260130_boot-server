package kr.java.bootserver.repository;

import kr.java.bootserver.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}

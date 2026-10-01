package mx.com.company.demo2.backend.repository;

import mx.com.company.demo2.backend.document.ShowDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ShowRepository extends MongoRepository<ShowDocument, Long> {
}
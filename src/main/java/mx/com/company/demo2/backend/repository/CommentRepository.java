package mx.com.company.demo2.backend.repository;

import mx.com.company.demo2.backend.document.CommentDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CommentRepository extends MongoRepository<CommentDocument, String> {

    List<CommentDocument> findByShowId(Long showId);
}
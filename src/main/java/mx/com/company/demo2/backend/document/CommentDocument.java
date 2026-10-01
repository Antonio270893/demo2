package mx.com.company.demo2.backend.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "comments")
public class CommentDocument {

    @Id
    private String id;

    private Long showId;

    private String comment;

    private Integer rating;
}
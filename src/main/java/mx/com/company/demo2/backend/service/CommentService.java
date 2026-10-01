
package mx.com.company.demo2.backend.service;

import java.util.List;

import mx.com.company.demo2.backend.dto.CommentResponse;
import mx.com.company.demo2.backend.request.CommentRequest;

public interface CommentService {

    void saveComment(Long showId, CommentRequest request);
    List<CommentResponse> getCommentsByShowId(Long showId);
}

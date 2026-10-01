package mx.com.company.demo2.backend.service.impl;

import lombok.RequiredArgsConstructor;
import mx.com.company.demo2.backend.document.CommentDocument;
import mx.com.company.demo2.backend.dto.CommentResponse;
import mx.com.company.demo2.backend.repository.CommentRepository;
import mx.com.company.demo2.backend.request.CommentRequest;
import mx.com.company.demo2.backend.service.CommentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;

    @Override
    public void saveComment(Long showId, CommentRequest request) {
        CommentDocument comment = new CommentDocument(
                null,
                showId,
                request.comment(),
                request.rating()
        );

        commentRepository.save(comment);
    }

    @Override
    public List<CommentResponse> getCommentsByShowId(Long showId) {
        return commentRepository.findByShowId(showId)
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    private CommentResponse mapToResponse(CommentDocument comment) {
        return new CommentResponse(
                comment.getComment(),
                comment.getRating()
        );
    }
}
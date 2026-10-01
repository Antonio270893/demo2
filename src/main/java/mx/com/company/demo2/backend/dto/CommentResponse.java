package mx.com.company.demo2.backend.dto;

public record CommentResponse(
        String comment,
        Integer rating
) {
}
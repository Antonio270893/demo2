package mx.com.company.demo2.backend.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import mx.com.company.demo2.backend.request.CommentRequest;
import mx.com.company.demo2.backend.service.CommentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/shows")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/{showId}/comments")
    public ResponseEntity<Void> saveComment(
            @PathVariable Long showId,
            @Valid @RequestBody CommentRequest request) {

        commentService.saveComment(showId, request);

        return ResponseEntity.status(201).build();
    }
}
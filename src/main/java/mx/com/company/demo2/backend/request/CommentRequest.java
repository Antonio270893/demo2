package mx.com.company.demo2.backend.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record CommentRequest(
        @NotBlank(message = "El comentario es obligatorio")
        String comment,

        @Min(value = 0, message = "La calificación mínima es 0")
        @Max(value = 5, message = "La calificación máxima es 5")
        Integer rating
) {
}
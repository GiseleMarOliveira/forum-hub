package br.com.alura.forumhub.topic;

import br.com.alura.forumhub.answer.AnswerDisplayDAO;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.util.List;

public record TopicDisplayDetailDAO(
        @JsonProperty("titulo")
        String title,
        @JsonProperty("mensagem")
        String message,
        @JsonProperty("data_criacao")
        LocalDateTime creationDate,
        Status status,
        @JsonProperty("autor")
        String author,
        List<AnswerDisplayDAO> answers) {
    public TopicDisplayDetailDAO(Topic topic) {
        this(topic.getTitle(), topic.getMessage(), topic.getCreationDate(), topic.getStatus(), topic.getAuthor().getName(), topic.getAnswers());
    }
}
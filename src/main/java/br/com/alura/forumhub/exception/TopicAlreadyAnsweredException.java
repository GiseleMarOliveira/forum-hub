package br.com.alura.forumhub.exception;

public class TopicAlreadyAnsweredException extends RuntimeException {
    public TopicAlreadyAnsweredException(String message) {
        super(message);
    }
}
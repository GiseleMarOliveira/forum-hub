package br.com.alura.forumhub.topic;

import br.com.alura.forumhub.answer.Answer;
import br.com.alura.forumhub.answer.AnswerDisplayDAO;
import br.com.alura.forumhub.user.User;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Table(name = "topicos")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@EqualsAndHashCode(of = "id")
public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "titulo")
    private String title;
    @Column(name = "mensagem")
    private String message;
    @Column(name = "data_criacao")
    private LocalDateTime creationDate;
    @Setter
    @Enumerated(EnumType.STRING)
    private Status status;

    @Setter
    @ManyToOne
    @JoinColumn(name = "autor")
    private User author;

    @OneToMany(mappedBy = "topic", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Answer> answers = new ArrayList<>();

    public Topic(TopicDataReceiverDTO data) {
        this.title = data.title();
        this.message = data.message();
        this.creationDate = data.creationDate();
        this.status = Status.NAO_RESPONDIDO;
    }

    public void updateTopic(TopicUpdatingDataReceiverDTO data) {
        this.title = data.title();
        this.message = data.message();
    }

    public List<AnswerDisplayDAO> getAnswers() {
        return answers.stream().map(AnswerDisplayDAO::new).toList();
    }
}

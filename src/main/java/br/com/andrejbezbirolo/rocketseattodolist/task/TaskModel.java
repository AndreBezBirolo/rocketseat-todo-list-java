package br.com.andrejbezbirolo.rocketseattodolist.task;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity(name = "tb_tasks")
public class TaskModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(length = 50)
    private String title;

    private String description;
    private LocalDateTime startAt;
    private LocalDateTime endAt;
    private String priority;
    private UUID idUser;
}

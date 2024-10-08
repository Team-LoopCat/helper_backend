package org.example.persistence.teacher.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.example.persistence.auth.entity.UserJpaEntity;
import org.hibernate.annotations.ColumnDefault;

import java.util.UUID;

@Getter
@Entity(name = "teacher")
@AllArgsConstructor
public class TeacherJpaEntity {
    @Id
    @Column(nullable = false, columnDefinition = "BINARY(16)")
    private UUID teacherId;

    @OneToOne(cascade = CascadeType.ALL, optional = false, targetEntity = UserJpaEntity.class)
    @JoinColumn(name = "userId", referencedColumnName = "userId")
    private UserJpaEntity user;

    @Column(nullable = false, columnDefinition = "varchar(5)")
    private String name;

    @ColumnDefault("'DEFAULT_IMG_URL'") // todo: 기본 이미지 URL 정해지면 그걸로 바꾸기
    @Column(nullable = false, columnDefinition = "varchar(100)")
    private String profile;

    protected TeacherJpaEntity() {};
}

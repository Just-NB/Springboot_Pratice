package com.example.demo.controller.domain;

/*
보통 Entity에는 데이터의 생성/수정시간을 포함한다.
이를 위한 클래스를 LocalDate or LocalDateTime을 이용하여 만든다.
*/

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass // JPA Entity클래스들이 BaseTimeEntity(현재 클래스)를 상속할 경우, 필드들도 칼럼으로 인식하도록 한다.
@EntityListeners(AuditingEntityListener.class) // BaseTimeEntity(현재 클래스)에 Auditing기능을 포함한다.
public class BaseTimeEntity {

    @CreatedDate // Entity가 생성되어 저장될 때 시간이 자동저장된다.
    private LocalDateTime createdDate;

    @LastModifiedDate // Entity가 변경될 때 시간이 자동저장된다.
    private LocalDateTime modifiedDate;
}

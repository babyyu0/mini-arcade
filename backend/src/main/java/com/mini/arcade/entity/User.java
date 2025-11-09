package com.mini.arcade.entity;

import com.mini.arcade.dto.UserResponseDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Comment;

@AllArgsConstructor
@Entity
@Getter
@NoArgsConstructor
@Setter
public class User {
    @Id
    @Column(columnDefinition = "VARCHAR(255) CHARACTER SET UTF8")
    @Comment("유저 IP")
    private String ip;

    @Comment("유저 잔액")
    private long money;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="weapon_id")
    private Weapon weapon;

    public UserResponseDto toResponseDto() {
        return new UserResponseDto(ip, money);
    }
}

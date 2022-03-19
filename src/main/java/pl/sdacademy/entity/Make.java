package pl.sdacademy.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class Make {
    @Id
    private Integer id;
    private String name;


}

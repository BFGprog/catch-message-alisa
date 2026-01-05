package home.localhost.catch_message_alisa.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Item {
    @SequenceGenerator(
            name = "generatorItemId"
            ,sequenceName = "generatoritemid"
            ,allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "generatorItemId")
    private Long id;
    private Long sort_num;
    private String name;
    private LocalDateTime create_date;
    private Integer status;


}

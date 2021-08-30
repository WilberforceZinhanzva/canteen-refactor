package com.nim.canteen.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="allergies")
@Data
@NoArgsConstructor
public class Allergy {
    @Id @GeneratedValue
    private Integer id;
    @Column(nullable = false, name="allergy_name")
    private String allergyName;
    @ManyToMany(mappedBy="allergies")
    private List<Student> students;

}

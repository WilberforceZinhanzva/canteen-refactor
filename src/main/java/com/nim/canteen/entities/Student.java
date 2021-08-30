package com.nim.canteen.entities;

import com.nim.canteen.dtos.consumables.StudentConsumable;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@Entity
@Data
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String surname;
    private String regNumber;
    @ManyToMany(cascade=CascadeType.MERGE,fetch=FetchType.LAZY)
    @JoinTable(
            name="student_allergies",
            joinColumns=
            @JoinColumn(name="student_id", referencedColumnName="id"),
            inverseJoinColumns=
            @JoinColumn(name="allergy_id", referencedColumnName="id")
    )
    private List<Allergy> allergies;

    public Student(StudentConsumable consumable){
        this.name = consumable.getName();
        this.surname= consumable.getSurname();
        this.regNumber = consumable.getRegNumber();
    }

}

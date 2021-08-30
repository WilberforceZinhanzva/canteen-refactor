package com.nim.canteen.dtos.transferables;

import com.nim.canteen.entities.Student;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class StudentTransferable {
    private Integer id;
    private String name;
    private String surname;
    private String regNumber;
    private List<String> allergies;


    public StudentTransferable(Student student){
        this.id = student.getId();
    }
}

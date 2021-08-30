package com.nim.canteen.dtos.consumables;

import com.nim.canteen.entities.Student;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class StudentConsumable {
    private String name;
    private String surname;
    private String regNumber;
    private List<String> allergies;




}

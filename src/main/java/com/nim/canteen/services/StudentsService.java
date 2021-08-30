package com.nim.canteen.services;

import com.nim.canteen.dtos.consumables.StudentConsumable;
import com.nim.canteen.dtos.transferables.StudentTransferable;
import com.nim.canteen.entities.Allergy;
import com.nim.canteen.entities.Student;
import com.nim.canteen.repositories.AllergyRepository;
import com.nim.canteen.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentsService {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private AllergyRepository allergyRepository;

    public StudentTransferable createStudent(StudentConsumable consumable){
        Student student = new Student(consumable);

        List<Allergy> allergyCollection = new ArrayList<>();
        for(String allergyName : consumable.getAllergies()){
            Optional<Allergy> al = allergyRepository.findByAllergyName(allergyName);
            if(al.isPresent()){
                allergyCollection.add(al.get())
;            }
        }
        student.setAllergies(allergyCollection);

        Student savedStudent = studentRepository.save(student);
        return new StudentTransferable(savedStudent);
    }
}

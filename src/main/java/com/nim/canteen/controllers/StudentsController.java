package com.nim.canteen.controllers;

import com.nim.canteen.dtos.consumables.StudentConsumable;
import com.nim.canteen.dtos.transferables.StudentTransferable;
import com.nim.canteen.services.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(value="/students")
public class StudentsController {

    @Autowired
    private StudentsService studentsService;


    @PostMapping("/{id}")
    public ResponseEntity<StudentTransferable> createStudent(@RequestBody StudentConsumable consumable){
        StudentTransferable savedStudent =  studentsService.createStudent(consumable);
        if(Optional.ofNullable(savedStudent).isPresent()){
            return new ResponseEntity<>(savedStudent, HttpStatus.CREATED);
        }
        else{
            return ResponseEntity.ok(null);
        }
    }
}

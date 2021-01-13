package com.cagemini.capgemini.practica.web.controller;

import com.cagemini.capgemini.practica.entity.DatosPersona;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping

public class PersonController {
    static List<DatosPersona> listaDatosPersonas = new ArrayList<>();
    static {
        listaDatosPersonas.add(new DatosPersona("pedro", "perez", 20));
        listaDatosPersonas.add(new DatosPersona("ana", "gomez", 30));
    }
    @GetMapping("/lista")
    public ResponseEntity<List<DatosPersona>> lista() {
        return new ResponseEntity<>(listaDatosPersonas,HttpStatus.OK);
    }
    @PutMapping("/{nombre}")
    public ResponseEntity<List<DatosPersona>> actualizar(@PathVariable("nombre") String nombre, @RequestBody DatosPersona datosPersona) {
        listaDatosPersonas.remove(new DatosPersona(nombre));
        listaDatosPersonas.add(datosPersona);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<List<DatosPersona>> addPersona(@RequestBody DatosPersona datosPersona) {
        listaDatosPersonas.add(datosPersona);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}


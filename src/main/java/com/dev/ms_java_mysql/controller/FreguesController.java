package com.dev.ms_java_mysql.controller;

import com.dev.ms_java_mysql.api.FreguesApi;
import com.dev.ms_java_mysql.clients.EmailClient;
import com.dev.ms_java_mysql.dtos.FreguesRecordDto;
import com.dev.ms_java_mysql.models.FreguesModel;
import com.dev.ms_java_mysql.models.RegisterModel;
import com.dev.ms_java_mysql.repositories.FreguesRepository;
import com.dev.ms_java_mysql.repositories.RegisterRepository;
import jakarta.validation.ConstraintViolationException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Optional;

@Component
@RestController
public class FreguesController implements FreguesApi{

    @Autowired
    FreguesRepository freguesRepository;
    @Autowired
    RegisterRepository registerRepository;
    @Autowired
    EmailClient emailClient;

    @Transactional
    @Override
    public FreguesModel insert(FreguesRecordDto freguesRecordDto) {
        var freguesModel = new FreguesModel();
        BeanUtils.copyProperties(freguesRecordDto, freguesModel);
        try {
            freguesModel = freguesRepository.save(freguesModel);
            var registerModel = new RegisterModel();
            registerRepository.save(registerModel);
            emailClient.publishMenssageEmail(freguesModel);
            return freguesModel;
        } catch (ConstraintViolationException e) {
            e.getConstraintViolations().forEach(violation -> {
                System.out.println(violation.getMessage());
            });
        }
        return null;
    }

    @Override
    public List<FreguesModel> find() {
        List<FreguesModel> listaModel = freguesRepository.findAll();
        if (!listaModel.isEmpty()) {
            for (FreguesModel fregues : listaModel) {
                Long id = fregues.getIdFregues();
                fregues.add(linkTo(methodOn(FreguesController.class).findOne(id)).withSelfRel());
            }
        }
        return freguesRepository.findAll();
    }

    @Override
    public Object findOne(Long id) {
        Optional<FreguesModel> optional = freguesRepository.findById(id);
        if (optional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("NAO ENCONTRADO");
        }
        return ResponseEntity.status(HttpStatus.OK).body(optional.get());
    }

    @Override
    public ResponseEntity<Object> update(Long id, FreguesRecordDto freguesRecordDto) {
        Optional<FreguesModel> optional = freguesRepository.findById(id);
        if (optional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("NAO ENCONTRADO");
        }
        var freguesModel = optional.get();
        BeanUtils.copyProperties(freguesRecordDto, freguesModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(freguesRepository.save(freguesModel));
    }

    @Override
    public ResponseEntity<Object> delete(Long id) {
        Optional<FreguesModel> optional = freguesRepository.findById(id);
        if (optional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("NAO ENCONTRADO");
        }
        freguesRepository.delete(optional.get());
        return ResponseEntity.status(HttpStatus.OK).body("CLIENTE DELETADO");
    }

    @Override
    public long count() {
        return freguesRepository.count();
    }
}

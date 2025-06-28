package com.dev.ms_java_mysql.v1.fregues.api;

import com.dev.ms_java_mysql.v1.fregues.dto.FreguesRecordDto;
import com.dev.ms_java_mysql.v1.fregues.model.FreguesModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;

@Api(tags = {"Fregues"})
@RequestMapping("/v1/fregues")
public interface FreguesApi {

    @ApiOperation(value = "Cadastrar fregues", notes = "Forneça dados válido para cadastrar fregues.")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "")
    FreguesModel insert(@RequestBody @Valid FreguesRecordDto freguesRecordDto);

    @ApiOperation(value = "Buscar fregues", notes = "Retorno todos os fregueses cadastrados.")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "")
    List<FreguesModel> find();

    @ApiOperation(value = "Buscar um fregues por ID", notes = "Forneça um ID válido para obter os detalhes do fregues.")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "{id}")
    Object findOne(@PathVariable(value = "id") Long id);

    @ApiOperation(value = "Atualizar fregues", notes = "Forneça um ID válido e seus dados atualizados para atualizar o fregues.")
    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping(value = "{id}")
    ResponseEntity<Object> update(@PathVariable(value = "id") Long id,
                                  @RequestBody @Valid FreguesRecordDto freguesRecordDto);

    @ApiOperation(value = "Deletar fregues", notes = "Forneça um ID válido e deletar fregues.")
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping(value = "{id}")
    ResponseEntity<Object> delete(@PathVariable(value = "id") Long id);

    @ApiOperation(value = "Conta fregues", notes = "Chame-o e retorno o total de fregueses cadastrados")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/count")
    long count();

}

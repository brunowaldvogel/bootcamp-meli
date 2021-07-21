package com.bootcampmeli.apicontrolepedidos.controllers;

import java.util.List;

import com.bootcampmeli.apicontrolepedidos.dtos.UpsertOrderDTO;
import com.bootcampmeli.apicontrolepedidos.entities.Table;
import com.bootcampmeli.apicontrolepedidos.interfaces.ITableService;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("tables")
public class TableController {
    
    private final ITableService tableService;

    
    public TableController(ITableService tableService) {
        this.tableService = tableService;
    }

    @GetMapping
    public List<Table> getAllTables() {
        return this.tableService.getAllTables();
    }

    @GetMapping("{tableId}")
    public Table getTableById(@PathVariable long tableId) {
        Table table = null;
        try {
            table = this.tableService.getTableById(tableId);
        } catch (RuntimeException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
        }
        return table;
    }

    @PostMapping("{tableId}/orders")
    @ResponseStatus(HttpStatus.CREATED)
    public Table addOrder(
            @PathVariable long tableId,
            @RequestBody UpsertOrderDTO upsertOrderDTO) {
        Table table = null;
        try {
            table = this.tableService.addOrder(tableId, upsertOrderDTO);
        } catch (RuntimeException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
        }
        return table;
    }

    @PostMapping("{tableId}/close-orders")
    @ResponseStatus(HttpStatus.OK)
    public Table closeOrders(@PathVariable long tableId) {
        Table table = null;
        try {
            table = this.tableService.closeOrders(tableId);
        } catch (RuntimeException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
        }
        return table;
    }
}

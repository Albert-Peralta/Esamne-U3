package mx.edu.utez.ordenes.controller;

import mx.edu.utez.ordenes.dtos.OrdenDto;
import mx.edu.utez.ordenes.service.OrdenService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/orden")
@CrossOrigin(origins = "*")
public class OrdenController {

    private final OrdenService ordenService;

    public OrdenController(OrdenService ordenService) {
        this.ordenService = ordenService;
    }

    @PostMapping("")
    public ResponseEntity<Object> addOrden(@RequestBody OrdenDto dto) {
        var respuesta = OrdenService.CreateOrden(dto);
        return new ResponseEntity<>(respuesta, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getById(@PathVariable Integer id){
        var respuesta = OrdenService.getOrdenByID(id);
        return new ResponseEntity<>(respuesta, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteOrden(@PathVariable Integer id){
        var respuesta = OrdenService.eliminarOrden(id);
        return new ResponseEntity<>(respuesta, HttpStatus.OK);
    }
}

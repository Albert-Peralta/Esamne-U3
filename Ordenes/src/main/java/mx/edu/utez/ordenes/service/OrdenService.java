package mx.edu.utez.ordenes.service;

import mx.edu.utez.ordenes.dtos.OrdenDto;
import mx.edu.utez.ordenes.model.OrdenCompra;
import mx.edu.utez.ordenes.repository.OrdenRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class OrdenService {
    OrdenRepository ordenRepository;

    public OrdenService(OrdenRepository ordenRepository) {
        this.ordenRepository = ordenRepository;
    }


    public static Map<String, Object> CreateOrden(OrdenDto dto) {
        Map<String, Object> respuesta = new HashMap<>();

        // Validacion de edad minima 18
        LocalDate fechaCreacion = dto.getFechaCreacion().toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();

        int creacion = LocalDate.now().getYear();

        if (creacion < 2025) {
            respuesta.put("mensaje", "No debe se pasar la fecha actual");
            respuesta.put("code", 400);
            return respuesta;
        }

        OrdenCompra ordenCompra = new OrdenCompra();
        ordenCompra.setMontoTotal(dto.getMontoTotal());
        ordenCompra.setClienteEmail(dto.getClienteEmail());
        ordenCompra.setFechaCreacion(dto.getFechaCreacion());

        OrdenRepository.save(ordenCompra);

        respuesta.put("mensaje", "Orden creado correctamente");
        respuesta.put("code", 200);
        return respuesta;

    }

    public static Map<String, Object> getOrdenByID(Integer id) {

        Map<String, Object> mapResponse = new HashMap<>();

        Optional<OrdenCompra> ordenCompra = OrdenRepository.findById(id);

        if (ordenCompra.isPresent()) {
            mapResponse.put("producto", ordenCompra.get());
            mapResponse.put("mensaje", "Orden encontrado correctamente");
        }else {
            mapResponse.put("mensaje", "La orden no existe");
            mapResponse.put("code", 404);
        }
        return mapResponse;
    }

    public static Object eliminarOrden(Integer id) {
        Map<String, Object> mapResponse = new HashMap<>();
        Optional<OrdenCompra> ordenCompra = OrdenRepository.findById(id);
        if (ordenCompra.isPresent()) {
            OrdenCompra productoExistente = ordenCompra.get();
            OrdenRepository.delete(productoExistente);
            mapResponse.put("mensaje", "Orden eliminado correctamente");
            mapResponse.put("producto", productoExistente);
        }else {
            mapResponse.put("mensaje", "La orden no existe, no se puede eliminar");
            mapResponse.put("code", 404);
        }
        return mapResponse;
    }
}

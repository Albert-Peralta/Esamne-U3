package mx.edu.utez.ordenes.repository;

import mx.edu.utez.ordenes.model.OrdenCompra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdenRepository extends JpaRepository<OrdenCompra, Integer> {
}


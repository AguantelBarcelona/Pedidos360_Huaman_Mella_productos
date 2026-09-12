package cl.pedidos360.productos_service.controller;

import cl.pedidos360.productos_service.model.Producto;
import cl.pedidos360.productos_service.service.ProductoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping
    public List<Producto> listar() {
        return productoService.listarTodos();
    }

    @GetMapping("/{id}")
    public Producto obtener(@PathVariable Long id) {
        return productoService.buscarPorId(id);
    }

    @GetMapping("/marca/{marca}")
    public List<Producto> porMarca(
            @PathVariable String marca) {

        return productoService.buscarPorMarca(marca);
    }

    @GetMapping("/categoria/{categoria}")
    public List<Producto> porCategoria(
            @PathVariable String categoria) {

        return productoService.buscarPorCategoria(categoria);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Producto crear(
            @Valid @RequestBody Producto producto) {

        return productoService.crear(producto);
    }

    @PutMapping("/{id}")
    public Producto actualizar(
            @PathVariable Long id,
            @Valid @RequestBody Producto producto) {

        return productoService.actualizar(id, producto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long id) {

        productoService.eliminar(id);
    }
}
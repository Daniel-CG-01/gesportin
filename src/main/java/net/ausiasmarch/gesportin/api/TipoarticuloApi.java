package net.ausiasmarch.gesportin.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
<<<<<<< HEAD
=======
import org.springframework.data.web.PageableDefault;
>>>>>>> upstream/main
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
<<<<<<< HEAD
=======
import org.springframework.web.bind.annotation.RequestParam;
>>>>>>> upstream/main
import org.springframework.web.bind.annotation.RestController;

import net.ausiasmarch.gesportin.entity.TipoarticuloEntity;
import net.ausiasmarch.gesportin.service.TipoarticuloService;

<<<<<<< HEAD
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/tipoarticulo")
public class TipoarticuloApi {
    
    @Autowired
    TipoarticuloService oTipoarticuloService;

    // Obtener un tipo de artículo por su ID
=======
@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
@RestController
@RequestMapping("/tipoarticulo")
public class TipoarticuloApi {

    @Autowired
    private TipoarticuloService oTipoarticuloService;

>>>>>>> upstream/main
    @GetMapping("/{id}")
    public ResponseEntity<TipoarticuloEntity> get(@PathVariable Long id) {
        return ResponseEntity.ok(oTipoarticuloService.get(id));
    }

<<<<<<< HEAD
    // Crear un tipo de artículo
    @PostMapping("")
    public ResponseEntity<TipoarticuloEntity> create(@RequestBody TipoarticuloEntity oTipoarticuloEntity) {
        return ResponseEntity.ok(oTipoarticuloService.create(oTipoarticuloEntity));
    }

    // Modificar un tipo de artículo
    @PutMapping("")
    public ResponseEntity<Long> update(@RequestBody TipoarticuloEntity oTipoarticuloEntity) {
        return ResponseEntity.ok(oTipoarticuloService.update(oTipoarticuloEntity));
    }

    // Borrar un tipo de artículo
=======
    @GetMapping
    public ResponseEntity<Page<TipoarticuloEntity>> getPage(
            @PageableDefault(size = 1000) Pageable pageable,
            @RequestParam(required = false) String descripcion,
            @RequestParam(required = false) Long idClub) {
        return ResponseEntity.ok(oTipoarticuloService.getPage(pageable, descripcion, idClub));
    }

    @PostMapping
    public ResponseEntity<TipoarticuloEntity> create(@RequestBody TipoarticuloEntity tipoarticulo) {
        return ResponseEntity.ok(oTipoarticuloService.create(tipoarticulo));
    }

    @PutMapping
    public ResponseEntity<TipoarticuloEntity> update(@RequestBody TipoarticuloEntity tipoarticulo) {
        return ResponseEntity.ok(oTipoarticuloService.update(tipoarticulo));
    }

>>>>>>> upstream/main
    @DeleteMapping("/{id}")
    public ResponseEntity<Long> delete(@PathVariable Long id) {
        return ResponseEntity.ok(oTipoarticuloService.delete(id));
    }

<<<<<<< HEAD
    // Rellenar datos "fake"
    @GetMapping("/rellena/{numPosts}")
    public ResponseEntity<Long> creaEquipo(
            @PathVariable Long numPosts) {
        return ResponseEntity.ok(oTipoarticuloService.crearTipoarticulo(numPosts));
    }

    // Vaciar la tabla (solo para administradores)
=======
    @PostMapping("/fill/{cantidad}")
    public ResponseEntity<Long> fill(@PathVariable Long cantidad) {
        return ResponseEntity.ok(oTipoarticuloService.fill(cantidad));
    }

>>>>>>> upstream/main
    @DeleteMapping("/empty")
    public ResponseEntity<Long> empty() {
        return ResponseEntity.ok(oTipoarticuloService.empty());
    }

<<<<<<< HEAD
    // Listado paginado de tipos de artículos
    @GetMapping("")
    public ResponseEntity<Page<TipoarticuloEntity>> getPage(Pageable oPageable) {
        return ResponseEntity.ok(oTipoarticuloService.getPage(oPageable));
    }

=======
>>>>>>> upstream/main
    @GetMapping("/count")
    public ResponseEntity<Long> count() {
        return ResponseEntity.ok(oTipoarticuloService.count());
    }
}

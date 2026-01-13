package net.ausiasmarch.gesportin.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import net.ausiasmarch.gesportin.entity.TipoarticuloEntity;
import net.ausiasmarch.gesportin.exception.ResourceNotFoundException;
import net.ausiasmarch.gesportin.repository.TipoarticuloRepository;

@Service
public class TipoarticuloService {
    
    @Autowired
    TipoarticuloRepository oTipoarticuloRepository;

    @Autowired
    AleatorioService oAleatorioService;

    ArrayList<String> descripciones = new ArrayList<>();

    public TipoarticuloService() {
        descripciones.add("Es un balón fabricado con materiales sintéticos de alta resistencia");
        descripciones.add("Es raqueta con estructura liviana y balance equilibrado");
        descripciones.add("Son zapatillas diseñadas para correr, con suela antideslizante y sistema de amortiguación");
        descripciones.add("Son guantes deportivos con ajuste ergonómico que protegen las manos");
        descripciones.add("Es una bicicleta resistente con cuadro reforzado y suspensión delantera");
        descripciones.add("Es una cuerda para ejercicios cardiovasculares, ligera y ajustable a diferentes alturas");
        descripciones.add("Es una mochila espaciosa y duradera, diseñada para transportar ropa, calzado y accesorios deportivos");
        descripciones.add("Es una esterilla fabricada con material acolchado y superficie antideslizante");
        descripciones.add("Es un casco ligero con sistema de ajuste regulable que garantiza una protección segura y confortable");
        descripciones.add("Son mancuernas con recubrimiento protector que evita deslizamientos y protege el suelo");
    }

    public Long crearTipoarticulo(Long numPosts) {
        for (long j = 0; j < numPosts; j++) {

            // Crea una entidad y la rellana con datos aleatorios
            TipoarticuloEntity oTipoarticuloEntity = new TipoarticuloEntity();

            oTipoarticuloEntity.setDescripcion(
                    descripciones.get(oAleatorioService.GenerarNumeroAleatorioEnteroEnRango(0, descripciones.size() - 1)));
            
            oTipoarticuloEntity.setId_club(oAleatorioService.GenerarNumeroAleatorioEnteroEnRango(1, 50));
            
            // Guardar la entidad en la base de datos
            oTipoarticuloRepository.save(oTipoarticuloEntity);
        }
        return oTipoarticuloRepository.count();
    }

    // -------------------------------------------------- CRUD --------------------------------------------------

    public TipoarticuloEntity get(Long id) {
        return oTipoarticuloRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No se ha encontrado el tipo de artículo buscado"));
    }

    public TipoarticuloEntity create(TipoarticuloEntity tipoarticuloEntity) {
        tipoarticuloEntity.setId(null);
        return oTipoarticuloRepository.save(tipoarticuloEntity);
    }

    public Long update(TipoarticuloEntity tipoarticuloEntity) {
        TipoarticuloEntity oExistingTipoarticulo = oTipoarticuloRepository.findById(tipoarticuloEntity.getId())
                .orElseThrow(() -> new ResourceNotFoundException("No se ha encontrado el tipo de artículo buscado"));
        oExistingTipoarticulo.setDescripcion(tipoarticuloEntity.getDescripcion());
        oExistingTipoarticulo.setId_club(tipoarticuloEntity.getId_club());
        oTipoarticuloRepository.save(oExistingTipoarticulo);
        return oExistingTipoarticulo.getId();
    }

    public Long delete(Long id) {
        oTipoarticuloRepository.deleteById(id);
        return id;
    }

    public Page<TipoarticuloEntity> getPage(Pageable oPageable) {
        return oTipoarticuloRepository.findAll(oPageable);
    }


    public Long count() {
        return oTipoarticuloRepository.count();
    }

    // Vaciar la tabla (solo para administradores)
    public Long empty() {
        Long total = count();
        oTipoarticuloRepository.deleteAll();
        return total;
    }
}

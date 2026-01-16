package net.ausiasmarch.gesportin.entity;

<<<<<<< HEAD
=======
import jakarta.persistence.Column;
>>>>>>> upstream/main
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
<<<<<<< HEAD
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tipoarticulo")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TipoarticuloEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull
    @Size(min = 3, max = 255)
    private String descripcion;

    @NotNull
    private int id_club;
=======
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tipoarticulo")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TipoarticuloEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false)
    private String descripcion;

    @NotNull
    @Column(name = "id_club", nullable = false)
    private Long idClub;
>>>>>>> upstream/main
}

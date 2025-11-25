package cl.fabioladiaz.canciones.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;

@Entity
@Table(name ="canciones")
public class Cancion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; 
    @Column(nullable = false)
    @Size(min = 5, message = "Debe contener al menos 5 caracteres.")
    private String titulo; 
    
    @Column(nullable = false)
    @Size(min = 3, message = "Debe contener al menos 3 caracteres.")
    private String artista;
    
    @Column(nullable = false)
    @Size(min = 3, message = "Debe contener al menos 3 caracteres.")
    private String album;
    
    @Size(min = 3, message = "Debe contener al menos 3 caracteres.")
    private String genero;

    @Size(min = 3, message = "Debe contener al menos 3 caracteres.")
    private String idioma; 

    private LocalDate fechaDeCreacion;
    private LocalDate fechaDeActualizacion;
      
    public Cancion() {
    }

    public Cancion(String titulo, String artista, String album, String genero, String idioma) {
        this.titulo = titulo;
        this.artista = artista;
        this.album = album;
        this.genero = genero;
        this.idioma = idioma;
    }

    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public String getTitulo() {
        return titulo;
    }


    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }


    public String getArtista() {
        return artista;
    }


    public void setArtista(String artista) {
        this.artista = artista;
    }


    public String getAlbum() {
        return album;
    }


    public void setAlbum(String album) {
        this.album = album;
    }


    public String getGenero() {
        return genero;
    }


    public void setGenero(String genero) {
        this.genero = genero;
    }


    public String getIdioma() {
        return idioma;
    }


    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }


    public LocalDate getFechaDeCreacion() {
        return fechaDeCreacion;
    }


    public void setFechaDeCreacion(LocalDate fechaDeCreacion) {
        this.fechaDeCreacion = fechaDeCreacion;
    }


    public LocalDate getFechaDeActualizacion() {
        return fechaDeActualizacion;
    }


    public void setFechaDeActualizacion(LocalDate fechaDeActualizacion) {
        this.fechaDeActualizacion = fechaDeActualizacion;
    }

    @Override
    public String toString() {
        return "Cancion [id=" + id + ", titulo=" + titulo + ", artista=" + artista + ", album=" + album + ", genero="
                + genero + ", idioma=" + idioma + ", fechaDeCreacion=" + fechaDeCreacion + ", fechaDeActualizacion="
                + fechaDeActualizacion + "]";
    }

    @PrePersist
    protected void onCreate(){
        this.fechaDeCreacion = LocalDate.now();
        this.fechaDeActualizacion = LocalDate.now();
    }

    @PreUpdate
    protected void onUpdate(){
        this.fechaDeActualizacion = LocalDate.now();
    }

    
}

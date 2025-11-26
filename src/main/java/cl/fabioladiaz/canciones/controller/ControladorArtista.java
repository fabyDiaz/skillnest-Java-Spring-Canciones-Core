package cl.fabioladiaz.canciones.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import cl.fabioladiaz.canciones.model.Artista;
import cl.fabioladiaz.canciones.service.ServicioArtistas;
import jakarta.validation.Valid;

@Controller
public class ControladorArtista {

    @Autowired
    ServicioArtistas servicioArtistas;

    @GetMapping("/artistas")
    public String desplegarArtistas(Model modelo){
        modelo.addAttribute("listaArtistas", servicioArtistas.obtenerTodosLosArtistas());
        return "artistas.jsp";
    }

    @GetMapping("/artistas/detalle/{idArtista}")
    public String desplegarDetalleArtista(Model modelo, @PathVariable("idArtista") Long idArtista){
        modelo.addAttribute("artista", servicioArtistas.obtenerArtistaPorId(idArtista));
        return "detalleArtista.jsp";
    }

    @GetMapping("/artistas/formulario/agregar")
    public String formularioAgregarArtista(Model modelo){
        modelo.addAttribute("artista", new Artista());
        return "agregarArtista.jsp";
    }

    @PostMapping("/artistas/procesa/agregar")
    public String procesarAgregarArtista(@Valid @ModelAttribute("artista") Artista artista, BindingResult validaciones){
         if (validaciones.hasErrors()) {
            return "agregarArtista.jsp";
        }
        this.servicioArtistas.agregarArtista(artista);
        return "redirect:/artistas";    
    }

    
}

package cl.fabioladiaz.canciones.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import cl.fabioladiaz.canciones.model.Cancion;
import cl.fabioladiaz.canciones.service.ServicioArtistas;
import cl.fabioladiaz.canciones.service.ServicioCanciones;
import jakarta.validation.Valid;


@Controller
public class ControladorCanciones {

    @Autowired
    private ServicioCanciones servicioCanciones;

    @Autowired
    private ServicioArtistas servicioArtistas;

    @GetMapping("/canciones")
    public String desplegarCanciones(Model modelo){
        modelo.addAttribute("listaCanciones", servicioCanciones.obtenerTodasLasCanciones());
        return "canciones.jsp";
    }

    @GetMapping("/canciones/detalle/{idCancion}")
    public String desplegarDetalleCancion(Model modelo, @PathVariable("idCancion") Long idCancion){
        modelo.addAttribute("cancion", servicioCanciones.obtenerCancionPorId(idCancion));
        return "detalleCancion.jsp";
    }

    @PostMapping("/canciones/procesa/agregar")
    public String procesarAgregarCancion(
            @Valid @ModelAttribute("cancion") Cancion cancion,
            BindingResult validaciones){
        
        if (validaciones.hasErrors()) {
            return "agregarCancion.jsp";
        }

        servicioCanciones.agregarCancion(cancion);
        return "redirect:/canciones";
    }

    @GetMapping("/canciones/formulario/agregar")
    public String formularioAgregarCancion(Model modelo) {
        modelo.addAttribute("cancion", new Cancion());
        modelo.addAttribute("listaArtistas", servicioArtistas.obtenerTodosLosArtistas());
        return "agregarCancion.jsp";
    }

    @GetMapping("/canciones/formulario/editar/{idCancion}")
    public String formularioEditarCancion(Model modelo, @PathVariable("idCancion") Long idCancion){
        modelo.addAttribute("cancion", this.servicioCanciones.obtenerCancionPorId(idCancion));
        modelo.addAttribute("listaArtistas", servicioArtistas.obtenerTodosLosArtistas());
        return "editarCancion.jsp";
    }

    @PutMapping("/canciones/procesa/editar")
    public String procesarEditarCancion(@Valid @ModelAttribute("cancion") Cancion cancion, BindingResult validaciones){
         if (validaciones.hasErrors()) {
            return "editarCancion.jsp";
        }
        this.servicioCanciones.actualizaCancion(cancion);
        return "redirect:/canciones";    
    }

    @DeleteMapping("/canciones/eliminar/{idCancion}")
    public String procesarEliminarCancion(@PathVariable("idCancion") Long id){
        this.servicioCanciones.eliminaCancion(id);
        return"redirect:/canciones";
    }
}

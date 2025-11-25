package cl.fabioladiaz.canciones.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import cl.fabioladiaz.canciones.model.Cancion;
import cl.fabioladiaz.canciones.service.ServicioCanciones;
import jakarta.validation.Valid;

@Controller
public class ControladorCanciones {

    @Autowired
    private ServicioCanciones servicioCanciones;

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
    public String procesarAgregarCancion(@Valid @ModelAttribute("cancion") Cancion cancion, BindingResult validaciones){
         if (validaciones.hasErrors()) {
            return "agregarCancion.jsp";
        }
        this.servicioCanciones.agregarCancion(cancion);
        return "redirect:/canciones";    
    }

    @GetMapping("/canciones/formulario/agregar")
    public String formularioAgregarCancion(Model modelo) {
        modelo.addAttribute("cancion", new Cancion());
        return "agregarCancion.jsp";
    }

    @GetMapping("/canciones/formulario/editar/{idCancion}")
    public String formularioEditarCancion(Model modelo, @PathVariable("idCancion") Long idCancion){
        modelo.addAttribute("cancion", new Cancion());
        return "editarCancion.jsp";
    }

    @PostMapping("/canciones/procesa/editar/{idCancion}")
    public String procesarEditarCancion(@Valid @ModelAttribute("cancion") Cancion cancion, BindingResult validaciones){
         if (validaciones.hasErrors()) {
            return "ediarCancion.jsp";
        }
        this.servicioCanciones.actualizaCancion(cancion);
        return "redirect:/canciones";    
    }
}

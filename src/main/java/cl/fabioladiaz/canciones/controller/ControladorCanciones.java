package cl.fabioladiaz.canciones.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import cl.fabioladiaz.canciones.service.ServicioCanciones;

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

}

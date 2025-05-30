package com.kiskecode.app;

import org.springframework.web.bind.annotation.*;
import com.kiskecode.app.actions.ActionHandler;
import java.lang.reflect.Method;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@RestController
@RequestMapping("/api")
public class SpringBootApiController {

    private static final Logger log = LogManager.getLogger(SpringBootApiController.class);
    private static final String TOKEN_VALIDO = "Bearer 12345";

    @GetMapping("/saludo")
    public String saludo() {
        log.info("Llamada a /api/saludo");
        return "¡Hola desde Spring Boot kiskecode!";
    }

    @PostMapping("/accion")
    public Object procesarAccion(@RequestBody Map<String, Object> body, @RequestHeader("Authorization") String token) {

        if (!TOKEN_VALIDO.equals(token)) {
            log.warn("Intento de acceso con token inválido");
            return "Token inválido";
        }

        String action = (String) body.get("action");

        try {

            ActionHandler handler = new ActionHandler();
            Method metodo = handler.getClass().getMethod(action);
            Object resultado = metodo.invoke(handler);
            log.info("Acción ejecutada: {}", action);
            return resultado;

        } catch (NoSuchMethodException e) {

            log.error("Acción no encontrada: {}", action);
            return "Acción no válida";

        } catch (Exception e) {

            log.error("Error al ejecutar la acción: {}", e.getMessage());
            return "Error interno al procesar la acción";
        }
    }

}

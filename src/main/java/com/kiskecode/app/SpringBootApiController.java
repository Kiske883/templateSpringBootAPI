package com.kiskecode.app;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class SpringBootApiController {

    @GetMapping("/saludo")
    public String saludo() {
        return "¡Hola desde Spring Boot!";
    }

    @PostMapping("/accion")
    public String procesarAccion(@RequestParam String action, @RequestHeader("Authorization") String token) {
        // Esto es solo un ejemplo, simulando tu seguridad por token
        if (!token.equals("123456")) {
            return "Token inválido";
        }

        // Aquí simularías una llamada por reflexión según "action"
        return "Acción recibida: " + action;
    }    
    
}

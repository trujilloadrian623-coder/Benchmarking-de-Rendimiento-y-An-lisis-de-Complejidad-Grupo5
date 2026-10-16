package com.example.demo_jmeter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeSet;

@RestController
@RequestMapping("/api/demo")
public class DemoController {

    @GetMapping("/ineficiente")
    public String codigoIneficiente(@RequestParam(defaultValue = "3000") int n) {
        long inicio = System.currentTimeMillis();
        
        ArrayList<Integer> lista = new ArrayList<>();
        for (int i = n; i > 0; i--) {
            lista.add(i);
            Collections.sort(lista); 
        }
        
        long fin = System.currentTimeMillis();
        return "Ineficiente completado para n=" + n + " en " + (fin - inicio) + " ms.";
    }

    @GetMapping("/optimizado")
    public String codigoOptimizado(@RequestParam(defaultValue = "3000") int n) {
        long inicio = System.currentTimeMillis();
        
        TreeSet<Integer> setOrdenado = new TreeSet<>();
        for (int i = n; i > 0; i--) {
            setOrdenado.add(i); 
        }
        
        long fin = System.currentTimeMillis();
        return "Optimizado completado para n=" + n + " en " + (fin - inicio) + " ms.";
    }
}
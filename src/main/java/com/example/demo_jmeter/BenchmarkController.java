package com.example.demo_jmeter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeSet;

@RestController
@RequestMapping("/api/benchmark")
public class BenchmarkController {

    @GetMapping("/ineficiente")
    public String codigoIneficiente(@RequestParam(defaultValue = "3000") int n) {
        long inicio = System.currentTimeMillis();
        
        long resultado = 0; // evitar overflow
        for (int i = n; i > 0; i--) {
            for (int j = n; j > 0; j--) {
                resultado += i * j;
            }
        }
        
        long fin = System.currentTimeMillis();
        return "Ineficiente completado para n=" + n + " en " + (fin - inicio) + " ms.";
    }

    @GetMapping("/optimizado")
    public String codigoOptimizado(@RequestParam(defaultValue = "3000") int n) {
        long inicio = System.currentTimeMillis();
        
        long sumaGauss = 0;
        for (int i = 1; i <= n; i++) {
            sumaGauss += i;
        }
        long resultado = sumaGauss * sumaGauss; // Equivalente matemático exacto a los bucles anidados O(n)
        
        long fin = System.currentTimeMillis();
        return "Optimizado O(n) completado para n=" + n + " en " + (fin - inicio) + " ms. Resultado: " + resultado;
    }
}
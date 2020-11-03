package com.example.proyecto_final_1.Adaptadores;

import java.io.Serializable;

public class CocinaVO implements Serializable {
    private String pedidosCocina;

    public CocinaVO(){
    }

    public CocinaVO (String pedidosCocina) {
        this.pedidosCocina = pedidosCocina;
    }


    public String getPedidosCocina() {
        return pedidosCocina;
    }

    public void setPedidosCocina(String pedidosCocina) {
        this.pedidosCocina = pedidosCocina;
    }
}

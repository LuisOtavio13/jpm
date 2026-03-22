package com.JPM.java.packet.manager.dto;

import java.time.Instant;

public class ErrorDTO {

    private Instant timestamp;
    private String erro;
    private String mensagem;

    public ErrorDTO(Instant timestamp, String erro, String mensagem) {
        this.timestamp = timestamp;
        this.erro = erro;
        this.mensagem = mensagem;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Instant timestamp) {
        this.timestamp = timestamp;
    }

    public String getErro() {
        return erro;
    }

    public void setErro(String erro) {
        this.erro = erro;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}

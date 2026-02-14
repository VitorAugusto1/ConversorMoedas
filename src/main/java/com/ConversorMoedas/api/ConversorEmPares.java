package com.conversormoedas.api;

import com.google.gson.annotations.SerializedName;

public class ConversorEmPares {
    @SerializedName("base_code")
    private String moedaOrigem;
    @SerializedName("target_code")
    private String moedaDestino;
    @SerializedName("conversion_rate")
    private double taxaCambio;
    @SerializedName("conversion_result")
    private double resultadoConversao;

    public String getMoedaOrigem() {
        return moedaOrigem;
    }

    public String getMoedaDestino() {
        return moedaDestino;
    }

    public double getTaxaCambio() {
        return taxaCambio;
    }

    public double getResultadoConversao() {
        return resultadoConversao;
    }

    public void setMoedaDestino(String moedaDestino) {
        this.moedaDestino = moedaDestino;
    }

    public void setResultadoConversao(double resultadoConversao) {
        this.resultadoConversao = resultadoConversao;
    }
}

package com.unincor.cadastro_carros.model.domain;

public class Carro {

    private Long id;
    private String modelo;
    private String marca;
    private Integer ano;
    private Double potencia;
    private Integer cavalos;
    private Boolean hibrido;

    public Carro(Long id, String modelo, String marca, Integer ano, Double potencia, Integer cavalos, Boolean hibrido) {
        this.id = id;
        this.modelo = modelo;
        this.marca = marca;
        this.ano = ano;
        this.potencia = potencia;
        this.cavalos = cavalos;
        this.hibrido = hibrido;
    }

    public Carro() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public Double getPotencia() {
        return potencia;
    }

    public void setPotencia(Double potencia) {
        this.potencia = potencia;
    }

    public Integer getCavalos() {
        return cavalos;
    }

    public void setCavalos(Integer cavalos) {
        this.cavalos = cavalos;
    }

    public Boolean getHibrido() {
        return hibrido;
    }

    public void setHibrido(Boolean hibrido) {
        this.hibrido = hibrido;
    }
}


package model;

import java.math.BigDecimal;

public class Produto {

    private Long codigo;
    private String descricao;
    private BigDecimal valor;

    public Produto(Long id, String descricao, BigDecimal valor) {
        this.codigo = id;
        this.descricao = descricao;
        this.valor = valor;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
}

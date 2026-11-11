package br.com.imobiliaria.frontend.model;
import java.math.BigDecimal;

public class Imovel {
 private Long id;
 private String descricao;
 private String endereco;
 private String tipo;
 private BigDecimal valor;
 private Boolean disponivel;
 public Long getId() { return id; }
 public void setId(Long id) { this.id = id; }
 public String getDescricao() { return descricao; }
 public void setDescricao(String descricao) { this.descricao = descricao; }
 public String getEndereco() { return endereco; }
 public void setEndereco(String endereco) { this.endereco = endereco; }
 public String getTipo() { return tipo; }
 public void setTipo(String tipo) { this.tipo = tipo; }
 public BigDecimal getValor() { return valor; }
 public void setValor(BigDecimal valor) { this.valor = valor; }
 public Boolean getDisponivel() { return disponivel; }
 public void setDisponivel(Boolean disponivel) { this.disponivel = disponivel; }
}

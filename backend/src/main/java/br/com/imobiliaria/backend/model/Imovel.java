package br.com.imobiliaria.backend.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;

@Entity
@Table(name = "imoveis")
public class Imovel {
 @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;
 @NotBlank private String descricao;
 @NotBlank private String endereco;
 @NotBlank private String tipo;
 @NotNull @DecimalMin(value = "0.01") @Column(precision = 12, scale = 2)
 private BigDecimal valor;
 @NotNull private Boolean disponivel;

 public Imovel() {}
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

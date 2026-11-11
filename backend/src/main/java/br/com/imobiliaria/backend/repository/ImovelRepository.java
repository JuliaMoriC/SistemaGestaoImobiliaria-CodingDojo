package br.com.imobiliaria.backend.repository;
import br.com.imobiliaria.backend.model.Imovel;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ImovelRepository extends JpaRepository<Imovel, Long> {}

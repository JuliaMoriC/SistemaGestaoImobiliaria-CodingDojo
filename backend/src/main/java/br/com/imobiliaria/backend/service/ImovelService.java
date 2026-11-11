package br.com.imobiliaria.backend.service;
import br.com.imobiliaria.backend.model.Imovel;
import br.com.imobiliaria.backend.repository.ImovelRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ImovelService {
 private final ImovelRepository repository;
 public ImovelService(ImovelRepository repository) { this.repository = repository; }
 public List<Imovel> listarTodos() { return repository.findAll(); }
 public Imovel cadastrar(Imovel imovel) { imovel.setId(null); return repository.save(imovel); }
}

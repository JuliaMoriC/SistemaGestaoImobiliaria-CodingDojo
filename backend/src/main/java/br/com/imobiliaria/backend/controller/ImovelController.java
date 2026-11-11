package br.com.imobiliaria.backend.controller;
import br.com.imobiliaria.backend.model.Imovel;
import br.com.imobiliaria.backend.service.ImovelService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/imoveis")
public class ImovelController {
 private final ImovelService service;
 public ImovelController(ImovelService service) { this.service = service; }
 @GetMapping public List<Imovel> listar() { return service.listarTodos(); }
 @PostMapping @ResponseStatus(HttpStatus.CREATED)
 public Imovel cadastrar(@Valid @RequestBody Imovel imovel) { return service.cadastrar(imovel); }
}

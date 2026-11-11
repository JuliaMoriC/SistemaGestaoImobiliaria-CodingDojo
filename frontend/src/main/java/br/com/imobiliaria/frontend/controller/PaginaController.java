package br.com.imobiliaria.frontend.controller;
import br.com.imobiliaria.frontend.model.Imovel;
import br.com.imobiliaria.frontend.service.ImovelApiClient;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClientException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class PaginaController {
 private final ImovelApiClient api;
 public PaginaController(ImovelApiClient api) { this.api = api; }

 @GetMapping("/")
 public String index(Model model) {
  model.addAttribute("imovel", new Imovel());
  try {
   model.addAttribute("imoveis", api.listar());
  } catch (RestClientException e) {
   model.addAttribute("erro", "Não foi possível conectar ao backend. Verifique se a aplicação da porta 8081 está em execução.");
  }
  return "index";
 }

 @PostMapping("/imoveis")
 public String cadastrar(@ModelAttribute Imovel imovel, RedirectAttributes redirect) {
  try {
   api.cadastrar(imovel);
   redirect.addFlashAttribute("sucesso", "Imóvel cadastrado com sucesso!");
  } catch (RestClientException e) {
   redirect.addFlashAttribute("erro", "Erro ao cadastrar. Verifique os dados e se o backend está ativo.");
  }
  return "redirect:/";
 }
}

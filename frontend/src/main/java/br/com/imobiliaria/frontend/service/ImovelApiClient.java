package br.com.imobiliaria.frontend.service;
import br.com.imobiliaria.frontend.model.Imovel;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import java.util.List;

@Service
public class ImovelApiClient {
 private final RestTemplate restTemplate = new RestTemplate();
 private final String apiUrl = "http://localhost:8081/api/imoveis";
 public List<Imovel> listar() {
  ResponseEntity<List<Imovel>> response = restTemplate.exchange(apiUrl, HttpMethod.GET, null,
    new ParameterizedTypeReference<List<Imovel>>() {});
  return response.getBody();
 }
 public Imovel cadastrar(Imovel imovel) {
  return restTemplate.postForObject(apiUrl, imovel, Imovel.class);
 }
}

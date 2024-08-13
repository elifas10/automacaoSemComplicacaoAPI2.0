package steps;

import io.cucumber.java.es.Dado;
import io.cucumber.java.es.E;
import io.cucumber.java.it.Quando;
import io.cucumber.java.pt.Entao;
import io.restassured.http.ContentType;
import maps.FilmesMaps;
import utils.RestUtils;

import java.util.HashMap;
import java.util.Map;

public class FilmeSteps {

    @Dado("que tenha um payload valido da API de Filme")
    public void queTenhaUmPayloadValidoDaAPIDeFilme() {
        FilmesMaps.initAll();
    }
    @Quando("realizo uma requisicao do tipo POST de Filme")
    public void realizoUmaRequisicaoDoTipoPOSTDeFilme() {
        RestUtils.post(FilmesMaps.getHeader(), FilmesMaps.getFilme(), ContentType.JSON, "filmes");
    }
    @Entao("armazeno o id que recebo do reponse de Filme")
    public void armazenoOIdQueReceboDoReponseDeFilme() {
        FilmesMaps.id = RestUtils.getResponse().jsonPath().get("id");
    }

    @Quando("realizo uma requisicao do tipo GET de Filme atraves do nome")
    public void realizoUmaRequisicaoDoTipoGETDeFilmeAtravesDoNome() {
        Map<String, Object> param = new HashMap<>();
        String nome = FilmesMaps.getFilme().get("nome").toString();
        param.put("nome", nome);

        RestUtils.get(FilmesMaps.getHeader(), param, "filmes");
    }

    @E("altero o indice {int} da lista de categorias de filme com os valores")
    public void alteroOIndiceDaListaDeCategoriasDeFilmeComOsValores(int indice,
                                                                    Map<String, String> map) {
        FilmesMaps.getListCategoria().get(indice).putAll(map);
    }

    @Quando("realizo uma requisicao do tipo PUT de Filme")
    public void realizoUmaRequisicaoDoTipoPUTDeFilme() {
        RestUtils.put(FilmesMaps.getHeader(), FilmesMaps.getFilme(),
                ContentType.JSON, "filmes/" + FilmesMaps.id);
    }
    @Quando("realizo uma requisicao do tipo Delete de Filme")
    public void realizoUmaRequisicaoDoTipoDeleteDeFilme() {
        RestUtils.delete(FilmesMaps.getHeader(), "filmes/"+FilmesMaps.id);
    }
}

package steps;

import io.cucumber.java.es.E;
import org.junit.Assert;
import utils.RestUtils;

import java.util.ArrayList;
import java.util.List;
import io.cucumber.java.pt.Entao;
import utils.RestUtils;

public class GenericSteps {

    @Entao("valido que recebo status {int} no response")
    public void validoQueReceboStatusNoResponse(int status) {
        Assert.assertEquals(status, RestUtils.getResponse().getStatusCode());
    }

    @Entao("valido que no campo {string} possui o valor {string}")
    public void validoQueNoCampoPossuiOValor(String key, String value) {
        Assert.assertEquals(value, RestUtils.getResponse().jsonPath().get(key));
    }
    @E("valido que no campo {string} possui o valor {int}")
    public void validoQueNoCampoPossuiOValor(String key, Integer value) {
        Assert.assertEquals(value, RestUtils.getResponse().jsonPath().get(key));
    }

    @E("valido que recebo uma lista vazia no response")
    public void validoQueReceboUmaListaVaziaNoResponse() {
        Assert.assertEquals(new ArrayList<>(0), RestUtils.getResponse().jsonPath().get());
    }
}

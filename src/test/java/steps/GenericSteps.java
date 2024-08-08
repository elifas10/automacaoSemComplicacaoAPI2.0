package steps;

import io.cucumber.java.pt.Entao;
import org.testng.Assert;
import utils.RestUtils;

public class GenericSteps {
    @Entao("valido que recebo status {int} no response")
    public void validoQueReceboStatusNoResponse(int status) {
        Assert.assertEquals(status, RestUtils.getResponse().getStatusCode() );
    }
}

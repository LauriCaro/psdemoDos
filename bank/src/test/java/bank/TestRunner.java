package bank;



import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty"},
        tags = "@balance-check",
        features = {"src/test/resources/bank/bank.feature"}
)
//@SelectClasspathResource("bank/bank.feature")
public class TestRunner {
}

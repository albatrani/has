import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;


@RunWith(Suite.class)
@SuiteClasses({
        ControlLightingHandlerTests.class, HouseSectionTests.class, HouseTests.class,
        LightAdapterTests.class, LightingControlTransactionTests.class
})
public class AllControlLightingTests {

}

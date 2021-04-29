package br.com.regresrestassuredapitest.runners;

import br.com.regresrestassuredapitest.tests.base.tests.BaseTest;
import br.com.regresrestassuredapitest.tests.user.tests.DeleteUsersTest;
import br.com.regresrestassuredapitest.tests.user.tests.GetUsersTest;
import br.com.regresrestassuredapitest.tests.user.tests.PostUsersTest;
import br.com.regresrestassuredapitest.tests.user.tests.PutUsersTest;
import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;


@RunWith(Categories.class)
@Categories.IncludeCategory(br.com.regresrestassuredapitest.suites.AllTests.class)
@Suite.SuiteClasses({
        BaseTest.class,
        GetUsersTest.class,
        PostUsersTest.class,
        PutUsersTest.class,
        DeleteUsersTest.class,
})

public class AllTests {
}

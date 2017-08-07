package J001checkingGroups;


import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(JUnitParamsRunner.class)
public class GroupsTest {

    @Test
    @Parameters({
            "(),true",
            "{},true",
            "({}),true",
            "[[]()],true",
            "[{()}],true",
            "{(}),false",
            "([],false",
            "[]),false"
    })
    public void shouldTestStringForCorrectGroupsMatching(String stringToValidate, boolean expectedResult) {
        // given
        Groups groups = new Groups();

        // when
        boolean isValid = groups.groupCheck(stringToValidate);

        // then
        assertThat(isValid).isEqualTo(expectedResult);
    }

}
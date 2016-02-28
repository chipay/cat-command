package org.chipay.cat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.shell.Bootstrap;
import org.springframework.shell.core.CommandResult;
import org.springframework.shell.core.JLineShellComponent;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class CatCommandsTest {

    private static final String[] CONTEXT_PATH =
            new String[]{"classpath*:/META-INF/spring/test-spring-shell-plugin.xml"};

    @Test
    public void testCommandCall() {

        Bootstrap bootstrap = new Bootstrap(null, CONTEXT_PATH);

        JLineShellComponent shell = bootstrap.getJLineShellComponent();

        CatService catService = (CatService) bootstrap.getApplicationContext().getBean("catService");
        String expectedCatFact = "Cats are cute";
        Mockito.when(catService.getFact()).thenReturn(expectedCatFact);

        CommandResult cr = shell.executeCommand("cat fact");
        assertEquals(true, cr.isSuccess());
        assertEquals(expectedCatFact, cr.getResult());
    }

}
package org.chipay.cat;

import org.chipay.cat.response.Category;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.shell.Bootstrap;
import org.springframework.shell.core.CommandResult;
import org.springframework.shell.core.JLineShellComponent;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class CatCommandsTest {

    private static final String[] CONTEXT_PATH =
            new String[]{"classpath*:/META-INF/spring/test-spring-shell-plugin.xml"};

    @Test
    public void testFactCommandCall() {

        Bootstrap bootstrap = new Bootstrap(null, CONTEXT_PATH);

        JLineShellComponent shell = bootstrap.getJLineShellComponent();

        CatService catService = (CatService) bootstrap.getApplicationContext().getBean("catService");
        String expectedCatFact = "Cats are cute";
        Mockito.when(catService.getFact()).thenReturn(expectedCatFact);

        CommandResult cr = shell.executeCommand("cat fact");
        assertEquals(true, cr.isSuccess());
        assertEquals(expectedCatFact, cr.getResult());
    }

    @Test
    public void testCategoriesCommandCall() {

        Bootstrap bootstrap = new Bootstrap(null, CONTEXT_PATH);
        JLineShellComponent shell = bootstrap.getJLineShellComponent();
        CatService catService = (CatService) bootstrap.getApplicationContext().getBean("catService");

        String sortedCategories = "[cute, hat, tabby]";

        List<Category> categories = new ArrayList<>();
        categories.add(this.newCategory("hat"));
        categories.add(this.newCategory("cute"));
        categories.add(this.newCategory("tabby"));
        Mockito.when(catService.getCategories()).thenReturn(categories);

        CommandResult cr = shell.executeCommand("cat categories");
        assertEquals(true, cr.isSuccess());
        assertEquals(sortedCategories, cr.getResult());
    }

    private Category newCategory(String name) {
        Category result = new Category();
        result.setName(name);
        return result;
    }
}
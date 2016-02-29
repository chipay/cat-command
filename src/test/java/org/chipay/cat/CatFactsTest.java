package org.chipay.cat;

import org.chipay.cat.response.CatFacts;
import org.junit.Test;

import static org.junit.Assert.*;

public class CatFactsTest {

    @Test
    public void success_createdWithNotSuccessString_false() throws Exception {
        CatFacts catFacts = new CatFacts();
        catFacts.setSuccess("not cool");
        assertFalse(catFacts.success());
    }

    @Test
    public void success_createdWithSuccessString_true() throws Exception {
        CatFacts catFacts = new CatFacts();
        catFacts.setSuccess("success");
        assertTrue(catFacts.success());
    }
}
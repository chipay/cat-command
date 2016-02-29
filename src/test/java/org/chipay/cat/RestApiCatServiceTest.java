package org.chipay.cat;

import org.chipay.cat.response.CatCategoriesResponse;
import org.chipay.cat.response.CatFacts;
import org.chipay.cat.response.CatImagesURLResponse;
import org.chipay.cat.response.CategoriesData;
import org.chipay.cat.response.Category;
import org.chipay.cat.response.Image;
import org.chipay.cat.response.ImagesData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.web.client.RestTemplate;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class RestApiCatServiceTest {

    @Mock
    RestTemplate restTemplateMock;

    @Test
    public void getFact_SuccessAndCatFactPresent_FactReturned() {
        RestApiCatService restService = this.createTestObject();
        String expectedFact = "Cats are laid back";
        CatFacts catFacts = new CatFacts();
        catFacts.setSuccess(true);
        catFacts.addFact(expectedFact);
        when(restTemplateMock.getForObject("http://catfacts-api.appspot.com/api/facts", CatFacts.class))
                .thenReturn(catFacts);
        assertEquals(expectedFact, restService.getFact());
    }

    @Test(expected = RuntimeException.class)
    public void getFact_ResponseNotSuccess_ThrowsException() {

        RestApiCatService restService = this.createTestObject();
        CatFacts catFacts = new CatFacts();
        catFacts.setSuccess(false);
        when(restTemplateMock.getForObject("http://catfacts-api.appspot.com/api/facts", CatFacts.class))
                .thenReturn(catFacts);
        restService.getFact();
    }

    @Test(expected = RuntimeException.class)
    public void getFact_SuccessButNoFacts_ThrowsException() {

        RestApiCatService restService = this.createTestObject();
        CatFacts catFacts = new CatFacts();
        catFacts.setSuccess(true);
        when(restTemplateMock.getForObject("http://catfacts-api.appspot.com/api/facts", CatFacts.class))
                .thenReturn(catFacts);
        restService.getFact();
    }

    @Test(expected = MalformedURLException.class)
    public void getImageURL_MalformedURLFound_ThrowsException() throws MalformedURLException {
        RestApiCatService restService = this.createTestObject();
        String expectedURL = "notAnURL";
        CatImagesURLResponse catImagesURLResponse = this.newCatImagesURLResponse(expectedURL);
        when(
                restTemplateMock.getForObject("http://thecatapi.com/api/images/get?format=xml",
                        CatImagesURLResponse.class)
        ).thenReturn(catImagesURLResponse);
        restService.getImageURL();
    }

    @Test
    public void getImageURL_ImageIsFound_URLReturned() throws MalformedURLException {
        RestApiCatService restService = this.createTestObject();
        String expectedURL = "http://cat.picture/picture.jpg";
        CatImagesURLResponse catImagesURLResponse = this.newCatImagesURLResponse(expectedURL);
        when(
                restTemplateMock.getForObject("http://thecatapi.com/api/images/get?format=xml",
                        CatImagesURLResponse.class)
        ).thenReturn(catImagesURLResponse);
        assertEquals(new URL(expectedURL), restService.getImageURL());
    }

    @Test(expected = RuntimeException.class)
    public void getImageURL_NoImageIsFound_ThrowsException() throws MalformedURLException {
        RestApiCatService restService = this.createTestObject();
        CatImagesURLResponse catImagesURLResponse = new CatImagesURLResponse();
        when(
                restTemplateMock.getForObject("http://thecatapi.com/api/images/get?format=xml",
                        CatImagesURLResponse.class)
        ).thenReturn(catImagesURLResponse);
        restService.getImageURL();
    }

    @Test
    public void getCategories_TwoCategoriesInResponse_ReturnsCategories() throws MalformedURLException {
        RestApiCatService restService = this.createTestObject();
        CatCategoriesResponse catCategoriesResponse = new CatCategoriesResponse();
        CategoriesData data = new CategoriesData();
        catCategoriesResponse.setData(data);

        Category categoryHat = this.newCategory("hat");
        data.addCategory(categoryHat);
        Category categoryTabby = this.newCategory("tabby");
        data.addCategory(categoryTabby);

        when(
                restTemplateMock.getForObject("http://thecatapi.com/api/categories/list",
                        CatCategoriesResponse.class)
        ).thenReturn(catCategoriesResponse);
        assertEquals(
                Arrays.asList(new Category[]{categoryHat, categoryTabby}),
                restService.getCategories()
        );
    }

    private RestApiCatService createTestObject() {
        RestApiCatService restService = new RestApiCatService();
        restService.setRestTemplate(restTemplateMock);
        return restService;
    }

    private CatImagesURLResponse newCatImagesURLResponse(String expectedURL) {
        CatImagesURLResponse catImagesURLResponse = new CatImagesURLResponse();
        ImagesData imagesData = new ImagesData();
        catImagesURLResponse.setData(imagesData);
        Image image = new Image();
        image.setUrl(expectedURL);
        imagesData.addImage(image);
        return catImagesURLResponse;
    }

    private Category newCategory(String name) {
        Category category = new Category();
        category.setName(name);
        return category;
    }
}
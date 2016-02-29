package org.chipay.cat.response;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "response")
public class CatCategoriesResponse {

    private CategoriesData data;

    public CategoriesData getData() {
        return this.data;
    }

    public void setData(CategoriesData data) {
        this.data = data;
    }
}

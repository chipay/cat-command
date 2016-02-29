package org.chipay.cat.response;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

public class CategoriesData {

    @XmlElementWrapper(name = "categories")
    @XmlElement(name = "category")
    private ArrayList<Category> categories;

    public CategoriesData() {
        this.categories = new ArrayList<>();
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void addCategory(Category category) {
        this.categories.add(category);
    }
}

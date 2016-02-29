package org.chipay.cat.response;


import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

public class ImagesData {

    @XmlElementWrapper(name = "images")
    @XmlElement(name = "image")
    private ArrayList<Image> images;

    public ImagesData() {
        this.images = new ArrayList<>();
    }

    public List<Image> getImages() {
        return images;
    }

    public void addImage(Image image) {
        this.images.add(image);
    }

    @Override
    public String toString() {
        return "ImagesData{" +
                "images=" + images +
                '}';
    }
}

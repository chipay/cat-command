package org.chipay.cat.response;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "response")
public class CatImagesURLResponse {

    private ImagesData data;

    public CatImagesURLResponse() {
        this.data = new ImagesData();
    }

    public ImagesData getData() {
        return this.data;
    }

    public void setData(ImagesData data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "CatImagesURLResponse{" +
                "data=" + data +
                '}';
    }
}
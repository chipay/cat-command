package org.chipay.cat.response;

import javax.xml.bind.annotation.XmlElement;

public class Image {

    String url;

    String id;

    String sourceURL;

    public Image() {
    }

    public String getUrl() {
        return url;
    }

    public String getId() {
        return id;
    }

    @XmlElement(name = "source_url")
    public String getSourceURL() {
        return sourceURL;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setId(String id) {
        this.id = id;
    }
}

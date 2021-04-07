
package lesson7;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;

@JsonIgnoreProperties(ignoreUnknown = true)
public class City1 {
    private String name;
    private String key;

    public City1(String name, String key) {
        this.name = name;
        this.key = key;
    }

    public City1() {
    }

    @JsonGetter("EnglishName")
    public String getName() {
        return name;
    }

    @JsonSetter("EnglishName")
    public void setName(String name) {
        this.name = name;
    }

    @JsonGetter("Key")
    public String getKey() {
        return key;
    }

    @JsonSetter("Key")
    public void setKey(String key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return "\n{" +
                "\"name\" : " + "\"" + name + "\"," +
                "\"key\" : " + "\"" + key + "\"" +
                "}";
    }

}
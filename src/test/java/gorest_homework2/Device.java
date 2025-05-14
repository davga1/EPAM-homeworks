package gorest_homework2;

//էս մեկում ձեր քոլը պետքա լինի լրիվ այլ API-ի։
//https://api.restful-api.dev/objects ։ Գրում եք համապատասխան class-ները ու էս API-ի ռեսփոնսը deserialize անում։
//Ուշադրություն դարձրեք data-ի մեջի կոնտենտին տարբեր item-ների համար մինչև համապատասխան dto-ն գրելը, որովհետև property-ներ կան,
//որոնք ոչ բոլորի data օբջեքթներում կան։ Պետքա ուսումնասիրեք, թե Jackson-ը ոնցա վերաբերում էն փռոփերթիներին deserialize անելուց, որոնք կարան չլինեն ռեսփոնսի մեջ, բայց կան dto-ում սահմանված, ու ոնցա դրանք deserialize անում

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;

//@JsonIgnoreProperties(ignoreUnknown = true)
public class Device {
    @JsonProperty("id")
    private int id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("data")
    private DeviceData data;
//    private Map<String, Object> data;

    Device() {
    }

    Device(int id, String name,
           DeviceData data
//           Map<String, Object> data
    ) {
        this.id = id;
        this.name = name;
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DeviceData
//    Map<String, Object>
    getData() {
        return data;
    }

    public void setData(
            DeviceData
//            Map<String, Object>
                    data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", data=" + data +
                "}";
    }
}

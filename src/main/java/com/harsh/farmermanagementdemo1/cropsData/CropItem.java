package com.harsh.farmermanagementdemo1.cropsData;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class CropItem {

    private ObjectId _id;
    private String type;
    private String name;
    private Double quantityInKg;
    private Double pricePerKg;
    private String email;
    private String address;

    public CropItem(String type, String name, Double quantity, Double pricePerKg, String email, String address) {
        this.type = type;
        this.name = name;
        this.quantityInKg = quantity;
        this.pricePerKg = pricePerKg;
        this.email = email;
        this.address = address;
    }

    public String get_id() { return _id.toHexString(); }
    public void set_id(ObjectId _id) { this._id = _id; }

}

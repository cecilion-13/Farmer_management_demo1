package com.harsh.farmermanagementdemo1.cropsData;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class RequestItem {
    private String type;
    private String name;
    private Double quantityInKg;
    private Double pricePerKg;
    private String email;
    private String address;
}

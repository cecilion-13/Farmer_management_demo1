package com.harsh.farmermanagementdemo1.cropsData;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class UpdateRequest {

    private Double quantityInKg;
    private Double pricePerKg;
    private String address;

}

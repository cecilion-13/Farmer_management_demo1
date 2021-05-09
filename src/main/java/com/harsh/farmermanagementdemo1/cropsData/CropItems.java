package com.harsh.farmermanagementdemo1.cropsData;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class CropItems {

    private List<CropItem> itemList;

}

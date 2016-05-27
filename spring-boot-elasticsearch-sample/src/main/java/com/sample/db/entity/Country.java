package com.sample.db.entity;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@ToString
@Data
public class Country implements Serializable{

    private String id;

    private String iso;

    private String name;

    @JsonProperty("meta_data_1")
    private String metaData1;

    @JsonProperty("meta_data_2")
    private String metaData2;

    @JsonProperty("meta_data_3")
    private String metaData3;

    @JsonProperty("meta_data_4")
    private String metaData4;

}

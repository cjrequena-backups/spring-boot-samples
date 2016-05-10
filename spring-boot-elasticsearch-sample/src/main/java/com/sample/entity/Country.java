package com.sample.entity;


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

    private String metaData1;

    private String metaData2;

    private String metaData3;

    private String metaData4;

}

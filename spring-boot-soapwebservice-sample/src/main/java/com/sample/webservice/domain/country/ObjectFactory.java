//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.05.18 at 05:08:58 PM CEST 
//


package com.sample.webservice.domain.country;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.sample.webservice.domain.country package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.sample.webservice.domain.country
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CountryRQ }
     * 
     */
    public CountryRQ createCountryRQ() {
        return new CountryRQ();
    }

    /**
     * Create an instance of {@link CountryRS }
     * 
     */
    public CountryRS createCountryRS() {
        return new CountryRS();
    }

    /**
     * Create an instance of {@link Country }
     * 
     */
    public Country createCountry() {
        return new Country();
    }

}

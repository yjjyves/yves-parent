package com.yves.common.context;

import com.yves.model.common.Org;
import com.yves.model.common.Person;
import com.yves.model.common.enums.CityEnum;

import java.io.Serializable;

/**
 * @author Administrator
 */
public class Context implements Serializable{
    /**
     * 当前城市
     */
    private Org cu;


    /**
     * 当前城市
     */
    private CityEnum city;

    /**
     * 当前人
     */
    private Person person;

    public CityEnum getCity() {
        return city;
    }

    public String getCityStr() {
        return city == null ? null : city.name();
    }

    public void setCity(CityEnum city) {
        this.city = city;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Org getCu() {
        return cu;
    }

    public void setCu(Org cu) {
        this.cu = cu;
    }
}

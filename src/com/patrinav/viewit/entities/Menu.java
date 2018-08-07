package com.patrinav.viewit.entities;

import main.resources.enumerations.MenuSize;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
@DiscriminatorValue("menu")
public class Menu extends Product {
    @Enumerated(EnumType.STRING)
    private MenuSize size;

    public Menu() {
    }

    public MenuSize getMenuSize() {
        return size;
    }

    public void setMenuSize(MenuSize size) {
        this.size = size;
    }
}

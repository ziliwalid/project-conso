package com.ensi.project;

import com.ensi.project.models.Menu;

public class Main {

    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.execute();
        menu.close();
    }
}

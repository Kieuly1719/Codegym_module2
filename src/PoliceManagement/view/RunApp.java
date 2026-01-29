package PoliceManagement.view;

import PoliceManagement.controller.PoliceController;

public class RunApp {
    private static final PoliceController policeController =  new PoliceController();

    public static void main(String[] args) {
        policeController.displayMenuMain();
    }
}

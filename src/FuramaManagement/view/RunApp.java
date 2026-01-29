package FuramaManagement.view;

import FuramaManagement.controller.FuramaController;

public class RunApp {
    public static FuramaController furamaController = new FuramaController();

    public static void main(String[] args) {
        furamaController.displayMain();
    }
}

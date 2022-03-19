package pl.sdacademy.ui;

import pl.sdacademy.repository.MakeRepository;


import java.util.Scanner;

public class MakeUI {
    private MakeRepository modelRepository;
    private Scanner scanner;

    public MakeUI(MakeRepository modelRepository) {
        this.scanner = new Scanner(System.in);
        this.modelRepository = modelRepository;
    }
}

package ru.glazov.java.core.view;

import ru.glazov.java.core.controller.Controller;
import ru.glazov.java.core.controller.IController;
import ru.glazov.java.core.model.entity.Weather;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class UserInterface implements ru.glazov.java.core.view.IUserInterface {

    IController controller = new Controller();

    @Override
    public void showMenu() {

        while (true) {
            System.out.println("Введите название города на английском языке, '*' для просмотра базы текущих прогнозов или 'exit' для выхода");
            Scanner scanner = new Scanner(System.in);

            String userResponse = scanner.nextLine();

            checkIsExit(userResponse);

            if (userResponse.equals("*")) {

                controller.printAllData();
                continue;
            }


            try {
                controller.onCityInput(userResponse);
            } catch (Exception e) {
                e.printStackTrace();
                continue;
            }

            System.out.println("Введите команду\n1 - для получения погоды на текущий день\n2 - для получения прогноза на 5 дней\n3 - для просмотра базы текущих прогнозов\nили\n0 - для выхода из программы.");

            int selectedCommand = scanner.nextInt();

            try {
                controller.onCommandChosen(selectedCommand);
            } catch (IOException e) {
                e.printStackTrace();
                continue;
            }
        }
    }


    private void checkIsExit(String userResponse) {
        if (userResponse.equalsIgnoreCase("exit") ||
                userResponse.equalsIgnoreCase("выход")) {
            System.out.println("Завершаю работу...");
            System.exit(0);
        }
    }
}


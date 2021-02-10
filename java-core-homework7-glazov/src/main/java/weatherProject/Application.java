package weatherProject;

import com.fasterxml.jackson.databind.ObjectMapper;
import weatherProject.view.IUserInterface;
import weatherProject.view.UserInterface;

import java.io.File;
import java.io.IOException;

public class Application {

    public static void main(String[] args) throws IOException {
        IUserInterface ui = new UserInterface();
        ui.showMenu();




    }
}

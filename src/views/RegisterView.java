/**
 * @author UWENAYO Alain Pacifique
 * @description RegisterView class
 * @date 2022-03-06
 **/

package views;

import com.fasterxml.jackson.databind.ObjectMapper;
import interfaces.MessageTypes;
import models.RegisterUser;
import models.RequestBody;
import models.UserUtils.UserGender;
import models.UserUtils.UserRoles;
import utils.Handlers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import static utils.MessagePrinter.printConsoleMessage;

/**
 * The type RegisterUser view.
 */
public class RegisterView {

    /**
     * Register user.
     *
     * @throws Exception the exception
     * @description register a new user
     * @author UWENAYO ALain Pacifique
     */
    public static void registerUser() throws Exception {

        Scanner scanner = new Scanner(System.in);
        UserRoles userRole = UserRoles.EMPLOYER;
        UserGender userGender = UserGender.MALE;
        printConsoleMessage(MessageTypes.NORMAL, false, "\tUSER REGISTER");
        printConsoleMessage(MessageTypes.NORMAL, false,"\t-----------------------");
        printConsoleMessage(MessageTypes.NORMAL, false,"\tEnter your first name[ex:UWENAYO]");
        String firstName = scanner.nextLine();
        printConsoleMessage(MessageTypes.NORMAL, false,"\tEnter your last name[ex:Alain]");
        String lastName = scanner.nextLine();
        printConsoleMessage(MessageTypes.NORMAL, false,"\tEnter your gender[1:Male,2:Female]");
        if(scanner.nextInt() == 2){
            userGender = UserGender.FEMALE;
        }
        scanner.nextLine();
        printConsoleMessage(MessageTypes.NORMAL, false,"\tEnter your email[ex:example@domain.com]");
        String email = scanner.nextLine();
        printConsoleMessage(MessageTypes.NORMAL, false,"\tEnter your password[strong password suggested]");
        String password = scanner.nextLine();
        printConsoleMessage(MessageTypes.NORMAL, false,"\tEnter your Date of Birth[ex:01/12/1990]");
        Date dateOfBirth = new SimpleDateFormat("dd/MM/yyyy").parse(scanner.nextLine());
        printConsoleMessage(MessageTypes.NORMAL, false,"\tChoose account type[1:employer,2:employee]");
        int accountType = scanner.nextInt();
        if (accountType == 2){
            userRole = UserRoles.EMPLOYEE;
        }
        RegisterUser user = new RegisterUser(1,firstName,lastName,email,password,userGender,userRole, dateOfBirth);
        RequestBody requestBody = new RequestBody();
        requestBody.setUrl("/users");
        requestBody.setAction("register");
        requestBody.setObject(user);

        String requestString = new ObjectMapper().writeValueAsString(requestBody);
        System.out.println(requestString);
        Handlers.RequestHandler(requestString);
    }

}


import java.sql.*;
import java.util.Scanner;
public class Main extends Methods {
    private static final String url = "jdbc:mysql://localhost:3306/bankomat?serverTimezone=Europe/Moscow&useSSL=false";
    private static final String username = "root";
    private static final String password = "W4p_Aspect";

    public static void  main (String[] args)
    {
        Account account = new Account();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Account: выберите действие: \n 1. Создать аккаунт \n 2. Транзакция"); String a = scanner.next();
        switch (a){
            case "1":
                System.out.print("Введите имя: "); String person = scanner.next();
                System.out.print("Введите кол-во денег: "); int money = Integer.parseInt(scanner.next());
                System.out.print("Введите пароль: "); String password_ = scanner.next();
                account.create(person, money, password_); System.out.print("Аккаунт создан!");
                break;
            case "2":
                System.out.print("Введите имя с чьего счета снимаются деньги: "); String person1 = scanner.next();
                System.out.print("Введите имя на чей счет получяются деньги: "); String person2 = scanner.next();
                System.out.print("Введите сумму: "); int cash = Integer.parseInt(scanner.next());
                account.transaction(person1, person2, cash); System.out.print("Транзакция совершена!");
                break;

        }
    }

}

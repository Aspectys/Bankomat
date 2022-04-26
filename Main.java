import java.sql.*;
import java.util.Scanner;
public class Main
{
    private static final String url = "jdbc:mysql://localhost:3306/bankomat?serverTimezone=Europe/Moscow&useSSL=false";
    private static final String username = "root";
    private static final String password = "W4p_Aspect";

    public static void main (String[] args)
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


    static class Check {
        void checkAvailabilityMoney(int moneyOnRequest, int moneyOnAccount){
            try(Connection conn = DriverManager.getConnection(url, username, password)){
                if (moneyOnAccount>moneyOnRequest){
                    System.out.println(".");
                }else if(moneyOnAccount<moneyOnRequest) {
                    System.out.printf("checkAvailabilityMoney: На счету не хватает %d $", (moneyOnRequest-moneyOnAccount));
                }
            }catch (Exception ex){
                System.err.println("ERROR");
                ex.printStackTrace();
            }
        }

    }
    static class Account{
        void create(String person, int money, String password_){
            try(Connection conn = DriverManager.getConnection(url, username, password)){
                PreparedStatement st = conn.prepareStatement("INSERT INTO base (person, money, passwords) VALUES (?, ?, ?)");
                st.setString(1, person);
                st.setInt(2, money);
                st.setString(3, password_);
                int rs = st.executeUpdate();
                System.out.printf("%d row(s) returned", rs);

                System.out.println("Account created successful");
            }catch(Exception ex){
                System.out.println("Account don`t created(");
                ex.printStackTrace();
            }
        }
        void transaction(String person1, String person2, int cash){

            try (Connection conn = DriverManager.getConnection(url, username, password)){
                PreparedStatement person_first = conn.prepareStatement("SELECT id, person, passwords, money FROM base WHERE person = ?;"); person_first.setString(1, person1);
                PreparedStatement person_second = conn.prepareStatement("SELECT id, person, passwords, money FROM base WHERE person = ?;");person_second.setString(1, person2);
                ResultSet resultSet1 = person_first.executeQuery();

                while(resultSet1.next()){
                    int money1 = resultSet1.getInt("money"); // Kolvo money u Alimzhan

                    Check check = new Check();
                    check.checkAvailabilityMoney(cash, money1);
                    int money2 = 0;
                    money2 = money1 + cash; money1 = money1 - cash;

                    PreparedStatement m = conn.prepareStatement("update base set money = ? where person = ?;");
                            m.setInt(1, money1); m.setString(2, person1);
                            int mRun = m.executeUpdate();
                            System.out.println(mRun);

                    PreparedStatement p = conn.prepareStatement("update base set money = ? where person = ?;");
                            p.setInt(1, money2); p.setString(2, person2);
                            int pRun = p.executeUpdate();
                            System.out.println(pRun);
                }
            }catch (Exception ex){
                System.out.println("ERROR");
                ex.printStackTrace();
            }
        }
    }
}
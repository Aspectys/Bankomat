package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Methods {
    private static final String url = "jdbc:h2:~/test";
    private static final String username = "sa";
    private static final String password = "";
    static class db{
        void create(String name){
            try{
                Connection conn = DriverManager.getConnection(url, username, password);
                PreparedStatement ps = conn.prepareStatement("CREATE table ?(id int primary key AUto_increment, person varchar(30), money int, passwords varchar(40));");
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }
    }
    static class Account{
        private void checkAvailabilityMoney(int moneyOnRequest, int moneyOnAccount){
            if (moneyOnAccount>moneyOnRequest){
                System.out.println(".");
            }else if(moneyOnAccount<moneyOnRequest) {
                System.out.printf("checkAvailabilityMoney: На счету не хватает %d $", (moneyOnRequest-moneyOnAccount));
            }
        }
        void create(String person, int money, String password_){
            try{
                Connection conn = DriverManager.getConnection(url, username, password);
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

            try{
                Connection conn = DriverManager.getConnection(url, username, password);
                PreparedStatement person_first = conn.prepareStatement("SELECT id, person, passwords, money FROM base WHERE person = ?;"); person_first.setString(1, person1);
                PreparedStatement person_second = conn.prepareStatement("SELECT id, person, passwords, money FROM base WHERE person = ?;");person_second.setString(1, person2);
                ResultSet resultSet1 = person_first.executeQuery();

                while(resultSet1.next()){
                    int money1 = resultSet1.getInt("money"); // Kolvo money u Alimzhan


                    checkAvailabilityMoney(cash, money1);
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

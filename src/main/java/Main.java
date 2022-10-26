
import accounts.SavingsAccount;
import accounts.CheckingAccount;
import accounts.CreditAccount;
import clients.Client;

import java.util.Arrays;
import java.util.Scanner;


public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        SavingsAccount newSaving = new SavingsAccount(1050, "Накопительный счет", 1000);
        //newSaving.add(20000);
        newSaving.pay(500);

        CheckingAccount newChaking = new CheckingAccount(2000, "Расчетный счет");
        newChaking.add(5000);
        newChaking.pay(1000);

        CreditAccount newCredit = new CreditAccount(-5000, "Кредитный счет");
        newCredit.add(2000);
        newCredit.pay(1000);

        System.out.println(newChaking.getName() + ". Баланс: " + newChaking.getBalance());
        System.out.println(newSaving.getName() + ". Баланс: " + newSaving.getBalance());
        System.out.println(newCredit.getName() + ". Баланс: " + newCredit.getBalance());
        newChaking.transfer(newCredit, 6000);
        System.out.println(newChaking.getName() + ". Баланс: " + newChaking.getBalance());
        System.out.println(newSaving.getName() + ". Баланс: " + newSaving.getBalance());
        System.out.println(newCredit.getName() + ". Баланс: " + newCredit.getBalance());

        Client client = new Client("Stas", 5);
//        client.print();
//        System.out.println("Выберите тип нового счета: ");
//        System.out.println("1 - Накопительный счет");
//        System.out.println("2 - Расчетный счет");
//        System.out.println("3 - Кредитный счет");
//        int number = scanner.nextInt();
//        switch (number) {
//            case 1:
//                SavingsAccount saving = new SavingsAccount(5000, "Накопительный счет", 20000);
//                client.newAccount(saving);
//                break;
//            case 2:
//                CheckingAccount chaking = new CheckingAccount(0, "Счет номер 2. Расчетный");
//                client.newAccount(chaking);
//                break;
//            case 3:
//                CreditAccount credit = new CreditAccount(-10000, "Счет номер 3. Кредитный");
//                client.newAccount(credit);
//                break;
//            default:
//                System.out.println("Неверное значение");
//        }
//        client.pay(2000);
//        SavingsAccount saving = new SavingsAccount(5000, "Накопительный счет", 20000);
//        client.newAccount(saving);
//        CheckingAccount chaking = new CheckingAccount(0, "Счет номер 2. Расчетный");
//        client.newAccount(chaking);
        CreditAccount credit = new CreditAccount(-10000, "Счет номер 3. Кредитный");
        client.newAccount(credit);
        CreditAccount credit2 = new CreditAccount(-10000, "Счет номер 3. Кредитный");
        client.newAccount(credit2);
        CreditAccount credit3 = new CreditAccount(-10000, "Счет номер 3. Кредитный");
        client.newAccount(credit3);
//        CheckingAccount chaking = new CheckingAccount(0, "Счет номер 2. Расчетный");
//        client.newAccount(chaking);
        client.accept(10000000);


    }
}

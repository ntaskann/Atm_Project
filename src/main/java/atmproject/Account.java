package atmproject;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Account {

    private int accountNumber; // Hesap numarasi
    private int pinNumber; // Sifre

    private double checkingBalance; // Vadesiz hesap bakiyesi
    private double savingBalance; // Vadeli hesap bakiyesi

    DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");

    Scanner input = new Scanner(System.in);

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getPinNumber() {
        return pinNumber;
    }

    public void setPinNumber(int pinNumber) {
        this.pinNumber = pinNumber;
    }

    public double getCheckingBalance() {
        return checkingBalance;
    }

    public void setCheckingBalance(double checkingBalance) {
        this.checkingBalance = checkingBalance;
    }

    public double getSavingBalance() {
        return savingBalance;
    }

    public void setSavingBalance(double savingBalance) {
        this.savingBalance = savingBalance;
    }

    // Para Cekme > Para Cekme Isleminden Sonr Kalan Miktar - Checking Balance

    private double calculateCheckingBalanceAfterWithdraw(double amount) {

        checkingBalance -= amount;
        return checkingBalance;

    }

    // Para Yatirma > Para Yatirma Isleminden Sonra Olusan Miktar - Checking Balance

    private double calculateCheckingBalanceAfterDeposit(double amount) {

        checkingBalance += amount;
        return checkingBalance;

    }

    // Para Cekme > Para Cekildikten Sonra Kalan Bakiye - Saving Balance

    private double calculateSavingBalanceAfterWithdraw(double amount) {

        savingBalance -= amount;
        return savingBalance;

    }

    // Para Yatirma > Para Yatirildiktan Sonra Olussan Bakiye - Saving Balance

    private double calculateSavingBalanceAfterDeposit(double amount) {

        savingBalance += amount;
        return savingBalance;

    }

    // Musteri Ile Para Cekmek Icin Etkilesim > Checking Balance
    public void getCheckingWithdraw() {

        displayCurrentAmount(checkingBalance);
        System.out.println("Cekmek Istediginiz Miktari Giriniz... :");
        double amount = input.nextDouble();

        if (amount <= 0) {
            System.out.println("Geçerli Bir Miktar Giriniz...");
            getCheckingWithdraw();
        } else if (amount <= checkingBalance) {
            calculateCheckingBalanceAfterWithdraw(amount);
            System.out.println();
            displayCurrentAmount(checkingBalance);
        } else {
            System.out.println("Yetersiz Bakiye !");
        }

    }

    // Musteri Ile Para Yatirmak Icin Etkilesim > Checking Balance
    public void getCheckingDeposit() {

        displayCurrentAmount(checkingBalance);
        System.out.println("Yatirmak Istediginiz Miktari Giriniz...");
        double amount = input.nextDouble();

        if (amount <= 0) {
            System.out.println("Geçerli Bir Miktar Giriniz...");
            getCheckingDeposit();
        } else {
            calculateCheckingBalanceAfterDeposit(amount);
            System.out.println();
            displayCurrentAmount(checkingBalance);
        }

    }

    // Musteri Ile Para Cekmek Icin Etkilesim > Saving Balance
    public void getSavingWithdraw() {

        displayCurrentAmount(savingBalance);
        System.out.println("Cekmek Istediginiz Miktari Giriniz... :");
        double amount = input.nextDouble();

        if (amount <= 0) {
            System.out.println("Geçerli Bir Miktar Giriniz...");
            getSavingWithdraw();
        } else if (amount <= savingBalance) {
            calculateSavingBalanceAfterWithdraw(amount);
            System.out.println();
            displayCurrentAmount(savingBalance);
        } else {
            System.out.println("Yetersiz Bakiye !");
        }

    }

    // Musteri Ile Para Yatirmak Icin Etkilesim > Saving Balance
    public void getSavingDeposit() {

        displayCurrentAmount(savingBalance);
        System.out.println("Yatirmak Istediginiz Miktari Giriniz...");
        double amount = input.nextDouble();

        if (amount <= 0) {
            System.out.println("Geçerli Bir Miktar Giriniz...");
            getSavingDeposit();
        } else {
            calculateSavingBalanceAfterDeposit(amount);
            System.out.println();
            displayCurrentAmount(savingBalance);
        }

    }


    // Son Bakiye
    public void displayCurrentAmount(double balance) {

        System.out.println("Hesabinizda Bulunan Bakiye :" + moneyFormat.format(balance));

    }


}

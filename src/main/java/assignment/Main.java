package assignment;

import assignment.model.Book;
import assignment.service.BookService;

import java.util.Scanner;

public class Main {

    /*
    1. Mượn sách
    2. Trả sách
    3. Data sách trong thư viện
     */

   // public static BookService bookService;


    public static void main(String[] args) {
        System.out.println("Menu:");
        System.out.println("1.Muon sach");
        System.out.println("2.Tra sach");
        Scanner scn = new Scanner(System.in);
        System.out.println("choose:");
        int number = scn.nextInt();

        switch (number) {
            case 1:
                System.out.println("nhap ten sach muon muon");
                break;
            case 2:
                System.out.println("nhap ten nguoi tra sach");
                break;
        }
    }
}

package com.alfonsovidrio.invoiceapp;

import com.alfonsovidrio.invoiceapp.models.Customer;
import com.alfonsovidrio.invoiceapp.models.Invoice;
import com.alfonsovidrio.invoiceapp.models.InvoiceItem;
import com.alfonsovidrio.invoiceapp.models.Product;

import java.util.Scanner;

public class InvoiceApp {
    public static void main(String[] args) {

        Customer customer = new Customer();
        customer.setRfc("LUIE800101HDFRNS09");
        customer.setName("Luis");

        Scanner sn = new Scanner(System.in);
        System.out.print("please enter the description of the invoice: ");
        String desc = sn.nextLine();
        Invoice invoice = new Invoice(desc, customer);

        Product product;

        System.out.println();

        for(int i = 0; i < 5; i++) {
            product = new Product();
            System.out.print("please enter the name of the product " + product.getCode() + ": ");
            product.setName(sn.nextLine());

            System.out.print("please enter the price of the product " + product.getCode() + ":  ");
            product.setPrice(sn.nextFloat());

            System.out.print("please enter the quantity of the product " + product.getCode() + ": ");

            invoice.addInvoiceItem(new InvoiceItem(sn.nextInt(), product));

            System.out.println();
            sn.nextLine();
        }
        sn.close();
        System.out.println(invoice);
    }
}

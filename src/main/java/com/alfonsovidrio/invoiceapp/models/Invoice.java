package com.alfonsovidrio.invoiceapp.models;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Invoice {
    private int invoiceNumber;
    private String description;
    private Date date;
    private Customer customer;
    private InvoiceItem[] items;
    private int itemsIndex;
    public static final int MAX_ITEMS = 30;
    private static int lastInvoiceNumber;

    public Invoice(String description, Customer customer) {
        this.description = description;
        this.customer = customer;
        this.items = new InvoiceItem[MAX_ITEMS];
        this.invoiceNumber = ++lastInvoiceNumber;
        this.date = new Date();
    }

    public int getInvoiceNumber() {
        return invoiceNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public InvoiceItem[] getItems() {
        return items;
    }

    public void addInvoiceItem(InvoiceItem item) {
        if (itemsIndex < MAX_ITEMS) {
            this.items[itemsIndex++] = item;
        }
    }

    public float calculateTotal() {
        float total = 0.0f;
        for(int i = 0; i < itemsIndex; i++) {
            total += this.items[i].calculateAmount();
        }
        return total;
    }

    public String viewDetails() {
        StringBuilder sb = new StringBuilder("Invoice N°: ");
        sb.append(invoiceNumber)
                .append("\nCustomer: ")
                .append(this.customer.getName())
                .append("\t RFC: ")
                .append(this.customer.getRfc())
                .append("\nDescription: ")
                .append(this.description)
                .append("\t")
        ;

        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        sb.append("Issue date: ")
                .append(df.format(this.date))
                .append("\n\n#\tName\t$\tQuantity. \t Amount\n");

        for(int i = 0; i < itemsIndex; i++) {
            sb.append(this.items[i]).append("\n");
        }
        sb.append("Total amount: $")
                .append(calculateTotal());

        return sb.toString();
    }

    @Override
    public String toString() {
        return viewDetails();
    }
}

package com.company.paymentmodel;

import Utils.MyException;
import com.company.Person;

public class User extends Person implements IPayment{

    private static long idUnique = 0;

    private long id;
    private String email;
    private Payment payment;

    public User() {
        super();
        id = idUnique++;
        email = "";
        payment = new Payment();
    }

    public User(String surname, String name, String patronymic, int age, Sex sex, String email)
    {
        super(surname, name, patronymic, age, sex);
        id = idUnique++;
        this.email = email;
        payment = new Payment();
    }

    public User(String surname, String name, String patronymic, int age, Sex sex) {
        super(surname, name, patronymic, age, sex);
        id = idUnique++;
        email = "";
        payment = new Payment();
    }

    public static long getIdUnique() {
        return idUnique;
    }

    public long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Payment getPayment() {
        return payment;
    }

    @Override
    public void addToPayment(Product product) {
        Payment.ProductInPayment productInPayment = payment.findProductById(product);
        if (productInPayment != null)
        {
            productInPayment.incrementCount();
        }
        else
        {
            payment.addProductInPayment(product);
        }
    }

    @Override
    public void addToPayment(Product product, int count) throws MyException {
        if (count < 1)
        {
            throw new MyException("Количество товаров должно быть от 1 и выше. Неверные данные.");
        }
        Payment.ProductInPayment productInPayment = payment.findProductById(product);
        if (productInPayment != null)
        {
            productInPayment.setCount(productInPayment.getCount() + count);
        }
        else
        {
            payment.addProductInPayment(product, count);
        }
    }

    @Override
    public void removeFromPayment(Payment.ProductInPayment product) {
        payment.removeProductFromPayment(product);
    }

    @Override
    public void clearPayment() {
        payment.clearPayment();
    }

    @Override
    public void changeCountOfProduct(Payment.ProductInPayment product, int newCount) throws MyException {
        if (newCount < 1)
        {
            throw new MyException("Количество товаров должно быть от 1 и выше. Неверные данные.");
        }
        product.setCount(newCount);
    }

    @Override
    public void incrementCountOfProduct(Payment.ProductInPayment product) {
        product.incrementCount();
    }

    @Override
    public void decrementCountOfProduct(Payment.ProductInPayment product) {
        if (product.getCount() > 1)
        {
            product.decrementCount();
        }
    }

    @Override
    public double getCommonPriceOfAllProductsInPayment() {
        return payment.getCommonPriceOfProducts();
    }

    @Override
    public String toString() {
        return "User id: " + id
                + " | " + getSurname()
                + " " + getName()
                + " " + getPatronymic()
                + " | " + "Age: " + getAge()
                + " | " + "Sex: " + getSex().toString()
                + " | " + "email: "+ email;
    }

    @Override
    public void printInfo() {
        System.out.println(toString());
    }
}
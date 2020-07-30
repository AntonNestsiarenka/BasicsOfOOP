package com.company.paymentmodel.user;

import Utils.MyException;
import com.company.comon.Person;
import com.company.paymentmodel.user.interfaces.IPayment;
import com.company.paymentmodel.Payment;
import com.company.paymentmodel.Product;

import java.util.Objects;

public final class User extends Person implements IPayment {

    /* Класс описывает пользователя интернет магазина. */

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
        // Добавляет товар в корзину.
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
        /* Добавляет товар в корзину в определенном количестве. Метод выбрасывает исключение MyException если заданное
           количество товаров меньше 1. */
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
        // Удаляет товар из корзины.
        payment.removeProductFromPayment(product);
    }

    @Override
    public void clearPayment() {
        // Очищает корзину.
        payment.clearPayment();
    }

    @Override
    public void changeCountOfProduct(Payment.ProductInPayment product, int newCount) throws MyException {
        /* Изменяет количество заданного товара в корзине. Метод выбрасывает исключение MyException если заданное
           количество товара меньше 1. */
        if (newCount < 1)
        {
            throw new MyException("Количество товаров должно быть от 1 и выше. Неверные данные.");
        }
        product.setCount(newCount);
    }

    @Override
    public void incrementCountOfProduct(Payment.ProductInPayment product) {
        // Добавляет к количеству заданного товара 1.
        product.incrementCount();
    }

    @Override
    public void decrementCountOfProduct(Payment.ProductInPayment product) {
        // Отнимает от заданного количества товара 1.
        if (product.getCount() > 1)
        {
            product.decrementCount();
        }
    }

    @Override
    public double getCommonPriceOfAllProductsInPayment() {
        // Получить общую стоимость товаров в корзине.
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        User user = (User) o;
        return id == user.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id);
    }

    @Override
    public void printInfo() {
        System.out.println(toString());
    }
}
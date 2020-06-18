package com.company.paymentmodel;

import Utils.MyException;

public interface IPayment {

    void addToPayment(Product product);

    void addToPayment(Product product, int count) throws MyException;

    void removeFromPayment(Payment.ProductInPayment product);

    void clearPayment();

    void changeCountOfProduct(Payment.ProductInPayment product, int newCount) throws MyException;

    void incrementCountOfProduct(Payment.ProductInPayment product);

    void decrementCountOfProduct(Payment.ProductInPayment product);

    double getCommonPriceOfAllProductsInPayment();

}
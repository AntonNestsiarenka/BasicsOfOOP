package com.company.paymentmodel.user.interfaces;

import Utils.MyException;
import com.company.paymentmodel.Payment;
import com.company.paymentmodel.Product;

public interface IPayment {

    /* Интерфейс для работы с корзиной товаров. */

    void addToPayment(Product product);

    void addToPayment(Product product, int count) throws MyException;

    void removeFromPayment(Payment.ProductInPayment product);

    void clearPayment();

    void changeCountOfProduct(Payment.ProductInPayment product, int newCount) throws MyException;

    void incrementCountOfProduct(Payment.ProductInPayment product);

    void decrementCountOfProduct(Payment.ProductInPayment product);

    double getCommonPriceOfAllProductsInPayment();

}
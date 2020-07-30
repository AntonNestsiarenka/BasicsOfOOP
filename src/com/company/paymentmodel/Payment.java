package com.company.paymentmodel;

import java.util.ArrayList;

public final class Payment {

    /* Класс описывает корзину товаров. */

    private double commonPriceOfProducts;
    private ArrayList<ProductInPayment> productsInPayment;

    public Payment()
    {
        commonPriceOfProducts = 0;
        productsInPayment = new ArrayList<>();
    }

    public class ProductInPayment {

        /* Внутренний класс описывает товар в корзине. */

        private Product product;
        private int count;

        public ProductInPayment(Product product) {
            this.product = product;
            count = 1;
        }

        public ProductInPayment(Product product, int count)
        {
            this.product = product;
            this.count = (count > 0) ? count : 1;
        }

        public void incrementCount()
        {
            count++;
        }

        public void decrementCount()
        {
            count--;
        }

        public Product getProduct() {
            return product;
        }

        public void setProduct(Product product) {
            this.product = product;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        @Override
        public String toString() {
            return product.toString() + " | " + "NumberOfProducts: " + count;
        }

        public void printPaymentInfo()
        {
            System.out.println(toString());
        }
    }

    public double getCommonPriceOfProducts() {
        recalculateCommonPriceInPayment();
        return commonPriceOfProducts;
    }

    public ArrayList<ProductInPayment> getProductsInPayment() {
        return productsInPayment;
    }

    public void addProductInPayment(Product product)
    {
        productsInPayment.add(new ProductInPayment(product));
        recalculateCommonPriceInPayment();
    }

    public void addProductInPayment(Product product, int count)
    {
        productsInPayment.add(new ProductInPayment(product, count));
        recalculateCommonPriceInPayment();
    }

    public void removeProductFromPayment(ProductInPayment productInPayment)
    {
        // Удаляет из корзины товар.
        if (productsInPayment.remove(productInPayment))
            recalculateCommonPriceInPayment();
    }

    public void clearPayment()
    {
        // Очищает корзину товаров.
        productsInPayment.clear();
        recalculateCommonPriceInPayment();
    }

    public ProductInPayment findProductById(Product product)
    {
        // Поиск товара в корзине. Возвращает объект ProductInPayment если такой объект есть либо null если нет.
        for (ProductInPayment productInPayment : productsInPayment)
        {
            if (productInPayment.getProduct().getId() == product.getId())
                return productInPayment;
        }
        return null;
    }

    public void recalculateCommonPriceInPayment()
    {
        // Пересчет стоимости корзины товаров.
        double tempCommonPriceOfProducts = 0;
        for (ProductInPayment productInPayment : productsInPayment)
        {
            tempCommonPriceOfProducts += (productInPayment.product.getPrice() * productInPayment.count);
        }
        commonPriceOfProducts = tempCommonPriceOfProducts;
    }

    @Override
    public String toString() {
        StringBuilder newStr = new StringBuilder();
        for (ProductInPayment productInPayment : productsInPayment)
        {
            newStr.append(productInPayment.toString() + '\n');
        }
        newStr.append("Total price of products: " + getCommonPriceOfProducts());
        return newStr.toString();
    }

    public void printPaymentInfo()
    {
        System.out.println(toString());
    }
}
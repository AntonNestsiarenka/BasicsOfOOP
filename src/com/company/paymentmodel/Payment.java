package com.company.paymentmodel;

import java.util.ArrayList;

public class Payment {

    private double commonPriceOfProducts;
    private ArrayList<ProductInPayment> productsInPayment;

    public Payment()
    {
        commonPriceOfProducts = 0;
        productsInPayment = new ArrayList<>();
    }

    public class ProductInPayment {

        private Product product;
        private int count;

        public ProductInPayment(Product product) {
            this.product = product;
            count = 1;
        }

        public ProductInPayment(Product product, int count)
        {
            this.product = product;
            this.count = count;
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
    }

    public void addProductInPayment(Product product, int count)
    {
        productsInPayment.add(new ProductInPayment(product, count));
    }

    public void removeProductFromPayment(ProductInPayment productInPayment)
    {
        productsInPayment.remove(productInPayment);
    }

    public void clearPayment()
    {
        productsInPayment.clear();
        commonPriceOfProducts = 0;
    }

    public ProductInPayment findProductById(Product product)
    {
        for (ProductInPayment productInPayment : productsInPayment)
        {
            if (productInPayment.getProduct().getId() == product.getId())
                return productInPayment;
        }
        return null;
    }

    public void recalculateCommonPriceInPayment()
    {
        for (ProductInPayment productInPayment : productsInPayment)
        {
            commonPriceOfProducts += (productInPayment.product.getPrice() * productInPayment.count);
        }
    }

    @Override
    public String toString() {
        StringBuilder newStr = new StringBuilder();
        for (ProductInPayment productInPayment : productsInPayment)
        {
            newStr.append(productInPayment.toString() + '\n');
        }
        newStr.append("Total price of products: " + String.valueOf(getCommonPriceOfProducts()));
        return newStr.toString();
    }

    public void printPaymentInfo()
    {
        System.out.println(toString());
    }
}
package com.pedro.efood.dto;

import java.util.List;

public class CheckoutRequestDTO {

    public List<ProductDTO> products;
    public DeliveryDTO delivery;
    public PaymentDTO payment;

    public static class ProductDTO {
        public Long id;
        public Double price;
    }

    public static class DeliveryDTO {
        public String receiver;
        public AddressDTO address;
    }

    public static class AddressDTO {
        public String description;
        public String city;
        public String zipCode;
        public Integer number;
        public String complement;
    }

    public static class PaymentDTO {
        public CardDTO card;
    }

    public static class CardDTO {
        public String name;
        public String number;
        public Integer code;
        public ExpirationDTO expires;
    }

    public static class ExpirationDTO {
        public Integer month;
        public Integer year;
    }
}

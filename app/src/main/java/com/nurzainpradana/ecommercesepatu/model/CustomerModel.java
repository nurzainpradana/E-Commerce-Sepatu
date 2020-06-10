package com.nurzainpradana.ecommercesepatu.model;

import com.midtrans.sdk.corekit.core.TransactionRequest;
import com.midtrans.sdk.corekit.models.CustomerDetails;
import com.midtrans.sdk.corekit.models.ItemDetails;
import com.midtrans.sdk.corekit.models.snap.Authentication;
import com.midtrans.sdk.corekit.models.snap.CreditCard;

import java.util.ArrayList;

public class CustomerModel {

    public static CustomerDetails customerDetails() {

        CustomerDetails customerDetails = new CustomerDetails();
        customerDetails.setFirstName("Nur Zain");
        customerDetails.setPhone("6282125652279");
        customerDetails.setEmail("pradananurzain@gmail.com");

        return customerDetails;

    }

    public static TransactionRequest transactionRequest (String id, int price, int qty, String name){

        TransactionRequest transactionRequest = new TransactionRequest(System.currentTimeMillis()+" ", 500000);
        transactionRequest.setCustomerDetails(customerDetails());

        ItemDetails details = new ItemDetails(id, price, qty, name);

        ArrayList<ItemDetails> itemDetails = new ArrayList<>();

        itemDetails.add(details);

        transactionRequest.setItemDetails(itemDetails);

        CreditCard creditCard =  new CreditCard();
        creditCard.setSaveCard(false);
        creditCard.setAuthentication(Authentication.AUTH_RBA);

        transactionRequest.setCreditCard(creditCard);

        return transactionRequest;
    }
}

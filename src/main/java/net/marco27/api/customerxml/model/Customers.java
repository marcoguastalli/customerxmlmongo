package net.marco27.api.customerxml.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import net.marco27.api.customerxml.model.Customer;

@JacksonXmlRootElement
public class Customers{

    @JacksonXmlProperty(localName = "Customers")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<Customer> customers = new ArrayList<Customer>();

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }
}
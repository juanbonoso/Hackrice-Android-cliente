package com.example.xaulleon.credipool;

import java.io.Serializable;

/**
 *
 * @author Juan
 */
public class CardList implements Serializable{
    private String network;
    private String credit_card;
    private Double cupon;

    public CardList(String network, String credit_card, Double cupon) {
        this.network = network;
        this.credit_card = credit_card;
        this.cupon = cupon;
    }

    public String getNetwork() {
        return network;
    }

    public void setNetwork(String network) {
        this.network = network;
    }

    public String getCredit_card() {
        return credit_card;
    }

    public void setCredit_card(String credit_card) {
        this.credit_card = credit_card;
    }

    public Double getCupon() {
        return cupon;
    }

    public void setCupon(Double cupon) {
        this.cupon = cupon;
    }

    @Override
    public String toString() {
        return "CardList{" + "network=" + network + ", credit_card=" + credit_card + ", cupon=" + cupon + '}';
    }

}
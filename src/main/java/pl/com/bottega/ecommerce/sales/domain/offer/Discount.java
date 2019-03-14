package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;

public class Discount {
    private String discountCause;

    private Money amount;

    public Discount(String discountCause, Money amount) {
        this.discountCause = discountCause;
        this.amount = amount;
    }

    public String getDiscountCause() {
        return discountCause;
    }

    public Money getAmount() {
        return amount;
    }
}

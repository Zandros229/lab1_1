package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Discount)) {
            return false;
        }
        Discount discount = (Discount) o;
        return Objects.equals(getDiscountCause(), discount.getDiscountCause()) && Objects.equals(getAmount(), discount.getAmount());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDiscountCause(), getAmount());
    }
}

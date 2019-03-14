package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;
import java.util.Objects;

public class Money {
    private BigDecimal value;

    private String currency;

    public Money(BigDecimal value, String currency) {
        this.value = value;
        this.currency = currency;
    }

    public BigDecimal getValue() {
        return value;
    }

    public String getCurrency() {
        return currency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Money)) {
            return false;
        }
        Money money = (Money) o;
        return Objects.equals(getValue(), money.getValue()) && Objects.equals(getCurrency(), money.getCurrency());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValue(), getCurrency());
    }
}

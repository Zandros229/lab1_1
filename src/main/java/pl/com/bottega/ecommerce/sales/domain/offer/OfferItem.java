/*
 * Copyright 2011-2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

public class OfferItem {

    // product
    private Product product;

    private int quantity;

    private Money totalCost;

    // discount
    private Discount discount;

    public OfferItem(Product product, int quantity, Money totalCost, Discount discount) {

        this.product = product;
        this.quantity = quantity;
        this.discount = discount;

        BigDecimal discountValue = new BigDecimal(0);
        if (discount != null) {
            discountValue = discountValue.add(discount.getAmount().getValue());
        }

        this.totalCost = new Money(product.getPrice().getValue().multiply((new BigDecimal(quantity))).subtract(discountValue),
                totalCost.getCurrency());

    }

    public Money getTotalCost() {
        return totalCost;
    }

    public Discount getDiscount() {
        return discount;
    }

    public int getQuantity() {
        return quantity;
    }

    public Product getProduct() {
        return product;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof OfferItem)) {
            return false;
        }
        OfferItem offerItem = (OfferItem) o;
        return getQuantity() == offerItem.getQuantity() && Objects.equals(getProduct(), offerItem.getProduct()) && Objects.equals(
                getTotalCost(), offerItem.getTotalCost()) && Objects.equals(getDiscount(), offerItem.getDiscount());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getProduct(), getQuantity(), getTotalCost(), getDiscount());
    }

    /**
     * @param other other OfferItem
     * @param delta acceptable percentage difference
     * @return True if product offer are the same or False if product offer are different( price difference are to high)
     */

    public boolean sameAs(OfferItem other, double delta) {
        if (this.getProduct() == null) {
            if (other.getProduct() != null) {
                return false;
            }
        }

        if (!(product.sameAs(other.product))) {
            return false;
        }

        if (quantity != other.quantity) {
            return false;
        }

        BigDecimal max;
        BigDecimal min;
        if (totalCost.compareTo(other.totalCost) > 0) {
            max = totalCost.getValue();
            min = other.totalCost.getValue();
        } else {
            max = other.totalCost.getValue();
            min = totalCost.getValue();
        }

        BigDecimal difference = max.subtract(min);
        BigDecimal acceptableDelta = max.multiply(BigDecimal.valueOf(delta / 100));

        return acceptableDelta.compareTo(difference) > 0;
    }

}

package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

public class Product {

    private String productId;

    private String productName;

    private Date productSnapshotDate;

    private String productType;

    private Money price;

    public Product(String productId, String productName, Date productSnapshotDate, String productType,
            Money price) {
        this.productId = productId;
        this.productName = productName;
        this.productSnapshotDate = productSnapshotDate;
        this.productType = productType;
        this.price = price;
    }

    public String getProductId() {
        return productId;
    }
    
    public String getProductName() {
        return productName;
    }

    public Date getProductSnapshotDate() {
        return productSnapshotDate;
    }

    public String getProductType() {
        return productType;
    }

    public Money getPrice() {
        return price;
    }

    public boolean sameAs(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Product)) {
            return false;
        }
        Product product = (Product) o;
        return Objects.equals(getProductId(), product.getProductId())
               && Objects.equals(getProductName(), product.getProductName())
               && Objects.equals(getProductType(), product.getProductType())
               && Objects.equals(getPrice(), product.getPrice());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Product)) {
            return false;
        }
        Product product = (Product) o;
        return Objects.equals(getProductId(), product.getProductId())
               && Objects.equals(getProductName(), product.getProductName())
               && Objects.equals(getProductSnapshotDate(), product.getProductSnapshotDate())
               && Objects.equals(getProductType(), product.getProductType())
               && Objects.equals(getPrice(), product.getPrice());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getProductId(), getProductName(), getProductSnapshotDate(), getProductType(), getPrice());
    }
}

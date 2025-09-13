package co.com.pragma.dynamodb;

import co.com.pragma.dynamodb.constants.DynamoDBKeys;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;

import java.math.BigDecimal;

@DynamoDbBean
public class PaymentPlanEntity {

  private Integer month;
  private String principalForMonth;
  private BigDecimal principalForMonthNumber;
  private String interestToPay;
  private String capitalPayment;
  private String obligationBalance;

  public PaymentPlanEntity() {
  }

  private PaymentPlanEntity(Builder builder) {
    this.month = builder.month;
    this.principalForMonth = builder.principalForMonth;
    this.principalForMonthNumber = builder.principalForMonthNumber;
    this.interestToPay = builder.interestToPay;
    this.capitalPayment = builder.capitalPayment;
    this.obligationBalance = builder.obligationBalance;
  }

  public static Builder builder() {
    return new Builder();
  }

  @DynamoDbAttribute(DynamoDBKeys.PROFILE_MONTH)
  public Integer getMonth() {
    return month;
  }

  @DynamoDbAttribute(DynamoDBKeys.PROFILE_PRINCIPAL_FOR_MONTH)
  public String getPrincipalForMonth() {
    return principalForMonth;
  }

  @DynamoDbAttribute(DynamoDBKeys.PROFILE_PRINCIPAL_FOR_MONTH_NUMBER)
  public BigDecimal getPrincipalForMonthNumber() {
    return principalForMonthNumber;
  }

  @DynamoDbAttribute(DynamoDBKeys.PROFILE_INTEREST_TO_PAY)
  public String getInterestToPay() {
    return interestToPay;
  }

  @DynamoDbAttribute(DynamoDBKeys.PROFILE_CAPITAL_PAYMENT)
  public String getCapitalPayment() {
    return capitalPayment;
  }

  @DynamoDbAttribute(DynamoDBKeys.PROFILE_OBLIGATION_BALANCE)
  public String getObligationBalance() {
    return obligationBalance;
  }

  public void setMonth(Integer month) {
    this.month = month;
  }

  public void setPrincipalForMonth(String principalForMonth) {
    this.principalForMonth = principalForMonth;
  }

  public void setPrincipalForMonthNumber(BigDecimal principalForMonthNumber) {
    this.principalForMonthNumber = principalForMonthNumber;
  }

  public void setInterestToPay(String interestToPay) {
    this.interestToPay = interestToPay;
  }

  public void setCapitalPayment(String capitalPayment) {
    this.capitalPayment = capitalPayment;
  }

  public void setObligationBalance(String obligationBalance) {
    this.obligationBalance = obligationBalance;
  }

  public static class Builder {
    private Integer month;
    private String principalForMonth;
    private BigDecimal principalForMonthNumber;
    private String interestToPay;
    private String capitalPayment;
    private String obligationBalance;

    public Builder() {
    }

    public Builder month(Integer month) {
      this.month = month;
      return this;
    }

    public Builder principalForMonth(String principalForMonth) {
      this.principalForMonth = principalForMonth;
      return this;
    }

    public Builder principalForMonthNumber(BigDecimal principalForMonthNumber) {
      this.principalForMonthNumber = principalForMonthNumber;
      return this;
    }

    public Builder interestToPay(String interestToPay) {
      this.interestToPay = interestToPay;
      return this;
    }

    public Builder capitalPayment(String capitalPayment) {
      this.capitalPayment = capitalPayment;
      return this;
    }

    public Builder obligationBalance(String obligationBalance) {
      this.obligationBalance = obligationBalance;
      return this;
    }

    public PaymentPlanEntity build() {
      return new PaymentPlanEntity(this);
    }
  }

}
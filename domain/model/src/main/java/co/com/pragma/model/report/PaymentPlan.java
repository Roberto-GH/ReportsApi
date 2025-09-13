package co.com.pragma.model.report;

import java.math.BigDecimal;

public class PaymentPlan {

  private Integer month;
  private String principalForMonth;
  private BigDecimal principalForMonthNumber;
  private String interestToPay;
  private String capitalPayment;
  private String obligationBalance;

  private PaymentPlan(Builder builder) {
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

  public Integer getMonth() {
    return month;
  }

  public String getPrincipalForMonth() {
    return principalForMonth;
  }

  public BigDecimal getPrincipalForMonthNumber() {
    return principalForMonthNumber;
  }

  public String getInterestToPay() {
    return interestToPay;
  }

  public String getCapitalPayment() {
    return capitalPayment;
  }

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

    public PaymentPlan build() {
      return new PaymentPlan(this);
    }

  }

}

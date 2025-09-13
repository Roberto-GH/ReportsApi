package co.com.pragma.dynamodb;

import co.com.pragma.dynamodb.constants.DynamoDBKeys;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;

import java.util.List;

@DynamoDbBean
public class ApprovedLoanEntity {

  private String applicationLoanId;
  private String email;
  private String subject;
  private String message;
  private Integer status;
  private String amount;
  private List<PaymentPlanEntity> paymentPlan;

  public ApprovedLoanEntity() {
  }

  public ApprovedLoanEntity(String applicationLoanId) {
    this.applicationLoanId = applicationLoanId;
  }

  @DynamoDbPartitionKey
  @DynamoDbAttribute(DynamoDBKeys.PROFILE_APPLICATION_LOAN_ID)
  public String getApplicationLoanId() {
    return applicationLoanId;
  }

  public void setApplicationLoanId(String applicationLoanId) {
    this.applicationLoanId = applicationLoanId;
  }

  @DynamoDbAttribute(DynamoDBKeys.PROFILE_EMAIL)
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  @DynamoDbAttribute(DynamoDBKeys.PROFILE_SUBJECT)
  public String getSubject() {
    return subject;
  }

  public void setSubject(String subject) {
    this.subject = subject;
  }

  @DynamoDbAttribute(DynamoDBKeys.PROFILE_MESSAGE)
  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  @DynamoDbAttribute(DynamoDBKeys.PROFILE_STATUS)
  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  @DynamoDbAttribute(DynamoDBKeys.PROFILE_AMOUNT)
  public String getAmount() {
    return amount;
  }

  public void setAmount(String amount) {
    this.amount = amount;
  }

  @DynamoDbAttribute(DynamoDBKeys.PROFILE_PAYMENT_PLAN)
  public List<PaymentPlanEntity> getPaymentPlan() {
    return paymentPlan;
  }

  public void setPaymentPlan(List<PaymentPlanEntity> paymentPlan) {
    this.paymentPlan = paymentPlan;
  }

}

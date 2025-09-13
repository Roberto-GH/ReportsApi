package co.com.pragma.dynamodb;

import co.com.pragma.dynamodb.constants.DynamoDBKeys;
import co.com.pragma.dynamodb.helper.GenericAdapterOperations;
import co.com.pragma.model.report.ApprovedLoan;
import co.com.pragma.model.report.gateways.ApprovedLoanRepository;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedAsyncClient;
import software.amazon.awssdk.enhanced.dynamodb.Key;
import software.amazon.awssdk.enhanced.dynamodb.model.QueryConditional;
import software.amazon.awssdk.enhanced.dynamodb.model.QueryEnhancedRequest;

import java.util.List;

@Repository
public class DynamoDBApprovedLoanAdapter extends GenericAdapterOperations<ApprovedLoan, String, ApprovedLoanEntity>
  implements ApprovedLoanRepository {

  public DynamoDBApprovedLoanAdapter(DynamoDbEnhancedAsyncClient connectionFactory, ObjectMapper mapper) {
    super(connectionFactory, mapper, d -> mapper.map(d, ApprovedLoan.class), DynamoDBKeys.TABLE_NAME_LOANS_APPROVED);
  }

  public Mono<List<ApprovedLoan>> getEntityBySomeKeys(String partitionKey, String sortKey) {
    QueryEnhancedRequest queryExpression = generateQueryExpression(partitionKey, sortKey);
    return query(queryExpression);
  }

  public Mono<List<ApprovedLoan>> getEntityBySomeKeysByIndex(String partitionKey, String sortKey) {
    QueryEnhancedRequest queryExpression = generateQueryExpression(partitionKey, sortKey);
    return queryByIndex(queryExpression);
  }

  private QueryEnhancedRequest generateQueryExpression(String partitionKey, String sortKey) {
    return QueryEnhancedRequest
      .builder()
      .queryConditional(QueryConditional.keyEqualTo(Key.builder().partitionValue(partitionKey).build()))
      .queryConditional(QueryConditional.sortGreaterThanOrEqualTo(Key.builder().sortValue(sortKey).build()))
      .build();
  }

  @Override
  public Mono<Void> saveApprovedLoan(ApprovedLoan approvedLoan) {
    return super.save(approvedLoan).then();
  }

}

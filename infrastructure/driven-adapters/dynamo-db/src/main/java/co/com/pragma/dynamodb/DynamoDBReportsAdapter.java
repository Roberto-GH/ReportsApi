package co.com.pragma.dynamodb;

import co.com.pragma.dynamodb.constants.DynamoDBKeys;
import co.com.pragma.dynamodb.helper.GenericAdapterOperations;
import co.com.pragma.model.report.Report;
import co.com.pragma.model.report.gateways.ReportRepository;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedAsyncClient;
import software.amazon.awssdk.enhanced.dynamodb.Key;
import software.amazon.awssdk.enhanced.dynamodb.model.QueryConditional;
import software.amazon.awssdk.enhanced.dynamodb.model.QueryEnhancedRequest;

import java.util.List;

@Repository
public class DynamoDBReportsAdapter extends GenericAdapterOperations<Report, Long, ReportEntity>
  implements ReportRepository {

  public DynamoDBReportsAdapter(DynamoDbEnhancedAsyncClient connectionFactory, ObjectMapper mapper) {
    super(connectionFactory, mapper, d -> mapper.map(d, Report.class), DynamoDBKeys.TABLE_NAME_REPORT_SUMMARY);
  }

  public Mono<List<Report>> getEntityBySomeKeys(String partitionKey, String sortKey) {
    QueryEnhancedRequest queryExpression = generateQueryExpression(partitionKey, sortKey);
    return query(queryExpression);
  }

  public Mono<List<Report>> getEntityBySomeKeysByIndex(String partitionKey, String sortKey) {
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
  public Mono<Report> getReport() {
    return super.getById(DynamoDBKeys.REPORT_ID);
  }

}

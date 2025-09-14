package co.com.pragma.dynamodb.helper;

import co.com.pragma.dynamodb.DynamoDBApprovedLoanAdapter;
import co.com.pragma.dynamodb.ApprovedLoanEntity;
import co.com.pragma.model.report.ApprovedLoan;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.reactivecommons.utils.ObjectMapper;
import reactor.test.StepVerifier;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbAsyncTable;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedAsyncClient;
import software.amazon.awssdk.enhanced.dynamodb.Key;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;

import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import java.util.concurrent.CompletableFuture;

import reactor.core.publisher.Mono;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.ArgumentMatchers.any;

class GenericAdapterOperationsTest {

    @Mock
    private DynamoDbEnhancedAsyncClient dynamoDbEnhancedAsyncClient;

    @Mock
    private ObjectMapper mapper;

    @Mock
    private DynamoDbAsyncTable<ApprovedLoanEntity> customerTable;

    private ApprovedLoanEntity approvedLoanEntity;
    private ApprovedLoan approvedLoan;

    @Mock
    private DynamoDBApprovedLoanAdapter dynamoDBApprovedLoanAdapter;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        when(dynamoDbEnhancedAsyncClient.table("table_name", TableSchema.fromBean(ApprovedLoanEntity.class)))
                .thenReturn(customerTable);

        approvedLoanEntity = new ApprovedLoanEntity();
        approvedLoanEntity.setApplicationLoanId("id");
        approvedLoan = ApprovedLoan.builder().applicationLoanId("id").build();
        when(mapper.map(approvedLoanEntity, ApprovedLoan.class)).thenReturn(approvedLoan);
        when(mapper.map(approvedLoan, ApprovedLoanEntity.class)).thenReturn(approvedLoanEntity);
    }

    @Test
    void modelEntityPropertiesMustNotBeNull() {
        ApprovedLoanEntity approvedLoanEntityUnderTest = new ApprovedLoanEntity("id");

        assertNotNull(approvedLoanEntityUnderTest.getApplicationLoanId());
    }

    @Test
    void testSave() {
        when(dynamoDBApprovedLoanAdapter.save(approvedLoan)).thenReturn(Mono.just(approvedLoan));

        StepVerifier.create(dynamoDBApprovedLoanAdapter.save(approvedLoan))
                .expectNext(approvedLoan)
                .verifyComplete();

        verify(dynamoDBApprovedLoanAdapter).save(approvedLoan);
    }

    @Test
    void testGetById() {
        String id = "id";
        when(dynamoDBApprovedLoanAdapter.getById(id)).thenReturn(Mono.just(approvedLoan));

        StepVerifier.create(dynamoDBApprovedLoanAdapter.getById("id"))
                .expectNext(approvedLoan)
                .verifyComplete();

        verify(dynamoDBApprovedLoanAdapter).getById(id);
    }

    @Test
    void testDelete() {
        when(dynamoDBApprovedLoanAdapter.delete(approvedLoan)).thenReturn(Mono.just(approvedLoan));

        StepVerifier.create(dynamoDBApprovedLoanAdapter.delete(approvedLoan))
                .expectNext(approvedLoan)
                .verifyComplete();

        verify(dynamoDBApprovedLoanAdapter).delete(approvedLoan);
    }
}
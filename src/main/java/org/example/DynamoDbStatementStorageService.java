package org.example;

import java.util.Optional;
import org.opensearch.sql.spark.execution.statement.StatementModel;
import org.opensearch.sql.spark.execution.statement.StatementState;
import org.opensearch.sql.spark.execution.statement.StatementStorageService;

public class DynamoDbStatementStorageService implements StatementStorageService {
  @Override
  public StatementModel createStatement(StatementModel statementModel, String s) {
    return null;
  }

  @Override
  public StatementModel updateStatementState(StatementModel statementModel,
                                             StatementState statementState, String s) {
    return null;
  }

  @Override
  public Optional<StatementModel> getStatementModel(String s, String s1) {
    return Optional.empty();
  }
}

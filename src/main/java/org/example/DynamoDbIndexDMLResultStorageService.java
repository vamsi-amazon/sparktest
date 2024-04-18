package org.example;

import org.opensearch.sql.datasource.DataSourceService;
import org.opensearch.sql.spark.dispatcher.model.IndexDMLResult;
import org.opensearch.sql.spark.flint.IndexDMLResultStorageService;

public class DynamoDbIndexDMLResultStorageService implements IndexDMLResultStorageService {

  private final DataSourceService dataSourceService;

  public DynamoDbIndexDMLResultStorageService(DataSourceService dataSourceService) {
    this.dataSourceService = dataSourceService;
  }

  @Override
  public IndexDMLResult createIndexDMLResult(IndexDMLResult indexDMLResult, String s) {
    return null;
  }
}

package org.example;

import java.util.Optional;
import org.opensearch.sql.spark.asyncquery.AsyncQueryJobMetadataStorageService;
import org.opensearch.sql.spark.asyncquery.model.AsyncQueryJobMetadata;

public class DynamoDbAsyncQueryJobMetadataStorageService implements
    AsyncQueryJobMetadataStorageService {
  @Override
  public void storeJobMetadata(AsyncQueryJobMetadata asyncQueryJobMetadata) {

  }

  @Override
  public Optional<AsyncQueryJobMetadata> getJobMetadata(String s) {
    return Optional.empty();
  }
}

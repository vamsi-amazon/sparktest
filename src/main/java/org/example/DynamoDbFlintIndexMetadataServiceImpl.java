package org.example;

import java.util.Map;
import org.opensearch.sql.spark.dispatcher.model.FlintIndexOptions;
import org.opensearch.sql.spark.flint.FlintIndexMetadata;
import org.opensearch.sql.spark.flint.FlintIndexMetadataService;

public class DynamoDbFlintIndexMetadataServiceImpl implements FlintIndexMetadataService {
  @Override
  public Map<String, FlintIndexMetadata> getFlintIndexMetadata(String s) {
    return null;
  }

  @Override
  public void updateIndexToManualRefresh(String s, FlintIndexOptions flintIndexOptions) {

  }

  @Override
  public void deleteFlintIndex(String s) {

  }
}

package org.example;

import java.util.Optional;
import org.opensearch.sql.spark.flint.FlintIndexState;
import org.opensearch.sql.spark.flint.FlintIndexStateModel;
import org.opensearch.sql.spark.flint.FlintIndexStateModelService;

public class DynamoDbFlintIndexStateModelService implements FlintIndexStateModelService {
  @Override
  public FlintIndexStateModel updateFlintIndexState(FlintIndexStateModel flintIndexStateModel,
                                                    FlintIndexState flintIndexState, String s) {
    return null;
  }

  @Override
  public Optional<FlintIndexStateModel> getFlintIndexStateModel(String s, String s1) {
    return Optional.empty();
  }

  @Override
  public FlintIndexStateModel createFlintIndexStateModel(FlintIndexStateModel flintIndexStateModel,
                                                         String s) {
    return null;
  }

  @Override
  public boolean deleteFlintIndexStateModel(String s, String s1) {
    return false;
  }
}

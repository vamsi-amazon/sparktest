package org.example;

import org.opensearch.sql.spark.leasemanager.LeaseManager;
import org.opensearch.sql.spark.leasemanager.model.LeaseRequest;

public class DQSLeaseManager implements LeaseManager {
  @Override
  public void borrow(LeaseRequest leaseRequest) {
  }
}
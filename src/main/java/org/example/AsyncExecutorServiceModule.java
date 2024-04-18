/*
 * Copyright OpenSearch Contributors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.example;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import org.opensearch.sql.datasource.DataSourceService;
import org.opensearch.sql.spark.asyncquery.AsyncQueryExecutorService;
import org.opensearch.sql.spark.asyncquery.AsyncQueryExecutorServiceImpl;
import org.opensearch.sql.spark.asyncquery.AsyncQueryJobMetadataStorageService;
import org.opensearch.sql.spark.client.EMRServerlessClientFactory;
import org.opensearch.sql.spark.client.EMRServerlessClientFactoryImpl;
import org.opensearch.sql.spark.config.SparkExecutionEngineConfigSupplier;
import org.opensearch.sql.spark.dispatcher.SparkQueryDispatcher;
import org.opensearch.sql.spark.execution.session.SessionConfigSupplier;
import org.opensearch.sql.spark.execution.session.SessionManager;
import org.opensearch.sql.spark.execution.statement.StatementStorageService;
import org.opensearch.sql.spark.execution.statestore.SessionStorageService;
import org.opensearch.sql.spark.flint.FlintIndexMetadataService;
import org.opensearch.sql.spark.flint.FlintIndexStateModelService;
import org.opensearch.sql.spark.flint.IndexDMLResultStorageService;
import org.opensearch.sql.spark.leasemanager.LeaseManager;
import org.opensearch.sql.spark.response.JobExecutionResponseReader;
import org.opensearch.sql.spark.response.JobExecutionResponseReaderImpl;

public class AsyncExecutorServiceModule extends AbstractModule {

  @Override
  protected void configure() {}

  @Provides
  public AsyncQueryExecutorService asyncQueryExecutorService(
      AsyncQueryJobMetadataStorageService asyncQueryJobMetadataStorageService,
      SparkQueryDispatcher sparkQueryDispatcher,
      SparkExecutionEngineConfigSupplier sparkExecutionEngineConfigSupplier) {
    return new AsyncQueryExecutorServiceImpl(
        asyncQueryJobMetadataStorageService,
        sparkQueryDispatcher,
        sparkExecutionEngineConfigSupplier);
  }

  @Provides
  public AsyncQueryJobMetadataStorageService asyncQueryJobMetadataStorageService() {
    return new DynamoDbAsyncQueryJobMetadataStorageService();
  }

  @Provides
  public SparkQueryDispatcher sparkQueryDispatcher(
      EMRServerlessClientFactory emrServerlessClientFactory,
      DataSourceService dataSourceService,
      JobExecutionResponseReaderImpl jobExecutionResponseReaderImpl,
      FlintIndexMetadataService flintIndexMetadataService,
      SessionManager sessionManager,
      LeaseManager leaseManager,
      FlintIndexStateModelService flintIndexStateModelService,
      IndexDMLResultStorageService indexDMLResultStorageService) {
    return new SparkQueryDispatcher(
        emrServerlessClientFactory,
        dataSourceService,
        jobExecutionResponseReaderImpl,
        flintIndexMetadataService,
        sessionManager,
        leaseManager,
        flintIndexStateModelService,
        indexDMLResultStorageService);
  }

  @Provides
  public SessionManager sessionManager(
      StatementStorageService statementStorageService,
      SessionStorageService sessionStorageService,
      EMRServerlessClientFactory emrServerlessClientFactory,
      SessionConfigSupplier sessionConfigSupplier) {
    return new SessionManager(
        statementStorageService,
        sessionStorageService,
        emrServerlessClientFactory,
        sessionConfigSupplier);
  }

  @Provides
  public StatementStorageService statementStorageService() {
    return new DynamoDbStatementStorageService();
  }

  @Provides
  public SessionStorageService sessionStorageService() {
    return new DynamoDbSessionStorageService();
  }

  @Provides
  public FlintIndexStateModelService flintIndexStateModelService() {
    return new DynamoDbFlintIndexStateModelService();
  }

  @Provides
  public IndexDMLResultStorageService indexDMLResultStorageService(
      DataSourceService dataSourceService) {
    return new DynamoDbIndexDMLResultStorageService(dataSourceService);
  }

  @Provides
  public LeaseManager leaseManager() {
    return new DQSLeaseManager();
  }

  @Provides
  public EMRServerlessClientFactory createEMRServerlessClientFactory(
      SparkExecutionEngineConfigSupplier sparkExecutionEngineConfigSupplier) {
    return new EMRServerlessClientFactoryImpl(sparkExecutionEngineConfigSupplier);
  }

  @Provides
  public SparkExecutionEngineConfigSupplier sparkExecutionEngineConfigSupplier() {
    return new DQSSparkExecutionEngineConfigSupplier();
  }

  @Provides
  @Singleton
  public FlintIndexMetadataService flintIndexMetadataReader() {
   return new DynamoDbFlintIndexMetadataServiceImpl();
  }

  @Provides
  public JobExecutionResponseReader jobExecutionResponseReader() {
    return new DynamoDbJobExecutionResponseReaderImpl();
  }

  @Provides
  public SessionConfigSupplier sessionConfigSupplier() {
    return new SessionConfigSupplier() {
      @Override
      public Long getSessionInactivityTimeoutMillis() {
        return null;
      }
    };
  }
}

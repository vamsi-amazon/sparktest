package org.example;


import com.google.inject.Guice;
import com.google.inject.Injector;
import org.opensearch.sql.spark.asyncquery.AsyncQueryExecutorService;
import org.opensearch.sql.spark.rest.model.CreateAsyncQueryRequest;
import org.opensearch.sql.spark.rest.model.CreateAsyncQueryResponse;
import org.opensearch.sql.spark.rest.model.LangType;

public class Main {
  public static void main(String[] args) {
    AsyncExecutorServiceModule asyncExecutorServiceModule = new AsyncExecutorServiceModule();
    Injector injector = Guice.createInjector(asyncExecutorServiceModule);
    AsyncQueryExecutorService asyncQueryExecutorService =
        (AsyncQueryExecutorService) injector.getProvider(AsyncQueryExecutorService.class);


    //Create async query.
    CreateAsyncQueryRequest createAsyncQueryRequest = new CreateAsyncQueryRequest("select * from cwl.default.logs","cwl", LangType.SQL );
    CreateAsyncQueryResponse createAsyncQueryResponse = asyncQueryExecutorService.createAsyncQuery(createAsyncQueryRequest);

    //Get response using queryId
    asyncQueryExecutorService.getAsyncQueryResults(createAsyncQueryResponse.getQueryId());

    //Cancel response using queryId
    asyncQueryExecutorService.cancelQuery(createAsyncQueryResponse.getQueryId());
  }

}
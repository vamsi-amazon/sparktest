package org.example;

import java.util.Optional;
import org.opensearch.sql.spark.execution.session.SessionModel;
import org.opensearch.sql.spark.execution.session.SessionState;
import org.opensearch.sql.spark.execution.statestore.SessionStorageService;

public class DynamoDbSessionStorageService implements SessionStorageService {
  @Override
  public SessionModel createSession(SessionModel sessionModel, String s) {
    return null;
  }

  @Override
  public Optional<SessionModel> getSession(String s, String s1) {
    return Optional.empty();
  }

  @Override
  public SessionModel updateSessionState(SessionModel sessionModel, SessionState sessionState,
                                         String s) {
    return null;
  }
}

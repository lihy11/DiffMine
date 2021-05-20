###  infomation 
method del:
-org.slf4j.Logger.trace()
method add：
+org.slf4j.Logger.debug()
###  support count
project count : 12
commit count : 31
###  code
ProjectName: 43164-sentry-java
CommitID: 6449358386f073f19f96e466eb1437d19006e0da
CommitMsg: Rely on debug rather than trace for the logs

FilePath: raven/src/main/java/net/kencochrane/raven/DefaultRavenFactory.java**
```diff
         } catch (ClassNotFoundException e) {
-            logger.trace("It seems that the current environment doesn't provide access to servlets.");
+            logger.debug("It seems that the current environment doesn't provide access to servlets.");
```
ProjectName: 43164-sentry-java
CommitID: 6449358386f073f19f96e466eb1437d19006e0da
CommitMsg: Rely on debug rather than trace for the logs

FilePath: raven/src/main/java/net/kencochrane/raven/dsn/Dsn.java**
```diff
         } catch (ClassNotFoundException e) {
-            logger.trace("JNDI not available");
+            logger.debug("JNDI not available");
```
ProjectName: 43164-sentry-java
CommitID: 6449358386f073f19f96e466eb1437d19006e0da
CommitMsg: Rely on debug rather than trace for the logs

FilePath: raven/src/main/java/net/kencochrane/raven/dsn/JndiLookup.java**
```diff
         } catch (NoInitialContextException e) {
-            logger.trace("JNDI not configured for sentry (NoInitialContextEx)");
+            logger.debug("JNDI not configured for sentry (NoInitialContextEx)");
```
ProjectName: 43164-sentry-java
CommitID: 6449358386f073f19f96e466eb1437d19006e0da
CommitMsg: Rely on debug rather than trace for the logs

FilePath: raven/src/main/java/net/kencochrane/raven/dsn/JndiLookup.java**
```diff
         } catch (NamingException e) {
-            logger.trace("No /sentry/dsn in JNDI");
+            logger.debug("No /sentry/dsn in JNDI");
```
ProjectName: 38320-ps3mediaserver
CommitID: 9e386fb2824cecde50133483f7a5aa0fc5b91a2a
CommitMsg: Restored verbose error messages (issue 1258)


FilePath: ps3mediaserver/net/pms/io/OutputTextLogger.java**
```diff
 			while ((line = br.readLine()) != null) {
-				logger.trace(line);
+				logger.debug(line);
```
ProjectName: 21583-schemaspy
CommitID: 245142d9a4684cbad8a8096e13ed6e507495ba7f
CommitMsg: Fix SLF4J mappings, clean up one double log

FilePath: src/main/java/org/schemaspy/model/ForeignKeyConstraint.java**
```diff
         this.name = name; // implied constraints will have a null name and override getName()
-        LOGGER.trace("Adding foreign key constraint '{}' to {}", getName(), child.getFullName());
+        LOGGER.debug("Adding foreign key constraint '{}' to {}", getName(), child.getFullName());
```
ProjectName: 23045-UniversalMediaServer
CommitID: f0b6e458aa035719f12406a782d04b4b69604b60
CommitMsg: Change a dbg level

FilePath: src/main/java/net/pms/PMS.java**
```diff
 			long pid = getPID();
-			LOGGER.trace("PID: " + pid);
+			LOGGER.debug("PID: " + pid);
```
ProjectName: 23045-UniversalMediaServer
CommitID: 34787ef023eb69d388480116a231d8a730da8f78
CommitMsg: Provide more information in debug logs to better identify renderers, part 2

FilePath: src/main/java/net/pms/network/RequestHandlerV2.java**
```diff
 					if (userAgentString != null) {
-						LOGGER.trace("HTTP User-Agent: " + userAgentString);
+						LOGGER.debug("HTTP User-Agent: " + userAgentString);
```
ProjectName: 23045-UniversalMediaServer
CommitID: 91b1a8369ca74c8830f02d8108cc357f9f2a4e88
CommitMsg: Provide more information in debug logs to better identify renderers

FilePath: src/main/java/net/pms/network/RequestHandler.java**
```diff
 					if (userAgentString != null) {
-						LOGGER.trace("HTTP User-Agent: " + userAgentString);
+						LOGGER.debug("HTTP User-Agent: " + userAgentString);
```
ProjectName: 23204-ebean
CommitID: 5f8f735bbeb2b23c80a262f3377f3d36ddf88821
CommitMsg: #412 - SQL_LOGGER trace() to debug() issue - Unintelligible logging settings

FilePath: src/main/java/com/avaje/ebeaninternal/server/transaction/JdbcTransaction.java**
```diff
   public void logSql(String msg) {
-    TransactionManager.SQL_LOGGER.trace(Str.add(logPrefix, msg));
+    TransactionManager.SQL_LOGGER.debug(Str.add(logPrefix, msg));
```
ProjectName: 23204-ebean
CommitID: 31099f6ddab6931d905dbcd000a401f2fd2c7462
CommitMsg: #397 - Internal logger name change - Rename DefaultContainer logger to be com.avaje.ebean.internal.DefaultContainer ... so that the offline debugging messages come out without a extra logback name logger entry

FilePath: src/main/java/com/avaje/ebeaninternal/server/core/DefaultContainer.java**
```diff
     if (DbOffline.isSet()) {
-      logger.trace("... DbOffline using platform [{}]", DbOffline.getPlatform());
+      logger.debug("... DbOffline using platform [{}]", DbOffline.getPlatform());
```
ProjectName: 25470-gravitee-gateway
CommitID: 9778c3d83d5f7883a92eb4c9cb8f4b28afe8a5c6
CommitMsg: refactor: Providing better logs

FilePath: gravitee-gateway-core/src/main/java/io/gravitee/gateway/core/reactor/GraviteeReactor.java**
```diff
 
-        logger.trace("Found {} handlers to handle request {}", mapHandlers.size(), path);
+        logger.debug("Found {} handlers for path {}", mapHandlers.size(), path);
```
ProjectName: 25470-gravitee-gateway
CommitID: 9778c3d83d5f7883a92eb4c9cb8f4b28afe8a5c6
CommitMsg: refactor: Providing better logs

FilePath: gravitee-gateway-core/src/main/java/io/gravitee/gateway/core/reactor/GraviteeReactor.java**
```diff
             ContextHandler handler = mapHandlers.iterator().next();
-            logger.trace("Returning the first handler matching path {} : {}", path, handler);
+            logger.debug("Returning the first handler matching path {} : {}", path, handler);
```
ProjectName: 24467-lenskit
CommitID: 3a5a6adbf34dcb3d82a3a05f61f501ef787f12f8
CommitMsg: Add more logging to user-user

FilePath: lenskit-knn/src/main/java/org/grouplens/lenskit/knn/user/UserUserItemScorer.java**
```diff
         }
-        logger.trace("Predicting for user {} with {} events",
-                     user, history.size());
+        logger.debug("Predicting for {} items for user {} with {} events",
+                     scores.size(), user, history.size());
```
ProjectName: 24467-lenskit
CommitID: 3a5a6adbf34dcb3d82a3a05f61f501ef787f12f8
CommitMsg: Add more logging to user-user

FilePath: lenskit-knn/src/main/java/org/grouplens/lenskit/knn/user/SimpleNeighborhoodFinder.java**
```diff
 
-        logger.trace("Found {} candidate neighbors", users.size());
+        logger.debug("Found {} candidate neighbors", users.size());
```
ProjectName: 14854-docker-java
CommitID: 45311797c80d95f35567f8c3a2879055bdcd4896
CommitMsg: Added some shortcut methods in the API
FilePath: src/main/java/com/github/dockerjava/jaxrs/BuildImageCmdExec.java**
```diff
 		
-		LOGGER.trace("POST: {}", webResource);
+		LOGGER.debug("POST: {}", webResource);
```
ProjectName: 5607-atmosphere
CommitID: b3cd22628fd0bc32db4d3d78a41bac858830c44f
CommitMsg: proper log

FilePath: modules/cpr/src/main/java/org/atmosphere/cpr/AtmosphereRequest.java**
```diff
             // https://github.com/Atmosphere/atmosphere/issues/1804
-            logger.trace("Unexpected getContextPath exception. Forcing `/`", ex);
+            logger.debug("Unexpected getContextPath exception. Forcing `/`", ex);
```
ProjectName: 5607-atmosphere
CommitID: 1deca1deb378dfbc3b574453e566de9d19114acc
CommitMsg: Turn the log to debug

FilePath: modules/cpr/src/main/java/org/atmosphere/interceptor/OnDisconnectInterceptor.java**
```diff
         if (p != null && s != null && s.equalsIgnoreCase(HeaderConfig.DISCONNECT_TRANSPORT_MESSAGE)) {
-            logger.trace("AtmosphereResource {} disconnected", uuid);
+            logger.debug("AtmosphereResource {} disconnected", uuid);
```
ProjectName: 5607-atmosphere
CommitID: 459d407658c9a2cc74d34298ea3725d2ed603ef9
CommitMsg: Final fixes #1141

FilePath: modules/cpr/src/main/java/org/atmosphere/cache/UUIDBroadcasterCache.java**
```diff
     private void addMessage(String clientId, CacheMessage message) {
-        logger.trace("Adding message {} for client {}", clientId, message);
+        logger.debug("Adding message {} for client {}", clientId, message);
```
ProjectName: 5607-atmosphere
CommitID: 8bfa124176aacc89d8dbe9f7f22c35c05d421701
CommitMsg: Increase logging

FilePath: modules/cpr/src/main/java/org/atmosphere/cpr/AtmosphereResponse.java**
```diff
         }
-        logger.trace("", ex);
+        logger.debug("", ex);
```
ProjectName: 5607-atmosphere
CommitID: d50d7b612cfe5cbb79fb9c3cd6d5b6443244e969
CommitMsg: Fix regression when setting resumeOnbroadcast. Turn on logging on exception, switch logic for now

FilePath: modules/cpr/src/main/java/org/atmosphere/cpr/DefaultBroadcaster.java**
```diff
         removeAtmosphereResource(r);
-        logger.trace("Unexpected exception for AtmosphereResource {} and Broadcaster " + name, ar.uuid(), t);
+        logger.debug("Unexpected exception for AtmosphereResource {} and Broadcaster " + name, ar.uuid(), t);
```
ProjectName: 5607-atmosphere
CommitID: ef1fbef8ade4a862f1bf624a95aa6a3b09b87393
CommitMsg: Fix for #678

FilePath: modules/cpr/src/main/java/org/atmosphere/cpr/AsynchronousProcessor.java**
```diff
                 } catch (Throwable t) {
-                    logger.trace("cancel", t);
+                    logger.debug("cancel", t);
```
ProjectName: 5607-atmosphere
CommitID: 9183e6aa346db85280e75a592272c2187b3dc3d6
CommitMsg: Ensure that setID is called before the broadcast handler is executed.  Otherwise, there is a race condition where the broadcaster may not be initialized before the executor fires.

FilePath: modules/cpr/src/main/java/org/atmosphere/util/AbstractBroadcasterProxy.java**
```diff
                 } catch (Throwable t) {
-                    logger.trace("incomingBroadcast Exception. Broadcaster will be broken unless reconfigured", t);
+                    logger.debug("incomingBroadcast Exception. Broadcaster will be broken unless reconfigured", t);
```
ProjectName: 5607-atmosphere
CommitID: 3691be4c1f9974b445e682c6d290306700eab602
CommitMsg: More fix for the new pattern matching algorithm for AtmosphereHandler

FilePath: modules/cpr/src/main/java/org/atmosphere/cpr/AsynchronousProcessor.java**
```diff
                 UriTemplate t = new UriTemplate(e.getKey());
-                logger.trace("Trying to map {} to {}", t, path);
+                logger.debug("Trying to map {} to {}", t, path);
```
ProjectName: 5607-atmosphere
CommitID: d336b58b1cb3c8603b023be3f440ff5685c20c25
CommitMsg: Shield the Broadcaster from any concurrent re-use of an AtmosphereResource

FilePath: modules/cpr/src/main/java/org/atmosphere/cpr/AtmosphereResourceImpl.java**
```diff
             } catch (IllegalStateException ex) {
-                logger.trace(ex.getMessage(), ex);
+                logger.warn("Unable to resume", this);
+                logger.debug(ex.getMessage(), ex);
```
ProjectName: 1272-flink
CommitID: 8c933ca0beb218f764a071b489aa282833356021
CommitMsg: [hotfix][runtime] Log RPC failures on debug

FilePath: flink-runtime/src/main/java/org/apache/flink/runtime/rpc/akka/AkkaRpcActor.java**
```diff
 					catch (InvocationTargetException e) {
-						log.trace("Reporting back error thrown in remote procedure {}", rpcMethod, e);
+						log.debug("Reporting back error thrown in remote procedure {}", rpcMethod, e);
```
ProjectName: 1272-flink
CommitID: 82dec053aece27e4c658218dee0cbb1e83c936b5
CommitMsg: [FLINK-8860] Change slot-report message to DEBUG

FilePath: flink-runtime/src/main/java/org/apache/flink/runtime/resourcemanager/slotmanager/SlotManager.java**
```diff
 
-		LOG.trace("Received slot report from instance {}.", instanceId);
+		LOG.debug("Received slot report from instance {}.", instanceId);
```
ProjectName: 13536-activemq
CommitID: 2013c6a54f483f0206e6727bd1088616ba98daa2
CommitMsg: Update some logging for better coverage
FilePath: activemq-amqp/src/main/java/org/apache/activemq/transport/amqp/protocol/AmqpReceiver.java**
```diff
                             if (getEndpoint().getCredit() <= (getConfiguredReceiverCredit() * .2)) {
-                                LOG.trace("Sending more credit ({}) to producer: {}", getConfiguredReceiverCredit() - getEndpoint().getCredit(), getProducerId());
+                                LOG.debug("Sending more credit ({}) to producer: {}", getConfiguredReceiverCredit() - getEndpoint().getCredit(), getProducerId());
```
ProjectName: 13536-activemq
CommitID: 2013c6a54f483f0206e6727bd1088616ba98daa2
CommitMsg: Update some logging for better coverage
FilePath: activemq-amqp/src/main/java/org/apache/activemq/transport/amqp/protocol/AmqpReceiver.java**
```diff
                 if (getEndpoint().getCredit() <= (getConfiguredReceiverCredit() * .2)) {
-                    LOG.trace("Sending more credit ({}) to producer: {}", getConfiguredReceiverCredit() - getEndpoint().getCredit(), getProducerId());
+                    LOG.debug("Sending more credit ({}) to producer: {}", getConfiguredReceiverCredit() - getEndpoint().getCredit(), getProducerId());
```
ProjectName: 16050-optaplanner
CommitID: 31d91dd85f9fc05750be1b5700bae9386661af0c
CommitMsg: exam: initialized statements are logged in debug

FilePath: optaplanner-examples/src/main/java/org/optaplanner/examples/examination/solver/solution/initializer/ExaminationSolutionInitializer.java**
```diff
         }
-        logger.trace("    Exam ({}) initialized.", leader);
+        logger.debug("    Exam ({}) initialized.", leader);
```
ProjectName: 16050-optaplanner
CommitID: 31d91dd85f9fc05750be1b5700bae9386661af0c
CommitMsg: exam: initialized statements are logged in debug

FilePath: optaplanner-examples/src/main/java/org/optaplanner/examples/examination/solver/solution/initializer/ExaminationSolutionInitializer.java**
```diff
         }
-        logger.trace("    Exam ({}) initialized.", exam);
+        logger.debug("    Exam ({}) initialized.", exam);
```

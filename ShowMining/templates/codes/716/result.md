###  infomation 
method del:
-org.slf4j.Logger.isDebugEnabled()
method add：
+org.slf4j.Logger.isTraceEnabled()
###  support count
project count : 10
commit count : 11
###  code
ProjectName: 30753-phoenix
CommitID: 9e686b758ff735fd9129430cd31fe36993b9711b
CommitMsg: PHOENIX-2012 RowKeyComparisonFilter logs unencoded data at DEBUG level

FilePath: phoenix-core/src/main/java/org/apache/phoenix/filter/RowKeyComparisonFilter.java**
```diff
             this.keepRow = Boolean.TRUE.equals(evaluate(inputTuple));
-            if (logger.isDebugEnabled()) {
-                logger.debug("RowKeyComparisonFilter: " + (this.keepRow ? "KEEP" : "FILTER")  + " row " + inputTuple);
+            if (logger.isTraceEnabled()) {
+                logger.trace("RowKeyComparisonFilter: " + (this.keepRow ? "KEEP" : "FILTER")
+                        + " row " + inputTuple);
```
ProjectName: 23204-ebean
CommitID: a86af94a8caf66ece25d55ce823648484d360308
CommitMsg: Reduce logging level only - no functional change

FilePath: src/main/java/io/ebeaninternal/server/type/DefaultTypeManager.java**
```diff
   private void logAdd(ScalarType<?> scalarType) {
-    if (logger.isDebugEnabled()) {
+    if (logger.isTraceEnabled()) {
```
ProjectName: 29689-mina
CommitID: e2e0ac8ffeb00849cc229571bec905b378e32ff9
CommitMsg: log level tweaking

FilePath: core/src/main/java/org/apache/mina/service/idlechecker/IndexedIdleChecker.java**
```diff
 
-        if (LOG.isDebugEnabled()) {
-            LOG.debug("checking idle time, last = {}, now = {}, delta = {}", new Object[] { lastCheckTimeMs, timeMs,
+        if (LOG.isTraceEnabled()) {
+            LOG.trace("checking idle time, last = {}, now = {}, delta = {}", new Object[] { lastCheckTimeMs, timeMs,
```
ProjectName: 11181-Chronicle-Queue
CommitID: db10f5ad73fa4c88b0cf3bbc23441b3dab23348f
CommitMsg: Have PricerV2 running locally with EURUSD

FilePath: src/main/java/net/openhft/chronicle/queue/impl/single/SingleChronicleQueueExcerpts.java**
```diff
             final long sequenceNumber = queue.rollCycle().toSequenceNumber(index);
-            if (LOG.isDebugEnabled()) {
+            if (LOG.isTraceEnabled()) {
```
ProjectName: 2306-metrics
CommitID: 91c5e89673cf302df63f5f13f0fa7b32bb45e1fe
CommitMsg: Merge pull request #95 from dinomite/development

Make emitting metrics in GangliaReporter messages trace
FilePath: metrics-ganglia/src/main/java/com/yammer/metrics/reporting/GangliaReporter.java**
```diff
             sendMetricData(metricType, metricName, metricValue, groupName, units);
-            if (LOG.isDebugEnabled()) {
-                LOG.debug("Emitting metric " + metricName + ", type " + metricType + ", value " + metricValue + " for gangliaHost: " + gangliaHost + ":" + port);
+            if (LOG.isTraceEnabled()) {
+                LOG.trace("Emitting metric " + metricName + ", type " + metricType + ", value " + metricValue + " for gangliaHost: " + gangliaHost + ":" + port);
```
ProjectName: 2306-metrics
CommitID: bc677bb43c249e76f7928119eacfa1ed262f6926
CommitMsg: Make emitting metrics messages trace

FilePath: metrics-ganglia/src/main/java/com/yammer/metrics/reporting/GangliaReporter.java**
```diff
             sendMetricData(metricType, metricName, metricValue, groupName, units);
-            if (LOG.isDebugEnabled()) {
-                LOG.debug("Emitting metric " + metricName + ", type " + metricType + ", value " + metricValue + " for gangliaHost: " + gangliaHost + ":" + port);
+            if (LOG.isTraceEnabled()) {
+                LOG.trace("Emitting metric " + metricName + ", type " + metricType + ", value " + metricValue + " for gangliaHost: " + gangliaHost + ":" + port);
```
ProjectName: 2688-swagger-core
CommitID: cd32cf59221d822f753963921a1b20bc38f26225
CommitMsg: fix generic model

FilePath: modules/swagger-core/src/main/java/io/swagger/converter/ModelConverterContextImpl.java**
```diff
     public void defineModel(String name, Schema model, Type type, String prevName) {
-        if (LOGGER.isDebugEnabled()) {
-            LOGGER.debug(String.format("defineModel %s %s", name, model));
+        if (LOGGER.isTraceEnabled()) {
+            LOGGER.trace(String.format("defineModel %s %s", name, model));
```
ProjectName: 1272-flink
CommitID: 92133b76cb3de55a98a0e14e3a57188f102985c3
CommitMsg: [FLINK-8800][REST] Reduce logging of all requests to TRACE

This closes #5594.

FilePath: flink-runtime/src/main/java/org/apache/flink/runtime/rest/AbstractHandler.java**
```diff
 	protected void respondAsLeader(ChannelHandlerContext ctx, Routed routed, T gateway) throws Exception {
-		if (log.isDebugEnabled()) {
-			log.debug("Received request " + routed.request().getUri() + '.');
+		if (log.isTraceEnabled()) {
+			log.trace("Received request " + routed.request().getUri() + '.');
```
ProjectName: 8573-drools
CommitID: e2ecfb8b3f7249dcf691218f7fb281cc7f61f939
CommitMsg: [DROOLS-1262] log state machine transitions at trace level (#884)


FilePath: drools-core/src/main/java/org/drools/core/common/DefaultAgenda.java**
```diff
         }
-        if ( log.isDebugEnabled() ) {
-            log.debug("State was {} is now {}", currentState, state);
+        if ( log.isTraceEnabled() ) {
+            log.trace("State was {} is now {}", currentState, state);
```
ProjectName: 7427-hive
CommitID: e0c27c63e75c838dd5dd842d658b7f883129b9a0
CommitMsg: HIVE-16109 : TestDbTxnManager generates a huge hive.log (Vihang Karajgaonkar via Sergey Shelukhin)

Signed-off-by: Ashutosh Chauhan <hashutosh@apache.org>

FilePath: metastore/src/java/org/apache/hadoop/hive/metastore/txn/TxnHandler.java**
```diff
       LockInfo[] locks = lockSet.toArray(new LockInfo[lockSet.size()]);
-      if(LOG.isDebugEnabled()) {
-        LOG.debug("Locks to check(full): ");
+      if(LOG.isTraceEnabled()) {
+        LOG.trace("Locks to check(full): ");
```
ProjectName: 967-mybatis-3
CommitID: e553d1aff88d84e9884c1653fb788e97e34e5833
CommitMsg: another typo

FilePath: src/main/java/org/apache/ibatis/logging/slf4j/Slf4jLoggerImpl.java**
```diff
   public boolean isTraceEnabled() {
-    return log.isDebugEnabled();
+    return log.isTraceEnabled();
```

###  infomation 
method del:
-org.apache.log4j.Logger.info()
method add：
+org.apache.log4j.Logger.debug()
###  support count
project count : 10
commit count : 18
###  code
ProjectName: 41143-sitewhere
CommitID: bbe97c066dbaf4da9a8a261dfb010f30e2a5d5d2
CommitMsg: Swap log level down to debug for recurring task.
FilePath: sitewhere-core/src/main/java/com/sitewhere/device/presence/DevicePresenceManager.java**
```diff
 							devices.getDeviceAssignmentsWithLastInteraction(site.getToken(), criteria);
-					LOGGER.info("Presence manager for '" + site.getName() + "' creating "
+					LOGGER.debug("Presence manager for '" + site.getName() + "' creating "
```
ProjectName: 38527-giraph
CommitID: 8205f0d26abda68a740de8c962a32172d2bc7e8b
CommitMsg: Out-of-core is logging too aggressively

Summary:
Example aggressive logging at INFO level:

INFO    <datestamp> [ooc-io-0] org.apache.giraph.ooc.policy.ThresholdBasedOracle  - getNextIOActions: usedMemoryFraction = 0.79
INFO    <datestamp> [ooc-io-0] org.apache.giraph.ooc.OutOfCoreIOCallable  - call: thread 0's next IO command is: LoadPartitionIOCommand: (partitionId = 4676, superstep = 0)
INFO    <datestamp> [ooc-io-0] org.apache.giraph.ooc.OutOfCoreIOCallable  - call: thread 0's command LoadPartitionIOCommand: (partitionId = 4676, superstep = 0) completed: bytes= 0, duration=0, bandwidth=NaN, bandwidth (excluding GC time)=NaN

Test Plan: mvn clean verify -P hadoop_facebook

Reviewers: majakabiljo, maja.kabiljo, sergey.edunov, heslami

Reviewed By: heslami

Subscribers: dionysis.logothetis

Differential Revision: https://reviews.facebook.net/D62853

FilePath: giraph-core/src/main/java/org/apache/giraph/ooc/policy/ThresholdBasedOracle.java**
```diff
     double usedMemoryFraction = 1 - MemoryUtils.freeMemoryFraction();
-    if (LOG.isInfoEnabled()) {
-      LOG.info(String.format("getNextIOActions: usedMemoryFraction = %.2f",
+    if (LOG.isDebugEnabled()) {
+      LOG.debug(String.format("getNextIOActions: usedMemoryFraction = %.2f",
```
ProjectName: 38527-giraph
CommitID: 8733950c1e0e0a8474219d60472f115375278e35
CommitMsg: GIRAPH-145: Change partition request log level to debug rather than info.


git-svn-id: https://svn.apache.org/repos/asf/incubator/giraph/trunk@1242541 13f79535-47bb-0310-9956-ffa450edef68

FilePath: src/main/java/org/apache/giraph/comm/BasicRPCCommunications.java**
```diff
 
-        if (LOG.isInfoEnabled()) {
-            LOG.info("sendPartitionReq: Sending to " + rpcProxy.getName() +
+        if (LOG.isDebugEnabled()) {
+            LOG.debug("sendPartitionReq: Sending to " + rpcProxy.getName() +
```
ProjectName: 23659-Kundera
CommitID: 91651bb173d27391c799e9e72a6c75c920e1e0c7
CommitMsg: log code changes
FilePath: kundera-core/src/main/java/com/impetus/kundera/loader/GenericClientFactory.java**
```diff
         {
-            logger.info("Returning fresh client instance for persistence unit : " + persistenceUnit);
+            logger.debug("Returning fresh client instance for persistence unit : " + persistenceUnit);
```
ProjectName: 22996-parquet-mr
CommitID: 3b8ad08b3c0b40221096f5db00e2b1524dbf9315
CommitMsg: cleanup logs

FilePath: redelm-pig/src/main/java/redelm/pig/RedelmFileReader.java**
```diff
     long footerIndexIndex = l - 8 - 8;
-    LOG.info("reading footer index at " + footerIndexIndex);
+    LOG.debug("reading footer index at " + footerIndexIndex);
```
ProjectName: 22996-parquet-mr
CommitID: 3b8ad08b3c0b40221096f5db00e2b1524dbf9315
CommitMsg: cleanup logs

FilePath: redelm-pig/src/main/java/redelm/pig/RedelmFileReader.java**
```diff
     }
-    LOG.info("read footer index: " + footerIndex + ", footer size: " + (footerIndexIndex - footerIndex));
+    LOG.debug("read footer index: " + footerIndex + ", footer size: " + (footerIndexIndex - footerIndex));
```
ProjectName: 22996-parquet-mr
CommitID: 3b8ad08b3c0b40221096f5db00e2b1524dbf9315
CommitMsg: cleanup logs

FilePath: redelm-pig/src/main/java/redelm/pig/RedelmInputFormat.java**
```diff
     List<FileStatus> statuses = super.listStatus(jobContext);
-    LOG.info("reading " + statuses.size() + " files");
+    LOG.debug("reading " + statuses.size() + " files");
```
ProjectName: 22996-parquet-mr
CommitID: 3b8ad08b3c0b40221096f5db00e2b1524dbf9315
CommitMsg: cleanup logs

FilePath: redelm-pig/src/main/java/redelm/pig/RedelmInputFormat.java**
```diff
     for (FileStatus fileStatus : statuses) {
-      LOG.info(fileStatus.getPath());
+      LOG.debug(fileStatus.getPath());
```
ProjectName: 26808-zhihu-crawler
CommitID: 4f11569eb23eed0687e7ce3e9a8acb6562a1e5f3
CommitMsg: update log config

FilePath: src/main/java/com/crawl/core/util/SimpleInvocationHandler.java**
```diff
 //        logger.debug("++++++after " + method.getName() + "++++++");
-        logger.info(target.getClass().getSimpleName() + " " + method.getName() + " cost time:" + (endTime - startTime) + "ms");
+        logger.debug(target.getClass().getSimpleName() + " " + method.getName() + " cost time:" + (endTime - startTime) + "ms");
```
ProjectName: 26808-zhihu-crawler
CommitID: 4f11569eb23eed0687e7ce3e9a8acb6562a1e5f3
CommitMsg: update log config

FilePath: src/main/java/com/crawl/core/util/ThreadPoolMonitor.java**
```diff
         while(!isStopMonitor){
-            logger.info(name +
+            logger.debug(name +
```
ProjectName: 26200-mondrian
CommitID: 51853ff46c857708e401209c75f4dd00dccf130d
CommitMsg: MONDRIAN: Make column name matches case insensitive. INFO to DEBUG logging level changes

[git-p4: depot-paths = "//open/mondrian/": change = 3580]

FilePath: src/main/mondrian/rolap/aggmatcher/ExplicitRules.java**
```diff
 
-            if (LOGGER.isInfoEnabled()) {
-                LOGGER.info("\n"+group);
+            if (LOGGER.isDebugEnabled()) {
+                LOGGER.debug("\n"+group);
```
ProjectName: 28480-accumulo
CommitID: 87194852ff2703dbf206e95b527c4714a61e0a4b
CommitMsg: ACCUMULO-3449 Move the log level to debug

FilePath: server/tracer/src/main/java/org/apache/accumulo/tracer/ZooTraceClient.java**
```diff
           updateHostsFromZooKeeper();
-          log.info("Successfully initialized tracer hosts from ZooKeeper");
+          log.debug("Successfully initialized tracer hosts from ZooKeeper");
```
ProjectName: 28480-accumulo
CommitID: a0e024451bdaea6f22706f3a38944778a94e539b
CommitMsg: ACCUMULO-1451 fix endless false major compaction

FilePath: core/src/main/java/org/apache/accumulo/core/conf/Property.java**
```diff
       instance = clazz.newInstance();
-      log.info("Loaded class : " + clazzName);
+      log.debug("Loaded class : " + clazzName, new Throwable());
```
ProjectName: 19415-hawtio
CommitID: 6c4d461ca9826a95537b30c68dc2ca79ff5d222c
CommitMsg: Tone down the logging

FilePath: hawtio-osgi-devmode/src/main/java/io/hawt/web/dev/DevServlet.java**
```diff
 
-        LOG.info("Serving file: " + file.getAbsolutePath() + " of type " + type);
+        LOG.debug("Serving file: " + file.getAbsolutePath() + " of type " + type);
```
ProjectName: 2253-zookeeper
CommitID: c6acf2c2e3504b057195e434791dc5a60a80f5fe
CommitMsg: ZOOKEEPER-199. fix log messages in persistence code

git-svn-id: https://svn.apache.org/repos/asf/hadoop/zookeeper/trunk@706512 13f79535-47bb-0310-9956-ffa450edef68

FilePath: src/java/main/org/apache/zookeeper/server/persistence/FileTxnLog.java**
```diff
             } catch (EOFException e) {
-                LOG.info("EOF excepton " + e);
+                LOG.debug("EOF excepton " + e);
```
ProjectName: 2763-storm
CommitID: 8e1e3cc1ced2e785c2ce47fd8708dcf2c5a2e8ec
CommitMsg: RollingCountBolt: use log level DEBUG to tell that a tick tuple was received

FilePath: src/jvm/storm/starter/bolt/RollingCountBolt.java**
```diff
         if (TupleHelpers.isTickTuple(tuple)) {
-            LOG.info("Received tick tuple, triggering emit of current window counts");
+            LOG.debug("Received tick tuple, triggering emit of current window counts");
```
ProjectName: 2763-storm
CommitID: 2ace708d42984057f1f29ac3a300ac296b4b7edb
CommitMsg: AbstractRankerBolt: use log level DEBUG instead INFO so that the bolt is more silent on the logging side

FilePath: src/jvm/storm/starter/bolt/AbstractRankerBolt.java**
```diff
         if (TupleHelpers.isTickTuple(tuple)) {
-            getLogger().info("Received tick tuple, triggering emit of current rankings");
+            getLogger().debug("Received tick tuple, triggering emit of current rankings");
```
ProjectName: 2763-storm
CommitID: 2ace708d42984057f1f29ac3a300ac296b4b7edb
CommitMsg: AbstractRankerBolt: use log level DEBUG instead INFO so that the bolt is more silent on the logging side

FilePath: src/jvm/storm/starter/bolt/AbstractRankerBolt.java**
```diff
         collector.emit(new Values(rankings));
-        getLogger().info("Rankings: " + rankings);
+        getLogger().debug("Rankings: " + rankings);
```

###  infomation 
method del:
-org.apache.commons.logging.Log.debug()
method add：
+org.apache.commons.logging.Log.info()
###  support count
project count : 6
commit count : 15
###  code
ProjectName: 33465-sqoop
CommitID: f4d5ed5375a7c4f94646ae0faa815b63ad641343
CommitMsg: SQOOP-907: Print out queries executed by Sqoop on mapreduce job side

(Jarcec Cecho via Cheolsoo Park)

FilePath: src/java/org/apache/sqoop/mapreduce/db/DBRecordReader.java**
```diff
 
-    LOG.debug("Executing query: " + query);
+    LOG.info("Executing query: " + query);
```
ProjectName: 15151-jabref
CommitID: 1d5e7ee90a0b6eb5c216abd627c1bc423c05ea41
CommitMsg: Try to debug failing CI test

FilePath: src/main/java/net/sf/jabref/logic/io/MimeTypeDetector.java**
```diff
         } catch (UnirestException e) {
-            LOGGER.debug("Error getting MIME type of URL", e);
+            LOGGER.info("Error getting MIME type of URL", e);
```
ProjectName: 1272-flink
CommitID: 77b7dccd3a30719a8d0bac82fa0ae49f2e9ac889
CommitMsg: [streaming] Logger updated, only streaming is logged

FilePath: flink-addons/flink-streaming/src/main/java/eu/stratosphere/streaming/api/streamcomponent/StreamInvokableComponent.java**
```diff
 				output.emit(record);
-				log.debug("EMITTED: " + record.getId() + " -- " + name);
+				log.info("EMITTED: " + record.getId() + " -- " + name);
```
ProjectName: 6424-hbase
CommitID: 2ce31f8945635259b4e53ac9a1d381b4df57a0fe
CommitMsg: HBASE-15220 Change two logs in SimpleRegionNormalizer to INFO level

FilePath: hbase-server/src/main/java/org/apache/hadoop/hbase/master/normalizer/SimpleRegionNormalizer.java**
```diff
       if (regionSize > 2 * avgRegionSize) {
-        LOG.debug("Table " + table + ", large region " + hri.getRegionNameAsString() + " has size "
+        LOG.info("Table " + table + ", large region " + hri.getRegionNameAsString() + " has size "
```
ProjectName: 6424-hbase
CommitID: 2ce31f8945635259b4e53ac9a1d381b4df57a0fe
CommitMsg: HBASE-15220 Change two logs in SimpleRegionNormalizer to INFO level

FilePath: hbase-server/src/main/java/org/apache/hadoop/hbase/master/normalizer/SimpleRegionNormalizer.java**
```diff
         if (regionSize + regionSize2 < avgRegionSize) {
-          LOG.debug("Table " + table + ", small region size: " + regionSize
+          LOG.info("Table " + table + ", small region size: " + regionSize
```
ProjectName: 6424-hbase
CommitID: 96f84594eee58b4e9a9347541baa3343a4ed3b97
CommitMsg: HBASE-11915 Document and test 0.94 -> 1.0.0 update -- ADDENDUM

FilePath: hbase-server/src/main/java/org/apache/hadoop/hbase/util/FSUtils.java**
```diff
         }
-        LOG.debug("Created version file at " + rootdir.toString() + " with version=" + version);
+        LOG.info("Created version file at " + rootdir.toString() + " with version=" + version);
```
ProjectName: 6424-hbase
CommitID: 6657449eb48f21d8f7501763aa6113f6a6ba3305
CommitMsg: HBASE-3890 Scheduled tasks in distributed log splitting not in sync with ZK

git-svn-id: https://svn.apache.org/repos/asf/hbase/trunk@1441321 13f79535-47bb-0310-9956-ffa450edef68

FilePath: hbase-server/src/main/java/org/apache/hadoop/hbase/master/SplitLogManager.java**
```diff
         } else {
-        LOG.debug(path +
+          LOG.info(path +
```
ProjectName: 6424-hbase
CommitID: 2ec4c4b939a90fa839cf54966cf9611e6871aa53
CommitMsg: HBASE-6285 HBase master should log INFO message when it attempts to assign a region

git-svn-id: https://svn.apache.org/repos/asf/hbase/trunk@1356247 13f79535-47bb-0310-9956-ffa450edef68

FilePath: hbase-server/src/main/java/org/apache/hadoop/hbase/master/AssignmentManager.java**
```diff
       try {
-        LOG.debug("Assigning region " + state.getRegion().getRegionNameAsString() +
+        LOG.info("Assigning region " + state.getRegion().getRegionNameAsString() +
```
ProjectName: 6424-hbase
CommitID: e896f6d400c7ad946141adbf7317df7c680fcdc6
CommitMsg: Upgrade nextKeyValue() error message from debug to info to highlight MR generation failures

git-svn-id: https://svn.apache.org/repos/asf/hbase/trunk@1199605 13f79535-47bb-0310-9956-ffa450edef68

FilePath: src/main/java/org/apache/hadoop/hbase/mapreduce/TableRecordReaderImpl.java**
```diff
     } catch (IOException e) {
-      LOG.debug("recovered from " + StringUtils.stringifyException(e));
+      LOG.info("recovered from " + StringUtils.stringifyException(e));
```
ProjectName: 6424-hbase
CommitID: 2937265741afe1fea533b86b6706915905256e7a
CommitMsg: HBASE-3202 Closing a region, if we get a ConnectException, handle it rather than abort

git-svn-id: https://svn.apache.org/repos/asf/hbase/trunk@1031846 13f79535-47bb-0310-9956-ffa450edef68

FilePath: src/main/java/org/apache/hadoop/hbase/master/AssignmentManager.java**
```diff
       // Failed to close, so pass through and reassign
-      LOG.debug("Server " + server + " returned NotServingRegionException");
+      LOG.info("Server " + server + " returned NotServingRegionException");
+    } catch (ConnectException e) {
+      // Failed to connect, so pass through and reassign
+      LOG.info("Server " + server + " returned ConnectException " +
+        e.getMessage());
```
ProjectName: 6424-hbase
CommitID: 44eab92141c9e984da26bbad393a5ae03f149a7f
CommitMsg: HBASE-3200 Make is so can disable DEBUG logging on HConnectionImplemenation without losing important messages

git-svn-id: https://svn.apache.org/repos/asf/hbase/trunk@1031767 13f79535-47bb-0310-9956-ffa450edef68

FilePath: src/main/java/org/apache/hadoop/hbase/client/HConnectionManager.java**
```diff
             tableLocations.remove(rl.getRegionInfo().getStartKey());
-            if (LOG.isDebugEnabled()) {
-              LOG.debug("Removed " +
+            if (LOG.isInfoEnabled()) {
+              LOG.info("Removed " +
```
ProjectName: 6424-hbase
CommitID: 44eab92141c9e984da26bbad393a5ae03f149a7f
CommitMsg: HBASE-3200 Make is so can disable DEBUG logging on HConnectionImplemenation without losing important messages

git-svn-id: https://svn.apache.org/repos/asf/hbase/trunk@1031767 13f79535-47bb-0310-9956-ffa450edef68

FilePath: src/main/java/org/apache/hadoop/hbase/client/HConnectionManager.java**
```diff
       if (this.zooKeeper != null) {
-        LOG.debug("Closed zookeeper sessionid=0x" +
+        LOG.info("Closed zookeeper sessionid=0x" +
```
ProjectName: 7427-hive
CommitID: 50e41ea2fed7120ee48299fe42d80d03ca19c28a
CommitMsg: HIVE-5241: Default log4j log level for WebHCat should be INFO not DEBUG (Eugene Koifman via Thejas Nair)

git-svn-id: https://svn.apache.org/repos/asf/hive/trunk@1523130 13f79535-47bb-0310-9956-ffa450edef68

FilePath: hcatalog/webhcat/svr/src/main/java/org/apache/hive/hcatalog/templeton/AppConfig.java**
```diff
         addResource(new Path(f.getAbsolutePath()));
-        LOG.debug("loaded config file " + f.getAbsolutePath());
+        LOG.info("loaded config file " + f.getAbsolutePath());
```
ProjectName: 13536-activemq
CommitID: 7629eafd0a54f163b8092f43d2d83f9cd6ee3907
CommitMsg: resolve https://issues.apache.org/activemq/browse/AMQ-2119 - have transport errors log at info level rather than debug

git-svn-id: https://svn.apache.org/repos/asf/activemq/trunk@983584 13f79535-47bb-0310-9956-ffa450edef68

FilePath: activemq-core/src/main/java/org/apache/activemq/broker/TransportConnection.java**
```diff
             transportException.set(e);
-            if (TRANSPORTLOG.isDebugEnabled()) {
-                TRANSPORTLOG.debug("Transport failed: " + e, e);
+            if (TRANSPORTLOG.isInfoEnabled()) {
+                TRANSPORTLOG.info("Transport failed: " + e, e);
```
ProjectName: 13536-activemq
CommitID: 6e714a2fe5bc5727ef55ce18c33d99128e73f8a5
CommitMsg: use INFO level logging when we loose a connection to a broker to highlight to users bad networking issues such as dropped sockets or bad firewalls etc. This change fixes AMQ-829

git-svn-id: https://svn.apache.org/repos/asf/incubator/activemq/trunk@434064 13f79535-47bb-0310-9956-ffa450edef68

FilePath: activemq-core/src/main/java/org/apache/activemq/transport/failover/FailoverTransport.java**
```diff
         synchronized (reconnectMutex) {
-            log.debug("Transport failed, starting up reconnect task", e);
+            log.info("Transport failed, attempting to automatically reconnect due to: " + e, e);
```

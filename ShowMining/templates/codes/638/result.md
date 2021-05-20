###  infomation 
method del:
-org.apache.commons.logging.Log.debug()
method add：
+org.apache.commons.logging.Log.trace()
###  support count
project count : 7
commit count : 12
###  code
ProjectName: 30753-phoenix
CommitID: 27722998c35cbc14f8a6c1c1be1c0cc6b0f7769a
CommitMsg: PHOENIX-3275 Reduce logging level of mutable secondary index logging

FilePath: phoenix-core/src/main/java/org/apache/phoenix/hbase/index/covered/NonTxIndexBuilder.java**
```diff
 
-        if (LOG.isDebugEnabled()) {
-            LOG.debug("Found index updates for Mutation: " + mutation + "\n" + manager);
+        if (LOG.isTraceEnabled()) {
+            LOG.trace("Found index updates for Mutation: " + mutation + "\n" + manager);
```
ProjectName: 28453-cuba
CommitID: 1ea543ee42794166a9712cdcb7859d62068f597c
CommitMsg: Some minor changes

FilePath: modules/core/src/com/haulmont/cuba/core/sys/ServiceInterceptor.java**
```diff
 
-        log.debug("Invoking method " + ctx.getMethod().getName() +
+        log.trace("Invoking method " + ctx.getMethod().getName() +
```
ProjectName: 18816-spring-cloud-sleuth
CommitID: e9cfe6d2ab8e29a3f04c6e1688370ae78ade8a7d
CommitMsg: Lowered logging level for RxJava hook - in debug mode it's present every second

FilePath: spring-cloud-sleuth-core/src/main/java/org/springframework/cloud/sleuth/instrument/rxjava/SleuthRxJavaSchedulersHook.java**
```diff
 				if (threadName.matches(threadToIgnore)) {
-					log.debug(String.format(
+					log.trace(String.format(
```
ProjectName: 7829-shiro
CommitID: f09c41e73cb78a9ef14e912675e7483f827f8f27
CommitMsg: updated logging, ensured SessionInterceptor 'touched' sessions for each web request


git-svn-id: https://svn.apache.org/repos/asf/incubator/jsecurity/trunk@710283 13f79535-47bb-0310-9956-ffa450edef68

FilePath: jsecurity/ri/business/src/org/jsecurity/session/AbstractSessionManager.java**
```diff
     protected Session retrieveSession( Serializable sessionId ) {
-        if ( log.isDebugEnabled() ) {
-            log.debug( "Retrieving session with id [" + sessionId + "] from the EIS" );
+        if ( log.isTraceEnabled() ) {
+            log.trace( "Retrieving session with id [" + sessionId + "] from the EIS" );
```
ProjectName: 6424-hbase
CommitID: f4d9597e1eef3baa9266581cf762ae3b249a1dff
CommitMsg:  HBASE-15210 Undo aggressive load balancer logging at tens of lines per millisecond; ADDENDUM changing LOG.debug to LOG.trace -- noticed by matteo

FilePath: hbase-server/src/main/java/org/apache/hadoop/hbase/master/balancer/BaseLoadBalancer.java**
```diff
         if (LOG.isTraceEnabled()) {
-          LOG.debug(" Lowest locality region index is " + lowestLocalityRegionIndex
+          LOG.trace(" Lowest locality region index is " + lowestLocalityRegionIndex
```
ProjectName: 6424-hbase
CommitID: 331b585934ecbb60a6d3477aab3533fabb1eef58
CommitMsg: HBASE-9661 Consistent log severity level guards and statements (Jackie Chang)


git-svn-id: https://svn.apache.org/repos/asf/hbase/trunk@1526620 13f79535-47bb-0310-9956-ffa450edef68

FilePath: hbase-client/src/main/java/org/apache/hadoop/hbase/zookeeper/ZKUtil.java**
```diff
     if (LOG.isTraceEnabled()) {
-      LOG.debug(identifier + " opening connection to ZooKeeper ensemble=" + ensemble);
+      LOG.trace(identifier + " opening connection to ZooKeeper ensemble=" + ensemble);
```
ProjectName: 6424-hbase
CommitID: 0b0cccb61d0eca166be235f8832ba2c7df873f1a
CommitMsg: HBASE-8879 Client Scanner spams the logs if there are lots of scanners.

git-svn-id: https://svn.apache.org/repos/asf/hbase/trunk@1500870 13f79535-47bb-0310-9956-ffa450edef68

FilePath: hbase-client/src/main/java/org/apache/hadoop/hbase/client/ClientScanner.java**
```diff
       final byte[] tableName, HConnection connection) throws IOException {
-      if (LOG.isDebugEnabled()) {
-        LOG.debug("Scan table=" + Bytes.toString(tableName)
+      if (LOG.isTraceEnabled()) {
+        LOG.trace("Scan table=" + Bytes.toString(tableName)
```
ProjectName: 6424-hbase
CommitID: f8a2ae4199aeceb8d8ae6c9c63119163446bca3a
CommitMsg: HBASE-8712  HFileLinkCleaner (FSUtils.listStatus) logs too much if
            links do not exists (Matteo via JD)


git-svn-id: https://svn.apache.org/repos/asf/hbase/trunk@1490871 13f79535-47bb-0310-9956-ffa450edef68

FilePath: hbase-server/src/main/java/org/apache/hadoop/hbase/util/FSUtils.java**
```diff
       // if directory doesn't exist, return null
-      LOG.debug(dir + " doesn't exist");
+      if (LOG.isTraceEnabled()) {
+        LOG.trace(dir + " doesn't exist");
+      }
```
ProjectName: 6424-hbase
CommitID: 61870830bf507c5d7a5eb1a756e64bbfd7a87570
CommitMsg: HBASE-8600 Bunch of log lines from QosFunction: Marking normal priority after

git-svn-id: https://svn.apache.org/repos/asf/hbase/trunk@1485886 13f79535-47bb-0310-9956-ffa450edef68

FilePath: hbase-server/src/main/java/org/apache/hadoop/hbase/regionserver/QosFunction.java**
```diff
       // server and have it throw the exception if still an issue.  Just mark it normal priority.
-      if (LOG.isDebugEnabled()) LOG.debug("Marking normal priority after getting exception=" + ex);
+      if (LOG.isTraceEnabled()) LOG.trace("Marking normal priority after getting exception=" + ex);
```
ProjectName: 6424-hbase
CommitID: d8ceacc577a90e0cfcc137983d37ed7b9d77e3fe
CommitMsg: HBASE-7214: CleanerChore logs too much, so much so it obscures all else that is going on

git-svn-id: https://svn.apache.org/repos/asf/hbase/trunk@1414229 13f79535-47bb-0310-9956-ffa450edef68

FilePath: hbase-server/src/main/java/org/apache/hadoop/hbase/master/cleaner/TimeToLiveHFileCleaner.java**
```diff
     long life = currentTime - time;
-    LOG.debug("Life:" + life + ", ttl:" + ttl + ", current:" + currentTime + ", from: " + time);
+    if (LOG.isTraceEnabled()) {
+      LOG.trace("HFile life:" + life + ", ttl:" + ttl + ", current:" + currentTime + ", from: "
+          + time);
+    }
```
ProjectName: 7427-hive
CommitID: 1e4c9612cacfc11d57134b7601dd1aa9e7984c59
CommitMsg: HIVE-8153: Reduce the verbosity of debug logs in ORC record reader (Prasanth J reviewed by Gopal V)

git-svn-id: https://svn.apache.org/repos/asf/hive/trunk@1625718 13f79535-47bb-0310-9956-ffa450edef68

FilePath: ql/src/java/org/apache/hadoop/hive/ql/io/orc/RecordReaderImpl.java**
```diff
     advanceToNextRow(rowInStripe + rowBaseInStripe);
-    if (LOG.isDebugEnabled()) {
-      LOG.debug("row from " + reader.path);
-      LOG.debug("orc row = " + result);
+    if (isLogTraceEnabled) {
+      LOG.trace("row from " + reader.path);
+      LOG.trace("orc row = " + result);
```
ProjectName: 13536-activemq
CommitID: 1ea430e557060809f726229ad9dffa6ee0ada649
CommitMsg: http://issues.apache.org/activemq/browse/AMQ-608

git-svn-id: https://svn.apache.org/repos/asf/incubator/activemq/trunk@420872 13f79535-47bb-0310-9956-ffa450edef68

FilePath: activemq-core/src/main/java/org/apache/activemq/transport/failover/FailoverTransport.java**
```diff
                         while (connectedTransport == null && !disposed && connectionFailure==null ) {
-                            log.debug("Waiting for transport to reconnect.");
+                            log.trace("Waiting for transport to reconnect.");
```

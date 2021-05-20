###  infomation 
method del:
-org.slf4j.Logger.isInfoEnabled()
method add：
+org.slf4j.Logger.isDebugEnabled()
###  support count
project count : 9
commit count : 11
###  code
ProjectName: 40863-isis
CommitID: 8bc8bfc29e7992e09a174af90f3a2f8f6d88f779
CommitMsg: ISIS-749: less noisy DataNucleusSimplePersistAlgorithm...

... for the makePersistent() method when persists (move from INFO to DEBUG).

FilePath: component/objectstore/jdo/jdo-datanucleus/src/main/java/org/apache/isis/objectstore/jdo/datanucleus/persistence/spi/DataNucleusSimplePersistAlgorithm.java**
```diff
         }
-        if (LOG.isInfoEnabled()) {
-            LOG.info("persist " + adapter);
+        if (LOG.isDebugEnabled()) {
+            LOG.debug("persist " + adapter);
```
ProjectName: 40863-isis
CommitID: 1fcec5fa0befa8d790eec8baefc7c89cb8f727fb
CommitMsg: ISIS-749: less noisy logging

in AdapterManagerDefault, ResourceServlet

FilePath: core/metamodel/src/main/java/org/apache/isis/core/webapp/content/ResourceServlet.java**
```diff
         final String servletPath = StringExtensions.stripLeadingSlash(request.getServletPath());
-        if (LOG.isInfoEnabled()) {
-            LOG.info("request: " + servletPath);
+        if (LOG.isDebugEnabled()) {
+            LOG.debug("request: " + servletPath);
```
ProjectName: 33064-xodus
CommitID: f73af028d148eee3a2b0c15f12fb39006846d42d
CommitMsg: debug logging in deferredFlushJob

FilePath: environment/src/main/java/jetbrains/exodus/env/EnvironmentImpl.java**
```diff
             protected void execute() throws Throwable {
-                if (logger.isInfoEnabled()) {
-                    logger.info("Idle environment flush: " + getLocation());
+                if (logger.isDebugEnabled()) {
+                    logger.debug("Idle environment flush: " + getLocation());
```
ProjectName: 37583-esper
CommitID: 66d23b2e318910324d9852ed8deded15de34493c
CommitMsg: merge remove info-level log for row recog tree

FilePath: common/src/main/java/com/espertech/esper/common/internal/epl/rowrecog/core/RowRecogNFAViewPlanUtil.java**
```diff
 
-        if (log.isInfoEnabled()) {
-            log.info("NFA tree:\n" + RowRecogNFAViewUtil.print(startStates));
+        if (log.isDebugEnabled()) {
+            log.debug("NFA tree:\n" + RowRecogNFAViewUtil.print(startStates));
```
ProjectName: 23659-Kundera
CommitID: 3376c65873952ef1198b65a758e2a03ddb64c76f
CommitMsg: Changed log level

FilePath: kundera-cassandra/src/main/java/com/impetus/client/cassandra/thrift/ThriftClientFactory.java**
```diff
 
-                if (logger.isInfoEnabled())
+                if (logger.isDebugEnabled())
```
ProjectName: 23204-ebean
CommitID: 77deab5cf06ffc2630183cfadfa745b42673f4a1
CommitMsg: #792 - Change Logging Rollback message on org.avaje.ebean.TXN from INFO level to DEBUG level

FilePath: src/main/java/com/avaje/ebeaninternal/server/transaction/TransactionManager.java**
```diff
     try {
-      if (TXN_LOGGER.isInfoEnabled()) {
+      if (TXN_LOGGER.isDebugEnabled()) {
```
ProjectName: 7829-shiro
CommitID: 73fb97373ff0f32604e70fc4037df8cb22eb3462
CommitMsg: Removing log spam when no cache manager is enabled.

Previously when the cache manager was not configured, the log would be spammed with:
"No cache or cacheManager properties have been set.  Authorization cache cannot be obtained. "

Fixes: SHIRO-428

FilePath: core/src/main/java/org/apache/shiro/realm/AuthorizingRealm.java**
```diff
             } else {
-                if (log.isInfoEnabled()) {
-                    log.info("No cache or cacheManager properties have been set.  Authorization cache cannot " +
+                if (log.isDebugEnabled()) {
+                    log.debug("No cache or cacheManager properties have been set.  Authorization cache cannot " +
```
ProjectName: 5818-jmeter
CommitID: 7324c82cab69fef97688112154c81900ab4fd951
CommitMsg: Don't log loop iteration events at info level

FilePath: src/core/src/main/java/org/apache/jmeter/control/LoopController.java**
```diff
     public void iterationStart(LoopIterationEvent iterEvent) {
-        if(LOGGER.isInfoEnabled()) {
-            LOGGER.info("iterationStart called on {} with source {} and iteration {}", getName(), iterEvent.getSource(), iterEvent.getIteration());
+        if (LOGGER.isDebugEnabled()) {
+            LOGGER.debug("iterationStart called on {} with source {} and iteration {}", getName(),
+                    iterEvent.getSource(), iterEvent.getIteration());
```
ProjectName: 7427-hive
CommitID: 2b1f8082e90e17bb6b48d486c1deacfdb06daf99
CommitMsg: HIVE-19003 : metastoreconf logs too much on info level (Sergey Shelukhin, reviewed by Alan Gates)

FilePath: standalone-metastore/src/main/java/org/apache/hadoop/hive/metastore/conf/MetastoreConf.java**
```diff
     if (!beenDumped.getAndSet(true) && getBoolVar(conf, ConfVars.DUMP_CONFIG_ON_CREATION) &&
-        LOG.isInfoEnabled()) {
-      LOG.info(dumpConfig(conf));
+        LOG.isDebugEnabled()) {
+      LOG.debug(dumpConfig(conf));
```
ProjectName: 7427-hive
CommitID: 954baa89bb4ee3e6ba7ed45157553dae633b3c9f
CommitMsg: HIVE-12312 : Excessive logging in PPD code (Carter Shanklin via Ashutosh Chauhan)

Signed-off-by: Ashutosh Chauhan <hashutosh@apache.org>

FilePath: ql/src/java/org/apache/hadoop/hive/ql/ppd/OpProcFactory.java**
```diff
     protected void logExpr(Node nd, ExprWalkerInfo ewi) {
-      if (!LOG.isInfoEnabled()) return;
+      if (!LOG.isDebugEnabled()) return;
```
ProjectName: 15769-calcite
CommitID: 05595f64902aa02c22a1a92c23452d74ceef02fe
CommitMsg: Fix plan changes in Druid tests caused by [CALCITE-1842]

FilePath: druid/src/main/java/org/apache/calcite/adapter/druid/DruidDateTimeUtils.java**
```diff
         });
-    if (LOGGER.isInfoEnabled()) {
-      LOGGER.info("Converted time ranges " + ranges + " to interval " + intervals);
+    if (LOGGER.isDebugEnabled()) {
+      LOGGER.debug("Converted time ranges " + ranges + " to interval " + intervals);
```

###  infomation 
method del:
-org.slf4j.Logger.info()
method add：
+org.slf4j.Logger.debug()
+org.slf4j.Logger.isDebugEnabled()
###  support count
project count : 12
commit count : 16
###  code
ProjectName: 44335-spring-cloud-contract
CommitID: c354bffafbd37ad1da4d80294521445420634bf4
CommitMsg: Lower the logging level where password can be printed; fixes #463

FilePath: spring-cloud-contract-stub-runner/src/main/java/org/springframework/cloud/contract/stubrunner/AetherStubDownloader.java**
```diff
 		ArtifactRequest request = new ArtifactRequest(artifact, this.remoteRepos, null);
-		log.info("Resolving artifact [" + artifact
-				+ "] using remote repositories " + this.remoteRepos);
+		if (log.isDebugEnabled()) {
+			log.debug("Resolving artifact [" + artifact
+					+ "] using remote repositories " + this.remoteRepos);
+		}
```
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
ProjectName: 40863-isis
CommitID: 1fcec5fa0befa8d790eec8baefc7c89cb8f727fb
CommitMsg: ISIS-749: less noisy logging

in AdapterManagerDefault, ResourceServlet

FilePath: core/runtime/src/main/java/org/apache/isis/core/runtime/persistence/adaptermanager/AdapterManagerDefault.java**
```diff
                     ) {
-                   LOG.info("updating version in oid, on " + originalOid + " (" + originalVersion + ") to (" + recreatedVersion +")");
-                   originalOid.setVersion(recreatedVersion);
+                    if(LOG.isDebugEnabled()) {
+                        LOG.debug("updating version in oid, on " + originalOid + " (" + originalVersion + ") to (" + recreatedVersion +")");
+                    }
+                    originalOid.setVersion(recreatedVersion);
```
ProjectName: 40863-isis
CommitID: 74c76ef28b5783fd662f09926f983c7b42e4c37d
CommitMsg: ISIS-437: making WebRequestCycleForIsis a bit less chatty in its logging

moving a LOG.info to a LOG.debug

FilePath: component/viewer/wicket/impl/src/main/java/org/apache/isis/viewer/wicket/viewer/integration/wicket/WebRequestCycleForIsis.java**
```diff
     public void onRequestHandlerExecuted(RequestCycle cycle, IRequestHandler handler) {
-        LOG.info("onRequestHandlerExecuted: handler: " + handler);
+        if(LOG.isDebugEnabled()) {
+            LOG.debug("onRequestHandlerExecuted: handler: " + handler);
+        }
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
ProjectName: 12015-mahout
CommitID: 85d756f00159d92e570a3412fc0e195377998683
CommitMsg: turn down the verbosity just a bit

git-svn-id: https://svn.apache.org/repos/asf/lucene/mahout/trunk@895302 13f79535-47bb-0310-9956-ffa450edef68

FilePath: core/src/main/java/org/apache/mahout/clustering/kmeans/KMeansClusterer.java**
```diff
           clusterCenter, point);
-      log.info("{} Cluster: {}", distance, cluster.getId());
+      if (log.isDebugEnabled()) {
+        log.debug("{} Cluster: {}", distance, cluster.getId());
+      }
```
ProjectName: 14287-Saturn
CommitID: 58cec0fc3cb2438ace7f12627956f5c20b8f1fa7
CommitMsg: #252 不设置超时时间不需要每次调度时都打印，日志改为debug级别
FilePath: saturn-core/src/main/java/com/vip/saturn/job/shell/ScriptJobRunner.java**
```diff
                 watchdog = new SaturnExecuteWatchdog(5L * 365 * 24 * 3600 * 1000, jobName, item, itemValue);
-                log.info("[{}] msg=Job {} disable timeout control", jobName, jobName);
+                if(log.isDebugEnabled()){
+                	log.debug("[{}] msg=Job {} disable timeout control", jobName, jobName);
+                }
```
ProjectName: 19415-hawtio
CommitID: 16a7fcb718be1cf540778991bd5f0db402231fa3
CommitMsg: lower to debug logging the use of OpenShift capable sockets

FilePath: hawtio-web/src/main/java/io/hawt/web/OpenShiftProtocolSocketFactory.java**
```diff
     public Socket createSocket(String host, int port, InetAddress localAddress, int localPort) throws IOException, UnknownHostException {
-        LOG.info("Creating OpenShift socket on " + host + ":" + port);
+        if (LOG.isDebugEnabled()) {
+            LOG.debug("Creating OpenShift socket on " + host + ":" + port);
+        }
```
ProjectName: 19415-hawtio
CommitID: 08e1e018b66b468aba23ffc04c6c29846a7d4f75
CommitMsg: switch to debug logging

FilePath: hawtio-web/src/main/java/io/hawt/web/ProxyServlet.java**
```diff
 
-        LOG.info("Registered OpenShiftProtocolSocketFactory Protocol for http: " + Protocol.getProtocol("http").getSocketFactory());
+        if (LOG.isDebugEnabled())  {
+            LOG.debug("Registered OpenShiftProtocolSocketFactory Protocol for http: " + Protocol.getProtocol("http").getSocketFactory());
+        }
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
ProjectName: 1272-flink
CommitID: bdf9f86c51aa2122441adea6944ce46f393d729f
CommitMsg: [hotfix] Improve Logging in CheckpointCoordinator, StreamTask, State Code

FilePath: flink-runtime/src/main/java/org/apache/flink/runtime/state/filesystem/FsCheckpointStreamFactory.java**
```diff
 
-		LOG.info("Initializing file stream factory to URI {}.", dir);
+		if (LOG.isDebugEnabled()) {
+			LOG.debug("Initializing file stream factory to URI {}.", dir);
+		}
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

###  infomation 
method del:
-org.apache.commons.logging.Log.warn()
method add：
+org.apache.commons.logging.Log.debug()
###  support count
project count : 13
commit count : 29
###  code
ProjectName: 32143-checkstyle-idea
CommitID: 079ce411575cb5e9c954777ef8c3a95a9b783258
CommitMsg: Victim location errors are now at debug level (#269).

FilePath: src/main/java/org/infernus/idea/checkstyle/checker/CheckStyleAuditListener.java**
```diff
                 addProblemTo(psiFile, psiFile, event, false);
-                LOG.warn("Couldn't find victim for error: " + event.getFileName() + "("
+                LOG.debug("Couldn't find victim for error: " + event.getFileName() + "("
```
ProjectName: 35083-pig
CommitID: 6d844513a8851cfbbc47e3e6df18c9f96d87c182
CommitMsg: PIG-4139: pig query throws error java.lang.NoSuchFieldException: jobsInProgress on MRv1 (satish via cheolsoo)


git-svn-id: https://svn.apache.org/repos/asf/pig/trunk@1620107 13f79535-47bb-0310-9956-ffa450edef68

FilePath: shims/src/hadoop23/org/apache/pig/backend/hadoop23/PigJobControl.java**
```diff
     } catch (Exception e) {
-      log.warn("falling back to default JobControl (not using hadoop 0.23 ?)", e);
+      log.debug("falling back to default JobControl (not using hadoop 0.23 ?)", e);
```
ProjectName: 36183-java-cas-client
CommitID: d6f11f89a205c8039347ef59f97a700a9fe71c7e
CommitMsg: CASC-105

changed log level to debug instead of warn.

FilePath: cas-client-core/src/main/java/org/jasig/cas/client/util/CommonUtils.java**
```diff
         if ("POST".equals(request.getMethod()) && "logoutRequest".equals(parameter)) {
-            LOG.warn("safeGetParameter called on a POST HttpServletRequest for LogoutRequest.  Cannot complete check safely.  Reverting to standard behavior for this Parameter");
+            LOG.debug("safeGetParameter called on a POST HttpServletRequest for LogoutRequest.  Cannot complete check safely.  Reverting to standard behavior for this Parameter");
```
ProjectName: 22223-pdfbox
CommitID: cd1a51a229cfb82752fd39b8981afd79a37455f4
CommitMsg: PDFBOX-4189: set message log level to debug, because the earlier message (that makes more sense) is also debug level

git-svn-id: https://svn.apache.org/repos/asf/pdfbox/trunk@1861795 13f79535-47bb-0310-9956-ffa450edef68

FilePath: fontbox/src/main/java/org/apache/fontbox/ttf/gsub/GlyphSubstitutionDataExtractor.java**
```diff
             {
-                LOG.warn("The type " + lookupSubTable + " is not yet supported, will be ignored");
+                // usually null, due to being skipped in GlyphSubstitutionTable.readLookupTable()
+                LOG.debug("The type " + lookupSubTable + " is not yet supported, will be ignored");
```
ProjectName: 22223-pdfbox
CommitID: 9e9920a2dd00ebcb76e4319c66e2f9448568be55
CommitMsg: PDFBOX-3819: downgrade logging to debug

git-svn-id: https://svn.apache.org/repos/asf/pdfbox/trunk@1800550 13f79535-47bb-0310-9956-ffa450edef68

FilePath: fontbox/src/main/java/org/apache/fontbox/ttf/PostScriptTable.java**
```diff
             // no postscript information is provided.
-            LOG.warn("No PostScript name information is provided for the font " + font.getName());
+            LOG.debug("No PostScript name information is provided for the font " + font.getName());
```
ProjectName: 22223-pdfbox
CommitID: 8d2aa613129022074e398a6a996a0b7f0b9781e3
CommitMsg: PDFBOX-1756: forgot to demote warning to debug level

git-svn-id: https://svn.apache.org/repos/asf/pdfbox/trunk@1597285 13f79535-47bb-0310-9956-ffa450edef68

FilePath: pdfbox/src/main/java/org/apache/pdfbox/cos/COSDocument.java**
```diff
                     {
-                        LOG.warn("Expected a /Name object after /Type, got '" + typeItem + "' instead");
+                        LOG.debug("Expected a /Name object after /Type, got '" + typeItem + "' instead");
```
ProjectName: 22223-pdfbox
CommitID: 2cb3b7fc6531ea8e00213e903db72978b8baa550
CommitMsg: PDFBOX-678: Support missing Text Rendering Modes when rendering a PDF

Turn the warning to a debug log message in PageDrawer.processTextPosition() to prevent excess verbosity with some PDF documents. The missing functionality is already directly visible in the drawed output and we have a Jira issue for this, so there's little need to log warnings about the problem.

git-svn-id: https://svn.apache.org/repos/asf/pdfbox/trunk@1004931 13f79535-47bb-0310-9956-ffa450edef68

FilePath: pdfbox/src/main/java/org/apache/pdfbox/pdfviewer/PageDrawer.java**
```diff
                     // TODO : need to implement....
-                    log.warn("Unsupported RenderingMode "
+                    log.debug("Unsupported RenderingMode "
```
ProjectName: 22696-spring-integration
CommitID: c80a6025fd469bf237b26b71bc9a61187bddbb22
CommitMsg: INT-1062

FilePath: org.springframework.integration/src/main/java/org/springframework/integration/context/IntegrationObjectSupport.java**
```diff
 			this.conversionService = IntegrationContextUtils.getConversionService(this.beanFactory);
-			if (this.conversionService == null && logger.isWarnEnabled()) {
-				logger.warn("Unable to attempt conversion of Message payload types. Component '" +
+			if (this.conversionService == null && logger.isDebugEnabled()) {
+				logger.debug("Unable to attempt conversion of Message payload types. Component '" +
```
ProjectName: 28453-cuba
CommitID: 9ecaf9ea78d772c12df5b40839de9cd1ea96f959
CommitMsg: Change log level for 'Suppress containerItemSetChange listeners' to 'debug'

FilePath: modules/web/src/com/haulmont/cuba/web/gui/data/OptionsDsWrapper.java**
```diff
         if (PaintContext.isPainting()) {
-            log.warn("Suppress containerItemSetChange listeners during painting, undefined behavior may be occured");
+            log.debug("Suppress containerItemSetChange listeners during painting, undefined behavior may be occured");
```
ProjectName: 28453-cuba
CommitID: 9ecaf9ea78d772c12df5b40839de9cd1ea96f959
CommitMsg: Change log level for 'Suppress containerItemSetChange listeners' to 'debug'

FilePath: modules/web/src/com/haulmont/cuba/web/gui/data/CollectionDsWrapper.java**
```diff
         if (PaintContext.isPainting()) {
-            log.warn("Suppress containerItemSetChange listeners during painting, undefined behavior may be occured");
+            log.debug("Suppress containerItemSetChange listeners during painting, undefined behavior may be occured");
```
ProjectName: 28453-cuba
CommitID: 9ecaf9ea78d772c12df5b40839de9cd1ea96f959
CommitMsg: Change log level for 'Suppress containerItemSetChange listeners' to 'debug'

FilePath: modules/web/src/com/haulmont/cuba/web/gui/components/filter/ConditionsContainer.java**
```diff
         if (PaintContext.isPainting()) {
-            log.warn("Suppress containerItemSetChange listeners during painting, undefined behavior may be occured");
+            log.debug("Suppress containerItemSetChange listeners during painting, undefined behavior may be occured");
```
ProjectName: 28453-cuba
CommitID: 48d32dc2ec6470cedd815c5e798a7337e057ca65
CommitMsg: Harmless but annoying message in logs when using entity diff manager #PL-1924

FilePath: modules/core/src/com/haulmont/cuba/core/app/EntityDiffManager.java**
```diff
             if ((firstValue != null) || (secondValue != null))
-                log.warn("Not null values for (null) view ignored, property: " + metaProperty.getName() +
+                log.debug("Not null values for (null) view ignored, property: " + metaProperty.getName() +
```
ProjectName: 28453-cuba
CommitID: 68f3913b27f88f13c1a91ae14d2213915db8d319
CommitMsg: Change validation errors log level from WARN to DEBUG

FilePath: modules/web/src/com/haulmont/cuba/web/gui/WebWindow.java**
```diff
                     } catch (ValidationException e) {
-                        log.warn("Validation failed", e);
+                        log.debug("Validation failed", e);
```
ProjectName: 28453-cuba
CommitID: 68f3913b27f88f13c1a91ae14d2213915db8d319
CommitMsg: Change validation errors log level from WARN to DEBUG

FilePath: modules/desktop/src/com/haulmont/cuba/desktop/gui/components/DesktopWindow.java**
```diff
                     } catch (ValidationException e) {
-                        log.warn("Validation failed", e);
+                        log.debug("Validation failed", e);
```
ProjectName: 11769-spring-cloud-gateway
CommitID: da853206d4ddc0137f0aecc8f0c5617702d6b9df
CommitMsg: change log message to debug

FilePath: spring-cloud-gateway-core/src/main/java/org/springframework/cloud/gateway/handler/predicate/RemoteAddrRoutePredicateFactory.java**
```diff
 				if (!hostAddress.equals(host)) {
-					log.warn("Remote addresses didn't match " + hostAddress + " != " + host);
+					log.debug("Remote addresses didn't match " + hostAddress + " != " + host);
```
ProjectName: 15151-jabref
CommitID: 2c7ea6027c86ebe6bd2d8016327e975989e1a73e
CommitMsg: Fix #2680 and fix #2667: Swing errors are catched properly and without freezing (#2681)


FilePath: src/main/java/org/jabref/JabRefException.java**
```diff
         if (localizedMessage == null) {
-            LOGGER.warn("No localized message exception message defined. Falling back to getMessage().");
+            LOGGER.debug("No localized message exception message defined. Falling back to getMessage().");
```
ProjectName: 15151-jabref
CommitID: 5a6507fcafd79a4ef3959f6d93cde55c6de410dc
CommitMsg: Merge pull request #2262 from JabRef/search-logleve

Change log level to debug
FilePath: src/main/java/net/sf/jabref/model/search/rules/GrammarBasedSearchRule.java**
```diff
         } catch (ParseCancellationException e) {
-            LOGGER.warn("Search query invalid", e);
+            LOGGER.debug("Search query invalid", e);
```
ProjectName: 15151-jabref
CommitID: 59dc87af910f0e7117af594460b570f87d9932d1
CommitMsg: Change log level to debug

FilePath: src/main/java/net/sf/jabref/model/search/rules/GrammarBasedSearchRule.java**
```diff
         } catch (ParseCancellationException e) {
-            LOGGER.warn("Search query invalid", e);
+            LOGGER.debug("Search query invalid", e);
```
ProjectName: 4391-rest-assured
CommitID: 89ca01c63ac35d7a4b124d2220fbf5a9d8a0b832
CommitMsg: Removed log.warn(..) messages from internal classes (issue 715)

FilePath: rest-assured/src/main/java/io/restassured/internal/http/HTTPBuilder.java**
```diff
         parsedData = resp.getEntity().getContent();
-        if (parsedData == null) log.warn("Parser returned null!");
+        if (parsedData == null) log.debug("Parser returned null!");
```
ProjectName: 4391-rest-assured
CommitID: 89ca01c63ac35d7a4b124d2220fbf5a9d8a0b832
CommitMsg: Removed log.warn(..) messages from internal classes (issue 715)

FilePath: rest-assured/src/main/java/io/restassured/internal/http/HTTPBuilder.java**
```diff
             } else if (parsedData instanceof Closeable)
-                log.warn("Parsed data is streaming, but will be accessible after " +
+                log.debug("Parsed data is streaming, but will be accessible after " +
```
ProjectName: 4391-rest-assured
CommitID: 89ca01c63ac35d7a4b124d2220fbf5a9d8a0b832
CommitMsg: Removed log.warn(..) messages from internal classes (issue 715)

FilePath: rest-assured/src/main/java/io/restassured/internal/http/HTTPBuilder.java**
```diff
             if (query != null) {
-                log.warn("'params' argument is deprecated; use 'query' instead.");
+                log.debug("'params' argument is deprecated; use 'query' instead.");
```
ProjectName: 1272-flink
CommitID: 93256b2c77214413f025f55e3ef48cc9be3bd82b
CommitMsg: Reduced verbosity of RuntimeInputChannelContext log messages

FilePath: nephele/nephele-server/src/main/java/eu/stratosphere/nephele/taskmanager/runtime/RuntimeInputChannelContext.java**
```diff
 				if (!this.isReexecuted || sequenceNumber > expectedSequenceNumber) {
-					if (LOG.isWarnEnabled()) {
-						LOG.warn("Input channel " + getChannelName() + " expected envelope " + expectedSequenceNumber
+					if (LOG.isDebugEnabled()) {
+						LOG.debug("Input channel " + getChannelName() + " expected envelope " + expectedSequenceNumber
```
ProjectName: 6424-hbase
CommitID: 14fb57cab2fd8c0117d59669018b09e29bd6e387
CommitMsg: HBASE-17780 BoundedByteBufferPool "At capacity" messages are not actionable

FilePath: hbase-common/src/main/java/org/apache/hadoop/hbase/io/BoundedByteBufferPool.java**
```diff
       if (countOfBuffers >= maxToCache) {
-        if (LOG.isWarnEnabled()) {
-          LOG.warn("At capacity: " + countOfBuffers);
+        if (LOG.isDebugEnabled()) {
+          LOG.debug("At capacity: " + countOfBuffers);
```
ProjectName: 6424-hbase
CommitID: a1c94c0bdfe31d2d2435a135fc2ff1d36a979e13
CommitMsg: HBASE-13677 changed RecoverableZooKeeper logs about retries from info and warn to debug

Signed-off-by: Sean Busbey <busbey@cloudera.com>

FilePath: hbase-client/src/main/java/org/apache/hadoop/hbase/zookeeper/RecoverableZooKeeper.java**
```diff
       String opName) throws KeeperException {
-    LOG.warn("Possibly transient ZooKeeper, quorum=" + quorumServers + ", exception=" + e);
+    LOG.debug("Possibly transient ZooKeeper, quorum=" + quorumServers + ", exception=" + e);
```
ProjectName: 6424-hbase
CommitID: 96f84594eee58b4e9a9347541baa3343a4ed3b97
CommitMsg: HBASE-11915 Document and test 0.94 -> 1.0.0 update -- ADDENDUM

FilePath: hbase-server/src/main/java/org/apache/hadoop/hbase/util/FSUtils.java**
```diff
         if (retries > 0) {
-          LOG.warn("Unable to create version file at " + rootdir.toString() + ", retrying", e);
+          LOG.debug("Unable to create version file at " + rootdir.toString() + ", retrying", e);
```
ProjectName: 7427-hive
CommitID: eac9d09da686575fb51446276620313abdbaed16
CommitMsg: HIVE-6733: Driver context logs every query in the warn level (Gunther Hagleitner, reviewed by Thejas M Nair)

git-svn-id: https://svn.apache.org/repos/asf/hive/trunk@1582086 13f79535-47bb-0310-9956-ffa450edef68

FilePath: ql/src/java/org/apache/hadoop/hive/ql/DriverContext.java**
```diff
   public synchronized void shutdown() {
-    LOG.warn("Shutting down query " + ctx.getCmd());
+    LOG.debug("Shutting down query " + ctx.getCmd());
```
ProjectName: 13536-activemq
CommitID: ce7495ec1e613fe878ecef7f539ca0f004484269
CommitMsg: Avoid the ugly  'Async exception with no exception listener' message from showing up in the output when shutting down the broker.



git-svn-id: https://svn.apache.org/repos/asf/activemq/trunk@648250 13f79535-47bb-0310-9956-ffa450edef68

FilePath: activemq-core/src/main/java/org/apache/activemq/ActiveMQConnection.java**
```diff
             } else {
-                LOG.warn("Async exception with no exception listener: " + error, error);
+                LOG.debug("Async exception with no exception listener: " + error, error);
```
ProjectName: 13536-activemq
CommitID: b16d55f79af6a95a96a23d636667f8d156c1b48d
CommitMsg: Lowered the logging level of empty messages returned. For background see : http://www.nabble.com/HTTP-%3A-Received-null-command-tp14997476s2354p14997476.html

git-svn-id: https://svn.apache.org/repos/asf/activemq/trunk@613889 13f79535-47bb-0310-9956-ffa450edef68

FilePath: activemq-optional/src/main/java/org/apache/activemq/transport/http/HttpClientTransport.java**
```diff
                     if (command == null) {
-                        LOG.warn("Received null command from url: " + remoteUrl);
+                        LOG.debug("Received null command from url: " + remoteUrl);
```
ProjectName: 13536-activemq
CommitID: 9f15a47340887e79e48cbfc061e5b593a22321cd
CommitMsg: only use debug logging when re-filling a batch

git-svn-id: https://svn.apache.org/repos/asf/activemq/trunk@512642 13f79535-47bb-0310-9956-ffa450edef68

FilePath: activemq-core/src/main/java/org/apache/activemq/broker/region/cursors/TopicStorePrefetch.java**
```diff
                     if(batchList.isEmpty()){
-                        log.warn("Refilling batch - haven't got past first message = " + firstMessageId);
+                        log.debug("Refilling batch - haven't got past first message = " + firstMessageId);
```

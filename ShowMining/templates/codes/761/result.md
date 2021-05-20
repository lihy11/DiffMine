###  infomation 
method del:
-java.util.logging.Logger.info()
method add：
+java.util.logging.Logger.fine()
###  support count
project count : 12
commit count : 18
###  code
ProjectName: 33731-restfb
CommitID: 1a02888bc5b86bf84fe54d5631dabc52e39e960a
CommitMsg: Log level too high for makeRequestAndProcessResponse.

FilePath: source/library/com/restfb/DefaultFacebookClient.java**
```diff
 
-    if (logger.isLoggable(INFO))
-      logger.info("Facebook responded with " + response);
+    if (logger.isLoggable(FINE))
+      logger.fine("Facebook responded with " + response);
```
ProjectName: 35898-opencensus-java
CommitID: 9e5ca39dbc5a447dd665066f51c76467b269a761
CommitMsg: Reduce log level to avoid spamming stdout. (#543)

This was useful during initial development, but is now annoying as info-level logs end up on stdout, assuming the default j.u.l. configuration.
FilePath: contrib/agent/src/main/java/io/opencensus/contrib/agent/AgentMain.java**
```diff
 
-    logger.info("Initializing.");
+    logger.fine("Initializing.");
```
ProjectName: 35898-opencensus-java
CommitID: 9e5ca39dbc5a447dd665066f51c76467b269a761
CommitMsg: Reduce log level to avoid spamming stdout. (#543)

This was useful during initial development, but is now annoying as info-level logs end up on stdout, assuming the default j.u.l. configuration.
FilePath: contrib/agent/src/main/java/io/opencensus/contrib/agent/AgentMain.java**
```diff
 
-    logger.info("Initialized.");
+    logger.fine("Initialized.");
```
ProjectName: 36830-java-sdk
CommitID: a751ab56adb36fb7f2f40b5b41033d3ac5633a85
CommitMsg: :unamused: change log level for JDNI keys

FilePath: src/main/java/com/ibm/watson/developer_cloud/util/CredentialUtils.java**
```diff
     } catch (Exception e) {
-      log.info("JNDI " + lookupName + " not found.");
+      log.fine("JNDI " + lookupName + " not found.");
```
ProjectName: 20541-camunda-bpm-platform
CommitID: 38bed3b9821c907d3def7779ee5de742cdff1bbc
CommitMsg: Log message about the deployment being processed on fine instead of info.

FilePath: activiti-engine/src/main/java/org/activiti/engine/impl/bpmn/deployer/BpmnDeployer.java**
```diff
   public void deploy(DeploymentEntity deployment) {
-    LOG.info("Processing deployment " + deployment.getName());
+    LOG.fine("Processing deployment " + deployment.getName());
```
ProjectName: 29579-Payara
CommitID: f25dbab3b0923ff01b18e0579e4ef65b746c61ff
CommitMsg: Increasing the logging level to prevent some logging noises

git-svn-id: https://svn.java.net/svn/glassfish~svn/trunk/main@56300 6f3ba3e3-413c-0410-a8aa-90bee3ab43b5

FilePath: nucleus/admin/config-api/src/main/java/com/sun/enterprise/config/modularity/ConfigModularityUtils.java**
```diff
             serverType = RuntimeType.valueOf(typeString);
-        LOG.info("server type is: " + serverType.name());
+        LOG.fine("server type is: " + serverType.name());
```
ProjectName: 10413-nutch
CommitID: 7ab2f64165224219f1b9c864893f7bd9b5856b3f
CommitMsg: Fix for NUTCH-190 (ParseUtil drops reason for failed parse).

Also, hide the message about successful parse behind LOG.fine() -
no message is a good message; if users want this they can still have it.



git-svn-id: https://svn.apache.org/repos/asf/lucene/nutch/trunk@372664 13f79535-47bb-0310-9956-ffa450edef68

FilePath: src/java/org/apache/nutch/parse/ParseUtil.java**
```diff
     for (int i=0; i<parsers.length; i++) {
-      LOG.info("Parsing [" + content.getUrl() + "] with [" + parsers[i] + "]");
+      LOG.fine("Parsing [" + content.getUrl() + "] with [" + parsers[i] + "]");
```
ProjectName: 10413-nutch
CommitID: b4ee2022aab84c0713267c3d56d0ed4b1917b782
CommitMsg: Reduce info-level logging.


git-svn-id: https://svn.apache.org/repos/asf/lucene/nutch/trunk@190951 13f79535-47bb-0310-9956-ffa450edef68

FilePath: src/plugin/parse-html/src/java/org/apache/nutch/parse/html/HtmlParser.java**
```diff
     HTMLMetaProcessor.getMetaTags(metaTags, root, base);
-    LOG.info("Meta tags for " + base + ": " + metaTags.toString());
+    LOG.fine("Meta tags for " + base + ": " + metaTags.toString());
```
ProjectName: 13030-geoserver
CommitID: b63f7b604ca3685601c8ec05fe914233b533800b
CommitMsg: lower logging severity of geoserver tile layer loading

FilePath: src/gwc/src/main/java/org/geoserver/gwc/layer/DefaultTileLayerCatalog.java**
```diff
     private GeoServerTileLayerInfoImpl depersist(final File file) throws IOException {
-        LOGGER.info("Depersisting GeoServerTileLayerInfo from " + file.getAbsolutePath());
+        if (LOGGER.isLoggable(Level.FINE)) {
+            LOGGER.fine("Depersisting GeoServerTileLayerInfo from " + file.getAbsolutePath());
+        }
```
ProjectName: 5737-junit5
CommitID: e061fa45d89529edff690f329298c6a061482834
CommitMsg: Reduce log level to FINE in Launcher.discoverRootDescriptor()

Issue: #84

------------------------------------------------------------------------
On behalf of the community, the JUnit Lambda Team thanks msg systems ag
(http://www.msg-systems.com) for supporting the JUnit crowdfunding
campaign!
------------------------------------------------------------------------

FilePath: junit-launcher/src/main/java/org/junit/gen5/launcher/Launcher.java**
```diff
 		for (TestEngine testEngine : testEngineRegistry.getTestEngines()) {
-			LOG.info(() -> String.format("Discovering tests during launcher %s phase in engine '%s'.", phase,
+			LOG.fine(() -> String.format("Discovering tests during launcher %s phase in engine '%s'.", phase,
```
ProjectName: 3760-robolectric
CommitID: 45b9412180306566c664b348a36e4a4c23013824
CommitMsg: Changed a log line from INFO to FINE.

This cleans up builds by eliminating a lot of log noise that's of
dubious value.

FilePath: src/main/java/org/robolectric/res/ResourceExtractor.java**
```diff
       resourceIdToResName.put(id, resName);
-      LOGGER.info("no id mapping found for " + resName.getFullyQualifiedName() + "; assigning ID #0x" + Integer.toHexString(id));
+      LOGGER.fine("no id mapping found for " + resName.getFullyQualifiedName() + "; assigning ID #0x" + Integer.toHexString(id));
```
ProjectName: 8346-pmd
CommitID: f0276471ec5d1e2a425ce593715058f9881ca991
CommitMsg: pmd (build): Switch logger from info to debug

git-svn-id: https://pmd.svn.sourceforge.net/svnroot/pmd/trunk@7531 51baf565-9d33-0410-a72c-fc3788e3496d

FilePath: pmd/tools/src/net/sourceforge/pmd/build/xml/RulesetFileTemplater.java**
```diff
 		for ( File dir : FileUtil.filterFilesFrom(FileUtil.existAndIsADirectory(rulesDirectory), new DirectoryFileFilter() )) {
-			logger.info("Adding directory:" + dir.getAbsolutePath());
+			logger.fine("Adding directory:" + dir.getAbsolutePath());
```
ProjectName: 13675-framework
CommitID: c0427b1a7f83a915a16dd38ce30442714a671cf5
CommitMsg: Changed UI close debug message level from info to fine

FilePath: server/src/com/vaadin/server/VaadinSession.java**
```diff
                 ui.fireCloseEvent();
-                getLogger().info(
+                getLogger().fine(
```
ProjectName: 13675-framework
CommitID: c9f2bc3b79adeff283545b9a380f6b6ef19d6fbb
CommitMsg: Reduced logging
FilePath: src/com/vaadin/terminal/gwt/server/AbstractCommunicationManager.java**
```diff
         for (Vaadin6Component c : legacyComponents) {
-            logger.info("Painting legacy Component " + c.getClass().getName()
+            logger.fine("Painting Vaadin6Component " + c.getClass().getName()
```
ProjectName: 35532-cxf
CommitID: 5c0c7df629f628fe5e76458e99a2105f6c55ddee
CommitMsg: Only log namespacehandler reg on debug level

FilePath: core/src/main/java/org/apache/cxf/bus/blueprint/NamespaceHandlerRegisterer.java**
```diff
                 bc.registerService(NamespaceHandler.class.getName(), handler, properties);
-                LOG.info("Registered blueprint namespace handler for " + namespace);
+                LOG.fine("Registered blueprint namespace handler for " + namespace);
```
ProjectName: 35532-cxf
CommitID: 53514d28fd9299e2e9680bc7ece79d8f4c3acad7
CommitMsg: Minor update to ProviderFactory to minimize the noise when Jettison is missing

git-svn-id: https://svn.apache.org/repos/asf/cxf/trunk@1242729 13f79535-47bb-0310-9956-ffa450edef68

FilePath: rt/frontend/jaxrs/src/main/java/org/apache/cxf/jaxrs/provider/ProviderFactory.java**
```diff
             }
-            LOG.info(message);
+            LOG.fine(message);
```
ProjectName: 35532-cxf
CommitID: 007fe6f05fe37c86e98a6a9fbbc44706d74ad3b1
CommitMsg: Change log level to fine

git-svn-id: https://svn.apache.org/repos/asf/cxf/trunk@786583 13f79535-47bb-0310-9956-ffa450edef68

FilePath: rt/transports/jbi/src/main/java/org/apache/cxf/transport/jbi/JBITransportFactory.java**
```diff
     public void setDeliveryChannel(DeliveryChannel newDeliverychannel) {
-        LOG.info(new org.apache.cxf.common.i18n.Message(
+        LOG.fine(new org.apache.cxf.common.i18n.Message(
```
ProjectName: 35532-cxf
CommitID: e0815a4d1f960f2711c10233f5d962ba033c003a
CommitMsg: [CXF-1556] Reduce logging level in JAXRS
Also change protection on a method in aegis that is seeming to invoke a bug in the latest PMD or checkstyle plugin in eclipse.


git-svn-id: https://svn.apache.org/repos/asf/cxf/trunk@652899 13f79535-47bb-0310-9956-ffa450edef68

FilePath: rt/frontend/jaxrs/src/main/java/org/apache/cxf/jaxrs/interceptor/JAXRSInInterceptor.java**
```diff
         }
-        LOG.info("Found operation: " + ori.getMethod().getName());
+        LOG.fine("Found operation: " + ori.getMethod().getName());
```

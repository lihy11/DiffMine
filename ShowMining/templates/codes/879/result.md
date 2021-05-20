###  infomation 
method del:
-null.equalsIgnoreCase()
method add：
+java.lang.String.equalsIgnoreCase()
###  support count
project count : 12
commit count : 18
###  code
ProjectName: 21374-psi-probe
CommitID: 89886f66ded04b5ef9b977d5e90e4655538a80a3
CommitMsg: [ci] Small language cleanup

FilePath: core/src/main/java/psiprobe/controllers/jsp/RecompileJspController.java**
```diff
 
-    if (request.getMethod().equalsIgnoreCase("post") && summary != null) {
+    if ("post".equalsIgnoreCase(request.getMethod()) && summary != null) {
```
ProjectName: 10166-Anki-Android
CommitID: 0a1dc942eed02ca289da11b80d9e1d5b3f97d47f
CommitMsg: make sure we normalize deck names on input

https://anki.tenderapp.com/discussions/ankidesktop/31635-anki-crashes-when-new-card-is-added
dae/anki@71e0c880328029f2cec4604db29e82c80b1c0e58 and
dae/anki@30f19c07be9425824120f3faf163de3181ac9d79

I introduce extra variable because otherwise the lines would be
extremly long. Such as:
```
if (Normalizer.normalize(g.getValue().getString("name"), Normalizer.Form.NFC).equalsIgnoreCase(name)) {
```

FilePath: AnkiDroid/src/main/java/com/ichi2/libanki/Decks.java**
```diff
             for (Map.Entry<Long, JSONObject> g : mDecks.entrySet()) {
-                if (g.getValue().getString("name").equalsIgnoreCase(name)) {
+                String deckName = g.getValue().getString("name");
+                deckName = Normalizer.normalize(deckName, Normalizer.Form.NFC);
+                if (deckName.equalsIgnoreCase(name)) {
```
ProjectName: 13030-geoserver
CommitID: f7497aaa8e926ec1320da65dec7d000bcdbce411
CommitMsg: Merge pull request #650 from geosolutions-it/GEOS-6476

GEOS-6476: Fixing NPE on animate requests on WMS-EO plugin
FilePath: src/community/wms-eo/src/main/java/org/geoserver/wms/eo/EOGetMapChecker.java**
```diff
         final GetMapRequest request = content.getRequest();
-        if(!request.getVersion().equalsIgnoreCase("1.3.0")){
-            return super.beforeRender(content);     
+        if(!"1.3.0".equalsIgnoreCase(request.getVersion())){
+            return super.beforeRender(content);
```
ProjectName: 13030-geoserver
CommitID: 83aca5bea70e66a4a7acd88d600b732a9b8d4cf6
CommitMsg: GEOS-6476: Fixing NPE on animate requests on WMS-EO plugin

FilePath: src/community/wms-eo/src/main/java/org/geoserver/wms/eo/EOGetMapChecker.java**
```diff
         final GetMapRequest request = content.getRequest();
-        if(!request.getVersion().equalsIgnoreCase("1.3.0")){
-            return super.beforeRender(content);     
+        if(!"1.3.0".equalsIgnoreCase(request.getVersion())){
+            return super.beforeRender(content);
```
ProjectName: 11281-liquibase
CommitID: 84c2f7d587c57aeec153ba8a5356f1d0bb46005e
CommitMsg: CORE-1685 NPE at SchemaComparator

FilePath: liquibase-core/src/main/java/liquibase/diff/compare/core/SchemaComparator.java**
```diff
         if (accordingTo.supportsSchemas()) {
-            return thisSchema.getSchemaName().equalsIgnoreCase(otherSchema.getSchemaName());
+            String thisSchemaName = thisSchema.getSchemaName();
+            String otherSchemaName = otherSchema.getSchemaName();
+            if (thisSchemaName == null) {
+                return otherSchemaName == null;
+            }
+            return thisSchemaName.equalsIgnoreCase(otherSchemaName);
```
ProjectName: 11281-liquibase
CommitID: 6aad72657e8deee3fb06d2348994d0a0e2a5f11f
CommitMsg: CORE-795 NullPointerException in Diff class if index is unnamed

SHould not be null, but added null checks just in case

git-svn-id: http://liquibase.jira.com/svn/CORE/trunk@1882 e6edf6fb-f266-4316-afb4-e53d95876a76

FilePath: liquibase-core/src/main/java/liquibase/diff/Diff.java**
```diff
 
-					if ( idx1.getName().equalsIgnoreCase( idx2.getName() )
+                    String index1Name = StringUtils.trimToEmpty(idx1.getName());
+                    String index2Name = StringUtils.trimToEmpty(idx2.getName());
+                    if ( index1Name.equalsIgnoreCase(index2Name)
```
ProjectName: 1386-PermissionsDispatcher
CommitID: 39ba1ed14b84e08b26d3855c86f4698b77999dfc
CommitMsg: Handle the case Build.MANUFACTURER = null

FilePath: library/src/main/android/permissions/dispatcher/PermissionUtils.java**
```diff
     private static boolean hasSelfPermission(Context context, String permission) {
-        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.M && Build.MANUFACTURER.equalsIgnoreCase("Xiaomi")) {
+        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.M && "Xiaomi".equalsIgnoreCase(Build.MANUFACTURER)) {
```
ProjectName: 5607-atmosphere
CommitID: 626a2cb4c81a53186d87b6436e036167d59db894
CommitMsg: Catch possible NPE

FilePath: samples/jquery-meteor-pubsub/src/main/java/org/atmosphere/samples/pubsub/MeteorPubSub.java**
```diff
 
-        if (req.getHeader(HeaderConfig.X_ATMOSPHERE_TRANSPORT).equalsIgnoreCase(HeaderConfig.LONG_POLLING_TRANSPORT)) {
+        String header = req.getHeader(HeaderConfig.X_ATMOSPHERE_TRANSPORT);
+        if (header != null && header.equalsIgnoreCase(HeaderConfig.LONG_POLLING_TRANSPORT)) {
```
ProjectName: 5607-atmosphere
CommitID: 5d0acb978056fd4faf97f20f374adf53c09b9af1
CommitMsg: Fix for http://java.net/jira/browse/ATMOSPHERE-116
("Improve atmosphere jquery plugin to support message lenght definition: trackMessageSize")
Fix NPE

FilePath: modules/cpr/src/main/java/org/atmosphere/client/TrackMessageSizeFilter.java**
```diff
 
-        if (request.getHeader("X-Atmosphere-TrackMessageSize").equalsIgnoreCase("true") && String.class.isAssignableFrom(message.getClass())) {
+        if ("true".equalsIgnoreCase(request.getHeader("X-Atmosphere-TrackMessageSize"))
+                && message != null && String.class.isAssignableFrom(message.getClass())) {
+
```
ProjectName: 1272-flink
CommitID: f257cff0b5251b29c8540b0861855c3a73522541
CommitMsg: [hotfix] Inverse comparison order in ExecutorFactory.isCompatibleWith to avoiod NPE

FilePath: flink-clients/src/main/java/org/apache/flink/client/deployment/executors/StandaloneSessionClusterExecutorFactory.java**
```diff
 	public boolean isCompatibleWith(@Nonnull final Configuration configuration) {
-		return configuration.get(DeploymentOptions.TARGET)
-				.equalsIgnoreCase(StandaloneSessionClusterExecutor.NAME);
+		return StandaloneSessionClusterExecutor.NAME.equalsIgnoreCase(configuration.get(DeploymentOptions.TARGET));
```
ProjectName: 1272-flink
CommitID: f257cff0b5251b29c8540b0861855c3a73522541
CommitMsg: [hotfix] Inverse comparison order in ExecutorFactory.isCompatibleWith to avoiod NPE

FilePath: flink-yarn/src/main/java/org/apache/flink/yarn/executors/YarnJobClusterExecutorFactory.java**
```diff
 	public boolean isCompatibleWith(@Nonnull final Configuration configuration) {
-		return configuration.get(DeploymentOptions.TARGET)
-				.equalsIgnoreCase(YarnJobClusterExecutor.NAME);
+		return YarnJobClusterExecutor.NAME.equalsIgnoreCase(configuration.get(DeploymentOptions.TARGET));
```
ProjectName: 1272-flink
CommitID: f257cff0b5251b29c8540b0861855c3a73522541
CommitMsg: [hotfix] Inverse comparison order in ExecutorFactory.isCompatibleWith to avoiod NPE

FilePath: flink-yarn/src/main/java/org/apache/flink/yarn/executors/YarnSessionClusterExecutorFactory.java**
```diff
 	public boolean isCompatibleWith(@Nonnull final Configuration configuration) {
-		return configuration.get(DeploymentOptions.TARGET)
-				.equalsIgnoreCase(YarnSessionClusterExecutor.NAME);
+		return YarnSessionClusterExecutor.NAME.equalsIgnoreCase(configuration.get(DeploymentOptions.TARGET));
```
ProjectName: 5818-jmeter
CommitID: 13f0ef5813bcd4168daec80c946453a1b152f5f2
CommitMsg: Bug 34261 - NPE in HtmlParser (allow for missing attributes)

git-svn-id: https://svn.apache.org/repos/asf/jakarta/jmeter/branches/rel-2-2@498490 13f79535-47bb-0310-9956-ffa450edef68

Former-commit-id: 1ada125f96efa9ff044ed5d36e600d291c4cf6c6
FilePath: src/protocol/http/org/apache/jmeter/protocol/http/parser/HtmlParserHTMLParser.java**
```diff
 					LinkTagTag script = (LinkTagTag) node;
-					if (script.getAttribute(ATT_REL).equalsIgnoreCase(STYLESHEET)) {
+					if (STYLESHEET.equalsIgnoreCase(script.getAttribute(ATT_REL))) {
```
ProjectName: 7427-hive
CommitID: ce154012fc9294077445c3baeaeec8ff88125bf4
CommitMsg: HIVE-14359: Hive on Spark might fail in HS2 with LDAP authentication in a kerberized cluster (Chaoyu Tang, reviewed by Xuefu Zhang)

FilePath: spark-client/src/main/java/org/apache/hive/spark/client/SparkClientImpl.java**
```diff
 
-      if (hiveConf.getVar(HiveConf.ConfVars.HIVE_SERVER2_AUTHENTICATION).equalsIgnoreCase("kerberos")) {
+      if ("kerberos".equalsIgnoreCase(hiveConf.get(HADOOP_SECURITY_AUTHENTICATION))) {
```
ProjectName: 35532-cxf
CommitID: 53d69d2e5a7b31a292f0365b0c70a3ad804adb48
CommitMsg: Yet another update to avoid a possible NPE

git-svn-id: https://svn.apache.org/repos/asf/cxf/trunk@702248 13f79535-47bb-0310-9956-ffa450edef68

FilePath: api/src/main/java/org/apache/cxf/databinding/AbstractDataBinding.java**
```diff
         if (schemaInfo != null && (systemId == null && schemaInfo.getSystemId() == null 
-            || systemId != null && schemaInfo.getSystemId().equalsIgnoreCase(systemId))) {
+            || systemId != null && systemId.equalsIgnoreCase(schemaInfo.getSystemId()))) {
```
ProjectName: 48895-azure-sdk-for-java
CommitID: b8ac2c2d18d1811b30bdc66e4a6aa349797b1b62
CommitMsg: Fix minor build break from merge

FilePath: client-runtime/src/main/java/com/microsoft/rest/v2/RestProxy.java**
```diff
                     final TypeToken singleReturnTypeToken = TypeToken.of(singleReturnType);
-                    if (methodDetails.method().equalsIgnoreCase("HEAD")) {
+                    if (methodDetails.httpMethod().equalsIgnoreCase("HEAD")) {
```
ProjectName: 48895-azure-sdk-for-java
CommitID: b8ac2c2d18d1811b30bdc66e4a6aa349797b1b62
CommitMsg: Fix minor build break from merge

FilePath: client-runtime/src/main/java/com/microsoft/rest/v2/RestProxy.java**
```diff
             final HttpResponse response = httpClient.sendRequest(request);
-            if (returnType.equals(Void.TYPE) || !response.hasBody() || methodDetails.method().equalsIgnoreCase("HEAD")) {
+            if (returnType.equals(Void.TYPE) || !response.hasBody() || methodDetails.httpMethod().equalsIgnoreCase("HEAD")) {
```
ProjectName: 132-retrofit
CommitID: db20a59b2819fbe4fe7e9a8478b726b592dc3971
CommitMsg: Remove usage of HTTP constants class from Apache dependency.

FilePath: retrofit/src/main/java/retrofit/http/RestAdapter.java**
```diff
         for (Header header : headers) {
-          if (HTTP.CONTENT_TYPE.equalsIgnoreCase(header.getName()) //
+          if ("Content-Type".equalsIgnoreCase(header.getName()) //
```

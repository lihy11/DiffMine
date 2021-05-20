###  infomation 
method del:
-java.util.Map.keySet()
method add：
+java.util.Map$Entry.getKey()
+java.util.Map$Entry.getValue()
+java.util.Map.entrySet()
###  support count
project count : 14
commit count : 17
###  code
ProjectName: 40863-isis
CommitID: 820bc8095ef9f488c7abd6e846a0649a4ae14327
CommitMsg: ISIS-1135 Make a copy of the PojoAdapter and OidAdapter maps for debugging purposes to avoid ConcurrentModificationException caused by loading/unloading an entity

FilePath: core/runtime/src/main/java/org/apache/isis/core/runtime/persistence/adaptermanager/PojoAdapterHashMap.java**
```diff
         int count = 0;
-        for (final Object pojo : adapterByPojoMap.keySet()) {
-            final ObjectAdapter object = adapterByPojoMap.get(pojo);
+        final Map<Object, ObjectAdapter> copyForDebug = Maps.newHashMap(adapterByPojoMap);
+        for (final Map.Entry<Object, ObjectAdapter> entry : copyForDebug.entrySet()) {
+            Object pojo = entry.getKey();
+            final ObjectAdapter object = entry.getValue();
```
ProjectName: 32143-checkstyle-idea
CommitID: b6fe1dd39036ff05aa22c5d578098ead88c18ae6
CommitMsg: squid:S2864 - 'entrySet()' should be iterated when both the key and value are needed (#251)


FilePath: src/main/java/org/infernus/idea/checkstyle/checker/ListPropertyResolver.java**
```diff
 
-        for (final String propertyName : properties.keySet()) {
-            setProperty(propertyName, properties.get(propertyName));
+        for (final Map.Entry<String, String> propertieEntry : properties.entrySet()) {
+            setProperty(propertieEntry.getKey(), propertieEntry.getValue());
```
ProjectName: 32143-checkstyle-idea
CommitID: b6fe1dd39036ff05aa22c5d578098ead88c18ae6
CommitMsg: squid:S2864 - 'entrySet()' should be iterated when both the key and value are needed (#251)


FilePath: src/main/java/org/infernus/idea/checkstyle/checker/CheckerFactory.java**
```diff
             final Map<String, String> propertiesToValues = listResolver.getPropertyNamesToValues();
-            for (final String propertyName : propertiesToValues.keySet()) {
-                final String propertyValue = propertiesToValues.get(propertyName);
-                LOG.debug("- Property: " + propertyName + "=" + propertyValue);
+            for (final Map.Entry<String, String> propertyEntry : propertiesToValues.entrySet()) {
+                final String propertyValue = propertyEntry.getValue();
+                LOG.debug("- Property: " + propertyEntry.getKey() + "=" + propertyValue);
```
ProjectName: 38660-guacamole-client
CommitID: 8e3a73a9a2ac0070471edd98f5480b717fc7c2c5
CommitMsg: Ticket #362: Fixed inefficient map iteration.

FilePath: guacamole/src/main/java/org/glyptodon/guacamole/net/basic/rest/connection/APIConnectionWrapper.java**
```diff
         
-        for(String key : parameters.keySet())
-            configuration.setParameter(key, parameters.get(key));
+        for(Map.Entry<String, String> entry : parameters.entrySet())
+            configuration.setParameter(entry.getKey(), entry.getValue());
```
ProjectName: 20458-Jupiter
CommitID: 5efad6220a4728a4a812fcae0cee646e588f64d5
CommitMsg: Initial commit

FilePath: jupiter-common/src/main/java/org/jupiter/common/util/Reflects.java**
```diff
     static {
-        for (final Class<?> primitiveClass : primitiveWrapperMap.keySet()) {
-            final Class<?> wrapperClass = primitiveWrapperMap.get(primitiveClass);
+        for (Map.Entry<Class<?>, Class<?>> entry : primitiveWrapperMap.entrySet()) {
+            final Class<?> wrapperClass = entry.getValue();
+            final Class<?> primitiveClass = entry.getKey();
```
ProjectName: 24493-smarthome
CommitID: 43c921c49d8ad2ae991537cce6aa7ac7a539a8c2
CommitMsg: fix nullness annotations for automation commands utils (#4319)

Signed-off-by: Markus Rathgeb <maggu2810@gmail.com>
FilePath: bundles/automation/org.eclipse.smarthome.automation.commands/src/main/java/org/eclipse/smarthome/automation/internal/commands/Utils.java**
```diff
         Hashtable<String, String> filtered = new Hashtable<String, String>();
-        for (String id : listUIDs.keySet()) {
-            String uid = listUIDs.get(id);
+        for (final Entry<String, String> entry : listUIDs.entrySet()) {
+            final String id = entry.getKey();
+            final String uid = entry.getValue();
```
ProjectName: 26506-spoon
CommitID: ee2f5955a669c894a0b927dfa973b0048aa6df32
CommitMsg: refactor: change keySet to entrySet to improve performance (#2539)


FilePath: src/main/java/spoon/support/compiler/SnippetCompilationHelper.java**
```diff
 		// and we replace the snippets
-		for (CtPath p : elements2before.keySet()) {
-			CtElement toReplace = elements2before.get(p);
-			toReplace.replace(elements2after.get(p));
+		for (Map.Entry<CtPath, CtElement> ctPath : elements2before.entrySet()) {
+			CtElement toReplace = ctPath.getValue();
+			toReplace.replace(elements2after.get(ctPath.getKey()));
```
ProjectName: 12435-commafeed
CommitID: caff34cc3b6eb89e78071f9133a00fc9914a8b0a
CommitMsg: small perf boost

FilePath: src/main/java/com/commafeed/backend/feed/FeedUtils.java**
```diff
 		String result = source;
-		for (String entity : HtmlEntities.NUMERIC_MAPPING.keySet()) {
-			result = StringUtils.replace(result, entity, HtmlEntities.NUMERIC_MAPPING.get(entity));
+		for (Map.Entry<String, String> entry : HtmlEntities.NUMERIC_MAPPING.entrySet()) {
+			result = StringUtils.replace(result, entry.getKey(), entry.getValue());
```
ProjectName: 1104-cat
CommitID: 5b8a62c1a8397638aa16594110da193030839077
CommitMsg: code review

FilePath: cat-consumer/src/main/java/com/dianping/cat/consumer/failure/FailureReportAnalyzer.java**
```diff
 		oldSegments.clear();
-		for (String key : newSegments.keySet()) {
-			oldSegments.put(key, newSegments.get(key));
+		for (java.util.Map.Entry<String, Segment> entry : newSegments.entrySet()) {
+			oldSegments.put(entry.getKey(), newSegments.get(entry.getValue()));
```
ProjectName: 4155-zeppelin
CommitID: 79a53129e887ac749c5d165b318207c9d8ddbe12
CommitMsg: [ZEPPELIN-2320] fixing test + modifying map browsing

### What is this PR for?
fixing String comparison and improving map browsing

### What type of PR is it?
Bug Fix

### Todos
* [ ] - Task

### What is the Jira issue?
[ZEPPELIN-2320](https://issues.apache.org/jira/browse/ZEPPELIN-2320)

### How should this be tested?
build with tests.

### Screenshots (if appropriate)

### Questions:
* Does the licenses files need update? No
* Is there breaking changes for older versions? No
* Does this needs documentation? No

Author: Remilito <remy.gayet@gmail.com>

Closes #2192 from Remilito/ZEPPELIN-2320 and squashes the following commits:

9ad16bc [Remilito] [ZEPPELIN-2320] fixing test + modifying map browsing

FilePath: zeppelin-server/src/main/java/org/apache/zeppelin/rest/NotebookRestApi.java**
```diff
     Map<String, Object> origConfig = p.getConfig();
-    for (String key : newConfig.keySet()) {
-      origConfig.put(key, newConfig.get(key));
+    for ( final Map.Entry<String, Object> entry : newConfig.entrySet()){
+      origConfig.put(entry.getKey(), entry.getValue());
```
ProjectName: 9531-nutz
CommitID: 9e2bcbf839aa625d6ad51784ac46c7799c363ba9
CommitMsg: 

git-svn-id: http://nutz.googlecode.com/svn/trunk@945 423f10f2-e3a4-11dd-a6ea-a32d6b26a33d

FilePath: src/org/nutz/http/Header.java**
```diff
 		if (null != map)
-			for (String key : map.keySet())
-				set(key, map.get(key));
+			for (Entry<String, String> entry : map.entrySet())
+				set(entry.getKey(), entry.getValue());
```
ProjectName: 1272-flink
CommitID: 8a5271e29f664dac27c95eb8e7df2ae9be76b592
CommitMsg: [FLINK-10189] Fix inefficient use of keySet iterators


FilePath: flink-runtime/src/main/java/org/apache/flink/runtime/state/ttl/TtlMapState.java**
```diff
 		Map<UK, TtlValue<UV>> ttlMap = new HashMap<>(map.size());
-		for (UK key : map.keySet()) {
-			ttlMap.put(key, wrapWithTs(map.get(key)));
+		for (Map.Entry<UK, UV> entry : map.entrySet()) {
+			UK key = entry.getKey();
+			ttlMap.put(key, wrapWithTs(entry.getValue()));
```
ProjectName: 6424-hbase
CommitID: 13e9eda3e7290d16b9370a644d7ef4d5c745c50f
CommitMsg: HBASE-9856 Fix some findbugs Performance Warnings



git-svn-id: https://svn.apache.org/repos/asf/hbase/trunk@1546888 13f79535-47bb-0310-9956-ffa450edef68

FilePath: hbase-server/src/main/java/org/apache/hadoop/hbase/regionserver/wal/WALEditsReplaySink.java**
```diff
     // replaying edits by region
-    for (HRegionInfo curRegion : entriesByRegion.keySet()) {
-      List<HLog.Entry> allActions = entriesByRegion.get(curRegion);
+    for (Map.Entry<HRegionInfo, List<HLog.Entry>> _entry : entriesByRegion.entrySet()) {
+      HRegionInfo curRegion = _entry.getKey();
+      List<HLog.Entry> allActions = _entry.getValue();
```
ProjectName: 6424-hbase
CommitID: 8bc2888278b75a525fb6898386b61bef78a114ac
CommitMsg: HBASE-2140 findbugs issues - 2 performance warnings as suggested by findbugs

git-svn-id: https://svn.apache.org/repos/asf/hadoop/hbase/trunk@900208 13f79535-47bb-0310-9956-ffa450edef68

FilePath: src/java/org/apache/hadoop/hbase/client/Scan.java**
```diff
     Map<byte[], NavigableSet<byte[]>> fams = scan.getFamilyMap();
-    for (byte[] fam : fams.keySet()) {
-      NavigableSet<byte[]> cols = fams.get(fam);
+    for (Map.Entry<byte[],NavigableSet<byte[]>> entry : fams.entrySet()) {
+      byte [] fam = entry.getKey();
+      NavigableSet<byte[]> cols = entry.getValue();
```
ProjectName: 5818-jmeter
CommitID: 8c9328ca6c0ba59a80ba96d96a3d0f50219230b2
CommitMsg: Use Map#entrySet instead of keySet
FilePath: src/protocol/mail/src/main/java/org/apache/jmeter/protocol/smtp/sampler/gui/SmtpPanel.java**
```diff
         result.setName(SmtpSampler.HEADER_FIELDS);
-        for (JTextField headerName : headerFields.keySet()) {
-            String name = headerName.getText();
-            String value = headerFields.get(headerName).getText();
+        for (Map.Entry<JTextField, JTextField> header : headerFields.entrySet()) {
+            String name = header.getKey().getText();
+            String value = header.getValue().getText();
```
ProjectName: 25739-poi
CommitID: 72834dfffa0c90b9d7866b0dc683aac4673492dd
CommitMsg: FindBugs fixes

git-svn-id: https://svn.apache.org/repos/asf/poi/trunk@1711708 13f79535-47bb-0310-9956-ffa450edef68

FilePath: src/java/org/apache/poi/ss/formula/CollaboratingWorkbooksEnvironment.java**
```diff
         Map<String, WorkbookEvaluator> evaluatorsByName = new HashMap<String, WorkbookEvaluator>(evaluators.size());
-        for (String wbName : evaluators.keySet()) {
-            FormulaEvaluator eval = evaluators.get(wbName);
+        for (Map.Entry<String,FormulaEvaluator> swb : evaluators.entrySet()) {
+            String wbName = swb.getKey();
+            FormulaEvaluator eval = swb.getValue();
```
ProjectName: 25739-poi
CommitID: 72834dfffa0c90b9d7866b0dc683aac4673492dd
CommitMsg: FindBugs fixes

git-svn-id: https://svn.apache.org/repos/asf/poi/trunk@1711708 13f79535-47bb-0310-9956-ffa450edef68

FilePath: src/java/org/apache/poi/hpsf/MutableSection.java**
```diff
         int length = TypeWriter.writeUIntToStream(out, dictionary.size());
-        for (final Iterator<Long> i = dictionary.keySet().iterator(); i.hasNext();)
-        {
-            final Long key = i.next();
-            final String value = dictionary.get(key);
+        for (Map.Entry<Long,String> ls : dictionary.entrySet()) {
+            final Long key = ls.getKey();
+            final String value = ls.getValue();
```

###  infomation 
method del:
-java.util.Map.keySet()
method add：
+java.util.Map.entrySet()
###  support count
project count : 22
commit count : 35
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
ProjectName: 36420-jena
CommitID: 84d99ae0689a1e833e54fb0a341a4a8107621657
CommitMsg: modified writePrefixes so that it doesn't need to retrieve the value from the map

FilePath: jena-core/src/main/java/org/apache/jena/n3/N3JenaWriterCommon.java**
```diff
     {
-        for ( String p : prefixMap.keySet() )
+        for ( Entry<String, String> entry : prefixMap.entrySet() )
```
ProjectName: 22223-pdfbox
CommitID: 41d8aee0a5db617e3be2fb5cccce27273610afe7
CommitMsg: PDFBOX-2852: use entrySet instead of keySet to retrieve Map values

git-svn-id: https://svn.apache.org/repos/asf/pdfbox/trunk@1696069 13f79535-47bb-0310-9956-ffa450edef68

FilePath: pdfbox/src/main/java/org/apache/pdfbox/pdfparser/COSParser.java**
```diff
                     Map<COSObjectKey, Long> xrefOffset = xrefTrailerResolver.getXrefTable();
-                    for (COSObjectKey key : bfSearchCOSObjectKeyOffsets.keySet())
+                    final Set<Map.Entry<COSObjectKey, Long>> entries = bfSearchCOSObjectKeyOffsets.entrySet();
+                    for (Entry<COSObjectKey, Long> entry : entries)
```
ProjectName: 22223-pdfbox
CommitID: 640d2f9cebe69143e2cc0f84c41d6f0521253480
CommitMsg: PDFBOX-2576: avoid inefficient use of keySet iterator instead of entrySet iterator

git-svn-id: https://svn.apache.org/repos/asf/pdfbox/trunk@1650806 13f79535-47bb-0310-9956-ffa450edef68

FilePath: pdfbox/src/main/java/org/apache/pdfbox/pdmodel/font/encoding/Type1Encoding.java**
```diff
 
-        for (Integer code : codeToName.keySet())
+        for (Map.Entry<Integer, String> entry : codeToName.entrySet())
```
ProjectName: 22223-pdfbox
CommitID: e3eaabbe9aef07c0ddcfcb890f3c3836be081015
CommitMsg: PDFBOX-2576: avoid inefficient use of keySet iterator instead of entrySet iterator

git-svn-id: https://svn.apache.org/repos/asf/pdfbox/trunk@1650805 13f79535-47bb-0310-9956-ffa450edef68

FilePath: pdfbox/src/main/java/org/apache/pdfbox/pdmodel/common/COSDictionaryMap.java**
```diff
         COSDictionary dic = new COSDictionary();
-        for (String name : someMap.keySet())
+        for (Entry<String, ?> entry : someMap.entrySet())
```
ProjectName: 22223-pdfbox
CommitID: 0ccf479b4e1aa0398e8093c6c34a60f293e4020c
CommitMsg: PDFBOX-2576: avoid inefficient use of keySet iterator instead of entrySet iterator

git-svn-id: https://svn.apache.org/repos/asf/pdfbox/trunk@1650804 13f79535-47bb-0310-9956-ffa450edef68

FilePath: examples/src/main/java/org/apache/pdfbox/examples/pdmodel/ExtractEmbeddedFiles.java**
```diff
     {
-        for (String filename : names.keySet())
+        for (Entry<String,COSObjectable> entry : names.entrySet())
```
ProjectName: 22223-pdfbox
CommitID: a53a9a22d3623b623041c062a053423872e92a6a
CommitMsg: PDFBOX-2576: avoid inefficient use of keySet iterator instead of entrySet iterator

git-svn-id: https://svn.apache.org/repos/asf/pdfbox/trunk@1650801 13f79535-47bb-0310-9956-ffa450edef68

FilePath: pdfbox/src/main/java/org/apache/pdfbox/pdfparser/NonSequentialPDFParser.java**
```diff
         {
-            for (COSObjectKey objectKey : xrefOffset.keySet())
+            for (Entry<COSObjectKey, Long> objectEntry : xrefOffset.entrySet())
```
ProjectName: 22223-pdfbox
CommitID: 3b0d9da6f96321610d320b8c166de83c5d5d5353
CommitMsg: PDFBOX-2576: avoid inefficient use of keySet iterator instead of entrySet iterator

git-svn-id: https://svn.apache.org/repos/asf/pdfbox/trunk@1650798 13f79535-47bb-0310-9956-ffa450edef68

FilePath: pdfbox/src/main/java/org/apache/pdfbox/pdmodel/documentinterchange/logicalstructure/PDStructureTreeRoot.java**
```diff
         COSDictionary rmDic = new COSDictionary();
-        for (String key : roleMap.keySet())
+        for (Map.Entry<String, String> entry : roleMap.entrySet())
```
ProjectName: 22223-pdfbox
CommitID: 56991861f5905d2c31d162f166cd869f7baf8dd0
CommitMsg: PDFBOX-1308: fixed the getImages implementation so that it no longer returns an empty set as proposed by Ian Holsman

git-svn-id: https://svn.apache.org/repos/asf/pdfbox/trunk@1337895 13f79535-47bb-0310-9956-ffa450edef68

FilePath: pdfbox/src/main/java/org/apache/pdfbox/pdmodel/PDResources.java**
```diff
             images = new HashMap<String,PDXObjectImage>();
-            for( String imageName : allXObjects.keySet() )
+            for( Map.Entry<String,PDXObject> entry: allXObjects.entrySet() )
```
ProjectName: 23045-UniversalMediaServer
CommitID: b956918325c7445262e8f05bf434507c02193260
CommitMsg: Use more efficient an entrySet iterator
FilePath: src/main/java/net/pms/configuration/FormatConfiguration.java**
```diff
 			if (extras != null && miExtras != null) {
-				Iterator<String> keyIt = extras.keySet().iterator();
+				Iterator<Entry<String, String>> keyIt = extras.entrySet().iterator();
```
ProjectName: 21302-phpinspectionsea
CommitID: 6020eeabf0f3cd3a053db224091c3c661a9cb6cc
CommitMsg: [#754] NullPointerExceptionInspector: SCA, fixed 2 performance warnings

FilePath: src/main/java/com/kalessil/phpStorm/phpInspectionsEA/inspectors/semanticalAnalysis/npe/strategy/ChainedCallsStrategy.java**
```diff
                             boolean isNullTested = false;
-                            for (final MethodReference nullTestedReference : nullTestedReferences.keySet()) {
-                                final String nullTestedMethodName = nullTestedReferences.get(nullTestedReference);
+                            for (final Map.Entry<MethodReference, String> knownReference : nullTestedReferences.entrySet()) {
+                                final String nullTestedMethodName = knownReference.getValue();
```
ProjectName: 21302-phpinspectionsea
CommitID: 6020eeabf0f3cd3a053db224091c3c661a9cb6cc
CommitMsg: [#754] NullPointerExceptionInspector: SCA, fixed 2 performance warnings

FilePath: src/main/java/com/kalessil/phpStorm/phpInspectionsEA/inspectors/semanticalAnalysis/npe/strategy/NullableVariablesStrategy.java**
```diff
         final Project project                           = holder.getProject();
-        for (final String variableName : assignments.keySet()) {
-            final List<AssignmentExpression> variableAssignments = assignments.get(variableName);
+        for (final Map.Entry<String, List<AssignmentExpression>> knownAssignment : assignments.entrySet()) {
+            final List<AssignmentExpression> variableAssignments = knownAssignment.getValue();
```
ProjectName: 21374-psi-probe
CommitID: e5dee5f631964e092d5537aa8929bdad1efefd35
CommitMsg: [ci] Use entrySet rather than keySet

FilePath: core/src/main/java/psiprobe/model/stats/StatsCollection.java**
```diff
 
-            for (String key : stats.keySet()) {
-              List<XYDataItem> list = stats.get(key);
+            for (Entry<String, List<XYDataItem>> set : stats.entrySet()) {
+              List<XYDataItem> list = set.getValue();
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
ProjectName: 10008-transmittable-thread-local
CommitID: ada902048f550a6e0dc10d4be82c3f4f4183ddb6
CommitMsg: Use entrySet instead of keySet to traverse KV maps

Improve performance, more info see Alibaba Java Coding Guidelines
Item 12 of Collection section

Merge pull request #87 from lispking/master

FilePath: src/main/java/com/alibaba/ttl/TransmittableThreadLocal.java**
```diff
         Map<TransmittableThreadLocal<?>, Object> copy = new HashMap<>();
-        for (TransmittableThreadLocal<?> threadLocal : holder.get().keySet()) {
+        for (Map.Entry<TransmittableThreadLocal<?>, ?> entry : holder.get().entrySet()) {
+            TransmittableThreadLocal<?> threadLocal = entry.getKey();
+
```
ProjectName: 29579-Payara
CommitID: f8256b8762ac9a5ed74ffd94c391f2c7849b2839
CommitMsg: fix findbugs error WMI_WRONG_MAP_ITERATOR.

git-svn-id: https://svn.java.net/svn/glassfish~svn/trunk/main@58835 6f3ba3e3-413c-0410-a8aa-90bee3ab43b5

FilePath: appserver/admingui/common/src/main/java/org/glassfish/admingui/common/handlers/LoggingHandlers.java**
```diff
         try{
-            for(String key : attrs.keySet()){
+            for (Map.Entry<String, Object> e : attrs.entrySet()) {
+                String key=e.getKey();
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
ProjectName: 1272-flink
CommitID: 8a5271e29f664dac27c95eb8e7df2ae9be76b592
CommitMsg: [FLINK-10189] Fix inefficient use of keySet iterators


FilePath: flink-connectors/flink-hbase/src/main/java/org/apache/flink/addons/hbase/HBaseTableSource.java**
```diff
 			Map<String, TypeInformation<?>> familyInfo = hBaseSchema.getFamilyInfo(family);
-			for (String qualifier : familyInfo.keySet()) {
+			for (Map.Entry<String, TypeInformation<?>> entry : familyInfo.entrySet()) {
```
ProjectName: 6424-hbase
CommitID: cc4301ca0842d9c3f66dfa39c5627744f5f91a8c
CommitMsg: HBASE-18268 Eliminate the findbugs warnings for hbase-client

FilePath: hbase-client/src/main/java/org/apache/hadoop/hbase/client/ColumnFamilyDescriptorBuilder.java**
```diff
         boolean printComma = false;
-        for (Bytes k : values.keySet()) {
+        for (Map.Entry<Bytes, Bytes> entry : values.entrySet()) {
+          Bytes k = entry.getKey();
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
ProjectName: 5818-jmeter
CommitID: 3a4d3cfe0f048599541cfdf0f35b00c5164b0e76
CommitMsg: Use better iteration way

git-svn-id: https://svn.apache.org/repos/asf/jmeter/trunk@1663109 13f79535-47bb-0310-9956-ffa450edef68

Former-commit-id: 382886509e429042b4fe0213ff531a812ad15b0f
FilePath: src/protocol/http/org/apache/jmeter/protocol/http/proxy/HttpRequestHdr.java**
```diff
         HeaderManager manager = new HeaderManager();
-        for (String key : headers.keySet()) {
+        for (Map.Entry<String, Header> entry : headers.entrySet()) {
+            final String key = entry.getKey();
```
ProjectName: 15657-metadata-extractor
CommitID: 1c9a6c18ab67a091057d8f6d6dcfaa902bb30652
CommitMsg: Improve map iteration performance.

FilePath: Source/com/drew/tools/ProcessAllImagesInFolderUtility.java**
```diff
 
-            for (String extension : _rowListByExtension.keySet()) {
+            for (Map.Entry<String, List<Row>> entry : _rowListByExtension.entrySet()) {
+                String extension = entry.getKey();
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

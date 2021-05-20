###  infomation 
method del:
-java.util.Map.get()
method add：
+java.util.Map.getOrDefault()
###  support count
project count : 9
commit count : 11
###  code
ProjectName: 33009-Recaf
CommitID: 38884e4cfd4fdcf59352a89ffd8bbdc2f8ace386
CommitMsg: Should fix the follow-up error mentioned in #135 with the giant stack-trace

FilePath: src/main/java/me/coley/recaf/bytecode/insn/NamedLabelRefInsn.java**
```diff
 			} else if(ain instanceof LabelNode) {
-				copy.add(replace = labels.get(ain));
+				// TODO: Why does the 'labels' map not have a mapping for this instruction?
+				// Looking at this method's usage, this case should NEVER be called in the
+				// assembler since labels should be compiled to NamedLabelRefInsn...
+				copy.add(replace = labels.getOrDefault(ain, new LabelNode()));
```
ProjectName: 36169-takes
CommitID: b702b35028e8742f09b68e1296781f27ae172a34
CommitMsg: Removing more nulls (#917)

FilePath: src/main/java/org/takes/facets/cookies/RqCookies.java**
```diff
             final Map<String, String> map = this.map();
-            final String value = map.get(
-                new EnglishLowerCase(key.toString()).string()
+            final String value = map.getOrDefault(
+                new EnglishLowerCase(key.toString()).string(),
+                ""
```
ProjectName: 29579-Payara
CommitID: 256e207bd2c15811042f07420d2c20353d35c119
CommitMsg: Using Map.getOrDefault() to avoid calling get() twice
FilePath: nucleus/hk2/hk2-config/src/main/java/org/jvnet/hk2/config/ConfigModel.java**
```diff
     private static List<String> getMetadataFromDescription(Map<String, List<String>> map, String key) {
-        return map.get(key) == null ? Collections.emptyList() : map.get(key);
+        return map.getOrDefault(key, Collections.emptyList());
```
ProjectName: 18172-AsciidocFX
CommitID: a5b3f96dfc849665a8be541ed098f679dcb564cd
CommitMsg: Default charset UTF-8

FilePath: src/main/java/com/kodedu/other/IOHelper.java**
```diff
     public static Optional<Exception> writeToFile(Path path, String content, StandardOpenOption... openOption) {
-        String charset = pathCharsetMap.get(path);
+        String charset = pathCharsetMap.getOrDefault(path, "UTF-8");
```
ProjectName: 2306-metrics
CommitID: bee6db3b0b5bcdb48954e5f30e0ab5c40df0cb78
CommitMsg: Simplify dealing with maps in JmxReporter

Use `Map.getDefault` API instead of a ternary operator with `contains`.

FilePath: metrics-jmx/src/main/java/com/codahale/metrics/jmx/JmxReporter.java**
```diff
         public TimeUnit durationFor(String name) {
-            return durationOverrides.containsKey(name) ? durationOverrides.get(name) : defaultDuration;
+            return durationOverrides.getOrDefault(name, defaultDuration);
```
ProjectName: 2306-metrics
CommitID: bee6db3b0b5bcdb48954e5f30e0ab5c40df0cb78
CommitMsg: Simplify dealing with maps in JmxReporter

Use `Map.getDefault` API instead of a ternary operator with `contains`.

FilePath: metrics-jmx/src/main/java/com/codahale/metrics/jmx/JmxReporter.java**
```diff
         public TimeUnit rateFor(String name) {
-            return rateOverrides.containsKey(name) ? rateOverrides.get(name) : defaultRate;
+            return rateOverrides.getOrDefault(name, defaultRate);
```
ProjectName: 7108-google-java-format
CommitID: 8a5c63722100e4703893fd32a87eeaee0addad95
CommitMsg: More Java 8 cleanup

MOE_MIGRATED_REVID=171837101

FilePath: core/src/main/java/com/google/googlejavaformat/java/JavaOutput.java**
```diff
        */
-      BlankLineWanted wanted = firstNonNull(blankLines.get(lastK), BlankLineWanted.NO);
+      BlankLineWanted wanted = blankLines.getOrDefault(lastK, BlankLineWanted.NO);
```
ProjectName: 2763-storm
CommitID: 4605ae0a34858309171e726e1924b9a37695c977
CommitMsg: Merge branch 'STORM-3223' of https://github.com/revans2/incubator-storm into STORM-3223

STORM-3223: Fix NPE on blacklisted rack

This closes #2830

FilePath: storm-server/src/main/java/org/apache/storm/scheduler/resource/strategies/scheduling/BaseResourceAwareStrategy.java**
```diff
             return cachedNodes.computeIfAbsent(rackId,
-                (rid) -> sortNodes(rackIdToNodes.get(rid), exec, td, rid, perNodeScheduledCount));
+                (rid) -> sortNodes(rackIdToNodes.getOrDefault(rid, Collections.emptyList()), exec, td, rid, perNodeScheduledCount));
```
ProjectName: 2763-storm
CommitID: 6d58e63eb085ef21adf9170fbc3e9eb93db0c621
CommitMsg: STORM-3223: Fix NPE on blacklisted rack

FilePath: storm-server/src/main/java/org/apache/storm/scheduler/resource/strategies/scheduling/BaseResourceAwareStrategy.java**
```diff
             return cachedNodes.computeIfAbsent(rackId,
-                (rid) -> sortNodes(rackIdToNodes.get(rid), exec, td, rid, perNodeScheduledCount));
+                (rid) -> sortNodes(rackIdToNodes.getOrDefault(rid, Collections.emptyList()), exec, td, rid, perNodeScheduledCount));
```
ProjectName: 35532-cxf
CommitID: b11ba45f602ee0986cabd2020deb7e56b4f39bc5
CommitMsg: Fixing OpenJDK 12 compiler assertion (jdk.compiler/com.sun.tools.javac.util.Assert.error(Assert.java:155))

FilePath: rt/rs/extensions/json-basic/src/main/java/org/apache/cxf/jaxrs/json/basic/JsonMapObject.java**
```diff
             }
-            Integer count = updateCount.get(name);
-            count = count == null ? 2 : count++;
+            final Integer count = updateCount.getOrDefault(name, 1) + 1;
```
ProjectName: 38627-presto
CommitID: be6815e2f4239c67011698739055eefff4cf1a75
CommitMsg: Fix bugs in AddExchanges and constant optimizations

FilePath: presto-main/src/main/java/com/facebook/presto/sql/planner/optimizations/PropertyDerivations.java**
```diff
                 if (value instanceof QualifiedNameReference) {
-                    value = constants.get(Symbol.fromQualifiedName(((QualifiedNameReference) value).getName()));
+                    Symbol symbol = Symbol.fromQualifiedName(((QualifiedNameReference) value).getName());
+                    value = constants.getOrDefault(symbol, value);
```

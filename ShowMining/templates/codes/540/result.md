###  infomation 
method del:
-java.util.Map.get()
method add：
+java.util.Map.computeIfAbsent()
###  support count
project count : 10
commit count : 11
###  code
ProjectName: 43407-portfolio
CommitID: de13829f163d3f9b42a25f72490f0a038cf583a9
CommitMsg: Fix lookup of latest quote from HTML table if 'use as historic' flag is set

FilePath: name.abuchen.portfolio.ui/src/name/abuchen/portfolio/ui/UpdateQuotesJob.java**
```diff
 
-            List<Security> l = feed2securities.get(feedId);
-            if (l == null)
-                feed2securities.put(feedId, l = new ArrayList<Security>());
-            l.add(s);
+            feed2securities.computeIfAbsent(feedId, key -> new ArrayList<Security>()).add(s);
```
ProjectName: 36420-jena
CommitID: c88bb3bd1abe6075ae1ee51b565783b4e630a7ed
CommitMsg: Use computeIfAbsent

FilePath: jena-arq/src/main/java/org/apache/jena/riot/lang/BlankNodeAllocatorGlobal.java**
```diff
     public Node alloc(String label) {
-        Node b = map.get(label);
-        if ( b == null ) {
-            b = create();
-            map.put(label, b);
-        }
-        return b;
+        return map.computeIfAbsent(label, x->create());
```
ProjectName: 21302-phpinspectionsea
CommitID: 4fd0a07aac8b6664b0f922c4f80e8f5b91952f61
CommitMsg: Code grooming: use computeIfAbsent where possible.

FilePath: src/main/java/com/kalessil/phpStorm/phpInspectionsEA/inspectors/semanticalAnalysis/npe/strategy/NullableVariablesStrategy.java**
```diff
                 ) {
-                    if (!assignments.containsKey(variableName)) {
-                        assignments.put(variableName, new ArrayList<>());
-                    }
-                    assignments.get(variableName).add(assignment);
+                    assignments.computeIfAbsent(variableName, v -> new ArrayList<>()).add(assignment);
```
ProjectName: 21302-phpinspectionsea
CommitID: 5dc875ad9cf7bffccaea10d56336134ba08fd2bc
CommitMsg: Code grooming: use computeIfAbsent where possible.

FilePath: src/main/java/com/kalessil/phpStorm/phpInspectionsEA/inspectors/semanticalAnalysis/npe/strategy/NullableVariablesStrategy.java**
```diff
                 ) {
-                    if (!assignments.containsKey(variableName)) {
-                        assignments.put(variableName, new ArrayList<>());
-                    }
-                    assignments.get(variableName).add(assignment);
+                    assignments.computeIfAbsent(variableName, v -> new ArrayList<>()).add(assignment);
```
ProjectName: 12210-speedment
CommitID: c25087948d5f2f47c9662fc3b15a8a44d0039eaa
CommitMsg: Fix bug with NullpointerException in GUI

FilePath: src/main/java/com/speedment/internal/core/config/PluginDataImpl.java**
```diff
     public Optional<Child<PluginData>> add(Child<PluginData> child) {
-        final ChildHolder<Child<PluginData>> holder = children.get(child.getInterfaceMainClass());
+        final ChildHolder<Child<PluginData>> holder = children.computeIfAbsent(
+            child.getInterfaceMainClass(),
+            clazz -> new ChildHolderImpl<>((Class<Child<PluginData>>) clazz)
+        );
+        
```
ProjectName: 4948-spring-security
CommitID: 7b2a7847e5cad1e75dac59fa7839d4f73c897b82
CommitMsg: Java 8: Single Map method can be used

FilePath: web/src/main/java/org/springframework/security/web/savedrequest/DefaultSavedRequest.java**
```diff
 	private void addHeader(String name, String value) {
-		List<String> values = headers.get(name);
-
-		if (values == null) {
-			values = new ArrayList<>();
-			headers.put(name, values);
-		}
+		List<String> values = headers.computeIfAbsent(name, k -> new ArrayList<>());
```
ProjectName: 7280-mpush
CommitID: 0e67f51d668df4c9db884e5050c985ed6fa04d88
CommitMsg: udp gateway 模式下取消redis踢人消息订阅

FilePath: mpush-cache/src/main/java/com/mpush/cache/redis/listener/ListenerDispatcher.java**
```diff
     public void subscribe(String channel, MessageListener listener) {
-        List<MessageListener> listeners = subscribes.get(channel);
-        if (listeners == null) {
-            listeners = Lists.newArrayList();
-            subscribes.put(channel, listeners);
-        }
-        listeners.add(listener);
+        subscribes.computeIfAbsent(channel, k -> Lists.newArrayList()).add(listener);
```
ProjectName: 7593-javaparser
CommitID: 764fb2da14f6b1efc8ce598f027e39d43c970d21
CommitMsg: Use a WeakHashMap to avoid memory leaks without explicit calls of the 'clearInstances' method

FilePath: java-symbol-solver-core/src/main/java/com/github/javaparser/symbolsolver/javaparsermodel/JavaParserFacade.java**
```diff
     public static JavaParserFacade get(TypeSolver typeSolver) {
-        if (!instances.containsKey(typeSolver)) {
-            instances.put(typeSolver, new JavaParserFacade(typeSolver));
-        }
-        return instances.get(typeSolver);
+        return instances.computeIfAbsent(typeSolver, JavaParserFacade::new);
```
ProjectName: 5827-MinecraftForge
CommitID: dd0c251b3d4b2058d35456a1a7e85b3ebc160449
CommitMsg: Fix ModList cache never being updated (#5081)


FilePath: src/main/java/net/minecraftforge/fml/relauncher/libraries/ModList.java**
```diff
             String key = json.getCanonicalFile().getAbsolutePath();
-            if (cache.containsKey(key))
-                return cache.get(key);
+            return cache.computeIfAbsent(key, k -> new ModList(json, mcdir));
```
ProjectName: 8021-reactor-core
CommitID: 255baf338f1429c42b83c118dc89ce2d494c7912
CommitMsg: use computeIfAbsent instead of verbose null check (#396)


FilePath: src/main/java/reactor/core/publisher/Flux.java**
```diff
 			K key = keyExtractor.apply(d);
-			Collection<V> values = m.get(key);
-			if(values == null){
-				values = new ArrayList<>();
-				m.put(key, values);
-			}
+			Collection<V> values = m.computeIfAbsent(key, k -> new ArrayList<>());
```
ProjectName: 16050-optaplanner
CommitID: 334d363d429cbef70159f95ee6c1c610a05bcc55
CommitMsg: Use computeIfAbsent()

FilePath: optaplanner-core/src/main/java/org/optaplanner/core/impl/heuristic/selector/entity/pillar/DefaultPillarSelector.java**
```diff
             }
-            List<Object> pillar = valueStateToPillarMap.get(valueState);
-            if (pillar == null) {
-                pillar = new ArrayList<>();
-                valueStateToPillarMap.put(valueState, pillar);
-            }
+            List<Object> pillar = valueStateToPillarMap.computeIfAbsent(valueState, key -> new ArrayList<>());
```

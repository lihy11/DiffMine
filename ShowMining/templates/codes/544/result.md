###  infomation 
method del:
-java.lang.Class.forName()
method add：
+java.lang.ClassLoader.loadClass()
###  support count
project count : 6
commit count : 15
###  code
ProjectName: 32091-lz4-java
CommitID: 7f8890bb51995e87f5126ecd4f2b41df7cf7effc
CommitMsg: Made L4Z Java's JAR a valid OSGi bundle.
- computing the proper Import/Export package manifest entries using bnd
- replaced two calls to Class.forName with safer equivalents within OSGi

FilePath: src/java/net/jpountz/lz4/LZ4Factory.java**
```diff
   private static <T> T classInstance(String cls) throws NoSuchFieldException, SecurityException, ClassNotFoundException, IllegalArgumentException, IllegalAccessException {
-    final Class<?> c = Class.forName(cls);
+    final Class<?> c = LZ4Factory.class.getClassLoader().loadClass(cls);
```
ProjectName: 32091-lz4-java
CommitID: 7f8890bb51995e87f5126ecd4f2b41df7cf7effc
CommitMsg: Made L4Z Java's JAR a valid OSGi bundle.
- computing the proper Import/Export package manifest entries using bnd
- replaced two calls to Class.forName with safer equivalents within OSGi

FilePath: src/java/net/jpountz/xxhash/XXHashFactory.java**
```diff
   private static <T> T classInstance(String cls) throws NoSuchFieldException, SecurityException, ClassNotFoundException, IllegalArgumentException, IllegalAccessException {
-    final Class<?> c = Class.forName(cls);
+    final Class<?> c = XXHashFactory.class.getClassLoader().loadClass(cls);
```
ProjectName: 21551-struts
CommitID: bdf0f0da81937056e40d30d439d0de5f7221a1ec
CommitMsg: WW-3670: JSONWriter cannot load CGLIB classes if its JAR is in SharedLib
Patch provided by Bruno Borges

git-svn-id: https://svn.apache.org/repos/asf/struts/struts2/trunk@1161630 13f79535-47bb-0310-9956-ffa450edef68

FilePath: plugins/json/src/main/java/org/apache/struts2/json/JSONWriter.java**
```diff
             try {
-                baseAccessor = Class.forName(
+                baseAccessor = Thread.currentThread().getContextClassLoader().loadClass(
```
ProjectName: 24467-lenskit
CommitID: 5f8cf897ac34d6e4cd137c7fac250f0c42233146
CommitMsg: Merge update for newest version of Grapht

FilePath: lenskit-eval/src/main/java/org/grouplens/lenskit/eval/config/EvalScriptEngine.java**
```diff
 
-            return Class.forName(className).asSubclass(Command.class);
+            return classLoader.loadClass(className).asSubclass(Command.class);
```
ProjectName: 24467-lenskit
CommitID: 5f8cf897ac34d6e4cd137c7fac250f0c42233146
CommitMsg: Merge update for newest version of Grapht

FilePath: lenskit-eval/src/main/java/org/grouplens/lenskit/eval/config/EvalScriptEngine.java**
```diff
             try {
-                cls = Class.forName(name);
+                cls = classLoader.loadClass(name);
```
ProjectName: 24467-lenskit
CommitID: c4fef6f40695a90909d8d10451d9b7663c8d0b6d
CommitMsg: Load eval commands from the correct classloader

FilePath: lenskit-eval/src/main/java/org/grouplens/lenskit/eval/config/EvalScriptEngine.java**
```diff
 
-            return Class.forName(className).asSubclass(Command.class);
+            return classLoader.loadClass(className).asSubclass(Command.class);
```
ProjectName: 24467-lenskit
CommitID: c4fef6f40695a90909d8d10451d9b7663c8d0b6d
CommitMsg: Load eval commands from the correct classloader

FilePath: lenskit-eval/src/main/java/org/grouplens/lenskit/eval/config/EvalScriptEngine.java**
```diff
             try {
-                cls = Class.forName(name);
+                cls = classLoader.loadClass(name);
```
ProjectName: 5286-parceler
CommitID: 005a9268da1315a563dcebc9149e52ed55693052
CommitMsg: use classloader to load class

FilePath: parceler-api/src/main/java/org/parceler/Parcels.java**
```diff
             try {
-                Class parcelWrapperClass = Class.forName(buildParcelableImplName(clazz));
+                Class parcelWrapperClass = classLoader.loadClass(buildParcelableImplName(clazz));
```
ProjectName: 5607-atmosphere
CommitID: e358cf3ca02169cb3793c1877e32dc373da610eb
CommitMsg: bug fix: https://atmosphere.dev.java.net/issues/show_bug.cgi?id=43 Changed how to find Classes.

FilePath: modules/cpr/src/main/java/org/atmosphere/cpr/DefaultCometSupportResolver.java**
```diff
         try {
-            return testClass != null && testClass.length() > 0 && Class.forName(testClass) != null;
+            return testClass != null && testClass.length() > 0 &&  Thread.currentThread().getContextClassLoader().loadClass(testClass) != null;
```
ProjectName: 5607-atmosphere
CommitID: c28377b755d4359a81c9fb735dc7d3e25ea3c483
CommitMsg: Use ContextClassloader instead of Class.forName

FilePath: modules/cpr/src/main/java/org/atmosphere/cpr/AtmosphereServlet.java**
```diff
         try {
-            Class.forName(PRIMEFACES_SERVLET);
+            cl.loadClass(PRIMEFACES_SERVLET);
```
ProjectName: 5607-atmosphere
CommitID: c28377b755d4359a81c9fb735dc7d3e25ea3c483
CommitMsg: Use ContextClassloader instead of Class.forName

FilePath: modules/cpr/src/main/java/org/atmosphere/cpr/AtmosphereServlet.java**
```diff
         try {
-            Class.forName(JERSEY_CONTAINER);
+           cl.loadClass(JERSEY_CONTAINER);
```
ProjectName: 5607-atmosphere
CommitID: c28377b755d4359a81c9fb735dc7d3e25ea3c483
CommitMsg: Use ContextClassloader instead of Class.forName

FilePath: modules/cpr/src/main/java/org/atmosphere/cpr/DefaultCometSupportResolver.java**
```diff
         try {
-            return (CometSupport) Class.forName(targetClassFQN).getDeclaredConstructor(new Class[]{AtmosphereConfig.class}).newInstance(new Object[]{config});
+            ClassLoader cl = Thread.currentThread().getContextClassLoader();
+            return (CometSupport) cl.loadClass(targetClassFQN).getDeclaredConstructor(new Class[]{AtmosphereConfig.class}).newInstance(new Object[]{config});
```
ProjectName: 5607-atmosphere
CommitID: a4d6ab429bad982a82747cf3b9f381a2b751541d
CommitMsg: Use the context classloader instead of Class.forName

FilePath: modules/cpr/src/main/java/org/atmosphere/cpr/BroadcasterFactory.java**
```diff
             try {
-                b = (Class<? extends Broadcaster>) Class.forName(AtmosphereServlet.getDefaultBroadcasterClassName());
+                ClassLoader cl = Thread.currentThread().getContextClassLoader();
+                b = (Class<? extends Broadcaster>) cl.loadClass(AtmosphereServlet.getDefaultBroadcasterClassName());
```
ProjectName: 8021-reactor-core
CommitID: ed4d806d8e2b4b20e88bbef013066f4eb862b67c
CommitMsg: tweaks

FilePath: src/main/java/reactor/core/converter/DependencyUtils.java**
```diff
             detected = RXJAVA_1_OBSERVABLE;
-            Class.forName("rx.Single");
+            Flux.class.getClassLoader().loadClass("rx.Single");
```
ProjectName: 8021-reactor-core
CommitID: ed4d806d8e2b4b20e88bbef013066f4eb862b67c
CommitMsg: tweaks

FilePath: src/main/java/reactor/core/converter/DependencyUtils.java**
```diff
             detected |= RXJAVA_1_SINGLE;
-            Class.forName("rx.Completable");
+            Flux.class.getClassLoader().loadClass("rx.Completable");
```

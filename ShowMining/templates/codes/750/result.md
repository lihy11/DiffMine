###  infomation 
method del:
-java.lang.Class.getCanonicalName()
method add：
+java.lang.Class.getName()
###  support count
project count : 8
commit count : 12
###  code
ProjectName: 43164-sentry-java
CommitID: 65b9df458c894c9e4e7ea0b5900249f5ea3b1014
CommitMsg: Do not rely on the canonical name but on the classname

FilePath: raven/src/main/java/net/kencochrane/raven/jul/SentryHandler.java**
```diff
         LogManager manager = LogManager.getLogManager();
-        String dsn = manager.getProperty(this.getClass().getCanonicalName() + ".dsn");
-        String ravenFactory = manager.getProperty(this.getClass().getCanonicalName() + ".ravenFactory");
+        String dsn = manager.getProperty(SentryHandler.class.getName() + ".dsn");
+        String ravenFactory = manager.getProperty(SentryHandler.class.getName() + ".ravenFactory");
```
ProjectName: 43164-sentry-java
CommitID: 65b9df458c894c9e4e7ea0b5900249f5ea3b1014
CommitMsg: Do not rely on the canonical name but on the classname

FilePath: raven/src/main/java/net/kencochrane/raven/RavenFactory.java**
```diff
         for (RavenFactory ravenFactory : RAVEN_FACTORIES) {
-            if (!ravenFactoryName.equals(ravenFactory.getClass().getCanonicalName()))
+            if (!ravenFactoryName.equals(ravenFactory.getClass().getName()))
```
ProjectName: 28282-easy-random
CommitID: cd88f4db4e7ffef06298d854310855c573b5928a
CommitMsg: Search type by name instead of canonical name in ClassGraphFacade

Before this commit, searching for a matching type by canonical
name does not return concrete inner types.

This commit uses the type's name (instead of its canonical name)
to look for concrete types in the classpath.

Resolves issue #353

FilePath: easy-random-core/src/main/java/org/jeasy/random/util/ClassGraphFacade.java**
```diff
     private static <T> List<Class<?>> searchForPublicConcreteSubTypesOf(final Class<T> type) {
-        String typeName = type.getCanonicalName();
+        String typeName = type.getName();
```
ProjectName: 26124-droidparts
CommitID: 932653f25ba077533652ff9564718e62958edda6
CommitMsg: Canonical crashes.
FilePath: base/src/org/droidparts/inject/injector/DependencyInjector.java**
```diff
 					L.d(e);
-					L.e("No valid dependency method for "
-							+ cls.getCanonicalName());
+					L.e("No valid dependency method for " + cls.getName());
```
ProjectName: 26124-droidparts
CommitID: 932653f25ba077533652ff9564718e62958edda6
CommitMsg: Canonical crashes.
FilePath: base/src/org/droidparts/model/Entity.java**
```diff
 	public String toString() {
-		return getClass().getCanonicalName() + ", id: " + id;
+		return getClass().getName() + ", id: " + id;
```
ProjectName: 26124-droidparts
CommitID: 932653f25ba077533652ff9564718e62958edda6
CommitMsg: Canonical crashes.
FilePath: base/src/org/droidparts/reflect/util/ReflectionUtils.java**
```diff
 			clsTree.add(0, cls);
-			boolean inDroidParts = cls.getCanonicalName().startsWith(
-					"org.droidparts");
+			boolean inDroidParts = cls.getName().startsWith("org.droidparts");
```
ProjectName: 28453-cuba
CommitID: 0a763481a20ac4863587cb1108055957ea823c27
CommitMsg: PL-4433 Exception on script generation in SystemInfo window if the app server has no PostgreSQL driver
#PL-4433

FilePath: modules/core/src/com/haulmont/cuba/core/app/script/SqlScriptGenerator.java**
```diff
                     || value instanceof UUID
-                    || value.getClass().getCanonicalName().toLowerCase().contains("uuid")
+                    || value.getClass().getName().toLowerCase().contains("uuid")
```
ProjectName: 11118-truth
CommitID: 3b5f3777f6116440b2eaa809308fca5043e502c2
CommitMsg: Use getName() instead of getCanonicalName() (which GWT doesn't support).
-------------
Created by MOE: http://code.google.com/p/moe-java
MOE_MIGRATED_REVID=74342220

FilePath: core/src/main/java/com/google/common/truth/Subject.java**
```diff
     if (needsDisambiguation) {
-      message.append("(").append(getSubject().getClass().getCanonicalName()).append(") ");
+      message.append("(").append(getSubject().getClass().getName()).append(") ");
```
ProjectName: 11118-truth
CommitID: 3b5f3777f6116440b2eaa809308fca5043e502c2
CommitMsg: Use getName() instead of getCanonicalName() (which GWT doesn't support).
-------------
Created by MOE: http://code.google.com/p/moe-java
MOE_MIGRATED_REVID=74342220

FilePath: core/src/main/java/com/google/common/truth/Subject.java**
```diff
     if (needsDisambiguation) {
-      message.append(" (").append(part.getClass().getCanonicalName()).append(")");
+      message.append(" (").append(part.getClass().getName()).append(")");
```
ProjectName: 5242-graphql-java
CommitID: 9a56e3fb52de59a9f125023240944e6252942823
CommitMsg: PR feedback

FilePath: src/main/java/graphql/schema/PropertyDataFetcher.java**
```diff
     private String mkKey(Class clazz, String propertyName) {
-        return clazz.getCanonicalName() + "__" + propertyName;
+        return clazz.getName() + "__" + propertyName;
```
ProjectName: 13675-framework
CommitID: bfd675995ec352e5e83cc16bc51b54ecf270d5e0
CommitMsg: getCanonicalName() caused classloading problems when encoding json, changed to getName().

FilePath: src/com/vaadin/terminal/gwt/server/JsonCodec.java**
```diff
             // through fields
-            return combineTypeAndValue(valueType.getCanonicalName(),
+            return combineTypeAndValue(valueType.getName(),
```
ProjectName: 38627-presto
CommitID: c4c48e72c78065000c55e71bf3df9190ddb8bc09
CommitMsg: Fix class name serialization bug in SerializableNativeValue

FilePath: presto-spi/src/main/java/com/facebook/presto/spi/SerializableNativeValue.java**
```diff
             generator.writeStartObject();
-            generator.writeStringField("type", value.getType().getCanonicalName());
+            generator.writeStringField("type", value.getType().getName());
```

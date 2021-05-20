###  infomation 
method del:
-java.lang.Class.newInstance()
method add：
+java.lang.reflect.Constructor.newInstance()
###  support count
project count : 20
commit count : 35
###  code
ProjectName: 40343-hprose-java
CommitID: 6f65c19a88cd3f6b74a4db03df30a9ab4eddbd45
CommitMsg: Changed class.newInstance() to class.getDeclaredConstructor().newInstance()

FilePath: src/main/java/hprose/client/HproseClient.java**
```diff
             try {
-                HproseClient client = clientClass.newInstance();
+                HproseClient client = clientClass.getDeclaredConstructor().newInstance();
```
ProjectName: 32143-checkstyle-idea
CommitID: 4a2cb29199139ee421afe87b0cdc69591319a6e6
CommitMsg: Fixes for Java 11 compatibility

FilePath: src/main/java/org/infernus/idea/checkstyle/importer/ModuleImporterFactory.java**
```diff
             Class c = Class.forName(fqn);
-            Object o = c.newInstance();
+            Object o = c.getDeclaredConstructor().newInstance();
```
ProjectName: 42532-jenetics
CommitID: 7b612105565d1eb59b69371a94f5f40d39bd67ad
CommitMsg: #142: Method 'Class.newInstance()' has been deprecated in Java 9.

FilePath: org.jenetics/src/main/java/org/jenetics/internal/util/DieHarder.java**
```diff
 		try {
-			random = (Random)Class.forName(randomName).newInstance();
+			random = (Random)Class
+				.forName(randomName)
+				.getConstructor()
+				.newInstance();
+
```
ProjectName: 31210-hibernate-validator
CommitID: 0880b8b54bacf87be560ffb23b26b1eaa3f01747
CommitMsg: HV-1628 Remove deprecated call to Class#newInstance()

FilePath: engine/src/main/java/org/hibernate/validator/internal/util/privilegedactions/NewInstance.java**
```diff
 		try {
-			return clazz.newInstance();
+			return clazz.getConstructor().newInstance();
```
ProjectName: 22223-pdfbox
CommitID: dcf8afb03034bf72174ed90f36739399d770d5c4
CommitMsg: PDFBOX-3017: replace method that is deprecated in later jdk versions

git-svn-id: https://svn.apache.org/repos/asf/pdfbox/trunk@1854931 13f79535-47bb-0310-9956-ffa450edef68

FilePath: examples/src/main/java/org/apache/pdfbox/examples/signature/validation/AddValidationInformation.java**
```diff
             {
-                result = clazz.newInstance();
+                result = clazz.getDeclaredConstructor().newInstance();
```
ProjectName: 22223-pdfbox
CommitID: ffd2ead0998cdb528ea2427e1f13a7f010358d62
CommitMsg: PDFBOX-3766: replace method deprecated in jdk9

git-svn-id: https://svn.apache.org/repos/asf/pdfbox/trunk@1792763 13f79535-47bb-0310-9956-ffa450edef68

FilePath: pdfbox/src/main/java/org/apache/pdfbox/pdmodel/encryption/SecurityProvider.java**
```diff
                         .forName("org.bouncycastle.jce.provider.BouncyCastleProvider");
-                provider = providerClass.newInstance();
+                provider = providerClass.getDeclaredConstructor().newInstance();
```
ProjectName: 28282-easy-random
CommitID: 8a0cc071199def3fb4b0f48ec64d9dce5e1b2c0b
CommitMsg: If a class has no default constructor, try to force access to a non-public no-arg-constructor before using objenesis to create an instance.

This allows excluded fields of classes with no default constructor to be initialized with their default value (fixes #246).

FilePath: random-beans/src/main/java/io/github/benas/randombeans/ObjectFactory.java**
```diff
         try {
-            return type.newInstance();
+            Constructor<T> noArgConstructor = type.getDeclaredConstructor();
+            if (!noArgConstructor.isAccessible()) {
+                noArgConstructor.setAccessible(true);
+            }
+            return noArgConstructor.newInstance();
```
ProjectName: 23730-i2p.i2p
CommitID: 8a89b3da2959c3208ab74207e339cca5f1c48b0b
CommitMsg: Fix calls to Class.newInstance() deprecated in Java 9

FilePath: apps/susimail/src/src/i2p/susi/webmail/encoding/EncodingFactory.java**
```diff
 					Class<?> c = Class.forName( classNames[i] );
-					Encoding e = (Encoding)c.newInstance();
+					Encoding e = (Encoding) (c.getDeclaredConstructor().newInstance());
```
ProjectName: 23730-i2p.i2p
CommitID: 8a89b3da2959c3208ab74207e339cca5f1c48b0b
CommitMsg: Fix calls to Class.newInstance() deprecated in Java 9

FilePath: apps/imagegen/imagegen/webapp/src/main/java/net/i2p/imagegen/IdenticonServlet.java**
```diff
 				Class<?> cacheClass = Class.forName(cacheProvider);
-				this.cache = (IdenticonCache) cacheClass.newInstance();
+				this.cache = (IdenticonCache) cacheClass.getDeclaredConstructor().newInstance();
```
ProjectName: 23730-i2p.i2p
CommitID: 8a89b3da2959c3208ab74207e339cca5f1c48b0b
CommitMsg: Fix calls to Class.newInstance() deprecated in Java 9

FilePath: router/java/src/org/cybergarage/upnp/UPnP.java**
```diff
 			try {
-				parser = (Parser) Class.forName(parserClass[i]).newInstance();
+				parser = (Parser) Class.forName(parserClass[i]).getDeclaredConstructor().newInstance();
```
ProjectName: 23730-i2p.i2p
CommitID: 8a89b3da2959c3208ab74207e339cca5f1c48b0b
CommitMsg: Fix calls to Class.newInstance() deprecated in Java 9

FilePath: core/java/src/net/i2p/kademlia/KBucketSet.java**
```diff
         try {
-            rv = (T) _us.getClass().newInstance();
+            rv = (T) _us.getClass().getDeclaredConstructor().newInstance();
```
ProjectName: 23730-i2p.i2p
CommitID: 8a89b3da2959c3208ab74207e339cca5f1c48b0b
CommitMsg: Fix calls to Class.newInstance() deprecated in Java 9

FilePath: apps/imagegen/imagegen/webapp/src/main/java/net/i2p/imagegen/QRServlet.java**
```diff
 				Class<?> cacheClass = Class.forName(cacheProvider);
-				this.cache = (IdenticonCache) cacheClass.newInstance();
+				this.cache = (IdenticonCache) cacheClass.getDeclaredConstructor().newInstance();
```
ProjectName: 26124-droidparts
CommitID: 8e4ca8c7b79cb61b474e84bdac763a88b956a74b
CommitMsg: ReflectionUtils: instantiate private classes.
FilePath: droidparts/src/org/droidparts/inner/ReflectionUtils.java**
```diff
 		try {
-			return cls.newInstance();
+			Constructor<T> con = cls.getDeclaredConstructor();
+			con.setAccessible(true);
+			return con.newInstance();
```
ProjectName: 26208-logback-android
CommitID: 1784abbe27744cb11b2f9f6f3e9d2a09b2a79bd0
CommitMsg: fix deprecation issue

https://github.com/qos-ch/logback/commit/2b3578fa9

FilePath: logback-android/src/main/java/ch/qos/logback/core/util/OptionHelper.java**
```diff
       if (type == null) {
-        return classObj.newInstance();
+        return classObj.getConstructor().newInstance();
```
ProjectName: 10508-simple-binary-encoding
CommitID: 09616fc05fd77857d7bd72dd16127b359910b8c7
CommitMsg: [Java] Use Constructor to avoid deprecation warning in Java 10.

FilePath: sbe-tool/src/main/java/uk/co/real_logic/sbe/generation/TargetCodeGeneratorLoader.java**
```diff
         {
-            return (TargetCodeGenerator)Class.forName(name).newInstance();
+            return (TargetCodeGenerator)Class.forName(name).getConstructor().newInstance();
```
ProjectName: 14339-agrona
CommitID: 199b05e8e5a4bd2eb3c932db22c4637a787d47b2
CommitMsg: [Java] Use Constructor to avoid deprecation warning in Java 10.

FilePath: agrona/src/main/java/org/agrona/concurrent/HighResolutionTimer.java**
```diff
             final Method getDeviceInfoMethod = mediaProviderClass.getMethod("getDeviceInfo");
-            final MidiDeviceProvider provider = (MidiDeviceProvider)mediaProviderClass.newInstance();
+            final MidiDeviceProvider provider = (MidiDeviceProvider)mediaProviderClass.getConstructor().newInstance();
```
ProjectName: 17841-bootique
CommitID: 6eb98b15ab51f9b84391e1f1fe632ac086671388
CommitMsg: Replace `clazz.newInstance()` call with `clazz.getDeclaredConstructor().newInstance()`. Since `clazz.newInstance()` deprecated in Java 9.

FilePath: bootique/src/main/java/io/bootique/Bootique.java**
```diff
         try {
-            return moduleType.newInstance();
-        } catch (InstantiationException | IllegalAccessException e) {
+            return moduleType.getDeclaredConstructor().newInstance();
+        } catch (InstantiationException | IllegalAccessException |
+                NoSuchMethodException | InvocationTargetException e) {
```
ProjectName: 2253-zookeeper
CommitID: fb10c2b54698c8aab4477670bb0d6f7fe99c5c43
CommitMsg: ZOOKEEPER-2914: compiler warning using java 9

Replaced deprecated methods (Class.newInstance()) and removed redundant cast

Author: Andor Molnar <andor@cloudera.com>

Reviewers: Patrick Hunt <phunt@apache.org>

Closes #392 from dolphy17/ZOOKEEPER-2914 and squashes the following commits:

ab7bd5e2 [Andor Molnar] Reverted explicit case, because java 1.7 requires it to compile
b2d400bc [Andor Molnar] Replaced Class.newInstance() methods (deprecated in Java 9) with Constructor.newInstance()

Change-Id: Iae00f0874b69d425f35b96775d6ac9634b3ade73

FilePath: src/java/main/org/apache/zookeeper/jmx/ManagedUtil.java**
```diff
                 // org.apache.log4j.jmx.HierarchyDynamicMBean hdm = new org.apache.log4j.jmx.HierarchyDynamicMBean();
-                Object hdm = Class.forName("org.apache.log4j.jmx.HierarchyDynamicMBean").newInstance();
+                Object hdm = Class.forName("org.apache.log4j.jmx.HierarchyDynamicMBean").getDeclaredConstructor().newInstance();
```
ProjectName: 2253-zookeeper
CommitID: fb10c2b54698c8aab4477670bb0d6f7fe99c5c43
CommitMsg: ZOOKEEPER-2914: compiler warning using java 9

Replaced deprecated methods (Class.newInstance()) and removed redundant cast

Author: Andor Molnar <andor@cloudera.com>

Reviewers: Patrick Hunt <phunt@apache.org>

Closes #392 from dolphy17/ZOOKEEPER-2914 and squashes the following commits:

ab7bd5e2 [Andor Molnar] Reverted explicit case, because java 1.7 requires it to compile
b2d400bc [Andor Molnar] Replaced Class.newInstance() methods (deprecated in Java 9) with Constructor.newInstance()

Change-Id: Iae00f0874b69d425f35b96775d6ac9634b3ade73

FilePath: src/java/main/org/apache/zookeeper/server/ServerCnxnFactory.java**
```diff
         try {
-            ServerCnxnFactory serverCnxnFactory = (ServerCnxnFactory) Class.forName(serverCnxnFactoryName).newInstance();
+            ServerCnxnFactory serverCnxnFactory = (ServerCnxnFactory) Class.forName(serverCnxnFactoryName)
+                    .getDeclaredConstructor().newInstance();
```
ProjectName: 2253-zookeeper
CommitID: fb10c2b54698c8aab4477670bb0d6f7fe99c5c43
CommitMsg: ZOOKEEPER-2914: compiler warning using java 9

Replaced deprecated methods (Class.newInstance()) and removed redundant cast

Author: Andor Molnar <andor@cloudera.com>

Reviewers: Patrick Hunt <phunt@apache.org>

Closes #392 from dolphy17/ZOOKEEPER-2914 and squashes the following commits:

ab7bd5e2 [Andor Molnar] Reverted explicit case, because java 1.7 requires it to compile
b2d400bc [Andor Molnar] Replaced Class.newInstance() methods (deprecated in Java 9) with Constructor.newInstance()

Change-Id: Iae00f0874b69d425f35b96775d6ac9634b3ade73

FilePath: src/java/main/org/apache/zookeeper/server/auth/ProviderRegistry.java**
```diff
                                 .loadClass(className);
-                        AuthenticationProvider ap = (AuthenticationProvider) c
+                        AuthenticationProvider ap = (AuthenticationProvider) c.getDeclaredConstructor()
```
ProjectName: 6355-jodd
CommitID: 2c97c3dead1ac490f3162a13aeb3a67335da63a7
CommitMsg: Allow non-public classes for action method arguments

FilePath: jodd-madvoc/src/main/java/jodd/madvoc/ActionRequest.java**
```diff
 					// regular or static class
-					params[i] = type.newInstance();
+					Constructor ctor = type.getDeclaredConstructor(null);
+					ctor.setAccessible(true);
+					params[i] = ctor.newInstance();
```
ProjectName: 3683-checkstyle
CommitID: a2bfd59729017b80d4167505fdcfed28d17ca5ee
CommitMsg: Replace Class.newInstance() with Constructor.newInstance(). #1555

Fixes ClassNewInstance inspection violation.

Description:
Reports any calls to java.lang.Class.newInstance(). The newInstance method propagates any exception thrown by the no-arg constructor, including checked exceptions. Use of this method effectively bypasses the compile-time exception checking that would otherwise be performed by the compiler. Replacing such a method call with a call to the java.lang.reflect.Constructor.newInstance() method avoids this problem by wrapping any exception thrown by the constructor in a java.lang.reflect.InvocationTargetException.

FilePath: src/main/java/com/puppycrawl/tools/checkstyle/PackageObjectFactory.java**
```diff
             final Class<?> clazz = Class.forName(className, true, moduleClassLoader);
-            return clazz.newInstance();
+            return clazz.getDeclaredConstructor().newInstance();
```
ProjectName: 8848-lwjgl3
CommitID: d1227fa057302dc6fd12b35f4fd8e21de3f19a60
CommitMsg: Fix JDK 9 deprecated warnings for newInstance()

Class.newInstance() is deprecated in JDK 9 (JDK-6850612). Can easily be replaced with Class.getConstructor().newInstance().

FilePath: modules/core/src/main/java/org/lwjgl/system/APIUtil.java**
```diff
 			try {
-				Supplier<PrintStream> factory = (Supplier<PrintStream>)Class.forName((String)state).newInstance();
+				Supplier<PrintStream> factory = (Supplier<PrintStream>)Class.forName((String)state).getConstructor().newInstance();
```
ProjectName: 8848-lwjgl3
CommitID: d1227fa057302dc6fd12b35f4fd8e21de3f19a60
CommitMsg: Fix JDK 9 deprecated warnings for newInstance()

Class.newInstance() is deprecated in JDK 9 (JDK-6850612). Can easily be replaced with Class.getConstructor().newInstance().

FilePath: modules/core/src/main/java/org/lwjgl/system/MemoryManage.java**
```diff
 				Class<?> JEmallocAllocator = Class.forName("org.lwjgl.system.jemalloc.JEmallocAllocator");
-				return (MemoryAllocator)JEmallocAllocator.newInstance();
+				return (MemoryAllocator)JEmallocAllocator.getConstructor().newInstance();
```
ProjectName: 8848-lwjgl3
CommitID: d1227fa057302dc6fd12b35f4fd8e21de3f19a60
CommitMsg: Fix JDK 9 deprecated warnings for newInstance()

Class.newInstance() is deprecated in JDK 9 (JDK-6850612). Can easily be replaced with Class.getConstructor().newInstance().

FilePath: modules/core/src/main/java/org/lwjgl/system/MemoryManage.java**
```diff
 			try {
-				return (MemoryAllocator)Class.forName(allocator.toString()).newInstance();
+				return (MemoryAllocator)Class.forName(allocator.toString()).getConstructor().newInstance();
```
ProjectName: 3873-aeron
CommitID: cd8874c36b7cfca8031cc41bbb695eb181ad223b
CommitMsg: [Java] Prepare for Java 11.

FilePath: aeron-agent/src/main/java/io/aeron/agent/EventLogAgent.java**
```diff
         {
-            return (Agent)Class.forName(
-                System.getProperty(READER_CLASSNAME_PROP_NAME, READER_CLASSNAME_DEFAULT)).newInstance();
+            final Class<?> aClass = Class.forName(
+                System.getProperty(READER_CLASSNAME_PROP_NAME, READER_CLASSNAME_DEFAULT));
+
+            return (Agent)aClass.getDeclaredConstructor().newInstance();
```
ProjectName: 5818-jmeter
CommitID: 9d545bce26fcbf72b90f2c8221480469bd390a2b
CommitMsg: Replace calls to deprecated method Class#newInstance

Part of #435 and Bugzilla Id: 62972


git-svn-id: https://svn.apache.org/repos/asf/jmeter/trunk@1847985 13f79535-47bb-0310-9956-ffa450edef68

Former-commit-id: 5835c0fd8488ff8c9b197246fb5bf0914c593ea5
FilePath: src/core/org/apache/jmeter/gui/util/PowerTableModel.java**
```diff
         try {
-            return colClass.newInstance();
+            return colClass.getDeclaredConstructor().newInstance();
```
ProjectName: 5818-jmeter
CommitID: 4a1e0bfc8f1e69902b9bfd24434a99b49390deeb
CommitMsg: Replace calls to deprecated Class#newInstance method

Part of #435 and Bugzilla Id: 62972


git-svn-id: https://svn.apache.org/repos/asf/jmeter/trunk@1847982 13f79535-47bb-0310-9956-ffa450edef68

Former-commit-id: 368c4828d4048e3b3983351f4a53624109f42bea
FilePath: src/core/org/apache/jmeter/util/BeanShellServer.java**
```diff
             Class<?> interpreter = loader.loadClass("bsh.Interpreter");//$NON-NLS-1$
-            Object instance = interpreter.newInstance();
+            Object instance = interpreter.getDeclaredConstructor().newInstance();
```
ProjectName: 5818-jmeter
CommitID: 4a1e0bfc8f1e69902b9bfd24434a99b49390deeb
CommitMsg: Replace calls to deprecated Class#newInstance method

Part of #435 and Bugzilla Id: 62972


git-svn-id: https://svn.apache.org/repos/asf/jmeter/trunk@1847982 13f79535-47bb-0310-9956-ffa450edef68

Former-commit-id: 368c4828d4048e3b3983351f4a53624109f42bea
FilePath: src/core/org/apache/jmeter/gui/util/MenuFactory.java**
```diff
             } else {
-                item = (JMeterGUIComponent) c.newInstance();
+                item = (JMeterGUIComponent) c.getDeclaredConstructor().newInstance();
```
ProjectName: 5818-jmeter
CommitID: 105db4c4649ccb1235021152ba9b3bd85f455bd9
CommitMsg: Replace calls to deprecated Class#newInstance method

Part of #435 and Bugzilla Id: 62972


git-svn-id: https://svn.apache.org/repos/asf/jmeter/trunk@1847977 13f79535-47bb-0310-9956-ffa450edef68

Former-commit-id: cac54e6fe60bd5287115885d50482c25674b4d00
FilePath: src/protocol/http/org/apache/jmeter/protocol/http/parser/BaseParser.java**
```diff
         try {
-            Object clazz = Class.forName(parserClassName).newInstance();
+            Object clazz = Class.forName(parserClassName).getDeclaredConstructor().newInstance();
```
ProjectName: 5818-jmeter
CommitID: 23a3fc1cb0100c580389bcc567cabadfc0c9d6ed
CommitMsg: Replace calls to deprecated Class#newInstance

Part of #435 and Bugzilla Id: 62972


git-svn-id: https://svn.apache.org/repos/asf/jmeter/trunk@1847973 13f79535-47bb-0310-9956-ffa450edef68

Former-commit-id: 899304163af2381bf9f9a790baf3c9a82d9c342e
FilePath: src/components/org/apache/jmeter/visualizers/backend/BackendListener.java**
```diff
         try {
-            return (BackendListenerClient) clientClass.newInstance();
+            return (BackendListenerClient) clientClass.getDeclaredConstructor().newInstance();
```
ProjectName: 5818-jmeter
CommitID: 75fc0f705f05ac65351f6f1bde49f411758d366c
CommitMsg: Replace deprecated newInstance calls

Part of #435 and Bugzilla Id: 62972


git-svn-id: https://svn.apache.org/repos/asf/jmeter/trunk@1847960 13f79535-47bb-0310-9956-ffa450edef68

Former-commit-id: 5470c3831b280e9d195dcb694747a396adb6ba74
FilePath: src/protocol/http/org/apache/jmeter/protocol/http/sampler/AccessLogSampler.java**
```diff
                     if (StringUtils.isNotBlank(this.getLogFile())) {
-                        parser = (LogParser) Class.forName(getParserClassName()).newInstance();
+                        parser = (LogParser) Class.forName(getParserClassName()).getDeclaredConstructor().newInstance();
```
ProjectName: 5818-jmeter
CommitID: 75fc0f705f05ac65351f6f1bde49f411758d366c
CommitMsg: Replace deprecated newInstance calls

Part of #435 and Bugzilla Id: 62972


git-svn-id: https://svn.apache.org/repos/asf/jmeter/trunk@1847960 13f79535-47bb-0310-9956-ffa450edef68

Former-commit-id: 5470c3831b280e9d195dcb694747a396adb6ba74
FilePath: src/protocol/http/org/apache/jmeter/protocol/http/sampler/AccessLogSampler.java**
```diff
             try {
-                filter = (Filter) Class.forName(filterClassName).newInstance();
+                filter = (Filter) Class.forName(filterClassName).getDeclaredConstructor().newInstance();
```
ProjectName: 25739-poi
CommitID: 37c657754bf3ab0e0b4b1bb7244720a6558ed381
CommitMsg: Fix some IDE warnings and JVM deprecations

git-svn-id: https://svn.apache.org/repos/asf/poi/trunk@1851795 13f79535-47bb-0310-9956-ffa450edef68

FilePath: src/java/org/apache/poi/util/POILogFactory.java**
```diff
                     (Class<? extends POILogger>) Class.forName(_loggerClassName);
-                logger = loggerClass.newInstance();
+                logger = loggerClass.getConstructor().newInstance();
```
ProjectName: 731-ExoPlayer
CommitID: a476e090bcfd7dc79c6b40b08d3654fa994d03ac
CommitMsg: Use getConstructor().newInstance() in ExtractorSampleSource.
-------------
Created by MOE: https://github.com/google/moe
MOE_MIGRATED_REVID=126306436

FilePath: library/src/main/java/com/google/android/exoplayer/extractor/ExtractorSampleSource.java**
```diff
       try {
-        extractors[i] = defaultExtractorClasses.get(i).newInstance();
+        extractors[i] = defaultExtractorClasses.get(i).getConstructor().newInstance();
```

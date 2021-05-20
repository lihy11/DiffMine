###  infomation 
method del:
-java.lang.Class.newInstance()
method add：
+java.lang.Class.getConstructor()
+java.lang.reflect.Constructor.newInstance()
###  support count
project count : 8
commit count : 10
###  code
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

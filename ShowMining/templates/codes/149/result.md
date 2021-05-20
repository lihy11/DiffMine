###  infomation 
method del:
-java.lang.Class.getMethod()
method add：
+java.lang.Class.getDeclaredMethod()
###  support count
project count : 6
commit count : 11
###  code
ProjectName: 39628-Lucee
CommitID: e89b05b0bb9ac76efbf3c22d5516594ebf118f49
CommitMsg: improve https://luceeserver.atlassian.net/browse/LDEV-436

FilePath: core/src/main/java/lucee/commons/io/SystemUtil.java**
```diff
 					try {
-						Method m = thread.getClass().getMethod("stop0", new Class[]{Object.class});
+						Method m = thread.getClass().getDeclaredMethod("stop0", new Class[]{Object.class});
```
ProjectName: 11863-jetcache
CommitID: f107359fffe14c3b526d0863bd5587982a034db8
CommitMsg: 删除中文注释

FilePath: jetcache-spring/src/main/java/com/taobao/geek/jetcache/spring/CachePointcut.java**
```diff
         try {
-            Method method = clazz.getMethod(name, paramTypes);
+            Method method = clazz.getDeclaredMethod(name, paramTypes);
```
ProjectName: 6355-jodd
CommitID: 9b6cb06a7aaf1d359cad8e7dec5a7c4fce95cd8e
CommitMsg: Use getDeclaredMethod() instead of getMethod() since the method is protected
FilePath: jodd-core/src/main/java/jodd/util/ClassLoaderUtil.java**
```diff
 		try {
-			Method addURLMethod = URLClassLoader.class.getMethod("addURL", URL.class);
+			Method addURLMethod = URLClassLoader.class.getDeclaredMethod("addURL", URL.class);
```
ProjectName: 6355-jodd
CommitID: 5440b529fee46c1655cd5b6f17e0750ab75150bf
CommitMsg: Fixed calling declared methods.

FilePath: jodd-core/src/main/java/jodd/util/ClassLoaderUtil.java**
```diff
 		try {
-			Method defineClassMethod = ClassLoader.class.getMethod("defineClass", String.class, byte[].class, int.class, int.class);
+			Method defineClassMethod = ClassLoader.class.getDeclaredMethod("defineClass", String.class, byte[].class, int.class, int.class);
```
ProjectName: 6355-jodd
CommitID: 5440b529fee46c1655cd5b6f17e0750ab75150bf
CommitMsg: Fixed calling declared methods.

FilePath: jodd-core/src/main/java/jodd/util/ClassLoaderUtil.java**
```diff
 		try {
-			Method findClassMethod  = URLClassLoader.class.getMethod("findClass", String.class);
+			Method findClassMethod  = URLClassLoader.class.getDeclaredMethod("findClass", String.class);
```
ProjectName: 6355-jodd
CommitID: 5440b529fee46c1655cd5b6f17e0750ab75150bf
CommitMsg: Fixed calling declared methods.

FilePath: jodd-core/src/main/java/jodd/util/ObjectUtil.java**
```diff
 		try {
-			Method cloneMethod = source.getClass().getMethod("clone");
+			Method cloneMethod = source.getClass().getDeclaredMethod("clone");
```
ProjectName: 6355-jodd
CommitID: 5440b529fee46c1655cd5b6f17e0750ab75150bf
CommitMsg: Fixed calling declared methods.

FilePath: jodd-joy/src/main/java/jodd/joy/WebRunner.java**
```diff
 		try {
-			Method destroyMethod = MadvocConfig.class.getMethod("destroy");
+			Method destroyMethod = MadvocConfig.class.getDeclaredMethod("destroy");
```
ProjectName: 5827-MinecraftForge
CommitID: 9304420a2c197c097582c5b5ad1d97a791c805f6
CommitMsg: it's getdeclaredmethod, dipstick

FilePath: fml/common/cpw/mods/fml/common/ModClassLoader.java**
```diff
             try {
-                Method addUrl=URLClassLoader.class.getMethod("addUrl", URL.class);
+                Method addUrl=URLClassLoader.class.getDeclaredMethod("addUrl", URL.class);
```
ProjectName: 7427-hive
CommitID: afb4605abf2cffbb676a666b41676518f54d5d94
CommitMsg: HIVE-13391 : add an option to LLAP to use keytab to authenticate to read data (Sergey Shelukhin, reviewed by Siddharth Seth) ADDENDUM

FilePath: shims/0.23/src/main/java/org/apache/hadoop/hive/shims/Hadoop23Shims.java**
```diff
     try {
-      method = clazz.getMethod("getSubject");
+      method = clazz.getDeclaredMethod("getSubject");
```
ProjectName: 35532-cxf
CommitID: 3ea1c784f248e29dcda46b16b82ad0e923c4b6e1
CommitMsg: [CXF-6553] Various java2wadl-plugin improvements, patch from Francesco Chicchiriccò applied

FilePath: maven-plugins/java2wadl-plugin/src/main/java/org/apache/cxf/maven_plugin/javatowadl/ParseJavaDocMojo.java**
```diff
         
-            Method m = AbstractJavadocMojo.class.getMethod("executeReport", Locale.class);
+            Method m = AbstractJavadocMojo.class.getDeclaredMethod("executeReport", Locale.class);
```
ProjectName: 35532-cxf
CommitID: 62477b9f1ce289218a8f39207a76986f3c78d85b
CommitMsg: [CXF-2705] getPasswordAuthentication is protected and not found with
getMethod

git-svn-id: https://svn.apache.org/repos/asf/cxf/trunk@921943 13f79535-47bb-0310-9956-ffa450edef68

FilePath: rt/transports/http/src/main/java/org/apache/cxf/transport/http/CXFAuthenticator.java**
```diff
                 }
-                Method m = Authenticator.class.getMethod("getPasswordAuthentication");
+                Method m = Authenticator.class.getDeclaredMethod("getPasswordAuthentication");
```

###  infomation 
method del:
-java.lang.Thread.currentThread()
-java.lang.Thread.getContextClassLoader()
method add：
+java.lang.Class.getClassLoader()
###  support count
project count : 8
commit count : 11
###  code
ProjectName: 31172-qbit
CommitID: f22a363e9cd4012a4d3c0ca103978bb317c0fa71
CommitMsg: fixed classloader issue

FilePath: qbit/boon/src/main/java/io/advantageous/qbit/events/impl/BoonEventBusProxyCreator.java**
```diff
         };
-        final Object o = Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{eventBusProxyInterface, ClientProxy.class}, invocationHandler);
+        final Object o = Proxy.newProxyInstance(eventBusProxyInterface.getClassLoader(), new Class[]{eventBusProxyInterface, ClientProxy.class}, invocationHandler);
```
ProjectName: 36830-java-sdk
CommitID: 682c0ecc8cf17832ab9127fc7b9ed056866c7377
CommitMsg: Use RequestUtils class loader, fixes #586

FilePath: core/src/main/java/com/ibm/watson/developer_cloud/util/RequestUtils.java**
```diff
   private static String loadSdkVersion() {
-    InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("version.properties");
+    ClassLoader classLoader = RequestUtils.class.getClassLoader();
+    InputStream inputStream = classLoader.getResourceAsStream("version.properties");
```
ProjectName: 10572-Openfire
CommitID: 866d8c5824967bde4579a66434565bc57c4e9f3e
CommitMsg: Fix classloading issue in PluginClassLoader due to getting classloader off current thread.

git-svn-id: http://svn.igniterealtime.org/svn/repos/wildfire/trunk@4186 b35dd754-fafc-0310-a699-88a17e54d16e

FilePath: src/java/org/jivesoftware/wildfire/container/PluginClassLoader.java**
```diff
     private ClassLoader findParentClassLoader() {
-        ClassLoader parent = Thread.currentThread().getContextClassLoader();
+        ClassLoader parent = XMPPServer.class.getClassLoader();
```
ProjectName: 14046-sshj
CommitID: 9e3b9f7c248d00a1e6261e09d38981c20ab2ad3e
CommitMsg: Obtain the sshj.properties resource from the ClassLoader that loaded the DefaultConfig class, not from the context classloader.

FilePath: src/main/java/net/schmizz/sshj/DefaultConfig.java**
```diff
             Properties properties = new Properties();
-            properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("sshj.properties"));
+            properties.load(DefaultConfig.class.getClassLoader().getResourceAsStream("sshj.properties"));
```
ProjectName: 11281-liquibase
CommitID: 7c8c7f259ccd72d51cb59d8aa69138e47435ad53
CommitMsg: [ 1950060 ] Ant reports "UNKNOWN" version in databasechangelog table

git-svn-id: http://liquibase.jira.com/svn/CORE/trunk@671 e6edf6fb-f266-4316-afb4-e53d95876a76

FilePath: core/src/java/liquibase/util/LiquibaseUtil.java**
```diff
         Properties buildInfo = new Properties();
-        URL buildInfoFile = Thread.currentThread().getContextClassLoader().getResource("buildinfo.properties");
+        ClassLoader classLoader = LiquibaseUtil.class.getClassLoader();
+
+        URL buildInfoFile = classLoader.getResource("buildinfo.properties");
```
ProjectName: 4142-flyway
CommitID: 340dc666d611f4588b582f4157602db83c2ba51b
CommitMsg: Fixed #2270: LogFactory not initialized with the right classloader if first log is from the Flyway class

FilePath: flyway-core/src/main/java/org/flywaydb/core/api/logging/LogFactory.java**
```diff
         if (logCreator == null) {
-            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
-            logCreator = LogCreatorFactory.getLogCreator(classLoader, fallbackLogCreator);
+            logCreator = LogCreatorFactory.getLogCreator(LogFactory.class.getClassLoader(), fallbackLogCreator);
```
ProjectName: 9531-nutz
CommitID: e8282e84d419354b70d917c0d3359d4ea250410c
CommitMsg: Merge branch 'master' of github.com:nutzam/nutz

FilePath: src/org/nutz/log/impl/Log4jLogAdapter.java**
```diff
 		try {
-			Class.forName("org.apache.log4j.Logger", false, Thread.currentThread().getContextClassLoader());
+			Class.forName("org.apache.log4j.Logger", false, Log4jLogAdapter.class.getClassLoader());
```
ProjectName: 9531-nutz
CommitID: c79d2e0dd470ed7484fff372167415d2079286c2
CommitMsg: fix issue #169

FilePath: src/org/nutz/log/impl/Log4jLogAdapter.java**
```diff
 		try {
-			Class.forName("org.apache.log4j.Logger", false, Thread.currentThread().getContextClassLoader());
+			Class.forName("org.apache.log4j.Logger", false, Log4jLogAdapter.class.getClassLoader());
```
ProjectName: 8848-lwjgl3
CommitID: 08f047ba0eda41c34d402f6be5a7a1b0915bbe5c
CommitMsg: Do not use the thread context ClassLoader

FilePath: modules/core/src/main/java/org/lwjgl/system/APIUtil.java**
```diff
 	public static Optional<String> apiGetManifestValue(String attributeName) {
-		URL url = Thread.currentThread().getContextClassLoader().getResource("org/lwjgl/system/APIUtil.class");
+		URL url = APIUtil.class.getClassLoader().getResource("org/lwjgl/system/APIUtil.class");
```
ProjectName: 8848-lwjgl3
CommitID: 08f047ba0eda41c34d402f6be5a7a1b0915bbe5c
CommitMsg: Do not use the thread context ClassLoader

FilePath: modules/generator/src/main/java/org/lwjgl/generator/util/vulkan/VulkanFormatter.java**
```diff
 		try {
-			ClassLoader cl = Thread.currentThread().getContextClassLoader();
+			ClassLoader cl = getClass().getClassLoader();
```
ProjectName: 8848-lwjgl3
CommitID: 08f047ba0eda41c34d402f6be5a7a1b0915bbe5c
CommitMsg: Do not use the thread context ClassLoader

FilePath: modules/generator/src/main/java/org/lwjgl/generator/util/TemplateFormatter.java**
```diff
 		try {
-			ClassLoader cl = Thread.currentThread().getContextClassLoader();
+			ClassLoader cl = getClass().getClassLoader();
```

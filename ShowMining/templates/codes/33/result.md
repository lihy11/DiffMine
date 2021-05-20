###  infomation 
method del:
-java.io.File.mkdir()
method add：
+java.io.File.mkdirs()
###  support count
project count : 9
commit count : 10
###  code
ProjectName: 60116-Nukkit
CommitID: 80dad5e9b0f93581f5d7f0c4a7d61156fb6db043
CommitMsg: Check resource output folder exists

FilePath: src/main/java/cn/nukkit/plugin/PluginBase.java**
```diff
                 if (resource != null) {
-                    if (!dataFolder.exists()) {
-                        dataFolder.mkdir();
+                    File outFolder = out.getParentFile();
+                    if (!outFolder.exists()) {
+                        outFolder.mkdirs();
```
ProjectName: 23730-i2p.i2p
CommitID: a337185820b0c70f97ed4d4e0ac129836bb9d879
CommitMsg: better temp dir fallback and logging

FilePath: core/java/src/net/i2p/I2PAppContext.java**
```diff
                     _tmpDir = new SecureDirectory(_routerDir, "tmp");
-                    _tmpDir.mkdir();
+                    _tmpDir.mkdirs();
+                    if (!_tmpDir.exists())
+                        System.err.println("ERROR: Could not create temp dir " + _tmpDir.getAbsolutePath());
```
ProjectName: 29579-Payara
CommitID: 8fa77170c4b25e8aac8183ec389e6179b2d72c5b
CommitMsg: Follow-up fix for GLASSFISH-18018 - create all dirs in the path


git-svn-id: https://svn.java.net/svn/glassfish~svn/trunk/main@51741 6f3ba3e3-413c-0410-a8aa-90bee3ab43b5

FilePath: appserver/transaction/jts/src/main/java/com/sun/jts/CosTransactions/LogControl.java**
```diff
             if( !logDir.exists() )
-                logDir.mkdir();
+                logDir.mkdirs();
```
ProjectName: 1649-webmagic
CommitID: 8774cce7dabd5fb906ff77956aea6fa9443c603b
CommitMsg: files

FilePath: webmagic-plugin/src/main/java/us/codecraft/webmagic/pipeline/FreemarkerPipeline.java**
```diff
         if (!file.exists()) {
-            file.mkdir();
+            file.mkdirs();
```
ProjectName: 1649-webmagic
CommitID: 8774cce7dabd5fb906ff77956aea6fa9443c603b
CommitMsg: files

FilePath: webmagic-core/src/main/java/us/codecraft/webmagic/pipeline/FilePipeline.java**
```diff
         if (!file.exists()) {
-            file.mkdir();
+            file.mkdirs();
```
ProjectName: 5590-bitcoinj
CommitID: bc97cf977f5d9795f1b5bf43e7005fc631133ea0
CommitMsg: Handle creation of non existing parent directories. Improve exception message.

FilePath: core/src/main/java/com/google/bitcoin/kits/WalletAppKit.java**
```diff
         if (!directory.exists()) {
-            if (!directory.mkdir()) {
-                throw new IOException("Could not create named directory.");
+            if (!directory.mkdirs()) {
+                throw new IOException("Could not create directory " + directory.getAbsolutePath());
```
ProjectName: 1272-flink
CommitID: 721640778aa88b6491baf837278a873493f283f0
CommitMsg: [FLINK-6541] Improve tmp dir setup in TM/WebMonitor

This closes #3894.

FilePath: flink-runtime-web/src/main/java/org/apache/flink/runtime/webmonitor/WebRuntimeMonitor.java**
```diff
 			// the upload directory should either 1. exist and writable or 2. can be created and writable
-			if (!(uploadDir.exists() && uploadDir.canWrite()) && !(uploadDir.mkdir() && uploadDir.canWrite())) {
+			if (!(uploadDir.exists() && uploadDir.canWrite()) && !(uploadDir.mkdirs() && uploadDir.canWrite())) {
```
ProjectName: 3760-robolectric
CommitID: 15c1a6e605dce93123442f71e8f543d321592556
CommitMsg: Cleanup temporary files between test runs.

Closes #1330.

FilePath: robolectric-shadows/shadows-core/src/main/java/org/robolectric/shadows/ShadowContext.java**
```diff
   public File getExternalCacheDir() {
-    EXTERNAL_CACHE_DIR.mkdir();
+    EXTERNAL_CACHE_DIR.mkdirs();
```
ProjectName: 7427-hive
CommitID: b674192b090f68c612a7a6e605218a566ea41f00
CommitMsg: HIVE-2654 "hive.querylog.location" requires parent directory to be exist or
          else folder creation fails (Chinna Rao Lalam via namit)



git-svn-id: https://svn.apache.org/repos/asf/hive/trunk@1214891 13f79535-47bb-0310-9956-ffa450edef68

FilePath: ql/src/java/org/apache/hadoop/hive/ql/history/HiveHistory.java**
```diff
       if (!f.exists()) {
-        if (!f.mkdir()) {
+        if (!f.mkdirs()) {
```
ProjectName: 13675-framework
CommitID: ff9c8684698a7c57ea5b040be23c7a883713125a
CommitMsg: Allow the linker to handle deeper folder hierarchies inside the public
folder (#10593)

Change-Id: Ice5ed6f3d83fdc200201cd329089ed95b4e6744b

FilePath: client-compiler/src/com/vaadin/sass/linker/SassLinker.java**
```diff
         if (!tempDir.exists()) {
-            tempDir.mkdir();
+            tempDir.mkdirs();
```

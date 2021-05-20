###  infomation 
method del:
-org.apache.log.Logger.info()
method add：
+org.apache.log.Logger.debug()
###  support count
project count : 1
commit count : 20
###  code
ProjectName: 5818-jmeter
CommitID: 3fe566dadd977b35371dfb5cfbef46fbf062e717
CommitMsg: Reduce log level (duplicates message from JMeterThread)

git-svn-id: https://svn.apache.org/repos/asf/jmeter/trunk@1378856 13f79535-47bb-0310-9956-ffa450edef68

Former-commit-id: f10e3eea90f5f4e89e4265c65520c59b0251e76b
FilePath: src/core/org/apache/jmeter/threads/ThreadGroup.java**
```diff
     public void threadFinished(JMeterThread thread) {
-        log.info("Ending thread " + thread.getThreadName());
+        log.debug("Ending thread " + thread.getThreadName());
```
ProjectName: 5818-jmeter
CommitID: 16f377a13f0763dce9ed3a74904bf22dacc429b5
CommitMsg: Reduce logging; allow level to be specified; default to INFO level

git-svn-id: https://svn.apache.org/repos/asf/jakarta/jmeter/trunk@1163468 13f79535-47bb-0310-9956-ffa450edef68

Former-commit-id: d31a87efb84604a9e00db37a49d070b381127fdf
FilePath: src/protocol/http/org/apache/jmeter/protocol/http/control/HttpMirrorServer.java**
```diff
                         HttpMirrorThread thd = new HttpMirrorThread(clientSocket);
-                        log.info("Starting new Mirror thread");
+                        log.debug("Starting new Mirror thread");
```
ProjectName: 5818-jmeter
CommitID: 16f377a13f0763dce9ed3a74904bf22dacc429b5
CommitMsg: Reduce logging; allow level to be specified; default to INFO level

git-svn-id: https://svn.apache.org/repos/asf/jakarta/jmeter/trunk@1163468 13f79535-47bb-0310-9956-ffa450edef68

Former-commit-id: d31a87efb84604a9e00db37a49d070b381127fdf
FilePath: src/protocol/http/org/apache/jmeter/protocol/http/control/HttpMirrorThread.java**
```diff
     public void run() {
-        log.info("Starting thread");
+        log.debug("Starting thread");
```
ProjectName: 5818-jmeter
CommitID: 16f377a13f0763dce9ed3a74904bf22dacc429b5
CommitMsg: Reduce logging; allow level to be specified; default to INFO level

git-svn-id: https://svn.apache.org/repos/asf/jakarta/jmeter/trunk@1163468 13f79535-47bb-0310-9956-ffa450edef68

Former-commit-id: d31a87efb84604a9e00db37a49d070b381127fdf
FilePath: src/protocol/http/org/apache/jmeter/protocol/http/control/HttpMirrorThread.java**
```diff
         }
-        log.info("End of Thread");
+        log.debug("End of Thread");
```
ProjectName: 5818-jmeter
CommitID: a54dc411d6de807d201c46b9ce3864966f062e83
CommitMsg: Too noisy

git-svn-id: https://svn.apache.org/repos/asf/jakarta/jmeter/trunk@1064748 13f79535-47bb-0310-9956-ffa450edef68

Former-commit-id: aee9d465ab10d2174f517b9903a792aa107c7db0
FilePath: src/core/org/apache/jmeter/samplers/RemoteListenerWrapper.java**
```diff
     public void testStarted() {
-        log.info("Test Started()");
+        log.debug("Test Started()");
```
ProjectName: 5818-jmeter
CommitID: a54dc411d6de807d201c46b9ce3864966f062e83
CommitMsg: Too noisy

git-svn-id: https://svn.apache.org/repos/asf/jakarta/jmeter/trunk@1064748 13f79535-47bb-0310-9956-ffa450edef68

Former-commit-id: aee9d465ab10d2174f517b9903a792aa107c7db0
FilePath: src/core/org/apache/jmeter/samplers/RemoteListenerWrapper.java**
```diff
     public void testStarted(String host) {
-        log.info("Test Started on " + host); // should this be debug?
+        log.debug("Test Started on " + host);
```
ProjectName: 5818-jmeter
CommitID: 668e5a6334b32d52147331bb109cc20790f1610e
CommitMsg: Downgrade log message to debug

git-svn-id: https://svn.apache.org/repos/asf/jakarta/jmeter/trunk@1064352 13f79535-47bb-0310-9956-ffa450edef68

Former-commit-id: 97a7f15b856f28cfb9f7562200202d1b490e79b1
FilePath: src/core/org/apache/jmeter/engine/ConvertListeners.java**
```diff
             if (item instanceof AbstractThreadGroup) {
-                log.info("num threads = " + ((AbstractThreadGroup) item).getNumThreads());
+                log.debug("num threads = " + ((AbstractThreadGroup) item).getNumThreads());
```
ProjectName: 5818-jmeter
CommitID: f658c67c5302289c424581ffdcf20a190f904e95
CommitMsg: Fix possible NPE

git-svn-id: https://svn.apache.org/repos/asf/jakarta/jmeter/trunk@938057 13f79535-47bb-0310-9956-ffa450edef68

Former-commit-id: ce73ea46cae03e0ff7b8bbd57fd3590bf4014a7f
FilePath: src/protocol/jms/org/apache/jmeter/protocol/jms/sampler/MessageAdmin.java**
```diff
         }
-        if (!holder.hasReply()) {
-            log.info("Message with " + id + " not found.");
+        if (holder == null || !holder.hasReply()) {
+            log.debug("Message with " + id + " not found.");
```
ProjectName: 5818-jmeter
CommitID: 0bd5bace0d3916fae65bb5101fd434b2b8559442
CommitMsg: Reduce logging output

git-svn-id: https://svn.apache.org/repos/asf/jakarta/jmeter/branches/rel-2-2@524583 13f79535-47bb-0310-9956-ffa450edef68

Former-commit-id: 5243c88634fbcd1c2e732ebfdff3d7960dab8f8d
FilePath: src/core/org/apache/jmeter/gui/util/JMeterMenuBar.java**
```diff
 			if (start.getText().equals(host)) {
-				log.info("Found start host: " + start.getText());
+				log.debug("Found start host: " + start.getText());
```
ProjectName: 5818-jmeter
CommitID: 0bd5bace0d3916fae65bb5101fd434b2b8559442
CommitMsg: Reduce logging output

git-svn-id: https://svn.apache.org/repos/asf/jakarta/jmeter/branches/rel-2-2@524583 13f79535-47bb-0310-9956-ffa450edef68

Former-commit-id: 5243c88634fbcd1c2e732ebfdff3d7960dab8f8d
FilePath: src/core/org/apache/jmeter/gui/util/JMeterMenuBar.java**
```diff
 			if (stop.getText().equals(host)) {
-				log.info("Found stop  host: " + stop.getText());
+				log.debug("Found stop  host: " + stop.getText());
```
ProjectName: 5818-jmeter
CommitID: 0bd5bace0d3916fae65bb5101fd434b2b8559442
CommitMsg: Reduce logging output

git-svn-id: https://svn.apache.org/repos/asf/jakarta/jmeter/branches/rel-2-2@524583 13f79535-47bb-0310-9956-ffa450edef68

Former-commit-id: 5243c88634fbcd1c2e732ebfdff3d7960dab8f8d
FilePath: src/core/org/apache/jmeter/gui/util/JMeterMenuBar.java**
```diff
 			if (exit.getText().equals(host)) {
-				log.info("Found exit  host: " + exit.getText());
+				log.debug("Found exit  host: " + exit.getText());
```
ProjectName: 5818-jmeter
CommitID: 14a4569eff39e344bbd7148001c1a2a32511a4cd
CommitMsg: Downgrade unnecessary log message

git-svn-id: https://svn.apache.org/repos/asf/jakarta/jmeter/branches/rel-2-2@515351 13f79535-47bb-0310-9956-ffa450edef68

Former-commit-id: a15ef336acfc97a79da8c99b36e1d72497e0354b
FilePath: src/core/org/apache/jmeter/gui/SavePropertyDialog.java**
```diff
 		saveConfig = s;
-		log.info("SampleSaveConfiguration = " + saveConfig);// $NON-NLS-1$
+		log.debug("SampleSaveConfiguration = " + saveConfig);// $NON-NLS-1$
```
ProjectName: 5818-jmeter
CommitID: b94c43b60808ae25f76409bcf0f06553cb43d924
CommitMsg: Change log levels to more suitable values

git-svn-id: https://svn.apache.org/repos/asf/jakarta/jmeter/branches/rel-2-1@388319 13f79535-47bb-0310-9956-ffa450edef68

Former-commit-id: 4030bb8e6d30082b6a94a94041229fbcc746b28b
FilePath: src/core/org/apache/jmeter/visualizers/gui/AbstractVisualizer.java**
```diff
 	public void stateChanged(ChangeEvent e) {
-		log.info("getting new collector");
+		log.debug("getting new collector");
```
ProjectName: 5818-jmeter
CommitID: fd452c0232f043be38c44ef1005fa1f4a64cf37d
CommitMsg: Fix missing Help Entry for HTTPClient Sampler
Downgrade intrusive info log message
[Picking up changes from HEAD]


git-svn-id: https://svn.apache.org/repos/asf/jakarta/jmeter/branches/rel-2-1@325644 13f79535-47bb-0310-9956-ffa450edef68

Former-commit-id: 812183214308b52881b4229d46988fe7757d8a17
FilePath: src/protocol/http/org/apache/jmeter/protocol/http/sampler/HTTPSampler2.java**
```diff
 	public void threadStarted() {
-		log.info("Thread Started");
+		log.debug("Thread Started");
```
ProjectName: 5818-jmeter
CommitID: fd452c0232f043be38c44ef1005fa1f4a64cf37d
CommitMsg: Fix missing Help Entry for HTTPClient Sampler
Downgrade intrusive info log message
[Picking up changes from HEAD]


git-svn-id: https://svn.apache.org/repos/asf/jakarta/jmeter/branches/rel-2-1@325644 13f79535-47bb-0310-9956-ffa450edef68

Former-commit-id: 812183214308b52881b4229d46988fe7757d8a17
FilePath: src/protocol/http/org/apache/jmeter/protocol/http/sampler/HTTPSampler2.java**
```diff
 	public void threadFinished() {
-		log.info("Thread Finished");
+		log.debug("Thread Finished");
```
ProjectName: 5818-jmeter
CommitID: a549f491a9bf752c72e042159c1148aa53f5ed0d
CommitMsg: Reduce log level


git-svn-id: https://svn.apache.org/repos/asf/jakarta/jmeter/trunk@325235 13f79535-47bb-0310-9956-ffa450edef68

Former-commit-id: 0ec3788dec07217fea141c6d7b363b81ac5b9caf
FilePath: src/core/org/apache/jmeter/threads/TestCompiler.java**
```diff
             {
-            log.info("adding controller: " + maybeController + " to sampler config");
+            log.debug("adding controller: " + maybeController + " to sampler config");
```
ProjectName: 5818-jmeter
CommitID: 23e818af6f705b175c5bdea2e03c2344f90aacbc
CommitMsg: Change info message to debug


git-svn-id: https://svn.apache.org/repos/asf/jakarta/jmeter/trunk@324807 13f79535-47bb-0310-9956-ffa450edef68

Former-commit-id: 70f822c7fc9170907f8072488715f690aac39bef
FilePath: src/protocol/tcp/org/apache/jmeter/protocol/tcp/sampler/TCPSampler.java**
```diff
     {
-    	log.info(getLabel()+" "+getFilename()+" "+getUsername()+" "+getPassword());
+    	log.debug(getLabel()+" "+getFilename()+" "+getUsername()+" "+getPassword());
```
ProjectName: 5818-jmeter
CommitID: 571284ec59907cea280aea746d01df04a7e75128
CommitMsg: Avoid logging ugly useless stack dumps at startup.


git-svn-id: https://svn.apache.org/repos/asf/jakarta/jmeter/trunk@324097 13f79535-47bb-0310-9956-ffa450edef68

Former-commit-id: 85845c5409930075b1e85c24b004f8c1a9dee694
FilePath: src/core/org/apache/jmeter/gui/util/MenuFactory.java**
```diff
                 {
-                    log.info("Could not instantiate "+name, e);
+                    log.debug("Could not instantiate "+name, e);
```
ProjectName: 5818-jmeter
CommitID: 7ba93cb4ebf2cd182fda0518a90fd28794428a0b
CommitMsg: Reduce the default logging output


git-svn-id: https://svn.apache.org/repos/asf/jakarta/jmeter/trunk@324013 13f79535-47bb-0310-9956-ffa450edef68

Former-commit-id: ac6aa855bced3680e59e4429e197d5ca1332e31c
FilePath: src/protocol/http/org/apache/jmeter/protocol/http/parser/HTMLParser.java**
```diff
 		if (pars != null){
-			log.info("Fetched "+htmlParserClassName);
+			log.debug("Fetched "+htmlParserClassName);
```
ProjectName: 5818-jmeter
CommitID: 7ba93cb4ebf2cd182fda0518a90fd28794428a0b
CommitMsg: Reduce the default logging output


git-svn-id: https://svn.apache.org/repos/asf/jakarta/jmeter/trunk@324013 13f79535-47bb-0310-9956-ffa450edef68

Former-commit-id: ac6aa855bced3680e59e4429e197d5ca1332e31c
FilePath: src/protocol/http/org/apache/jmeter/protocol/http/parser/HTMLParser.java**
```diff
 		{
-			log.info("file   "+file);
+			log.debug("file   "+file);
```

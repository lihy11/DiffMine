###  infomation 
method del:
-org.apache.logging.log4j.Logger.warn()
method add：
+org.apache.logging.log4j.Logger.debug()
###  support count
project count : 3
commit count : 10
###  code
ProjectName: 41143-sitewhere
CommitID: f828a6ce01a309bd8a28d97b321b26e357321085
CommitMsg: Allow more graceful handling of uninitialized server/tracer.
FilePath: sitewhere-core/src/main/java/com/sitewhere/Tracer.java**
```diff
 	protected static ITracer getTracer() {
-		if (SiteWhere.getServer() == null) {
-			LOGGER.warn("Tracer called, but server does not exist. Check log file for errors on startup.");
+		if (!SiteWhere.isServerAvailable()) {
+			LOGGER.debug("Tracer called, but server does not exist. Check log file for errors on startup.");
```
ProjectName: 21551-struts
CommitID: 20c54df03a4e2f7be53a4f08061b658ae76fc847
CommitMsg: WW-4733 Reduces noise in the logs

FilePath: core/src/main/java/com/opensymphony/xwork2/config/providers/XmlConfigurationProvider.java**
```diff
                         } else {
-                            LOG.warn("No default parameter defined for result [{}] of type [{}] ", config.getName(), config.getClassName());
+                            LOG.debug("No default parameter defined for result [{}] of type [{}] ", config.getName(), config.getClassName());
```
ProjectName: 13882-blynk-server
CommitID: 0088e8929d05509b10f66347f252dffc3962a856
CommitMsg: less logging for know warning

FilePath: server/core/src/main/java/cc/blynk/server/handlers/common/UserNotLoggedHandler.java**
```diff
     protected void channelRead0(ChannelHandlerContext ctx, MessageBase msg) throws Exception {
-        log.warn("User not logged. {}. Closing.", ctx.channel().remoteAddress());
+        log.debug("User not logged. {}. Closing.", ctx.channel().remoteAddress());
```
ProjectName: 13882-blynk-server
CommitID: 406b60ad187df3d08c9fb9fa7979e2ebd5f9c3d0
CommitMsg: less spam in logs

FilePath: server/core/src/main/java/cc/blynk/server/handlers/common/HardwareNotLoggedHandler.java**
```diff
         if (now - lastLoggedTs > 1000) {
-            log.warn("Hardware not logged. {}. Closing.", ctx.channel().remoteAddress());
+            log.debug("Hardware not logged. {}. Closing.", ctx.channel().remoteAddress());
```
ProjectName: 13882-blynk-server
CommitID: 5c6e2405f3ce980353993b730fc6aae0a837d573
CommitMsg: less logging for http error

FilePath: server/http-core/src/main/java/cc/blynk/core/http/rest/params/BodyParam.java**
```diff
                 } catch (JsonParseException | JsonMappingException jsonParseError) {
-                    log.warn("Error parsing body param : '{}'.", data);
+                    log.debug("Error parsing body param : '{}'.", data);
```
ProjectName: 13882-blynk-server
CommitID: b2dfe2ff79e64b1d47ac86201ac546e8e23022bc
CommitMsg: less logging

FilePath: server/tcp-app-server/src/main/java/cc/blynk/server/application/handlers/main/auth/GetServerHandler.java**
```diff
         } else {
-            log.warn("Searching user {}-{} on another server.", email, appName);
+            log.debug("Searching user {}-{} on another server.", email, appName);
```
ProjectName: 13882-blynk-server
CommitID: ccce3ed7065054bb4941fcd6569405507645cb30
CommitMsg: #542 less logging for knows issues 2.

FilePath: server/core/src/main/java/cc/blynk/server/core/protocol/handlers/DefaultExceptionHandler.java**
```diff
             } else if (cause.getCause() instanceof SSLException) {
-                log.warn("Unsecured connection attempt. Channel : {}. Reason : {}", ctx.channel().remoteAddress(), cause.getMessage());
+                log.debug("Unsecured connection attempt. Channel : {}. Reason : {}", ctx.channel().remoteAddress(), cause.getMessage());
```
ProjectName: 13882-blynk-server
CommitID: ccce3ed7065054bb4941fcd6569405507645cb30
CommitMsg: #542 less logging for knows issues 2.

FilePath: server/core/src/main/java/cc/blynk/server/core/protocol/handlers/DefaultExceptionHandler.java**
```diff
         } else if (cause instanceof NotSslRecordException) {
-            log.warn("Not secure connection attempt detected. {}. IP {}", cause.getMessage(), ctx.channel().remoteAddress());
+            log.debug("Not secure connection attempt detected. {}. IP {}", cause.getMessage(), ctx.channel().remoteAddress());
```
ProjectName: 13882-blynk-server
CommitID: 3f19ec905dcf3598da88d517010f63c9409fdc59
CommitMsg: #542 less logging for knows issues.

FilePath: server/http-api/src/main/java/cc/blynk/server/api/http/logic/HttpAPILogic.java**
```diff
         if (tokenValue == null) {
-            log.warn("Requested token {} not found.", token);
+            log.debug("Requested token {} not found.", token);
```
ProjectName: 13882-blynk-server
CommitID: 3f19ec905dcf3598da88d517010f63c9409fdc59
CommitMsg: #542 less logging for knows issues.

FilePath: server/http-api/src/main/java/cc/blynk/server/api/http/logic/HttpAPILogic.java**
```diff
         if (tokenValue == null) {
-            log.warn("Requested token {} not found.", token);
+            log.debug("Requested token {} not found.", token);
```

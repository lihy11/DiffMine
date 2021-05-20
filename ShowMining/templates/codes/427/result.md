###  infomation 
method del:
-org.apache.logging.log4j.Logger.error()
method add：
+org.apache.logging.log4j.Logger.warn()
###  support count
project count : 1
commit count : 11
###  code
ProjectName: 13882-blynk-server
CommitID: d7f5d9e18552faad28ae420828576d49a2a46239
CommitMsg: less logging for clone case

FilePath: server/core/src/main/java/cc/blynk/server/core/dao/FileManager.java**
```diff
         } catch (Exception e) {
-            log.error("Error saving cloned project to disk.", e);
+            log.warn("Error reading cloned project from disk. {}", e.getMessage());
```
ProjectName: 13882-blynk-server
CommitID: ddb51ae880aad15511f279296a30f6c5cd1e23dc
CommitMsg: less logging

FilePath: server/core/src/main/java/cc/blynk/server/core/protocol/handlers/DefaultExceptionHandler.java**
```diff
         } else if (cause instanceof NotSslRecordException) {
-            log.error("Not secure connection attempt detected. {}. IP {}", cause.getMessage(), ctx.channel().remoteAddress());
+            log.warn("Not secure connection attempt detected. {}. IP {}", cause.getMessage(), ctx.channel().remoteAddress());
```
ProjectName: 13882-blynk-server
CommitID: ddb51ae880aad15511f279296a30f6c5cd1e23dc
CommitMsg: less logging

FilePath: server/core/src/main/java/cc/blynk/server/core/protocol/handlers/DefaultExceptionHandler.java**
```diff
         } else if (cause instanceof SSLException) {
-            log.error("SSL exception. {}.", cause.getMessage());
+            log.warn("SSL exception. {}.", cause.getMessage());
```
ProjectName: 13882-blynk-server
CommitID: 457199772516de9b567024c22a30e6480a83f7ae
CommitMsg: warnings instead of errors

FilePath: server/http-api/src/main/java/cc/blynk/server/api/http/logic/HttpAPILogic.java**
```diff
         if (tokenValue == null) {
-            log.error("Requested token {} not found.", token);
+            log.warn("Requested token {} not found.", token);
```
ProjectName: 13882-blynk-server
CommitID: 457199772516de9b567024c22a30e6480a83f7ae
CommitMsg: warnings instead of errors

FilePath: server/http-api/src/main/java/cc/blynk/server/api/http/logic/HttpAPILogic.java**
```diff
         if (tokenValue == null) {
-            log.error("Requested token {} not found.", token);
+            log.warn("Requested token {} not found.", token);
```
ProjectName: 13882-blynk-server
CommitID: 757f6706174a4531655cea066a23666df55e5eeb
CommitMsg: warnings, not errors for some logggins

FilePath: server/core/src/main/java/cc/blynk/server/core/protocol/handlers/DefaultExceptionHandler.java**
```diff
             } else if (cause.getCause() instanceof SSLException) {
-                log.error("Unsecured connection attempt. Channel : {}. Reason : {}", ctx.channel().remoteAddress(), cause.getMessage());
+                log.warn("Unsecured connection attempt. Channel : {}. Reason : {}", ctx.channel().remoteAddress(), cause.getMessage());
```
ProjectName: 13882-blynk-server
CommitID: 757f6706174a4531655cea066a23666df55e5eeb
CommitMsg: warnings, not errors for some logggins

FilePath: server/tcp-app-server/src/main/java/cc/blynk/server/application/handlers/main/auth/AppLoginHandler.java**
```diff
                         if (response.getStatusCode() != 200) {
-                            log.error("Error getting facebook token {} for user {}. Reason : {}", token, username, response.getResponseBody());
+                            log.warn("Error getting facebook token {} for user {}. Reason : {}", token, username, response.getResponseBody());
```
ProjectName: 13882-blynk-server
CommitID: 206878c6d711a8a85a45211b10aa099717654c4b
CommitMsg: less logging for http errors

FilePath: server/http-core/src/main/java/cc/blynk/core/http/rest/params/BodyParam.java**
```diff
                 } catch (JsonParseException | JsonMappingException jsonParseError) {
-                    log.error("Error parsing body '{}' param. {}. Message {}", uriDecoder.getBodyData(), data, jsonParseError.getMessage());
+                    log.warn("Error parsing body param : '{}'.", data);
```
ProjectName: 13882-blynk-server
CommitID: fa792cf0f5f1d880a759fad54ea7bc4f2ef94909
CommitMsg: logging messages simplified

FilePath: server/tcp-app-server/src/main/java/cc/blynk/server/application/handlers/main/auth/AppLoginHandler.java**
```diff
         if (user.pass == null) {
-            log.error("Facebook user tries to login with pass. Username '{}', {}", username, ctx.channel().remoteAddress());
+            log.warn("Facebook user '{}' tries to login with pass. {}", username, ctx.channel().remoteAddress());
```
ProjectName: 13882-blynk-server
CommitID: 83b24d38f0fb95bc26d914f5060ffe0179fcd6ef
CommitMsg: #137 change log level

FilePath: server/core/src/main/java/cc/blynk/server/core/dao/UserDao.java**
```diff
                 if (sum > 74) {
-                    log.error("Error in profile, too many widgets. User : {}. DashId : {}", user.name, dashBoard.id);
+                    log.warn("Error in profile, too many widgets. User : {}. DashId : {}", user.name, dashBoard.id);
```
ProjectName: 13882-blynk-server
CommitID: a48df5f70b3a6d1f4d5129cb019f1d784731e963
CommitMsg: less logging for not logged user

FilePath: server/core/src/main/java/cc/blynk/server/handlers/common/UserNotLoggedHandler.java**
```diff
     protected void channelRead0(ChannelHandlerContext ctx, MessageBase msg) throws Exception {
-        log.error("User not logged. {}. Closing.", ctx.channel().remoteAddress());
+        log.warn("User not logged. {}. Closing.", ctx.channel().remoteAddress());
```

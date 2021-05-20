###  infomation 
method del:
-java.util.Optional.orElse()
method add：
+java.util.Optional.orElseGet()
###  support count
project count : 6
commit count : 12
###  code
ProjectName: 46767-logbook
CommitID: 5a7d15d107a9db1034bd951f4c52ee892d0ba20f
CommitMsg: Use Optional.orElseGet instead of method call

FilePath: logbook-spring-boot-starter/src/main/java/org/zalando/logbook/spring/LogbookAutoConfiguration.java**
```diff
         final String category = properties.getWrite().getCategory();
-        return LoggerFactory.getLogger(Optional.ofNullable(category).orElse(Logbook.class.getName()));
+        return LoggerFactory.getLogger(Optional.ofNullable(category).orElseGet(Logbook.class::getName));
```
ProjectName: 36035-lambda
CommitID: d906dbb4e5c343db4dbd40f2a8bdb24b69e9f7a6
CommitMsg: Make Either.fromOptional lazily evaluate leftFn.

FilePath: src/main/java/com/jnape/palatable/lambda/adt/Either.java**
```diff
         return optional.<Either<L, R>>map(Either::right)
-                .orElse(left(leftFn.get()));
+                .orElseGet(() -> left(leftFn.get()));
```
ProjectName: 29210-java-client
CommitID: a1d8386735fb5c0f34ac1e7184333ece1266a97f
CommitMsg: Avoid making unnecessary function calls

FilePath: src/main/java/io/appium/java_client/pagefactory/WidgetByBuilder.java**
```diff
         return ofNullable(super.buildDefaultBy())
-                .orElse(getByFromDeclaredClass(WhatIsNeeded.DEFAULT_OR_HTML));
+                .orElseGet(() -> getByFromDeclaredClass(WhatIsNeeded.DEFAULT_OR_HTML));
```
ProjectName: 29210-java-client
CommitID: a1d8386735fb5c0f34ac1e7184333ece1266a97f
CommitMsg: Avoid making unnecessary function calls

FilePath: src/main/java/io/appium/java_client/pagefactory/WidgetByBuilder.java**
```diff
         return ofNullable(super.buildMobileNativeBy())
-                .orElse(getByFromDeclaredClass(WhatIsNeeded.MOBILE_NATIVE));
+                .orElseGet(() -> getByFromDeclaredClass(WhatIsNeeded.MOBILE_NATIVE));
```
ProjectName: 29210-java-client
CommitID: b8bc1f09427cff0d8ed38fbcc27038f7b724f2cd
CommitMsg: Build issue fix.

FilePath: src/main/java/io/appium/java_client/remote/AppiumProtocolHandShake.java**
```diff
         Capabilities desired = ofNullable((Capabilities) command.getParameters().get("desiredCapabilities"))
-                .orElse(new DesiredCapabilities());
+                .orElseGet(DesiredCapabilities::new);
```
ProjectName: 29210-java-client
CommitID: b8bc1f09427cff0d8ed38fbcc27038f7b724f2cd
CommitMsg: Build issue fix.

FilePath: src/main/java/io/appium/java_client/remote/AppiumProtocolHandShake.java**
```diff
         Capabilities required = ofNullable((Capabilities) command.getParameters().get("requiredCapabilities"))
-                .orElse(new DesiredCapabilities());
+                .orElseGet(DesiredCapabilities::new);
```
ProjectName: 11873-AxonFramework
CommitID: 4420a3e91ab2c8cc4d6b86328202b6532cd0966e
CommitMsg: Merge remote-tracking branch 'origin/master' into feature/236

FilePath: core/src/main/java/org/axonframework/config/EventHandlingConfiguration.java**
```diff
                 return Optional.of(annAttr.map(attr -> (String) attr.get("processingGroup"))
-                                          .orElse(fallback.apply(o)));
+                                          .orElseGet(() -> fallback.apply(o)));
```
ProjectName: 11873-AxonFramework
CommitID: 4420a3e91ab2c8cc4d6b86328202b6532cd0966e
CommitMsg: Merge remote-tracking branch 'origin/master' into feature/236

FilePath: core/src/main/java/org/axonframework/config/EventHandlingConfiguration.java**
```diff
                              .findFirst()
-                             .orElse(defaultSelector.select(handler).orElseThrow(IllegalStateException::new));
+                             .orElseGet(() -> defaultSelector.select(handler).orElseThrow(IllegalStateException::new));
```
ProjectName: 11873-AxonFramework
CommitID: 958cb70b47ae35a769cba2a8dfa6e845fc069a29
CommitMsg: #532 Wrap invocation of both default and fallback selectors in a lambda

FilePath: core/src/main/java/org/axonframework/config/EventHandlingConfiguration.java**
```diff
                 return Optional.of(annAttr.map(attr -> (String) attr.get("processingGroup"))
-                                          .orElse(fallback.apply(o)));
+                                          .orElseGet(() -> fallback.apply(o)));
```
ProjectName: 11873-AxonFramework
CommitID: 958cb70b47ae35a769cba2a8dfa6e845fc069a29
CommitMsg: #532 Wrap invocation of both default and fallback selectors in a lambda

FilePath: core/src/main/java/org/axonframework/config/EventHandlingConfiguration.java**
```diff
                              .findFirst()
-                             .orElse(defaultSelector.select(handler).orElseThrow(IllegalStateException::new));
+                             .orElseGet(() -> defaultSelector.select(handler).orElseThrow(IllegalStateException::new));
```
ProjectName: 5737-junit5
CommitID: 3295c15bc76a94fb4863c6e2da1091a837f5aeaf
CommitMsg: Use Options.orElseGet instead of orElse

For the two cases where the else value is actually computed.

FilePath: junit-platform-surefire-provider/src/main/java/org/junit/platform/surefire/provider/RunListenerAdapter.java**
```diff
 	public void executionSkipped(TestIdentifier testIdentifier, String reason) {
-		String source = getClassName(testIdentifier).orElse(parentDisplayName(testIdentifier));
+		String source = getClassName(testIdentifier).orElseGet(() -> parentDisplayName(testIdentifier));
```
ProjectName: 2454-cas
CommitID: 05b68ac43f056e5f19c5055a789cba37c5d8211b
CommitMsg: minor code formatting fixes

FilePath: core/cas-server-core-services/src/main/java/org/apereo/cas/config/CasCoreServicesConfiguration.java**
```diff
                 + "Ideally for production, you should choose a storage option (JSON, JDBC, MongoDb, etc) to track service definitions.");
-            val services = getInMemoryRegisteredServices().orElse(new ArrayList<>());
+            val services = getInMemoryRegisteredServices().orElseGet(ArrayList::new);
```

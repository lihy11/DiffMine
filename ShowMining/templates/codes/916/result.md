###  infomation 
method del:
-null.debug()
method add：
+null.trace()
###  support count
project count : 9
commit count : 33
###  code
ProjectName: 53780-alf.io
CommitID: a81272588b9d9740ebcbfd415e3c10de9ade61ba
CommitMsg: reduce log level

(cherry picked from commit 50d3fe3d9c3fcfbd47a347f9b428b1f3f3ca2149)

FilePath: src/main/java/alfio/manager/TicketReservationManager.java**
```diff
                 } else {
-                    log.debug("Will not cleanup reservation with id {} because the automatic removal has been disabled", reservationId);
+                    log.trace("Will not cleanup reservation with id {} because the automatic removal has been disabled", reservationId);
```
ProjectName: 40244-copycat
CommitID: e321984a80b0155714dd1c53d7a976d2ae877651
CommitMsg: Change log levels for some log messages.

FilePath: server/src/main/java/io/atomix/copycat/server/state/LeaderState.java**
```diff
       index = context.getLog().append(entry);
-      LOGGER.debug("{} - Appended {}", context.getCluster().member().address(), entry);
+      LOGGER.trace("{} - Appended {}", context.getCluster().member().address(), entry);
```
ProjectName: 35273-spring-cloud-consul
CommitID: 675b7e6c54f90d841a20583bdc836e45e1c81a51
CommitMsg: changed debug to trace

FilePath: spring-cloud-consul-discovery/src/main/java/org/springframework/cloud/consul/discovery/ConsulCatalogWatch.java**
```diff
 
-		log.debug("Received services update from consul: {}", response.getValue());
+		log.trace("Received services update from consul: {}, index: {}", response.getValue(), consulIndex);
```
ProjectName: 36240-Discord4J
CommitID: 24f2460f3fe3251c35b4c91cb22673b30d776249
CommitMsg: Improved some logging

FilePath: src/main/java/sx/blah/discord/api/EventDispatcher.java**
```diff
 		if (client.isReady()) {
-			Discord4J.LOGGER.debug("Dispatching event of type {}", event.getClass().getSimpleName());
+			Discord4J.LOGGER.trace("Dispatching event of type {}", event.getClass().getSimpleName());
```
ProjectName: 36240-Discord4J
CommitID: b5fe5fb36ad22bc641260342a04b617851fe9cee
CommitMsg: Moved ping pong messages down to trace

FilePath: src/main/java/sx/blah/discord/api/internal/DiscordWS.java**
```diff
 			} else {
-				Discord4J.LOGGER.debug("Sending ping...");
+				Discord4J.LOGGER.trace("Sending ping...");
```
ProjectName: 36240-Discord4J
CommitID: b5fe5fb36ad22bc641260342a04b617851fe9cee
CommitMsg: Moved ping pong messages down to trace

FilePath: src/main/java/sx/blah/discord/api/internal/DiscordWS.java**
```diff
 		} else {
-			Discord4J.LOGGER.debug("Received pong... Response time is {}ms", pingResponseTime = System.currentTimeMillis()-lastPingSent);
+			Discord4J.LOGGER.trace("Received pong... Response time is {}ms", pingResponseTime = System.currentTimeMillis()-lastPingSent);
```
ProjectName: 21288-JDA
CommitID: 4f33b81b3033ffb17f4a868d54a969540262ad5b
CommitMsg: Fix index exception in combined mixing

FilePath: src/main/java/net/dv8tion/jda/core/audio/AudioPacket.java**
```diff
         {
-            AudioConnection.LOG.debug("Failed to decrypt audio packet");
+            AudioConnection.LOG.trace("Failed to decrypt audio packet");
```
ProjectName: 29689-mina
CommitID: c9c1be1e8cc5553eec922461596f8564a8f5b15d
CommitMsg: lower log level for very frequent messages

FilePath: core/src/main/java/org/apache/mina/service/idlechecker/IndexedIdleChecker.java**
```diff
         lastCheckTimeMs = timeMs;
-        LOG.debug("detected {} idleing sessions", counter);
+        LOG.trace("detected {} idleing sessions", counter);
```
ProjectName: 13882-blynk-server
CommitID: 4a6ef68ab0a6254da539db8c07edb319270942fc
CommitMsg: less logging for known cases 2

FilePath: server/http-core/src/main/java/cc/blynk/core/http/TokenBaseHttpHandler.java**
```diff
         } else {
-            log.debug("Re registering http channel. {}", ctx.channel());
+            log.trace("Re registering http channel. {}", ctx.channel());
```
ProjectName: 13882-blynk-server
CommitID: 4a6ef68ab0a6254da539db8c07edb319270942fc
CommitMsg: less logging for known cases 2

FilePath: server/http-core/src/main/java/cc/blynk/core/http/TokenBaseHttpHandler.java**
```diff
         channel.writeAndFlush(response);
-        log.debug("Re registering http channel finished.");
+        log.trace("Re registering http channel finished.");
```
ProjectName: 13882-blynk-server
CommitID: 467509dbd0029dadee9c5b26c569dfe3d25fc2bd
CommitMsg: less logging for known cases

FilePath: server/launcher/src/main/java/cc/blynk/server/servers/application/AppAndHttpsServer.java**
```diff
 
-                log.debug("In http and websocket unificator handler.");
+                log.trace("In http and websocket unificator handler.");
```
ProjectName: 13882-blynk-server
CommitID: 467509dbd0029dadee9c5b26c569dfe3d25fc2bd
CommitMsg: less logging for known cases

FilePath: server/launcher/src/main/java/cc/blynk/server/servers/hardware/HardwareAndHttpAPIServer.java**
```diff
 
-                log.debug("In http and websocket unificator handler.");
+                log.trace("In http and websocket unificator handler.");
```
ProjectName: 13882-blynk-server
CommitID: 3edb1903d8d7f6f33f2a0e535b9ac35b29dfff0f
CommitMsg: less logging in debug mode

FilePath: server/tcp-hardware-server/src/main/java/cc/blynk/server/hardware/handlers/hardware/logic/HardwareLogic.java**
```diff
             } else {
-                log.debug("No active dashboard.");
+                log.trace("No active dashboard.");
```
ProjectName: 2454-cas
CommitID: 2e25e33cf0bb9932026b7306cad8fabe376e29ab
CommitMsg: updated

FilePath: support/cas-server-support-surrogate-webflow/src/main/java/org/apereo/cas/web/flow/action/LoadSurrogatesListAction.java**
```diff
             WebUtils.removeRequestSurrogateAuthenticationRequest(requestContext);
-            LOGGER.debug("Attempting to load surrogates...");
+            LOGGER.trace("Attempting to load surrogates...");
```
ProjectName: 2454-cas
CommitID: 82852aee1e52fb0662e9d9713cdb9f13438f5658
CommitMsg: minor cleanup + checkstyle

FilePath: core/cas-server-core-cookie-api/src/main/java/org/apereo/cas/web/support/DefaultCasCookieValueManager.java**
```diff
         } else {
-            LOGGER.debug("Cookie session-pinning is disabled");
+            LOGGER.trace("Cookie session-pinning is disabled");
```
ProjectName: 2454-cas
CommitID: 82852aee1e52fb0662e9d9713cdb9f13438f5658
CommitMsg: minor cleanup + checkstyle

FilePath: core/cas-server-core-cookie-api/src/main/java/org/apereo/cas/web/support/DefaultCasCookieValueManager.java**
```diff
         if (!cookieProperties.isPinToSession()) {
-            LOGGER.debug("Cookie session-pinning is disabled. Returning cookie value as it was provided");
+            LOGGER.trace("Cookie session-pinning is disabled. Returning cookie value as it was provided");
```
ProjectName: 2454-cas
CommitID: f78f08cfc54a5bbc439f98a8348e682c0956df4c
CommitMsg: dependency bumps for boot+tomcat

FilePath: webapp/cas-server-webapp-config/src/main/java/org/apereo/cas/web/security/CasWebSecurityConfigurerAdapter.java**
```diff
                 val defaultAccessRules = endpointDefaults.getAccess();
-                LOGGER.debug("Endpoint security is NOT defined for endpoint [{}]. Using default security rules [{}]", rootPath, endpointDefaults);
+                LOGGER.trace("Endpoint security is NOT defined for endpoint [{}]. Using default security rules [{}]", rootPath, endpointDefaults);
```
ProjectName: 2454-cas
CommitID: 679e22a3a92457ca158f5488084a0beb2bb99f4e
CommitMsg: fix filer service extraction

FilePath: support/cas-server-support-saml-idp-metadata/src/main/java/org/apereo/cas/support/saml/services/idp/metadata/cache/SamlRegisteredServiceMetadataExpirationPolicy.java**
```diff
                                   final long currentTime, final long currentDuration) {
-        LOGGER.debug("Cache expiration duration after updates is set to [{}]", currentDuration);
+        LOGGER.trace("Cache expiration duration after updates is set to [{}]", currentDuration);
```
ProjectName: 2454-cas
CommitID: 679e22a3a92457ca158f5488084a0beb2bb99f4e
CommitMsg: fix filer service extraction

FilePath: support/cas-server-support-saml-idp-metadata/src/main/java/org/apereo/cas/support/saml/services/idp/metadata/cache/SamlRegisteredServiceMetadataExpirationPolicy.java**
```diff
                                 final long currentTime, final long currentDuration) {
-        LOGGER.debug("Cache expiration duration after reads is set to [{}]", currentDuration);
+        LOGGER.trace("Cache expiration duration after reads is set to [{}]", currentDuration);
```
ProjectName: 2454-cas
CommitID: 4e35c5b6e305a7bc35d3243e92a64ec88c75e1c8
CommitMsg: fix tests

FilePath: core/cas-server-core-webflow-mfa-api/src/main/java/org/apereo/cas/web/flow/resolver/impl/mfa/DefaultMultifactorAuthenticationProviderEventResolver.java**
```diff
         return result.map(provider -> {
-            LOGGER.debug("Attempting to build an event based on the authentication provider [{}] and service [{}]", provider, registeredService.getName());
+            LOGGER.trace("Attempting to build an event based on the authentication provider [{}] and service [{}]", provider, registeredService);
```
ProjectName: 2454-cas
CommitID: 5d4be233fec77ffb5ea4b6cbf5662b878cbec32d
CommitMsg: small logging update

FilePath: core/cas-server-core-webflow-mfa-api/src/main/java/org/apereo/cas/web/flow/resolver/impl/mfa/GlobalMultifactorAuthenticationPolicyEventResolver.java**
```diff
             val provider = providerFound.get();
-            LOGGER.debug("Attempting to build an event based on the authentication provider [{}] and service [{}]", provider, service);
+            LOGGER.trace("Attempting to build an event based on the authentication provider [{}] and service [{}]", provider, service);
```
ProjectName: 2454-cas
CommitID: aa2220dd03a080552de6d67cc3a212b354ff93c3
CommitMsg: working on banner detection

FilePath: core/cas-server-core-util-api/src/main/java/org/apereo/cas/util/cipher/AbstractCipherExecutor.java**
```diff
                 setSigningKey(new AesKey(signingSecretKey.getBytes(StandardCharsets.UTF_8)));
-                LOGGER.debug("Created signing key instance [{}] based on provided secret key", this.signingKey.getClass().getSimpleName());
+                LOGGER.trace("Created signing key instance [{}] based on provided secret key", this.signingKey.getClass().getSimpleName());
```
ProjectName: 2454-cas
CommitID: 699b685d6fd79200ce1ca7f038af9b3525211b6c
CommitMsg: Merge branch 'master' of github.com:apereo/cas

FilePath: support/cas-server-support-pac4j-webflow/src/main/java/org/apereo/cas/web/DelegatedAuthenticationWebApplicationServiceFactory.java**
```diff
         val clientName = request.getParameter(Pac4jConstants.DEFAULT_CLIENT_NAME_PARAMETER);
-        LOGGER.debug("Indicated client name for service extraction is [{}]", clientName);
+        LOGGER.trace("Indicated client name for service extraction is [{}]", clientName);
```
ProjectName: 2454-cas
CommitID: 699b685d6fd79200ce1ca7f038af9b3525211b6c
CommitMsg: Merge branch 'master' of github.com:apereo/cas

FilePath: support/cas-server-support-pac4j-webflow/src/main/java/org/apereo/cas/web/DelegatedAuthenticationWebApplicationServiceFactory.java**
```diff
         if (StringUtils.isBlank(clientName)) {
-            LOGGER.debug("No client name found in the request");
+            LOGGER.trace("No client name found in the request");
```
ProjectName: 2454-cas
CommitID: 78fc02f65e2a728f0f663cac6c21b71a570c114c
CommitMsg: Update DelegatedAuthenticationWebApplicationServiceFactory.java
FilePath: support/cas-server-support-pac4j-webflow/src/main/java/org/apereo/cas/web/DelegatedAuthenticationWebApplicationServiceFactory.java**
```diff
         val clientName = request.getParameter(Pac4jConstants.DEFAULT_CLIENT_NAME_PARAMETER);
-        LOGGER.debug("Indicated client name for service extraction is [{}]", clientName);
+        LOGGER.trace("Indicated client name for service extraction is [{}]", clientName);
```
ProjectName: 2454-cas
CommitID: 78fc02f65e2a728f0f663cac6c21b71a570c114c
CommitMsg: Update DelegatedAuthenticationWebApplicationServiceFactory.java
FilePath: support/cas-server-support-pac4j-webflow/src/main/java/org/apereo/cas/web/DelegatedAuthenticationWebApplicationServiceFactory.java**
```diff
         if (StringUtils.isBlank(clientName)) {
-            LOGGER.debug("No client name found in the request");
+            LOGGER.trace("No client name found in the request");
```
ProjectName: 2454-cas
CommitID: e8e374b6d646d6b1913fd8a85001547f161402ca
CommitMsg: switch saml sp cache key to use metadata loc instead

FilePath: support/cas-server-support-saml-idp-metadata/src/main/java/org/apereo/cas/support/saml/services/idp/metadata/cache/SamlRegisteredServiceCacheKey.java**
```diff
     public static String buildRegisteredServiceCacheKey(final SamlRegisteredService service) {
-        val key = String.valueOf(service.getId()).concat("@").concat(service.getName());
-        LOGGER.debug("Determined cache key for service [{}] as [{}]", service.getName(), key);
+        val key = service.getMetadataLocation();
+        LOGGER.trace("Determined cache key for service [{}] as [{}]", service.getName(), key);
```
ProjectName: 2454-cas
CommitID: e8e374b6d646d6b1913fd8a85001547f161402ca
CommitMsg: switch saml sp cache key to use metadata loc instead

FilePath: support/cas-server-support-saml-idp-metadata/src/main/java/org/apereo/cas/support/saml/services/idp/metadata/cache/SamlRegisteredServiceCacheKey.java**
```diff
         val hashedKey = DigestUtils.sha512(key);
-        LOGGER.debug("Hashed service cache key as [{}]", hashedKey);
+        LOGGER.trace("Hashed service cache key as [{}]", hashedKey);
```
ProjectName: 2454-cas
CommitID: f2f07108bd4deb3307b0aac770cf9742b18d82fe
CommitMsg: updated

FilePath: core/cas-server-core-util-api/src/main/java/org/apereo/cas/util/InetAddressUtils.java**
```diff
         } catch (final Exception e) {
-            LOGGER.debug("Host name could not be determined automatically.", e);
+            LOGGER.trace("Host name could not be determined automatically.", e);
```
ProjectName: 2454-cas
CommitID: 824c6d156681faad9e1b371d3c7d27f5b91c77cb
CommitMsg: fixed bug with interrupt

FilePath: support/cas-server-support-saml/src/main/java/org/apereo/cas/support/saml/authentication/principal/SamlServiceFactory.java**
```diff
         if (!StringUtils.hasText(service) && !StringUtils.hasText(requestBody)) {
-            LOGGER.debug("Request does not specify a [{}] or request body is empty", SamlProtocolConstants.CONST_PARAM_TARGET);
+            LOGGER.trace("Request does not specify a [{}] or request body is empty", SamlProtocolConstants.CONST_PARAM_TARGET);
```
ProjectName: 16050-optaplanner
CommitID: 46812eb1c9a09ce4ae34f8e993542077c781802f
CommitMsg: lower logging level for movescope stuff

FilePath: drools-planner-examples/src/main/java/org/drools/planner/examples/travelingtournament/solver/smart/move/factory/SmartTravelingTournamentMoveFactory.java**
```diff
         RotationMovesFactory rotationMovesFactory = new RotationMovesFactory(travelingTournament);
-        logger.debug("Reused {} moves for N1 neighborhood.", moveList.size());
+        logger.trace("Reused {} moves for N1 neighborhood.", moveList.size());
```
ProjectName: 16050-optaplanner
CommitID: 46812eb1c9a09ce4ae34f8e993542077c781802f
CommitMsg: lower logging level for movescope stuff

FilePath: drools-planner-examples/src/main/java/org/drools/planner/examples/travelingtournament/solver/smart/move/factory/SmartTravelingTournamentMoveFactory.java**
```diff
         rotationMovesFactory.addDayRotation(moveList);
-        logger.debug("Created {} moves for N3 U N5 neighborhood.", (moveList.size() - oldSize));
+        logger.trace("Created {} moves for N3 U N5 neighborhood.", (moveList.size() - oldSize));
```
ProjectName: 16050-optaplanner
CommitID: 46812eb1c9a09ce4ae34f8e993542077c781802f
CommitMsg: lower logging level for movescope stuff

FilePath: drools-planner-examples/src/main/java/org/drools/planner/examples/travelingtournament/solver/smart/move/factory/SmartTravelingTournamentMoveFactory.java**
```diff
         rotationMovesFactory.addTeamRotation(moveList);
-        logger.debug("Created {} moves for N2 U N4 neighborhood.", (moveList.size() - oldSize));
+        logger.trace("Created {} moves for N2 U N4 neighborhood.", (moveList.size() - oldSize));
```

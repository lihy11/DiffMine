###  infomation 
method del:
-java.util.Optional.of()
method add：
+java.util.Optional.ofNullable()
###  support count
project count : 18
commit count : 27
###  code
ProjectName: 53780-alf.io
CommitID: 2fd08955d5240034cc7dfa94f5fc76fa238b1187
CommitMsg: payment result: fix cases where gatewayId is null: use Optional.ofNullable, reservation flow integration test: check transaction status.

FilePath: src/main/java/alfio/manager/support/PaymentResult.java**
```diff
     private PaymentResult setErrorCode( String errorCode ) {
-        this.errorCode = Optional.of(errorCode);
+        this.errorCode = Optional.ofNullable(errorCode);
```
ProjectName: 53780-alf.io
CommitID: 2fd08955d5240034cc7dfa94f5fc76fa238b1187
CommitMsg: payment result: fix cases where gatewayId is null: use Optional.ofNullable, reservation flow integration test: check transaction status.

FilePath: src/main/java/alfio/manager/support/PaymentResult.java**
```diff
     private PaymentResult setGatewayId(String gatewayId) {
-        this.gatewayId = Optional.of(gatewayId);
+        this.gatewayId = Optional.ofNullable(gatewayId);
```
ProjectName: 30422-RichTextFX
CommitID: 972249afc6a68d81dcc45f6088d845a88bacbe5a
CommitMsg: Fix rare case where NPE is thrown when resizing the Scene

FilePath: richtextfx/src/main/java/org/fxmisc/richtext/ParagraphText.java**
```diff
             Bounds localBounds = selectionShape.getBoundsInLocal();
-            return Optional.of(selectionShape.localToScreen(localBounds));
+            return Optional.ofNullable(selectionShape.localToScreen(localBounds));
```
ProjectName: 32871-baritone
CommitID: 091c19ca727083b8a07bcf192d4a21c34e7c097a
CommitMsg: Fix possible NullPointerExceptions caused by last commit

Silly Brady forgot how Optional works!

FilePath: src/main/java/baritone/bot/pathing/movement/MovementState.java**
```diff
         public final Optional<Vec3d> getPosition() {
-            return Optional.of(this.position);
+            return Optional.ofNullable(this.position);
```
ProjectName: 32871-baritone
CommitID: 091c19ca727083b8a07bcf192d4a21c34e7c097a
CommitMsg: Fix possible NullPointerExceptions caused by last commit

Silly Brady forgot how Optional works!

FilePath: src/main/java/baritone/bot/pathing/movement/MovementState.java**
```diff
         public final Optional<Rotation> getRotation() {
-            return Optional.of(this.rotation);
+            return Optional.ofNullable(this.rotation);
```
ProjectName: 36240-Discord4J
CommitID: b034a13be6469236c16ddabb9dbd329f59611cb6
CommitMsg: ofNullable as Discord developers can't make an API
FilePath: core/src/main/java/discord4j/core/object/entity/Message.java**
```diff
     public Optional<String> getContent() {
-        return Optional.of(data.getContent()).filter(content -> !content.isEmpty());
+        // Even though the bean / responses say it's not nullable Discord is being stupid atm
+        return Optional.ofNullable(data.getContent()).filter(content -> !content.isEmpty());
```
ProjectName: 36240-Discord4J
CommitID: 532359ca6409d2c36c9ea2701c3d9a561a139c62
CommitMsg: Make optional nullable

FilePath: src/main/java/sx/blah/discord/api/internal/ShardImpl.java**
```diff
 		IPresence oldPresence = ourUser.getPresence();
-		IPresence newPresence = new PresenceImpl(Optional.of(playing), Optional.of(streamUrl), status);
+		IPresence newPresence = new PresenceImpl(Optional.ofNullable(playing), Optional.ofNullable(streamUrl), status);
```
ProjectName: 23471-intellij-swagger
CommitID: 6a9779cd32725c6b28f50cffb3b922eb5ec04f8e
CommitMsg: Merge branch 'master' of github.com:zalando/intellij-swagger

FilePath: src/main/java/org/zalando/intellij/swagger/traversal/YamlTraversal.java**
```diff
     public Optional<String> getKeyNameIfKey(final PsiElement psiElement) {
-        return Optional.of(psiElement.getParent())
+        return Optional.ofNullable(psiElement.getParent())
```
ProjectName: 23471-intellij-swagger
CommitID: 832ad4cfcd84407f4f8b8208d0925d97e345d5a3
CommitMsg: Handle possibility of PsiElement's parent being null. (#63)

This will usually happen if the PsiElement has been deleted.

Fixes #60.
FilePath: src/main/java/org/zalando/intellij/swagger/traversal/YamlTraversal.java**
```diff
     public Optional<String> getKeyNameIfKey(final PsiElement psiElement) {
-        return Optional.of(psiElement.getParent())
+        return Optional.ofNullable(psiElement.getParent())
```
ProjectName: 28123-spotless
CommitID: f5e2aff61e408225ec5c80871e1ae1d495426413
CommitMsg: Fixed potential logging bug, in case log(Object,int,String,Throwable) is used directly.

FilePath: _ext/eclipse-groovy/src/main/java/com/diffplug/spotless/extra/eclipse/groovy/SpotlessLogService.java**
```diff
 		public SimpleLogEntry(LogLevel level, String message, Throwable execption) {
-			this(level, message, Optional.of(execption));
+			this(level, message, Optional.ofNullable(execption));
```
ProjectName: 28453-cuba
CommitID: ae672bffc40953126f244eb4728dda7c70e2df5e
CommitMsg: PL-9269 EntitySnapshotManager doesn't show changes for dynamic attributes (NPE on Optional.of)

FilePath: modules/core/src/com/haulmont/cuba/core/app/EntityDiffManager.java**
```diff
                                                                    MetaProperty metaProperty) {
-        Collection<Entity> firstCollection = Optional.of((Collection<Entity>)firstValue).orElse(Collections.emptyList());
-        Collection<Entity> secondCollection = Optional.of((Collection<Entity>)secondValue).orElse(Collections.emptyList());
+        Collection<Entity> firstCollection = Optional.ofNullable((Collection<Entity>)firstValue).orElse(Collections.emptyList());
+        Collection<Entity> secondCollection = Optional.ofNullable((Collection<Entity>)secondValue).orElse(Collections.emptyList());
```
ProjectName: 11873-AxonFramework
CommitID: 48f1b8aae297b03f4c10b4c05a88ddb4103b6aea
CommitMsg: The AggregateType of an event may now be null

FilePath: core/src/main/java/org/axonframework/serialization/upcasting/event/InitialEventRepresentation.java**
```diff
     public Optional<String> getAggregateType() {
-        return Optional.of(aggregateType);
+        return Optional.ofNullable(aggregateType);
```
ProjectName: 13220-spring-cloud-kubernetes
CommitID: f335da672ccdeb42b638d040350157f2cb3ba23f
CommitMsg: Fix NPE when local leader is null (#297)


FilePath: spring-cloud-kubernetes-leader/src/main/java/org/springframework/cloud/kubernetes/leader/LeadershipController.java**
```diff
 	public Optional<Leader> getLocalLeader() {
-		return Optional.of(localLeader);
+		return Optional.ofNullable(localLeader);
```
ProjectName: 13220-spring-cloud-kubernetes
CommitID: 987147d3ec7475d57f905a8fb52b089c2675290f
CommitMsg: Use Optional.ofNullable for service endpoints.

FilePath: spring-cloud-kubernetes-discovery/src/main/java/io/fabric8/spring/cloud/discovery/KubernetesDiscoveryClient.java**
```diff
         Assert.notNull(serviceId, "[Assertion failed] - the object argument must be null");
-        return Optional.of(client.endpoints().withName(serviceId).get()).orElse(new Endpoints())
+        return Optional.ofNullable(client.endpoints().withName(serviceId).get()).orElse(new Endpoints())
```
ProjectName: 15151-jabref
CommitID: 9978b67e5bedb14d9440d7245915d116906c6fee
CommitMsg: Fixed NPE when loading a style file that has no default style (#1857)


FilePath: src/main/java/net/sf/jabref/gui/PreviewPanel.java**
```diff
     public void setLayout(Layout layout) {
-        this.layout = Optional.of(layout);
+        this.layout = Optional.ofNullable(layout);
```
ProjectName: 15151-jabref
CommitID: b6269bcd8f3da8918b53e01f3b8fd59e73859bce
CommitMsg: Use Objects.equals for a null-safe comparison. Do not catch NPEs when possible.

FilePath: src/main/java/net/sf/jabref/logic/util/DOI.java**
```diff
         try {
-            return Optional.of(new DOI(doi));
-        } catch(NullPointerException | IllegalArgumentException e) {
+            return Optional.ofNullable(new DOI(doi));
+        } catch(IllegalArgumentException e) {
```
ProjectName: 11181-Chronicle-Queue
CommitID: b8791988e9a3043913ec347c2ae4e4434b93add2
CommitMsg: Typo

FilePath: src/main/java/net/openhft/chronicle/queue/impl/single/QueueFiles.java**
```diff
                     }
-                    return Optional.of(processor.apply(wire, queueStore));
+                    return Optional.ofNullable(processor.apply(wire, queueStore));
```
ProjectName: 2431-hsweb-framework
CommitID: f2d401125b691c037650ef7b4d64c173190e98bd
CommitMsg: 修复可能出现的空指针异常

FilePath: hsweb-boost/hsweb-boost-aop/src/main/java/org/hswebframework/web/boost/aop/context/MethodInterceptorHolder.java**
```diff
                 }
-                return Optional.of((T) args.get(name));
+                return Optional.ofNullable((T) args.get(name));
```
ProjectName: 2431-hsweb-framework
CommitID: 602b992bb2c676dba8f99ef4df6ea3d76ecd33a1
CommitMsg: ofNullable

FilePath: hsweb-system/hsweb-system-authorization/hsweb-system-authorization-service/hsweb-system-authorization-service-simple/src/main/java/org/hswebframework/web/service/authorization/simple/SimpleAuthentication.java**
```diff
     public <T extends Serializable> Optional<T> getAttribute(String name) {
-        return Optional.of((T) attributes.get(name));
+        return Optional.ofNullable((T) attributes.get(name));
```
ProjectName: 2979-Activiti
CommitID: a054e01f2353834b2d726152e00a3093eb2fae8e
CommitMsg: fixing task cancelled event listener

FilePath: activiti-api/activiti-process-runtime-api-impl/src/main/java/org/activiti/runtime/api/event/impl/ToActivityCancelledConverter.java**
```diff
     public Optional<BPMNActivityCancelled> from(ActivitiActivityEvent internalEvent) {
-        return Optional.of(new BPMNActivityCancelledEventImpl(toActivityConverter.from(internalEvent)));
+        BPMNActivityCancelledEventImpl bpmnActivityCancelledEvent = null;
+        if(internalEvent.getActivityId() != null && !internalEvent.getActivityId().isEmpty()){ // we are making sure that it is a BPMN Activity
+            bpmnActivityCancelledEvent = new BPMNActivityCancelledEventImpl(toActivityConverter.from(internalEvent));
+        }
+        return Optional.ofNullable(bpmnActivityCancelledEvent);
```
ProjectName: 3653-feign
CommitID: 17a515e073e8dc6e3d06a8404ad9742274ce0bb0
CommitMsg: Fix NPE in OptionalDecoder (#788)

The decoded instance (from delegate.decode()) will be null when a
response body is null. This decoded instance (null) will result in a NPE
in the Optional since Optional.of is used. Changing this to
Optional.ofNullable will return an empty Optional when the decoded
instance is null.
FilePath: core/src/main/java/feign/optionals/OptionalDecoder.java**
```diff
     Type enclosedType = Util.resolveLastTypeParameter(type, Optional.class);
-    return Optional.of(delegate.decode(response, enclosedType));
+    return Optional.ofNullable(delegate.decode(response, enclosedType));
```
ProjectName: 5737-junit5
CommitID: 5efa0a81f02538d9627d81c906930cc0f53b2151
CommitMsg: Fix NPE when getting name of unnamed module

Prior to this commit a NullPointerException was thrown when the passed
type resided in the unnamed module. The name of the unnamed module is
`null`. Now, using `Optional.ofNullable()`, the result will be an empty
optional instance as expected.

FilePath: junit-platform-commons-java-9/src/main/java/org/junit/platform/commons/util/ModuleUtils.java**
```diff
 	public static Optional<String> getModuleName(Class<?> type) {
-		return Optional.of(type.getModule().getName());
+		Preconditions.notNull(type, "Class type must not be null");
+
+		return Optional.ofNullable(type.getModule().getName());
```
ProjectName: 2454-cas
CommitID: 1a58a7ca043f770924f88f88669f8860329f0293
CommitMsg: Merge branch 'master' of github.com:apereo/cas

FilePath: core/cas-server-core-web-api/src/main/java/org/apereo/cas/services/web/support/RegisteredServiceResponseHeadersEnforcementFilter.java**
```diff
         if (service != null) {
-            return Optional.of(this.servicesManager.findServiceBy(service));
+            return Optional.ofNullable(this.servicesManager.findServiceBy(service));
```
ProjectName: 2454-cas
CommitID: 69523d0e4dc6f3b9b1e00ca0a0b05b2cc668907c
CommitMsg: fix an NPE being thrown when the specified service doesn't match a Registered Service (#3266)


FilePath: core/cas-server-core-web-api/src/main/java/org/apereo/cas/services/web/support/RegisteredServiceResponseHeadersEnforcementFilter.java**
```diff
         if (service != null) {
-            return Optional.of(this.servicesManager.findServiceBy(service));
+            return Optional.ofNullable(this.servicesManager.findServiceBy(service));
```
ProjectName: 6935-bisq
CommitID: aa4813d7b1e8a33626ac026b507c9fd58c3c2d9d
CommitMsg: don't fail if there is no shutdown hook.

FilePath: desktop/src/main/java/bisq/desktop/main/overlays/Overlay.java**
```diff
         this.actionButtonText = Res.get("shared.shutDown");
-        this.actionHandlerOptional = Optional.of(BisqApp.getShutDownHandler());
+        this.actionHandlerOptional = Optional.ofNullable(BisqApp.getShutDownHandler());
```
ProjectName: 6935-bisq
CommitID: c5d760b2a000ed68f9ae35d66c6d679b1ca777e9
CommitMsg: Replace manual checks with equivalent ``Optional.ofNullable()``

FilePath: network/src/main/java/io/bitsquare/p2p/P2PService.java**
```diff
 
-        optionalEncryptionService = encryptionService == null ? Optional.empty() : Optional.of(encryptionService);
-        optionalKeyRing = keyRing == null ? Optional.empty() : Optional.of(keyRing);
+        optionalEncryptionService = Optional.ofNullable(encryptionService);
+        optionalKeyRing = Optional.ofNullable(keyRing);
```
ProjectName: 998-playframework
CommitID: 0483ec1c91c904e63981c08f7e7b51ef45408ee4
CommitMsg: Use Optional.ofNullable

FilePath: framework/src/play-java/src/main/java/play/data/Form.java**
```diff
                     ImmutableList.Builder<String> builder = ImmutableList.builder();
-                    Optional<Messages> msgs = Optional.of(Http.Context.current.get()).map(c -> messagesApi.preferred(c.request()));
+                    Optional<Messages> msgs = Optional.ofNullable(Http.Context.current.get()).map(c -> messagesApi.preferred(c.request()));
```

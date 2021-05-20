###  infomation 
method del:
-java.util.Map.get()
method add：
+java.util.Map.remove()
###  support count
project count : 11
commit count : 19
###  code
ProjectName: 35644-countly-sdk-android
CommitID: dca882c21f0ba38521f8c086ea0605db5237c890
CommitMsg: Duration processing

FilePath: sdk/src/main/java/ly/count/android/sdk/Countly.java**
```diff
     public synchronized boolean endEvent(final String key, final Map<String, String> segmentation, final int count, final double sum) {
-        Event event = timedEvents.get(key);
+        Event event = timedEvents.remove(key);
```
ProjectName: 22231-client_java
CommitID: 9d14f766c6c73c26ebdfdf0bb0940a86bbf80df6
CommitMsg: Improve CollectorRegistry#unregister() (#335)

- In 'unregister', remove the collector before its names, so
we do instructions in the reverse order compare to 'register'.
It is consistent with 'clear'.
- So we do 1 lookup in collectors hash map instead of 2.

Signed-off-by: Cyril Martin <c.martin@criteo.com>
FilePath: simpleclient/src/main/java/io/prometheus/client/CollectorRegistry.java**
```diff
     synchronized (collectorsToNames) {
-      for (String name : collectorsToNames.get(m)) {
+      List<String> names = collectorsToNames.remove(m);
+      for (String name : names) {
```
ProjectName: 26998-rabbitmq-java-client
CommitID: 9f38faab2fc5fc0bc750f427106c47d60de796a6
CommitMsg: neatness codified - tidy up the consumer mapping as necessary

FilePath: src/com/rabbitmq/client/impl/ChannelN.java**
```diff
                 Basic.Cancel m = (Basic.Cancel)method;
-                Consumer callback = _consumers.get(m.consumerTag);
+                Consumer callback = _consumers.remove(m.consumerTag);
```
ProjectName: 24493-smarthome
CommitID: 011216d46b77b63679138a7668c3e93083d1869d
CommitMsg: hue binding: fix discovery service unregistration/deactivate order (#6150)

Signed-off-by: Henning Treu <henning.treu@telekom.de>
FilePath: extensions/binding/org.eclipse.smarthome.binding.hue/src/main/java/org/eclipse/smarthome/binding/hue/internal/HueThingHandlerFactory.java**
```diff
         if (thingHandler instanceof HueBridgeHandler) {
-            ServiceRegistration<?> serviceReg = this.discoveryServiceRegs.get(thingHandler.getThing().getUID());
+            ServiceRegistration<?> serviceReg = this.discoveryServiceRegs.remove(thingHandler.getThing().getUID());
```
ProjectName: 24493-smarthome
CommitID: ff01e6926d8d9d200df76939d7a9a6b6382a4458
CommitMsg: Fixes #2322 Basic UI no longer updates icons (#2338)

* Fixes #2322 Basic UI no longer updates icons

Signed-off-by: Wouter Born <eclipse@maindrain.net>

FilePath: bundles/io/org.eclipse.smarthome.io.rest.sitemap/src/main/java/org/eclipse/smarthome/io/rest/sitemap/SitemapSubscriptionService.java**
```diff
             // this was the only subscription listening on this page, so we can dispose the listener
-            PageChangeListener listener = pageChangeListeners.get(sitemapPage);
+            PageChangeListener listener = pageChangeListeners.remove(sitemapPage);
```
ProjectName: 11873-AxonFramework
CommitID: 3c44a5136f774b26d2de8e7d6c58b8e8410dc821
CommitMsg: remove channel from map on shutdown.

FilePath: axon-server-connector/src/main/java/org/axonframework/axonserver/connector/AxonServerConnectionManager.java**
```diff
     public void disconnect(String context) {
-        ManagedChannel channel = channels.get(context);
+        ManagedChannel channel = channels.remove(context);
```
ProjectName: 12171-atomix
CommitID: 17580a18a14637f7c87ad79e4f0ac2e63dd8ef2e
CommitMsg: Merge pull request #232 from atomix/lock-event-listener-cleanup

Ensure lock event listeners are removed on lock event
FilePath: concurrent/src/main/java/io/atomix/concurrent/DistributedLock.java**
```diff
   private void handleEvent(LockCommands.LockEvent event) {
-    CompletableFuture<Long> future = futures.get(event.id());
+    CompletableFuture<Long> future = futures.remove(event.id());
```
ProjectName: 12171-atomix
CommitID: 17580a18a14637f7c87ad79e4f0ac2e63dd8ef2e
CommitMsg: Merge pull request #232 from atomix/lock-event-listener-cleanup

Ensure lock event listeners are removed on lock event
FilePath: concurrent/src/main/java/io/atomix/concurrent/DistributedLock.java**
```diff
   private void handleFail(LockCommands.LockEvent event) {
-    CompletableFuture<Long> future = futures.get(event.id());
+    CompletableFuture<Long> future = futures.remove(event.id());
```
ProjectName: 12171-atomix
CommitID: ebf446c8d98a38e000c1a0fc440eec8053632414
CommitMsg: Ensure lock event listeners are removed on lock event.

FilePath: concurrent/src/main/java/io/atomix/concurrent/DistributedLock.java**
```diff
   private void handleEvent(LockCommands.LockEvent event) {
-    CompletableFuture<Long> future = futures.get(event.id());
+    CompletableFuture<Long> future = futures.remove(event.id());
```
ProjectName: 12171-atomix
CommitID: ebf446c8d98a38e000c1a0fc440eec8053632414
CommitMsg: Ensure lock event listeners are removed on lock event.

FilePath: concurrent/src/main/java/io/atomix/concurrent/DistributedLock.java**
```diff
   private void handleFail(LockCommands.LockEvent event) {
-    CompletableFuture<Long> future = futures.get(event.id());
+    CompletableFuture<Long> future = futures.remove(event.id());
```
ProjectName: 12171-atomix
CommitID: 38ce15cffb5936dd52bf438bbd045785b08fee00
CommitMsg: Fix memory leak in Netty connection response futures.

FilePath: netty/src/main/java/net/kuujo/copycat/io/transport/NettyConnection.java**
```diff
   private void handleResponseSuccess(long requestId, Object response) {
-    ContextualFuture future = responseFutures.get(requestId);
+    ContextualFuture future = responseFutures.remove(requestId);
```
ProjectName: 12171-atomix
CommitID: 38ce15cffb5936dd52bf438bbd045785b08fee00
CommitMsg: Fix memory leak in Netty connection response futures.

FilePath: netty/src/main/java/net/kuujo/copycat/io/transport/NettyConnection.java**
```diff
   private void handleResponseFailure(long requestId, Throwable t) {
-    ContextualFuture future = responseFutures.get(requestId);
+    ContextualFuture future = responseFutures.remove(requestId);
```
ProjectName: 2574-antlr4
CommitID: 528e9c7b86b9ba432221ae3164e5faa09c55cef0
CommitMsg: fix cut/paste error

FilePath: runtime/Java/src/org/antlr/v4/runtime/tree/ParseTreeProperty.java**
```diff
 	public void put(ParseTree node, V value) { annotations.put(node, value); }
-	public V removeFrom(ParseTree node) { return annotations.get(node); }
+	public V removeFrom(ParseTree node) { return annotations.remove(node); }
```
ProjectName: 6424-hbase
CommitID: 21f80b2cd48bef433c9db5eb58ee987dbe150652
CommitMsg: HBASE-8618 Master is providing dead RegionServer ServerName's to the balancer

git-svn-id: https://svn.apache.org/repos/asf/hbase/trunk@1486359 13f79535-47bb-0310-9956-ffa450edef68

FilePath: hbase-server/src/main/java/org/apache/hadoop/hbase/master/RegionStates.java**
```diff
     List<HRegionInfo> rits = new ArrayList<HRegionInfo>();
-    Set<HRegionInfo> assignedRegions = serverHoldings.get(sn);
+    Set<HRegionInfo> assignedRegions = serverHoldings.remove(sn);
```
ProjectName: 8573-drools
CommitID: 9ca2cc3ff4a0e8174128e70943ba807a836e03cb
CommitMsg: JBRULES-1137 Rules are not removed when they have shared nodes


git-svn-id: https://svn.jboss.org/repos/labs/labs/jbossrules/trunk@14619 c60d74c8-e8f6-0310-9e8f-d4a2fc68ab70

FilePath: drools-core/src/main/java/org/drools/reteoo/ReteooBuilder.java**
```diff
 
-        final Object object = this.rules.get( rule );
+        final Object object = this.rules.remove( rule );
```
ProjectName: 13536-activemq
CommitID: e16a63815f20681c4c0550dbf1dfa156d32c62ef
CommitMsg: The wireFormat option needs to get removed otherwise you'll get an error saying that it's unrecognized

git-svn-id: https://svn.apache.org/repos/asf/activemq/trunk@743870 13f79535-47bb-0310-9956-ffa450edef68

FilePath: activemq-core/src/main/java/org/apache/activemq/transport/TransportFactory.java**
```diff
     protected WireFormatFactory createWireFormatFactory(Map<String, String> options) throws IOException {
-        String wireFormat = (String)options.get("wireFormat");
+        String wireFormat = (String)options.remove("wireFormat");
```
ProjectName: 13536-activemq
CommitID: c3fd0a65b1fd1b056c4a91fad4d59e1df48e745a
CommitMsg: applied patch for AMQ-1128

git-svn-id: https://svn.apache.org/repos/asf/activemq/trunk@511912 13f79535-47bb-0310-9956-ffa450edef68

FilePath: activemq-core/src/main/java/org/apache/activemq/transport/vm/VMTransportFactory.java**
```diff
                 }
-                if( "false".equals(options.get("create")) ) {
+                if( "false".equals(options.remove("create")) ) {
```
ProjectName: 13536-activemq
CommitID: 2373eb2d22db60b179c2a3a63e7c48e93c8aab53
CommitMsg: fix for http://issues.apache.org/activemq/browse/AMQ-683

git-svn-id: https://svn.apache.org/repos/asf/incubator/activemq/trunk@392624 13f79535-47bb-0310-9956-ffa450edef68

FilePath: activemq-core/src/main/java/org/apache/activemq/broker/jmx/ManagedRegionBroker.java**
```diff
     public void unregisterSubscription(Subscription sub){
-        ObjectName name=(ObjectName) subscriptionMap.get(sub);
+        ObjectName name=(ObjectName) subscriptionMap.remove(sub);
```
ProjectName: 13675-framework
CommitID: 1ee652d48c5e9a5fb5ea4e550492935689ce53f9
CommitMsg: Fix VAbstractOrderedLayout widget removal race condition (#18703)

Removing a widget that got moved to another layout occasionally caused
slot to lose track of related widget. As a result the layout never
created a new slot when the same widget is put back in there.

Change-Id: I0d8793324b8a5ac8a06aa2803ac8de22b90b7545

FilePath: client/src/com/vaadin/client/ui/orderedlayout/VAbstractOrderedLayout.java**
```diff
     public void removeWidget(Widget widget) {
-        Slot slot = widgetToSlot.get(widget);
-        removeSlot(slot);
+        Slot slot = widgetToSlot.remove(widget);
+        if (slot != null) {
+            removeSlot(slot);
+        }
```

###  infomation 
method del:
-java.lang.System.nanoTime()
method add：
+java.lang.System.currentTimeMillis()
###  support count
project count : 5
commit count : 16
###  code
ProjectName: 1090-HikariCP
CommitID: b135955bf8a2cff6653e9010dd9d48342e94f54f
CommitMsg: Remove staggling nanoTime() calls.

FilePath: src/main/java/com/zaxxer/hikari/util/UtilityElf.java**
```diff
    {
-      return TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startNano);
+      return System.currentTimeMillis() - startMillis;
```
ProjectName: 5607-atmosphere
CommitID: 9754de49878983bf090655203e0c880cccad7b2e
CommitMsg: Fix for #876

FilePath: modules/cpr/src/main/java/org/atmosphere/cache/EventCacheBroadcasterCache.java**
```diff
     protected void invalidateExpiredEntries() {
-        long now = System.nanoTime();
+        long now = System.currentTimeMillis();
```
ProjectName: 5607-atmosphere
CommitID: 9754de49878983bf090655203e0c880cccad7b2e
CommitMsg: Fix for #876

FilePath: modules/cpr/src/main/java/org/atmosphere/cache/EventCacheBroadcasterCache.java**
```diff
 
-        long now = System.nanoTime();
+        long now = System.currentTimeMillis();
```
ProjectName: 5607-atmosphere
CommitID: 9754de49878983bf090655203e0c880cccad7b2e
CommitMsg: Fix for #876

FilePath: modules/cpr/src/main/java/org/atmosphere/cache/EventCacheBroadcasterCache.java**
```diff
         String clientId = r.uuid();
-        long now = System.nanoTime();
+        long now = System.currentTimeMillis();
```
ProjectName: 5607-atmosphere
CommitID: 57df7b8366c2d9a97a6b645c3b5b1f37a68ee35e
CommitMsg: Make sure we check using the same time

FilePath: modules/cpr/src/main/java/org/atmosphere/cache/AbstractBroadcasterCache.java**
```diff
                 try {
-                    long now = System.nanoTime();
+                    long now = System.currentTimeMillis();
```
ProjectName: 7218-cordova-android
CommitID: 2eb4c5e960d633f67c9767b9cdd254111476b2cd
CommitMsg: [CB-1022] Reverted nanoTime back to currentTimeMillis. Updated mobile-spec tests as well. This passes all accel tests.

FilePath: framework/src/org/apache/cordova/AccelListener.java**
```diff
             // Save time that event was received
-            this.timestamp = System.nanoTime();
+            this.timestamp = System.currentTimeMillis();
```
ProjectName: 2454-cas
CommitID: 4a38a621b60c5a0f153bceeb114d32bd051a9519
CommitMsg: Fix #2590: hjson will lose precision if id is too large (#2595)


FilePath: core/cas-server-core-services/src/main/java/org/apereo/cas/services/AbstractResourceBasedServiceRegistryDao.java**
```diff
             LOGGER.debug("Service id not set. Calculating id based on system time...");
-            ((AbstractRegisteredService) service).setId(System.nanoTime());
+            ((AbstractRegisteredService) service).setId(System.currentTimeMillis());
```
ProjectName: 2454-cas
CommitID: 4a38a621b60c5a0f153bceeb114d32bd051a9519
CommitMsg: Fix #2590: hjson will lose precision if id is too large (#2595)


FilePath: support/cas-server-support-ldap-service-registry/src/main/java/org/apereo/cas/adaptors/ldap/services/DefaultLdapRegisteredServiceMapper.java**
```diff
             if (svc.getId() == RegisteredService.INITIAL_IDENTIFIER_VALUE) {
-                ((AbstractRegisteredService) svc).setId(System.nanoTime());
+                ((AbstractRegisteredService) svc).setId(System.currentTimeMillis());
```
ProjectName: 2763-storm
CommitID: 455b2baf1d2cab4a478f16a288cc6a60923612c2
CommitMsg: Merge branch 'STORM-1571' of https://github.com/darionyaphet/storm

FilePath: external/storm-kafka/src/jvm/org/apache/storm/kafka/PartitionManager.java**
```diff
     private void fill() {
-        long start = System.nanoTime();
+        long start = System.currentTimeMillis();
```
ProjectName: 2763-storm
CommitID: 455b2baf1d2cab4a478f16a288cc6a60923612c2
CommitMsg: Merge branch 'STORM-1571' of https://github.com/darionyaphet/storm

FilePath: external/storm-kafka/src/jvm/org/apache/storm/kafka/PartitionManager.java**
```diff
         }
-        long end = System.nanoTime();
-        long millis = (end - start) / 1000000;
+        long millis = System.currentTimeMillis() - start;
```
ProjectName: 2763-storm
CommitID: 455b2baf1d2cab4a478f16a288cc6a60923612c2
CommitMsg: Merge branch 'STORM-1571' of https://github.com/darionyaphet/storm

FilePath: external/storm-kafka/src/jvm/org/apache/storm/kafka/trident/TridentKafkaEmitter.java**
```diff
     private ByteBufferMessageSet fetchMessages(SimpleConsumer consumer, Partition partition, long offset) {
-        long start = System.nanoTime();
+        long start = System.currentTimeMillis();
```
ProjectName: 2763-storm
CommitID: 455b2baf1d2cab4a478f16a288cc6a60923612c2
CommitMsg: Merge branch 'STORM-1571' of https://github.com/darionyaphet/storm

FilePath: external/storm-kafka/src/jvm/org/apache/storm/kafka/trident/TridentKafkaEmitter.java**
```diff
         msgs = KafkaUtils.fetchMessages(_config, consumer, partition, offset);
-        long end = System.nanoTime();
-        long millis = (end - start) / 1000000;
+        long millis = System.currentTimeMillis() - start;
```
ProjectName: 2763-storm
CommitID: d89f7027fcaf5576b5b4a14488f42c71094617ad
CommitMsg: Update time interval counting on TridentKafkaEmitter

FilePath: external/storm-kafka/src/jvm/org/apache/storm/kafka/trident/TridentKafkaEmitter.java**
```diff
     private ByteBufferMessageSet fetchMessages(SimpleConsumer consumer, Partition partition, long offset) {
-        long start = System.nanoTime();
+        long start = System.currentTimeMillis();
```
ProjectName: 2763-storm
CommitID: d89f7027fcaf5576b5b4a14488f42c71094617ad
CommitMsg: Update time interval counting on TridentKafkaEmitter

FilePath: external/storm-kafka/src/jvm/org/apache/storm/kafka/trident/TridentKafkaEmitter.java**
```diff
         msgs = KafkaUtils.fetchMessages(_config, consumer, partition, offset);
-        long end = System.nanoTime();
-        long millis = (end - start) / 1000000;
+        long millis = System.currentTimeMillis() - start;
```
ProjectName: 2763-storm
CommitID: 27373baee746f7baba2a60e06054590afd687976
CommitMsg: Improvment Kafka Spout Time Metric

FilePath: external/storm-kafka/src/jvm/org/apache/storm/kafka/PartitionManager.java**
```diff
     private void fill() {
-        long start = System.nanoTime();
+        long start = System.currentTimeMillis();
```
ProjectName: 2763-storm
CommitID: 27373baee746f7baba2a60e06054590afd687976
CommitMsg: Improvment Kafka Spout Time Metric

FilePath: external/storm-kafka/src/jvm/org/apache/storm/kafka/PartitionManager.java**
```diff
         }
-        long end = System.nanoTime();
-        long millis = (end - start) / 1000000;
+        long millis = System.currentTimeMillis() - start;
```

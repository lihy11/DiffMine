###  infomation 
method del:
-java.lang.System.currentTimeMillis()
method add：
+java.lang.System.nanoTime()
###  support count
project count : 12
commit count : 26
###  code
ProjectName: 40244-copycat
CommitID: 6ba9055f227ea20cb3fb06ba67ff0cb1398eed57
CommitMsg: Use System.nanoTime() for round trip request timing.

FilePath: server/src/main/java/io/atomix/copycat/server/state/AbstractAppender.java**
```diff
   protected void sendAppendRequest(Connection connection, MemberState member, AppendRequest request) {
-    long timestamp = System.currentTimeMillis();
+    long timestamp = System.nanoTime();
```
ProjectName: 40244-copycat
CommitID: 6ba9055f227ea20cb3fb06ba67ff0cb1398eed57
CommitMsg: Use System.nanoTime() for round trip request timing.

FilePath: server/src/main/java/io/atomix/copycat/server/state/MemberState.java**
```diff
   boolean canAppend() {
-    return appending < MAX_APPENDS && System.currentTimeMillis() - (timeBuffer.average() / MAX_APPENDS) >= appendTime;
+    return appending < MAX_APPENDS && System.nanoTime() - (timeBuffer.average() / MAX_APPENDS) >= appendTime;
```
ProjectName: 40244-copycat
CommitID: 6ba9055f227ea20cb3fb06ba67ff0cb1398eed57
CommitMsg: Use System.nanoTime() for round trip request timing.

FilePath: server/src/main/java/io/atomix/copycat/server/state/MemberState.java**
```diff
     appending++;
-    appendTime = System.currentTimeMillis();
+    appendTime = System.nanoTime();
```
ProjectName: 31277-xmemcached
CommitID: 13195297ed6a59d4081e23f2e807e9ab96f9e153
CommitMsg: Use nanoTime instead of currentTimeInMills to generate namespace timestamp

FilePath: src/main/java/net/rubyeye/xmemcached/XMemcachedClient.java**
```diff
 		while (item == null) {
-			item = String.valueOf(System.currentTimeMillis());
+			item = String.valueOf(System.nanoTime());
```
ProjectName: 26998-rabbitmq-java-client
CommitID: 9ef9733bfa5d9bf1f2ca7156fb4323b9e910b69f
CommitMsg: BlockingCell now consistently uses System.nanoTime rather than sometimes using System.currentTimeMillis

FilePath: src/main/java/com/rabbitmq/utility/BlockingCell.java**
```diff
 
-        long maxTime = System.currentTimeMillis() + timeout;
-        long now;
-        while (!_filled && (now = System.currentTimeMillis()) < maxTime) {
+        long now = System.nanoTime() / NANOS_IN_MILLI;
+        long maxTime = now + timeout;
+        while (!_filled && (now = (System.nanoTime() / NANOS_IN_MILLI)) < maxTime) {
```
ProjectName: 27583-Equivalent-Exchange-3
CommitID: 22337f0bbc12f0bd1b2704ffdc74b08325f73171
CommitMsg: Move away from System.currentTimeMillis to System.nanoTime (more accurate, less costly)

FilePath: src/main/java/com/pahimar/ee3/command/CommandRegenEnergyValues.java**
```diff
             // TODO Switch to nanoTime from currentTimeMillis
-            long timeDifference = System.currentTimeMillis() - requesterMap.get(commandSenderUUID).longValue();
+            long timeDifference = (System.nanoTime() - requesterMap.get(commandSenderUUID).longValue()) / 100000;
```
ProjectName: 27583-Equivalent-Exchange-3
CommitID: 22337f0bbc12f0bd1b2704ffdc74b08325f73171
CommitMsg: Move away from System.currentTimeMillis to System.nanoTime (more accurate, less costly)

FilePath: src/main/java/com/pahimar/ee3/command/CommandRegenEnergyValues.java**
```diff
         else {
-            requesterMap.put(commandSenderUUID, System.currentTimeMillis());
+            requesterMap.put(commandSenderUUID, System.nanoTime() / 100000);
```
ProjectName: 27583-Equivalent-Exchange-3
CommitID: 22337f0bbc12f0bd1b2704ffdc74b08325f73171
CommitMsg: Move away from System.currentTimeMillis to System.nanoTime (more accurate, less costly)

FilePath: src/main/java/com/pahimar/ee3/command/CommandSyncEnergyValues.java**
```diff
             // TODO Switch to nanoTime from currentTimeMillis
-            long timeDifference = System.currentTimeMillis() - requesterMap.get(commandSenderUUID).longValue();
+            long timeDifference = (System.nanoTime() - requesterMap.get(commandSenderUUID).longValue()) / 100000;
```
ProjectName: 27583-Equivalent-Exchange-3
CommitID: 22337f0bbc12f0bd1b2704ffdc74b08325f73171
CommitMsg: Move away from System.currentTimeMillis to System.nanoTime (more accurate, less costly)

FilePath: src/main/java/com/pahimar/ee3/command/CommandSyncEnergyValues.java**
```diff
         else {
-            requesterMap.put(commandSenderUUID, System.currentTimeMillis());
+            requesterMap.put(commandSenderUUID, System.nanoTime() / 100000);
```
ProjectName: 29579-Payara
CommitID: aa0dc160c474574ef6fc30645c9c799a10b23539
CommitMsg: PAYARA-2008-CPU-Healthcheck-Percentage-Wrong (#1920)


FilePath: nucleus/payara-modules/healthcheck-core/src/main/java/fish/payara/nucleus/healthcheck/preliminary/CpuUsageHealthCheck.java**
```diff
         long  totalCpuTime = getTotalCpuTime();
-        long time = System.currentTimeMillis();
+        long time = System.nanoTime();
```
ProjectName: 2306-metrics
CommitID: 2e447a69c23b56fe37edf71fd25a8b99f7d0a87a
CommitMsg: Improve calculation of Health check durations (#1361)

Use `System.nanotime` instead of `System.currentTimeMillis`.
Difference between invocations of System.currentTimeMillis() can
produce negative values depending of how CPU clock synchronization
works in different environments. The standard pattern is to use
`System.nanotime` which is monotonous.
FilePath: metrics-healthchecks/src/main/java/com/codahale/metrics/health/HealthCheck.java**
```diff
     public Result execute() {
-        long start = System.currentTimeMillis();
+        long start = System.nanoTime();
```
ProjectName: 2306-metrics
CommitID: 2e447a69c23b56fe37edf71fd25a8b99f7d0a87a
CommitMsg: Improve calculation of Health check durations (#1361)

Use `System.nanotime` instead of `System.currentTimeMillis`.
Difference between invocations of System.currentTimeMillis() can
produce negative values depending of how CPU clock synchronization
works in different environments. The standard pattern is to use
`System.nanotime` which is monotonous.
FilePath: metrics-healthchecks/src/main/java/com/codahale/metrics/health/HealthCheck.java**
```diff
         }
-        result.setDuration(System.currentTimeMillis() - start);
+        result.setDuration(TimeUnit.MILLISECONDS.convert(System.nanoTime() - start, TimeUnit.NANOSECONDS));
```
ProjectName: 5607-atmosphere
CommitID: 3d13c8ce85d33b67bfbf7e916a67c3c0e4d614d2
CommitMsg: One more for #646

FilePath: modules/cpr/src/main/java/org/atmosphere/cache/SessionBroadcasterCache.java**
```diff
     public void addToCache(String broadcasterId, AtmosphereResource r, Message message) {
-        long now = System.currentTimeMillis();
+        long now = System.nanoTime();
```
ProjectName: 5607-atmosphere
CommitID: 75d818e95d12ebd6c5c600bd2c8fb2657e0200da
CommitMsg: Tentative fix for #646 Patch provided by Paul Khodchenkov

FilePath: modules/cpr/src/main/java/org/atmosphere/cache/AbstractBroadcasterCache.java**
```diff
                 try {
-                    long now = System.currentTimeMillis();
+                    long now = System.nanoTime();
```
ProjectName: 5607-atmosphere
CommitID: 75d818e95d12ebd6c5c600bd2c8fb2657e0200da
CommitMsg: Tentative fix for #646 Patch provided by Paul Khodchenkov

FilePath: modules/cpr/src/main/java/org/atmosphere/cache/HeaderBroadcasterCache.java**
```diff
 
-        long now = System.currentTimeMillis();
+        long now = System.nanoTime();
```
ProjectName: 5607-atmosphere
CommitID: 75d818e95d12ebd6c5c600bd2c8fb2657e0200da
CommitMsg: Tentative fix for #646 Patch provided by Paul Khodchenkov

FilePath: modules/cpr/src/main/java/org/atmosphere/cache/HeaderBroadcasterCache.java**
```diff
         String cacheHeader = request.getHeader(X_CACHE_DATE);
-        r.getResponse().setHeader(X_CACHE_DATE, String.valueOf(System.currentTimeMillis()));
+        r.getResponse().setHeader(X_CACHE_DATE, String.valueOf(System.nanoTime()));
```
ProjectName: 7218-cordova-android
CommitID: ca1a322c7697bc2f927f4d14de309bc203a5f6ff
CommitMsg: Changing from currentTimeMillis to nanoTime, we need precision on Android 2.3

FilePath: framework/src/org/apache/cordova/AccelListener.java**
```diff
             // Save time that event was received
-            this.timestamp = System.currentTimeMillis();
+            this.timestamp = System.nanoTime();
```
ProjectName: 4607-hibernate-orm
CommitID: 193c8cef20775a798883e850c7cc3c4bb7ef24ed
CommitMsg: HHH-9344 Convert QueryLoader to use nanoTime instead of currentTimeMillis

FilePath: hibernate-core/src/main/java/org/hibernate/loader/hql/QueryLoader.java**
```diff
 		if ( stats ) {
-			startTime = System.currentTimeMillis();
+			startTime = System.nanoTime();
```
ProjectName: 4607-hibernate-orm
CommitID: 0d1460cc1e3f3cd4ddc9585dd729e9839bee3104
CommitMsg: HHH-9344 Convert QueryTranslatorImpl to use nanoTime instead of currentTimeMillis

FilePath: hibernate-core/src/main/java/org/hibernate/hql/internal/classic/QueryTranslatorImpl.java**
```diff
 		long startTime = 0;
-		if ( stats ) startTime = System.currentTimeMillis();
+		if ( stats ) startTime = System.nanoTime();
```
ProjectName: 5818-jmeter
CommitID: 1019dd824aec92d2f8f5e9092f1440659112eb4c
CommitMsg: Switch to System.nanoTime()
Add javadocs

git-svn-id: https://svn.apache.org/repos/asf/jmeter/trunk@1634565 13f79535-47bb-0310-9956-ffa450edef68

Former-commit-id: dea16cb9acf5feea276916c0f210cc552cc2ddea
FilePath: src/core/org/apache/jmeter/control/RunTime.java**
```diff
     private boolean endOfLoop() {
-        return System.currentTimeMillis() - startTime >= 1000 * getRuntime();
+        return ((System.nanoTime() - startTime)/1000) >= 1000 * getRuntime();
```
ProjectName: 5818-jmeter
CommitID: 1019dd824aec92d2f8f5e9092f1440659112eb4c
CommitMsg: Switch to System.nanoTime()
Add javadocs

git-svn-id: https://svn.apache.org/repos/asf/jmeter/trunk@1634565 13f79535-47bb-0310-9956-ffa450edef68

Former-commit-id: dea16cb9acf5feea276916c0f210cc552cc2ddea
FilePath: src/core/org/apache/jmeter/control/RunTime.java**
```diff
         if (startTime == 0) {
-            startTime = System.currentTimeMillis();
+            startTime = System.nanoTime();
```
ProjectName: 259-zxing
CommitID: 096cae7fcb69cfadfbef69f4d1b5fb5863ca7b78
CommitMsg: Use nanoTime for elapsed time

FilePath: android/src/com/google/zxing/client/android/DecodeHandler.java**
```diff
   private void decode(byte[] data, int width, int height) {
-    long start = System.currentTimeMillis();
+    long start = System.nanoTime();
```
ProjectName: 259-zxing
CommitID: 096cae7fcb69cfadfbef69f4d1b5fb5863ca7b78
CommitMsg: Use nanoTime for elapsed time

FilePath: android/src/com/google/zxing/client/android/DecodeHandler.java**
```diff
       // Don't log the barcode contents for security.
-      long end = System.currentTimeMillis();
-      Log.d(TAG, "Found barcode in " + (end - start) + " ms");
+      long end = System.nanoTime();
+      Log.d(TAG, "Found barcode in " + TimeUnit.NANOSECONDS.toMillis(end - start) + " ms");
```
ProjectName: 568-libgdx
CommitID: 02861e7f4513a03d6e22dafe6cb6af55fa1113a8
CommitMsg: Update FPSLogger to use nanoTime. 

"currentTimeMillsis" pulls time from the system clock and should not be used to measure elapsed time. Other processes like NTP, or the user, can alter the system clock and the time returned can unexpectedly shift and create bizarre and intermittent behavior.

"nanoTime" is a measure of nanoseconds from some arbitrary time point and is safe for measuring elapsed time.

The results of this bug are rather benign – worst case the time is changed back and you would not get a framerate log message for that time, or until the user restarts the program. However, this flavor of bug can cause significant intermittent issues if present in other areas if the user is unfortunate enough to have his clock changed while he is playing (this happens more than you may think thanks to NTP keeping our system clocks in sync.)

See: 
http://docs.oracle.com/javase/7/docs/api/java/lang/System.html#nanoTime%28%29
http://docs.oracle.com/javase/7/docs/api/java/lang/System.html#currentTimeMillis%28%29
FilePath: gdx/src/com/badlogic/gdx/graphics/FPSLogger.java**
```diff
 	public FPSLogger () {
-		startTime = System.currentTimeMillis();
+		startTime = System.nanoTime();
```
ProjectName: 568-libgdx
CommitID: 02861e7f4513a03d6e22dafe6cb6af55fa1113a8
CommitMsg: Update FPSLogger to use nanoTime. 

"currentTimeMillsis" pulls time from the system clock and should not be used to measure elapsed time. Other processes like NTP, or the user, can alter the system clock and the time returned can unexpectedly shift and create bizarre and intermittent behavior.

"nanoTime" is a measure of nanoseconds from some arbitrary time point and is safe for measuring elapsed time.

The results of this bug are rather benign – worst case the time is changed back and you would not get a framerate log message for that time, or until the user restarts the program. However, this flavor of bug can cause significant intermittent issues if present in other areas if the user is unfortunate enough to have his clock changed while he is playing (this happens more than you may think thanks to NTP keeping our system clocks in sync.)

See: 
http://docs.oracle.com/javase/7/docs/api/java/lang/System.html#nanoTime%28%29
http://docs.oracle.com/javase/7/docs/api/java/lang/System.html#currentTimeMillis%28%29
FilePath: gdx/src/com/badlogic/gdx/graphics/FPSLogger.java**
```diff
 	public void log () {
-		if (System.currentTimeMillis() - startTime > 1000) {
+		if (System.nanoTime() - startTime > 1000000000 /* 1,000,000,000ns == one second*/ {
```
ProjectName: 568-libgdx
CommitID: 02861e7f4513a03d6e22dafe6cb6af55fa1113a8
CommitMsg: Update FPSLogger to use nanoTime. 

"currentTimeMillsis" pulls time from the system clock and should not be used to measure elapsed time. Other processes like NTP, or the user, can alter the system clock and the time returned can unexpectedly shift and create bizarre and intermittent behavior.

"nanoTime" is a measure of nanoseconds from some arbitrary time point and is safe for measuring elapsed time.

The results of this bug are rather benign – worst case the time is changed back and you would not get a framerate log message for that time, or until the user restarts the program. However, this flavor of bug can cause significant intermittent issues if present in other areas if the user is unfortunate enough to have his clock changed while he is playing (this happens more than you may think thanks to NTP keeping our system clocks in sync.)

See: 
http://docs.oracle.com/javase/7/docs/api/java/lang/System.html#nanoTime%28%29
http://docs.oracle.com/javase/7/docs/api/java/lang/System.html#currentTimeMillis%28%29
FilePath: gdx/src/com/badlogic/gdx/graphics/FPSLogger.java**
```diff
 			Gdx.app.log("FPSLogger", "fps: " + Gdx.graphics.getFramesPerSecond());
-			startTime = System.currentTimeMillis();
+			startTime = System.nanoTime();
```

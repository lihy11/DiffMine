###  infomation 
method del:
-java.lang.Math.min()
method add：
+java.lang.Math.max()
###  support count
project count : 11
commit count : 15
###  code
ProjectName: 53780-alf.io
CommitID: 90138b20fbf7d5e8239cbdfb18d2188300e40496
CommitMsg: fix typo

FilePath: src/main/java/alfio/manager/payment/BankTransferManager.java**
```diff
         Map<String, Object> model = new HashMap<>();
-        model.put("delayForOfflinePayment", Math.min(1, delay.orElse( 0 )));
+        model.put("delayForOfflinePayment", Math.max(1, delay.orElse( 0 )));
```
ProjectName: 40244-copycat
CommitID: 4fd6ca324c4afd4f42567e534a8b1023bd125619
CommitMsg: Fixed a minor but significant error

FilePath: server/src/main/java/io/atomix/copycat/server/state/LeaderState.java**
```diff
       // what the new leader is advertising.
-      context.setGlobalIndex(Math.min(globalMatchIndex - 1, 0));
+      context.setGlobalIndex(Math.max(globalMatchIndex - 1, 0));
```
ProjectName: 42522-elki
CommitID: 139ceac384ba819fa6d10f1c8fc8067548f56749
CommitMsg: Current.

FilePath: src/experimentalcode/shared/outlier/ensemble/OutlierExperimentEnsembleMatrix.java**
```diff
       for(int b = a + 1; b < size; b++) {
-        double ref = Math.min(data[a][a], data[b][b]);
+        double ref = Math.max(data[a][a], data[b][b]);
```
ProjectName: 40863-isis
CommitID: 408d6647b8d425bd3692e12813f31a3b9913d870
CommitMsg: ISIS-1974: oops, that should've been Math.max ...

... not Math.min

FilePath: core/metamodel/src/main/java/org/apache/isis/core/runtime/threadpool/ThreadPoolSupport.java**
```diff
 
-        final int corePoolSize = Math.min(Runtime.getRuntime().availableProcessors(), MIN_CORE_POOL_SIZE);
-        final int maximumPoolSize = Math.min(Runtime.getRuntime().availableProcessors(), MIN_MAX_POOL_SIZE);
+        final int corePoolSize = Math.max(Runtime.getRuntime().availableProcessors(), MIN_CORE_POOL_SIZE);
+        final int maximumPoolSize = Math.max(Runtime.getRuntime().availableProcessors(), MIN_MAX_POOL_SIZE);
```
ProjectName: 1090-HikariCP
CommitID: 48e0acb98213234b32dd4c21eb5a7d4d94e25ca2
CommitMsg: Fix a bug reported on Stackoverflow.

FilePath: hikaricp-java6/src/main/java/com/zaxxer/hikari/util/PoolUtilities.java**
```diff
          try {
-            dataSource.setLoginTimeout((int) TimeUnit.MILLISECONDS.toSeconds(Math.min(1000L, connectionTimeout)));
+            dataSource.setLoginTimeout((int) TimeUnit.MILLISECONDS.toSeconds(Math.max(1000L, connectionTimeout)));
```
ProjectName: 1090-HikariCP
CommitID: 48e0acb98213234b32dd4c21eb5a7d4d94e25ca2
CommitMsg: Fix a bug reported on Stackoverflow.

FilePath: hikaricp/src/main/java/com/zaxxer/hikari/util/PoolUtilities.java**
```diff
          try {
-            dataSource.setLoginTimeout((int) TimeUnit.MILLISECONDS.toSeconds(Math.min(1000L, connectionTimeout)));
+            dataSource.setLoginTimeout((int) TimeUnit.MILLISECONDS.toSeconds(Math.max(1000L, connectionTimeout)));
```
ProjectName: 5827-MinecraftForge
CommitID: be415091cdafd72acb179988970960e5007e8529
CommitMsg: Fix crash when crashing during modloading. Fix GuiModList being weird.

Signed-off-by: cpw <cpw+github@weeksfamily.ca>

FilePath: src/main/java/net/minecraftforge/fml/client/gui/GuiModList.java**
```diff
         }
-        listWidth = Math.min(listWidth, 150);
+        listWidth = Math.max(listWidth, 100);
```
ProjectName: 7611-Terasology
CommitID: bf146683141551ca46a1a7a8f0b669e2e14dae5f
CommitMsg: Fix for loading bar flicking to empty for some steps.

FilePath: engine/src/main/java/org/terasology/engine/modes/loadProcesses/StepBasedLoadProcess.java**
```diff
     protected void setTotalSteps(int amount) {
-        this.totalSteps = Math.min(1, amount);
+        this.totalSteps = Math.max(1, amount);
```
ProjectName: 7611-Terasology
CommitID: c53c205849d57af2e98da4da1bee9ec41addc949
CommitMsg: Tweaks volumetric lighting and adds a workaround for one of the remaining artifacts.

FilePath: src/main/java/org/terasology/rendering/shader/ShaderParametersPrePost.java**
```diff
             if (activeCamera != null) {
-                float worldFog = worldRenderer.getSmoothedPlayerSunlightValue()
-                        * Math.min(CoreRegistry.get(WorldProvider.class).getFog(activeCamera.getPosition()), 0.5f);
-
+                float worldFog = Math.max(worldRenderer.getSmoothedPlayerSunlightValue(), 0.2f) * CoreRegistry.get(WorldProvider.class).getFog(activeCamera.getPosition());
```
ProjectName: 7427-hive
CommitID: 32b8994480ec94cb1f28ba9cd295cd85cc7fe064
CommitMsg: HIVE-18528: Stats: In the bitvector codepath, when extrapolating column stats for String type columnStringColumnStatsAggregator uses the min value instead of max (Vaibhav Gumashta reviewed by Ashutosh Chauhan)

FilePath: standalone-metastore/src/main/java/org/apache/hadoop/hive/metastore/columnstats/aggr/StringColumnStatsAggregator.java**
```diff
           } else {
-            aggregateData.setAvgColLen(Math.min(aggregateData.getAvgColLen(),
+            aggregateData.setAvgColLen(Math.max(aggregateData.getAvgColLen(),
```
ProjectName: 7427-hive
CommitID: 5e9f74ca377b576d8f08912073577f6ae6569eb9
CommitMsg: HIVE-9902 - Map join small table files need more replications [Spark Branch] (Jimmy via Chao)

git-svn-id: https://svn.apache.org/repos/asf/hive/branches/spark@1665384 13f79535-47bb-0310-9956-ffa450edef68

FilePath: ql/src/java/org/apache/hadoop/hive/ql/exec/SparkHashTableSinkOperator.java**
```diff
       int numOfPartitions = replication;
-      replication = (short) Math.min(MIN_REPLICATION, numOfPartitions);
+      replication = (short) Math.max(MIN_REPLICATION, numOfPartitions);
```
ProjectName: 38627-presto
CommitID: 15ca69b22b2bcdde426fa8e806c7748f2dfe22fe
CommitMsg: Fix bug in client calculation count in exchange operator

FilePath: presto-main/src/main/java/com/facebook/presto/operator/ExchangeOperator.java**
```diff
             int clientCount = (int) ((1.0 * neededPages / expectedPagesPerRequest) * concurrentRequestMultiplier);
-            clientCount = Math.min(clientCount, 1);
+            clientCount = Math.max(clientCount, 1);
```
ProjectName: 185-MPAndroidChart
CommitID: 90dc54a6853e7e82262c6ffeda006994bbc23b46
CommitMsg: Fix performance issue in linechart

FilePath: MPChartLib/src/main/java/com/github/mikephil/charting/charts/BarLineChartBase.java**
```diff
                 mViewPortHandler.contentBottom());
-        return (float) Math.min(mXAxis.mAxisMinimum, pos.x);
+        return (float) Math.max(mXAxis.mAxisMinimum, pos.x);
```
ProjectName: 185-MPAndroidChart
CommitID: 90dc54a6853e7e82262c6ffeda006994bbc23b46
CommitMsg: Fix performance issue in linechart

FilePath: MPChartLib/src/main/java/com/github/mikephil/charting/charts/HorizontalBarChart.java**
```diff
 				mViewPortHandler.contentBottom());
-        return (float) Math.min(mXAxis.mAxisMinimum, pos.y);
+        return (float) Math.max(mXAxis.mAxisMinimum, pos.y);
```
ProjectName: 199-glide
CommitID: 0d8a954b91ef8a37c944c2fdee75966c6f94d7bb
CommitMsg: Stop GifDrawables when callback is cleared.
FilePath: library/src/main/java/com/bumptech/glide/load/resource/gif/GifFrameManager.java**
```diff
 
-        long targetTime = SystemClock.uptimeMillis() + (Math.min(MIN_FRAME_DELAY, decoder.getNextDelay()));
+        long targetTime = SystemClock.uptimeMillis() + (Math.max(MIN_FRAME_DELAY, decoder.getNextDelay()));
```

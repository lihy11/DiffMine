###  infomation 
method del:
-null.toString()
method add：
+null.toStringBinary()
###  support count
project count : 2
commit count : 12
###  code
ProjectName: 30753-phoenix
CommitID: 27722998c35cbc14f8a6c1c1be1c0cc6b0f7769a
CommitMsg: PHOENIX-3275 Reduce logging level of mutable secondary index logging

FilePath: phoenix-core/src/main/java/org/apache/phoenix/hbase/index/covered/update/IndexUpdateManager.java**
```diff
     for (Entry<ImmutableBytesPtr, Collection<Mutation>> entry : map.entrySet()) {
-      String tableName = Bytes.toString(entry.getKey().get());
+      String tableName = Bytes.toStringBinary(entry.getKey().get());
```
ProjectName: 30753-phoenix
CommitID: 27722998c35cbc14f8a6c1c1be1c0cc6b0f7769a
CommitMsg: PHOENIX-3275 Reduce logging level of mutable secondary index logging

FilePath: phoenix-core/src/main/java/org/apache/phoenix/hbase/index/covered/update/IndexUpdateManager.java**
```diff
             + ((m instanceof Put) ? m.getTimeStamp() + " " : ""));
-        sb.append(" row=" + Bytes.toString(m.getRow()));
+        sb.append(" row=" + Bytes.toStringBinary(m.getRow()));
```
ProjectName: 6424-hbase
CommitID: d4cbff58cc67577ff66507b5d2bc0c7150bbd21b
CommitMsg: HBASE-16977 VerifyReplication should log a printable representation of the row keys

Signed-off-by: Gary Helmling <garyh@apache.org>

FilePath: hbase-server/src/main/java/org/apache/hadoop/hbase/mapreduce/replication/VerifyReplication.java**
```diff
             if (verbose) {
-              LOG.info("Good row key: " + delimiter + Bytes.toString(value.getRow()) + delimiter);
+              LOG.info("Good row key: " + delimiter
+                  + Bytes.toStringBinary(value.getRow()) + delimiter);
```
ProjectName: 6424-hbase
CommitID: f3bed5b0d98b3cb895e81b20f5e3017081b74972
CommitMsg: HBASE-17026 VerifyReplication log should distinguish whether good row key is result of revalidation

FilePath: hbase-server/src/main/java/org/apache/hadoop/hbase/mapreduce/replication/VerifyReplication.java**
```diff
             if (verbose) {
-              LOG.info("Good row key: " + delimiter + Bytes.toString(row.getRow()) + delimiter);
+              LOG.info("Good row key (with recompare): " + delimiter + Bytes.toStringBinary(row.getRow())
+              + delimiter);
```
ProjectName: 6424-hbase
CommitID: f3bed5b0d98b3cb895e81b20f5e3017081b74972
CommitMsg: HBASE-17026 VerifyReplication log should distinguish whether good row key is result of revalidation

FilePath: hbase-server/src/main/java/org/apache/hadoop/hbase/mapreduce/replication/VerifyReplication.java**
```diff
           LOG.error("recompare fail after sleep, rowkey=" + delimiter +
-              Bytes.toString(row.getRow()) + delimiter);
+              Bytes.toStringBinary(row.getRow()) + delimiter);
```
ProjectName: 6424-hbase
CommitID: f3bed5b0d98b3cb895e81b20f5e3017081b74972
CommitMsg: HBASE-17026 VerifyReplication log should distinguish whether good row key is result of revalidation

FilePath: hbase-server/src/main/java/org/apache/hadoop/hbase/mapreduce/replication/VerifyReplication.java**
```diff
       context.getCounter(Counters.BADROWS).increment(1);
-      LOG.error(counter.toString() + ", rowkey=" + delimiter + Bytes.toString(row.getRow()) +
+      LOG.error(counter.toString() + ", rowkey=" + delimiter + Bytes.toStringBinary(row.getRow()) +
```
ProjectName: 6424-hbase
CommitID: b35e1f41b865eeb1b3565e098cd012d1137b6f59
CommitMsg: HBASE-16315 RegionSizeCalculator prints region names as binary without escapes

FilePath: hbase-client/src/main/java/org/apache/hadoop/hbase/RegionLoad.java**
```diff
   public String getNameAsString() {
-    return Bytes.toString(getName());
+    return Bytes.toStringBinary(getName());
```
ProjectName: 6424-hbase
CommitID: c8f365c85b07259f04498a8bc5f0a59843b95989
CommitMsg: HBASE-2630. HFile should use toStringBinary when printing keys


git-svn-id: https://svn.apache.org/repos/asf/hbase/trunk@949547 13f79535-47bb-0310-9956-ffa450edef68

FilePath: src/main/java/org/apache/hadoop/hbase/io/hfile/HFile.java**
```diff
           throw new IOException("Added a key not lexically larger than" +
-            " previous key=" + Bytes.toString(key, offset, length) +
-            ", lastkey=" + Bytes.toString(this.lastKeyBuffer, this.lastKeyOffset,
+            " previous key=" + Bytes.toStringBinary(key, offset, length) +
+            ", lastkey=" + Bytes.toStringBinary(this.lastKeyBuffer, this.lastKeyOffset,
```
ProjectName: 6424-hbase
CommitID: c8f365c85b07259f04498a8bc5f0a59843b95989
CommitMsg: HBASE-2630. HFile should use toStringBinary when printing keys


git-svn-id: https://svn.apache.org/repos/asf/hbase/trunk@949547 13f79535-47bb-0310-9956-ffa450edef68

FilePath: src/main/java/org/apache/hadoop/hbase/io/hfile/HFile.java**
```diff
         sb.append(", ");
-        sb.append("key=").append(Bytes.toString(blockKeys[i])).
+        sb.append("key=").append(Bytes.toStringBinary(blockKeys[i])).
```
ProjectName: 6424-hbase
CommitID: 8d2b2830830793776a6756779188d3df6c0062a3
CommitMsg: HBASE-2573 client.HConnectionManager logs non-printable binary bytes

git-svn-id: https://svn.apache.org/repos/asf/hbase/trunk@946405 13f79535-47bb-0310-9956-ffa450edef68

FilePath: core/src/main/java/org/apache/hadoop/hbase/client/HConnectionManager.java**
```diff
           LOG.debug("Cache hit for row <" +
-            Bytes.toString(row) +
+            Bytes.toStringBinary(row) +
```
ProjectName: 6424-hbase
CommitID: 7fb19786ee45203725fc92d69b2b1d30a53bcb84
CommitMsg: HBASE-1585 More binary key/value log output cleanup

git-svn-id: https://svn.apache.org/repos/asf/hadoop/hbase/trunk@788479 13f79535-47bb-0310-9956-ffa450edef68

FilePath: src/java/org/apache/hadoop/hbase/client/HTable.java**
```diff
             + Bytes.toString(getTableName()) 
-            + " starting at key '" + Bytes.toString(scan.getStartRow()) + "'");
+            + " starting at key '" + Bytes.toStringBinary(scan.getStartRow()) + "'");
```
ProjectName: 6424-hbase
CommitID: 7fb19786ee45203725fc92d69b2b1d30a53bcb84
CommitMsg: HBASE-1585 More binary key/value log output cleanup

git-svn-id: https://svn.apache.org/repos/asf/hadoop/hbase/trunk@788479 13f79535-47bb-0310-9956-ffa450edef68

FilePath: src/java/org/apache/hadoop/hbase/client/HTable.java**
```diff
         CLIENT_LOG.debug("Advancing internal scanner to startKey at '" +
-          Bytes.toString(localStartKey) + "'");
+          Bytes.toStringBinary(localStartKey) + "'");
```

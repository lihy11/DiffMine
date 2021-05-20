###  infomation 
method del:
-InterfaceAudience.Public()
method add：
+InterfaceAudience.Private()
###  support count
project count : 2
commit count : 12
###  code
ProjectName: 35083-pig
CommitID: 3699726871f52db7559bbbe6f9c4dfcbf643d30d
CommitMsg: PIG-4319: Make LoadPredicatePushdown InterfaceAudience.Private till PIG-4093 (rohini)

git-svn-id: https://svn.apache.org/repos/asf/pig/trunk@1637728 13f79535-47bb-0310-9956-ffa450edef68

FilePath: src/org/apache/pig/LoadPredicatePushdown.java**
```diff
  */
-@InterfaceAudience.Public
+@InterfaceAudience.Private
```
ProjectName: 6424-hbase
CommitID: ab28f9d8c74c22f60acd6c526e09b980d059a151
CommitMsg: Revert "HBASE-22823 Mark Canary as Public/Evolving"

This reverts commit edf6f68cb2d0c10c9ecd2977c5f9c6f3b3579000.

See HBASE-22874

FilePath: hbase-server/src/main/java/org/apache/hadoop/hbase/tool/Canary.java**
```diff
  */
-@InterfaceAudience.Public
+@InterfaceAudience.Private
```
ProjectName: 6424-hbase
CommitID: cb32f4faf0b45dc75f462818600207e0d57ec715
CommitMsg: HBASE-21991 [Addendum] Mark LossCounting as Private

Signed-off-by: Guanghao Zhang <zghao@apache.org>

FilePath: hbase-server/src/main/java/org/apache/hadoop/hbase/util/LossyCounting.java**
```diff
 
-@InterfaceAudience.Public
+@InterfaceAudience.Private
```
ProjectName: 6424-hbase
CommitID: 3f1498ddb4236db021185ef69ae735bdabaaca2c
CommitMsg: HBASE-22044 ByteBufferUtils should not be IA.Public API

Signed-off-by: Andrew Purtell <apurtell@apache.org>

FilePath: hbase-common/src/main/java/org/apache/hadoop/hbase/util/ByteBufferUtils.java**
```diff
 @SuppressWarnings("restriction")
-@InterfaceAudience.Public
+@InterfaceAudience.Private
```
ProjectName: 6424-hbase
CommitID: 98a21ef1bae01e209cd1816e37f3afd89a6e473b
CommitMsg: HBASE-19439 Mark ShortCircuitMasterConnection  with InterfaceAudience Private.

FilePath: hbase-client/src/main/java/org/apache/hadoop/hbase/client/ShortCircuitMasterConnection.java**
```diff
  */
-@InterfaceAudience.Public
+@InterfaceAudience.Private
```
ProjectName: 6424-hbase
CommitID: 9c5b03acd72713f1a9956086ad0a6f4b389deaae
CommitMsg: HBASE-18766 Make TableSnapshotScanner Audience Private

Signed-off-by: Michael Stack <stack@apache.org>

FilePath: hbase-server/src/main/java/org/apache/hadoop/hbase/client/TableSnapshotScanner.java**
```diff
  */
-@InterfaceAudience.Public
+@InterfaceAudience.Private
```
ProjectName: 6424-hbase
CommitID: 177344cdbf8a08a6d225312b2327ff1ea8a21067
CommitMsg: HBASE-17873 Change the IA.Public annotation to IA.Private for unstable API

Signed-off-by: Sean Busbey <busbey@apache.org>

FilePath: hbase-client/src/main/java/org/apache/hadoop/hbase/client/AsyncAdmin.java**
```diff
  */
-@InterfaceAudience.Public
+@InterfaceAudience.Private
```
ProjectName: 6424-hbase
CommitID: 7bb68b9031591cf378954a0eb8f71a8b9be01f9c
CommitMsg: HBASE-15231 Make TableState.State private (Misty Stanley-Jones)

FilePath: hbase-client/src/main/java/org/apache/hadoop/hbase/client/TableState.java**
```diff
 
-  @InterfaceAudience.Public
+  @InterfaceAudience.Private
```
ProjectName: 6424-hbase
CommitID: c8e1177dd261ab2b9fa78c885b53d38fc598f95b
CommitMsg: HBASE-13368 - Hash.java is declared as public Interface - but it should be
Private (Ram)

FilePath: hbase-common/src/main/java/org/apache/hadoop/hbase/util/MurmurHash3.java**
```diff
  */
-@InterfaceAudience.Public
+@InterfaceAudience.Private
```
ProjectName: 6424-hbase
CommitID: c8e1177dd261ab2b9fa78c885b53d38fc598f95b
CommitMsg: HBASE-13368 - Hash.java is declared as public Interface - but it should be
Private (Ram)

FilePath: hbase-common/src/main/java/org/apache/hadoop/hbase/util/Hash.java**
```diff
  */
-@InterfaceAudience.Public
+@InterfaceAudience.Private
```
ProjectName: 6424-hbase
CommitID: c8e1177dd261ab2b9fa78c885b53d38fc598f95b
CommitMsg: HBASE-13368 - Hash.java is declared as public Interface - but it should be
Private (Ram)

FilePath: hbase-common/src/main/java/org/apache/hadoop/hbase/util/MurmurHash.java**
```diff
  */
-@InterfaceAudience.Public
+@InterfaceAudience.Private
```
ProjectName: 6424-hbase
CommitID: c8e1177dd261ab2b9fa78c885b53d38fc598f95b
CommitMsg: HBASE-13368 - Hash.java is declared as public Interface - but it should be
Private (Ram)

FilePath: hbase-common/src/main/java/org/apache/hadoop/hbase/util/JenkinsHash.java**
```diff
  */
-@InterfaceAudience.Public
+@InterfaceAudience.Private
```

###  infomation 
method del:
-java.util.Set.size()
method add：
+java.util.Set.isEmpty()
###  support count
project count : 10
commit count : 15
###  code
ProjectName: 32143-checkstyle-idea
CommitID: faaa59814d61806c1b48a651aba0a0083a8f1643
CommitMsg: squid:S1155 - Collection.isEmpty() should be used to test for emptiness (#249)


FilePath: src/main/java/org/infernus/idea/checkstyle/CheckStylePlugin.java**
```diff
         synchronized (checksInProgress) {
-            return checksInProgress.size() > 0;
+            return !checksInProgress.isEmpty();
```
ProjectName: 22223-pdfbox
CommitID: f212d6bb535f7537f1c04c75bf390b5ddd3c03fb
CommitMsg: PDFBOX-4071: SonarQube fix, move constructors up

git-svn-id: https://svn.apache.org/repos/asf/pdfbox/trunk@1861915 13f79535-47bb-0310-9956-ffa450edef68

FilePath: pdfbox/src/main/java/org/apache/pdfbox/pdmodel/font/FileSystemFontProvider.java**
```diff
         
-        if (pending.size() > 0)
+        if (!pending.isEmpty())
```
ProjectName: 21302-phpinspectionsea
CommitID: 2aafb07a4b238a90b5ab08ea4e4f4e81107c582c
CommitMsg: PotentialMalwareInspector: new patterns.

FilePath: src/main/java/com/kalessil/phpStorm/phpInspectionsEA/inspectors/security/PotentialMalwareInspector.java**
```diff
                 final Set<PsiElement> values = PossibleValuesDiscoveryUtil.discover(call.getFirstPsiChild());
-                if (values.size() > 0) {
-                    for (PsiElement value : values) {
+                if (!values.isEmpty()) {
+                    for (final PsiElement value : values) {
```
ProjectName: 21374-psi-probe
CommitID: 0bdeaf5bde4b958a8660efb572a0c497f5a62f18
CommitMsg: Use isEmpty instead of size() - it's faster

FilePath: core/src/main/java/com/googlecode/psiprobe/Utils.java**
```diff
       Set<ObjectInstance> threading = mbeanServer.queryMBeans(threadingOName, null);
-      return threading != null && threading.size() > 0;
+      return threading != null && !threading.isEmpty();
```
ProjectName: 14745-android
CommitID: 1e63423397582aff5fc2cd103c77d4b76040ee1c
CommitMsg: fix findbugs

Signed-off-by: tobiasKaminsky <tobias@kaminsky.me>

FilePath: src/main/java/com/owncloud/android/ui/activity/UploadListActivity.java**
```diff
 
-        if (jobs.size() == 0) {
+        if (jobs.isEmpty()) {
```
ProjectName: 1212-redisson
CommitID: 442d00b180606431fcb8be8aff2aea29e62d6fdb
CommitMsg: use isEmpty()

FilePath: redisson-tomcat/redisson-tomcat-9/src/main/java/org/redisson/tomcat/RedissonSessionManager.java**
```diff
             //remove valves when all of the RedissonSessionManagers (web apps) are not in use anymore
-            if (contextInUse.size() == 0) {
+            if (contextInUse.isEmpty()) {
```
ProjectName: 1212-redisson
CommitID: 442d00b180606431fcb8be8aff2aea29e62d6fdb
CommitMsg: use isEmpty()

FilePath: redisson-tomcat/redisson-tomcat-7/src/main/java/org/redisson/tomcat/RedissonSessionManager.java**
```diff
             //remove valves when all of the RedissonSessionManagers (web apps) are not in use anymore
-            if (contextInUse.size() == 0) {
+            if (contextInUse.isEmpty()) {
```
ProjectName: 1212-redisson
CommitID: 442d00b180606431fcb8be8aff2aea29e62d6fdb
CommitMsg: use isEmpty()

FilePath: redisson-tomcat/redisson-tomcat-6/src/main/java/org/redisson/tomcat/RedissonSessionManager.java**
```diff
             //remove valves when all of the RedissonSessionManagers (web apps) are not in use anymore
-            if (contextInUse.size() == 0) {
+            if (contextInUse.isEmpty()) {
```
ProjectName: 1212-redisson
CommitID: 442d00b180606431fcb8be8aff2aea29e62d6fdb
CommitMsg: use isEmpty()

FilePath: redisson-tomcat/redisson-tomcat-8/src/main/java/org/redisson/tomcat/RedissonSessionManager.java**
```diff
             //remove valves when all of the RedissonSessionManagers (web apps) are not in use anymore
-            if (contextInUse.size() == 0) {
+            if (contextInUse.isEmpty()) {
```
ProjectName: 2574-antlr4
CommitID: a34fd6330b7f22612800003824b9b8b108963331
CommitMsg: Use isEmpty() instead of size()==0

FilePath: runtime/Java/src/org/antlr/v4/runtime/dfa/DFAState.java**
```diff
 		}
-		if ( alts.size()==0 ) return null;
+		if ( alts.isEmpty() ) return null;
```
ProjectName: 2042-jsoup
CommitID: 3a158cfbcfe70c9a921b9ea525e2cd8113193219
CommitMsg: Tweaked removals in Whitelist

FilePath: src/main/java/org/jsoup/safety/Whitelist.java**
```diff
 
-            if(currentSet.size() == 0) // Remove tag from attribute map if no attributes are allowed for tag
+            if(currentSet.isEmpty()) // Remove tag from attribute map if no attributes are allowed for tag
```
ProjectName: 2042-jsoup
CommitID: 3a158cfbcfe70c9a921b9ea525e2cd8113193219
CommitMsg: Tweaked removals in Whitelist

FilePath: src/main/java/org/jsoup/safety/Whitelist.java**
```diff
 
-                if(currentSet.size() == 0) // Remove tag from attribute map if no attributes are allowed for tag
+                if(currentSet.isEmpty()) // Remove tag from attribute map if no attributes are allowed for tag
```
ProjectName: 8346-pmd
CommitID: 7e380e5d982c073ad7157c9ee95abb0c0118d12b
CommitMsg: Use isEmpty method.

FilePath: pmd-core/src/main/java/net/sourceforge/pmd/lang/metrics/MetricOptions.java**
```diff
         MetricOptions build() {
-            if (opts.size() == 0) {
+            if (opts.isEmpty()) {
```
ProjectName: 46-java-design-patterns
CommitID: 31f4b15e862a4d0b213561a0c20ff27d8d99822b
CommitMsg: Merge pull request #565 from kapinuss/patch-1

Update ObjectPool.java
FilePath: object-pool/src/main/java/com/iluwatar/object/pool/ObjectPool.java**
```diff
   public synchronized T checkOut() {
-    if (available.size() <= 0) {
+    if (available.isEmpty()) {
```
ProjectName: 46-java-design-patterns
CommitID: 798aee47b325c8be5001373c44d4940f87f9b444
CommitMsg: Update ObjectPool.java
FilePath: object-pool/src/main/java/com/iluwatar/object/pool/ObjectPool.java**
```diff
   public synchronized T checkOut() {
-    if (available.size() <= 0) {
+    if (available.isEmpty()) {
```
